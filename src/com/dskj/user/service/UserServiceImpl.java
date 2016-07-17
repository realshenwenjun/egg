package com.dskj.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dskj.user.entity.*;
import com.dskj.user.entity2_0.MyCollect;
import com.dskj.user.entity2_0.MyFans;
import com.dskj.user.entity2_0.UserAsk;
import com.dskj.user.entity2_0.UserGroup;
import com.dskj.user.entity2_0.UserPhoto;
import com.dskj.user.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.activity.mapper.ChildActivityCollectMapper;
import com.dskj.base.Base;
import com.dskj.community.mapper.PostCollectMapper;
import com.dskj.course.mapper.ClassFansMapper;
import com.dskj.enu.LevelRule;
import com.dskj.util.MD5Util;
import com.dskj.util.Page;

@Service
public class UserServiceImpl extends Base implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ChatService chatService;
    @Autowired
    private InstitutionMapper institutionMapper;
    @Autowired
    private UserLoginLogMapper userLoginLogMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private UserCircleMapper userCircleMapper;
    @Autowired
    private UserVisitMapper userVisitMapper;
    @Autowired
    private UserFansMapper userFansMapper;
    @Autowired
    private InstitutionFansMapper institutionFansMapper;
    @Autowired
    private ClassFansMapper classFansMapper;
    @Autowired
    private ChildActivityCollectMapper childActivityCollectMapper;
    @Autowired
    private PostCollectMapper postCollectMapper;
    @Autowired
    private UserPhotoMapper userPhotoMapper;
    @Autowired
    private UserAskMapper userAskMapper;
    @Autowired
    private UserGroupMapper userGroupMapper;
    /*
     * 用于重复提交处理
     */
    public static Map<String, Integer> options = new ConcurrentHashMap<String, Integer>();

    public String addUser(UserEntity userEntity) throws Exception {
        if (options.get(userEntity.getPhone()) != null)
            return "too fast";
        else
            options.put(userEntity.getPhone(), 0);
        try {
//            userEntity.setType(3);// 默认学生
            userEntity.setCreateTime(new Date());
            userMapper.addUser(userEntity);
            ChatUser chatUser = new ChatUser();
            chatUser.setUsername(userEntity.getId());
            chatUser.setPassword(MD5Util.MD5Encode(userEntity.getId() + netKey, "utf8"));
            Object obj = chatService.addUser(chatUser);
            if (obj == null)
                throw new Exception();
        } finally {
            options.remove(userEntity.getPhone());
        }
        return userEntity.getId();
    }

    public Boolean getCheckPhone(String phone) throws Exception {
        if (phone == null || "".equals(phone))
            return false;
        Integer count = this.userMapper.getUserCountByPhone(phone);
        if (count != 0) {
            return true;
        }
        return false;
    }

    public Object getRegistedPhones(String json) throws Exception {
        List<String> phones = stringToObj(json, ArrayList.class);
        return userMapper.getRegistedPhones(phones);
    }

    public UserEntity getUserLogin(String phone, String password) throws Exception {
        return userMapper.userLogin(phone, password);
    }

    public void updatePassword(String phone, String password) throws Exception {
        userMapper.updatePassword(phone, password);
    }

    public UserEntity getUserById(String id) throws Exception {
        return userMapper.getById(id);
    }

    public void updateUserPhoto(String id, String photo) throws Exception {
        userMapper.updatePhoto(id, photo);
    }

    public void updateUserInfo(UserEntity userEntity) throws Exception {
        if (userEntity.getType() != null && userEntity.getType() == 1) {
            List<InstitutionEntity> institutionEntities = institutionMapper.getMyInstitution(userEntity.getId());
            if (institutionEntities != null && institutionEntities.size() > 1) {
                throw new Exception("选择多个机构的人不能成为管理员");
            }
            //同时设置当前机构
            institutionMapper.updateCurrentStatus(userEntity.getId());
        }
        userMapper.updateInfo(userEntity);
    }

    public UserEntity getUserQQLogin(String qqOpenId) throws Exception {
        return userMapper.userQQLogin(qqOpenId);
    }

    public UserEntity getUserSinaLogin(String sinaOpenId) throws Exception {
        return userMapper.userSinaLogin(sinaOpenId);
    }

    public UserEntity getUserWeiXinLogin(String weixinOpenId) throws Exception {
        return userMapper.userWeiXinLogin(weixinOpenId);
    }

    public void updateUserBindQQ(String qqOpenId, String id) throws Exception {
        userMapper.userBindQQ(qqOpenId, id);
    }

    public void updateUserBindSina(String sinaOpenId, String id) throws Exception {
        userMapper.userBindSina(sinaOpenId, id);
    }

    public void updateUserBindWeiXin(String weixinOpenId, String id) throws Exception {
        userMapper.userBindWeiXin(weixinOpenId, id);
    }

    public List<InstitutionEntity> getMyInstitution(String id) throws Exception {
        return institutionMapper.getMyInstitution(id);
    }

    public void addRegistInstitutions(List<InstitutionUserEntity> institutionUserEntities, String userId) throws Exception {
        UserEntity userEntity = userMapper.getById(userId);
        if (userEntity.getType() != null && userEntity.getType() == 1) {
            throw new Exception("机构管理员不能选择机构");
        }
        for (InstitutionUserEntity i : institutionUserEntities) {
            List<InstitutionUserEntity> list = institutionMapper.getMyInstitutionUser(i.getUserId());
            if (list == null || list.size() == 0) {
                i.setCurrent(1);
            }
        }
        institutionMapper.registInstitutions(institutionUserEntities);
    }

    public List<UserEntity> getUserListPage(Page page) throws Exception {
        return userMapper.getUserListPage(page);
    }

    public void addUserLoginLog(UserEntity userEntity) throws Exception {
        UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setUserId(userEntity.getId());
        userLoginLog.setUserName(userEntity.getName());
        userLoginLog.setCreateTime(new Date());
        userLoginLogMapper.add(userLoginLog);
        new LevelUpThread(userEntity).run();
    }

    private class LevelUpThread implements Runnable {
        private UserEntity userEntity;

        private LevelUpThread(UserEntity userEntity) {
            super();
            this.userEntity = userEntity;
        }

        public void run() {
            try {
                inspectLevel(userEntity);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("用户登录时检查用户等级异常！");
            }
        }

        public void inspectLevel(UserEntity userEntity) throws Exception {
            int loginDay = userLoginLogMapper.getUserLoginDay(userEntity.getId());// 共登录多少天
            userEntity.setLoginDayCount(loginDay);
            if (userEntity.getLevelId() < LevelRule.getLevel(loginDay)) {
                UserEntity entity = new UserEntity();
                entity.setId(userEntity.getId());
                entity.setLevelId(LevelRule.getLevel(loginDay));
                userMapper.updateInfo(entity);
                userEntity.setLevelId(LevelRule.getLevel(loginDay));
            }
        }

    }

    public List<InstitutionEntity> getOtherInstitution(String id, Page page) throws Exception {
        return institutionMapper.getOtherInstitution(id, page);
    }

    public List<UserEntity> getManageTeacherList(String institutionId) throws Exception {
        return userMapper.getManageTeacherList(institutionId);
    }

    public List<UserEntity> getManageTeacherSearch(String institutionId, String key, Page page) throws Exception {
    	if("".equals(key))
    		key = null;
        return userMapper.getManageTeacherSearch(institutionId, key, page);
    }

    public List<UserEntity> getManageUserSearch(String institutionId, String key, Page page) throws Exception {
        return userMapper.getManageUserSearch(institutionId, key, page);
    }

    public List<UserEntity> getManageStudentSearch(String institutionId, String key, Page page) throws Exception {
    	if("".equals(key))
    		key = null;
        return userMapper.getManageStudentSearch(institutionId, key, page);
    }

    public int getMyClassCountByInstitution(String userId, String institutionId) throws Exception {
        return userMapper.getMyClassCountByInstitution(userId, institutionId);
    }

    public void deleteMyInstitution(String userId, String institutionId) throws Exception {
        UserEntity userEntity = userMapper.getById(userId);
        if (userEntity.getType() != null && userEntity.getType() == 1) {
            throw new Exception("机构管理员不能删除自己所管理的机构");
        }
        institutionMapper.deleteMyInstitution(userId, institutionId);
    }

    public List<UserEntity> getSystemUser(String key, Page page) throws Exception {
        return userMapper.getSystemUser(key, page);
    }

    public int getAllUserCount() throws Exception {
        return userMapper.getAllUserCount();
    }

    public List<UserEntity> getFriendList(List<String> ids) throws Exception {
        return userMapper.getFriendList(ids);
    }

    public void addCollect(Collect collect) throws Exception {
        this.collectMapper.add(collect);
    }

    public List<CollectInstitution> getCollectList(String userId, String columnKey, Page page) throws Exception {
        return collectMapper.list(userId, "institution_id", page);
    }

    public List<InstitutionEntity> getOtherInstitutionSearch(String id,
                                                             String key) throws Exception {
        return institutionMapper.getOtherInstitutionSearch(id, key);
    }

    public void deleteCollect(int id) throws Exception {
        collectMapper.delete(id);
    }

    public List<InstitutionEntity> getCollectInstitutionSearch(String userId,
                                                               String key, Page page) throws Exception {
        return collectMapper.getCollectInstitutionSearch(userId, key, page);
    }

    public void addCurrentInstitution(
            InstitutionUserEntity institutionUserEntity) throws Exception {
        institutionMapper.deleteAllCurrentInstitution(institutionUserEntity.getUserId());
        institutionMapper.addCurrentInstitution(institutionUserEntity);
    }

    public List<InstitutionWithCurrent> getMyInstitutionWithCurrent(String id)
            throws Exception {
        return institutionMapper.getMyInstitutionWithCurrent(id);
    }

    public List<UserEntity> getSupperAdminList(String userId,String key, Page page) throws Exception {
    	if("".equals(key))
    		key = null;
        return userMapper.getSupperAdminList(userId,key, page);
    }

    public List<UserEntity> getSystemUserAll(String key, Page page) throws Exception {
        return userMapper.getSystemUserAll(key, page);
    }

    public void addUserCircle(UserCircle userCircle) throws Exception {
        userCircleMapper.add(userCircle);
    }

    public void deleteUserCircle(int userCircleId) throws Exception {
        userCircleMapper.delete(userCircleId);
    }

    public List<UserCircle> getMyCircle(String userId) throws Exception {
        return userCircleMapper.getList(userId);
    }

    public UserFace updateGetUserFace(String userId, String beenUserId) throws Exception {
        if (userVisitMapper.getUserVisitCount(userId, beenUserId) == 0) {
            UserVisit userVisit = new UserVisit();
            userVisit.setCreateTime(new Date());
            userVisit.setUserId(userId);
            userVisit.setBeenUserId(beenUserId);
            userVisitMapper.add(userVisit);
            userMapper.updateUserVisitCount(beenUserId);
        }
        UserFace userFace = userMapper.getFaceById(beenUserId);
        userFace.setFansCount(userFansMapper.getBeenUserFans(beenUserId));
        userFace.setFansId(userFansMapper.getUserFansId(userId, beenUserId));
        return userFace;
    }

    @Override
    public void addBeenUserFans(UserFans userFans) throws Exception {
        userFansMapper.add(userFans);
    }

    @Override
    public void deleteBeenUserFans(Integer fansId) throws Exception {
        userFansMapper.delete(fansId);
    }

    @Override
    public List<UserEntity> getInstitutionTeacherSearch2_0(String  institutionId,String key,Page page) throws Exception {
        return institutionMapper.getInstitutionTeacherSearch2_0(institutionId,key,page);
    }

    @Override
    public void deleteInstitutionTeacherSearchBatch2_0(String institutionId, List<String> teacherIds) throws Exception {
        institutionMapper.deleteInstitutionTeacherSearchBatch2_0(institutionId,teacherIds);
        userMapper.clear();
    }

    @Override
    public void addInstitutionTeacherSearchBatch2_0(String institutionId, List<String> teacherIds) throws Exception {
        List<InstitutionUserEntity> teachers = new ArrayList<InstitutionUserEntity>();
        for (String teacherId : teacherIds){
            InstitutionUserEntity institutionUserEntity = new InstitutionUserEntity();
            institutionUserEntity.setInstitutionId(institutionId);
            institutionUserEntity.setUserId(teacherId);
            teachers.add(institutionUserEntity);
        }
        if (teachers.size() == 0)
            return;
        institutionMapper.addInstitutionTeacherSearchBatch2_0(teachers);
        userMapper.clear();
    }

	public List<UserEntity> getInstitutionStudentAll2_0(String institutionId,
			Page page) throws Exception {
		List<String> studentIds = institutionMapper.getInstitutionStudentAll2_0(institutionId, page);
		if(studentIds == null || studentIds.size() == 0)
			return new ArrayList<UserEntity>();
		return userMapper.getInstitutionStudentAll2_0(studentIds);
	}

	public List<UserEntity> getInstitutionStudentSearch2_0(
			String institutionId, String key, Page page) throws Exception {
		return institutionMapper.getInstitutionStudentSearch2_0(institutionId, key, page);
	}

	public Object getUserMyInstitution2_0(String userId, Page page)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Object o = institutionMapper.getUserMyInstitution2_0(userId,page);
		int myInsCount = institutionMapper.getUserMyInstitutionCount(userId);
		result.put("list", o);
		result.put("count", myInsCount);
		return result;
	}

	public Object getUserMyInstitutionSearch2_0(String userId, String key,
			Page page) throws Exception {
        if ("".equals(key))
            key = null;
		Map<String, Object> result = new HashMap<String, Object>();
		Object o = institutionMapper.getUserMyInstitutionSearch2_0(userId,key,page);
		int myInsCount = institutionMapper.getUserMyInstitutionCount(userId);
		result.put("list", o);
		result.put("count", myInsCount);
		return result;
	}

	public void addUserMyInstitution2_0(String userId,
			List<String> institutionId) throws Exception {
		List<InstitutionUserEntity> institutionUserEntities = new ArrayList<InstitutionUserEntity>();
		if(institutionId != null){
			for(String insId : institutionId){
				InstitutionUserEntity isUserEntity = new InstitutionUserEntity();
				isUserEntity.setInstitutionId(insId);
				isUserEntity.setUserId(userId);
				institutionUserEntities.add(isUserEntity);
			}
		}
		if(institutionUserEntities.size() != 0){
			institutionMapper.addUserMyInstitution(institutionUserEntities);
		}
	}

	public Object getUserNotInstitutionSearch2_0(String userId, String key,
			Page page) throws Exception {
        if ("".equals(key))
            key = null;
		Map<String, Object> result = new HashMap<String, Object>();
		Object o = institutionMapper.getUserNotInstitutionSearch2_0(userId,key,page);
		int myInsCount = institutionMapper.getUserMyInstitutionCount(userId);
		result.put("list", o);
		result.put("count", myInsCount);
		return result;
	}

	public void deleteUserMyInstitution2_0(String userId,
			List<String> institutionId) throws Exception {
		institutionMapper.deleteUserMyInstitution2_0(userId, institutionId);
	}

	public List<MyFans> getUserFansList2_0(String userId) throws Exception {
		List<MyFans> myFans = userFansMapper.getUserFansList2_0(userId);
		List<MyFans> imFans = institutionFansMapper.getUserFansList2_0(userId);
		List<MyFans> fans = new ArrayList<MyFans>();
		fans.addAll(myFans);
		fans.addAll(imFans);
		return fans;
	}

	public void deleteUserFans2_0(int fansId,int type) throws Exception {
		if(type == 1){
			institutionFansMapper.delete(fansId);
		}else{
			userFansMapper.delete(fansId);
		}
	}

	public List<MyCollect> getUserCollectList2_0(String userId)
			throws Exception {
		List<MyCollect> classCollect = classFansMapper.getUserCollectList2_0(userId);
		
		List<MyCollect> activityCollect = childActivityCollectMapper.getUserCollectList2_0(userId);
		
		List<MyCollect> postCollect = postCollectMapper.getUserCollectList2_0(userId);
		
		List<MyCollect> collects = new ArrayList<MyCollect>();
		collects.addAll(postCollect);
		collects.addAll(activityCollect);
		collects.addAll(classCollect);
		return collects;
	}

	public void deleteUserCollectList2_0(int collectId, int type) throws Exception {
		if(type == 1){
			classFansMapper.delete(collectId);
		}else if(type == 2){
			childActivityCollectMapper.delete(collectId);
		}else{
			postCollectMapper.delete(collectId);
		}
	}

	public List<UserEntity> getUnfirendSearch2_0(String key,List<String> ids,Page page)
			throws Exception {
        if (key == null || "".equals(key))
            key = null;
		if(ids == null || ids.size()== 0)
			ids = null;
		return userMapper.getUnfirendSearch2_0(key,ids,page);
	}

	public List<UserEntity> getFirendSearch2_0(String key,List<String> ids) throws Exception {
		if(ids == null || ids.size()== 0)
			ids = null;
		if (key == null || "".equals(key))
            key = null;
		return userMapper.getFirendSearch2_0(key, ids);
	}

    public void addUserPhoto(List<String> urls, String userId) throws Exception {
        List<UserPhoto> photos = null;
        if (urls != null && urls.size() != 0){
            photos = new ArrayList<UserPhoto>();
            Date date = new Date();
            for (String url : urls){
                UserPhoto userPhoto = new UserPhoto();
                userPhoto.setUserId(userId);
                userPhoto.setUrl(url);
                userPhoto.setCreateTime(date);
                photos.add(userPhoto);
            }
            userPhotoMapper.add(photos);
        }
    }

    public void deleteUserPhoto(List<Integer> ids) throws Exception {
        userPhotoMapper.delete(ids);
    }

    public Object getUserPhotot2_0(String userId) throws Exception {
        return userPhotoMapper.list(userId);
    }

    public void addUserAsk(UserAsk userAsk) throws Exception {
        userAskMapper.add(userAsk);
    }

    public Object getUserAskList2_0(String institutionId, Page page) throws Exception {
        return userAskMapper.getUserAskList2_0(institutionId,page);
    }

	public void addUserGroup(UserGroup userGroup) throws Exception {
		userGroupMapper.add(userGroup);
	}

	public UserGroup getUserGroup(String uid) throws Exception {
		return userGroupMapper.get(uid);
	}

	public List<UserEntity> getplatformsList(Page page) throws Exception {
		return userMapper.getplatformsList(page);
	}

	public int getplatformsCount() throws Exception {
		return userMapper.getplatformsCount();
	}

	public int getSupperAdminCount(String userId,String key) throws Exception {
		if("".equals(key))
			key = null;
		return userMapper.getSupperAdminCount(userId,key);
	}

	public List<UserEntity> getNomalUserSearch(String key, Page page)
			throws Exception {
		if("".equals(key))
			key = null;
		return userMapper.getNomalUserSearch(key,page);
	}

	public int getNomalUserSearchCount(String key) throws Exception {
		if("".equals(key))
			key = null;
		return userMapper.getNomalUserSearchCount(key);
	}

	public String addPlatformsAdmin(String userId) throws Exception {
		int count = userMapper.getMyInstitutionCount(userId);
		if(count != 0){
			return "选择多个机构的用户无法成为管理员!";
		}
		userMapper.addPlatformsAdmin(userId);
		return null;
	}

	public String deletePlatformsAdmin(String userId) throws Exception {
		if(institutionMapper.getMyOldType(userId) == null){
			return "没有权限删除此管理员";
		}
		userMapper.deletePlatformsAdmin(userId);
		return null;
	}

}
