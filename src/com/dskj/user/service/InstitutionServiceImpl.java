package com.dskj.user.service;

import com.dskj.announcement.mapper.AnnouncementMapper;
import com.dskj.announcement.mapper.AnnouncementReadMapper;
import com.dskj.base.Base;
import com.dskj.comment.entity.Comment;
import com.dskj.comment.mapper.CommentMapper;
import com.dskj.course.mapper.ClassMapper;
import com.dskj.course.mapper.ClassSignMapper;
import com.dskj.spread.mapper.PropaMapper;
import com.dskj.user.entity.*;
import com.dskj.user.exception.DeleteChildException;
import com.dskj.user.exception.UserExistException;
import com.dskj.user.mapper.*;
import com.dskj.util.MD5Util;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InstitutionServiceImpl extends Base implements InstitutionService {
    @Autowired
    private InstitutionMapper institutionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ChatService chatService;
    @Autowired
    private InstitutionCommentMapper institutionCommentMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private InstitutionLoveMapper institutionLoveMapper;
    @Autowired
    private InstitutionVisitMapper institutionVisitMapper;
    @Autowired
    private InstitutionFansMapper institutionFansMapper;
    @Autowired
    private AnnouncementMapper announcementMapper;
    @Autowired
    private AnnouncementReadMapper announcementReadMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private ClassSignMapper classSignMapper;
    @Autowired
    private PropaMapper propaMapper;

    public String addInstitution(InstitutionEntity institutionEntity, UserEntity userEntity) throws Exception {
        if (userEntity.getPhone() != null) {
            if (UserServiceImpl.options.get(userEntity.getPhone()) != null)
                return "too fast";
            else
                UserServiceImpl.options.put(userEntity.getPhone(), 0);
        }
        try {
            InstitutionEntity institutionEntity2 = institutionMapper.getInstitutionByName(institutionEntity.getName());
            if (institutionEntity2 != null) {
                return "name been used";
            }
            institutionMapper.addInstitution(institutionEntity);
            if (userEntity.getPhone() != null) {
                if (userMapper.getUserCountByPhone(userEntity.getPhone()) != 0) {
                    throw new UserExistException("phone has been used");
                }
                userMapper.addUser(userEntity);
                ChatUser chatUser = new ChatUser();
                chatUser.setUsername(userEntity.getId());
                chatUser.setPassword(MD5Util.MD5Encode(userEntity.getId() + netKey, "utf8"));
                Object obj = chatService.addUser(chatUser);
                if (obj == null)
                    throw new Exception();
            }
        } finally {
            if (userEntity.getPhone() != null)
                UserServiceImpl.options.remove(userEntity.getPhone());
        }
        if (userEntity.getPhone() != null) {
            InstitutionUserEntity institutionUserEntity = new InstitutionUserEntity();
            institutionUserEntity.setCreateTime(new Date());
            institutionUserEntity.setCurrent(1);
            institutionUserEntity.setInstitutionId(institutionEntity.getId());
            institutionUserEntity.setUserId(userEntity.getId());
            institutionMapper.addInstitutionUserEntity(institutionUserEntity);
        }
        return "success";
    }

    public InstitutionEntity getInstitutionByName(String name) throws Exception {
        return institutionMapper.getInstitutionByName(name);
    }

    public InstitutionEntity getInstitutionById(String id) throws Exception {
        return institutionMapper.getInstitutionById(id);
    }

    public void updateInstitutionLogo(String logo, String id) throws Exception {
        institutionMapper.updateInstitutionLogo(logo, id);
    }

    public void updateInstitutionInfo(InstitutionEntity institutionEntity) throws Exception {
        institutionMapper.updateInstitutionInfo(institutionEntity);
    }

    public String addChildInstitution(InstitutionEntity institutionEntity, UserEntity userEntity) throws Exception {
        InstitutionEntity institutionEntity2 = institutionMapper.getInstitutionByName(institutionEntity.getName());
        if (institutionEntity2 != null) {
            return "name been used";
        }
        institutionMapper.addInstitution(institutionEntity);
        userMapper.updateInfo(userEntity);
        institutionMapper.addInstitutionUser(institutionEntity.getId(), userEntity.getId());
        return "success";
    }

    public List<InstitutionEntity> getInstitutionListPage(Page page) throws Exception {
        return institutionMapper.getInstitutionListPage(page);
    }

    public List<InstitutionEntity> getInstitutionListByName(String name, Page page) throws Exception {
        return institutionMapper.getInstitutionListByName(name, page);
    }

    public List<ChildInstitutionList> getMyChildInstitution(String institutionId, String key) throws Exception {
        if ("".equals(key))
            key = null;
        return institutionMapper.getMyChildInstitution(institutionId, key);
    }

    public void deleteMyChildInstitution(String institutionId) throws Exception {
        // 查看下面是否已经有课程，如果有则不能删除
        if (institutionMapper.getChildInstitutionCourseCount(institutionId) != 0) {
            throw new DeleteChildException("子机构下已有课程，不能删除");
        }
        institutionMapper.deleteMyChildInstitution(institutionId);
        // 删除机构人员关系
        institutionMapper.deleteInstitutionUser(institutionId);
    }

    public List<UserEntity> getMyChildInstitutionAdmin(String institutionId) throws Exception {
        return userMapper.getMyChildInstitutionAdmin(institutionId);
    }

    public void updateInstitutionFace(String institutionId, String face)
            throws Exception {
        institutionMapper.updateInstitutionFace(institutionId, face);
    }

    public List<InstitutionWithPropa> getInstitutionWithPropaListPage(String key, Integer regionId, Page page) throws Exception {
        if (regionId == null)
            regionId = 0;
        if ("".equals(key))
            key = null;
        return institutionMapper.getInstitutionWithPropaListPage(key, regionId, page);
    }

    public void addComment(String userId, String institutionId, String context)
            throws Exception {
        Comment comment = new Comment();
        comment.setContext(context);
        comment.setCreateTime(new Date());
        comment.setIsOriginal(false);
        comment.setUserId(userId);
        commentMapper.add(comment);
        InstitutionComment institutionComment = new InstitutionComment();
        institutionComment.setCommentId(comment.getId());
        institutionComment.setCreateTime(new Date());
        institutionComment.setInstitutionId(institutionId);
        institutionCommentMapper.add(institutionComment);
    }

    public Object getInstitutionComments(String institutionId, String userId,
                                         Page page) throws Exception {
        List<Integer> commentIds = institutionCommentMapper.getInstitutionCommentIds(institutionId, page);
        if (commentIds != null && commentIds.size() != 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", commentIds);
            map.put("userId", userId);
            Object o = commentMapper.getCommentsByIds(map);
            return o;
        }
        return null;
    }

    public void addInstitutionLove(InstitutionLove institutionLove)
            throws Exception {
        institutionLoveMapper.add(institutionLove);
    }

    public void deleteInstitutionLove(int loveId) throws Exception {
        institutionLoveMapper.delete(loveId);
    }

    public InstitutionFace updateAndGetInstitutionFaceById(String institutionId, String userId)
            throws Exception {
        if (institutionVisitMapper.getUserVisitCount(institutionId, userId) == 0) {
            InstitutionVisit institutionVisit = new InstitutionVisit();
            institutionVisit.setCreateTime(new Date());
            institutionVisit.setInstitutionId(institutionId);
            institutionVisit.setUserId(userId);
            institutionVisitMapper.add(institutionVisit);
            institutionMapper.updateVisitCount(institutionId);
        }
        InstitutionFace institutionFace = institutionMapper.getById(institutionId);
        institutionFace.setCommentCount(institutionCommentMapper.getCommentCount(institutionId));
        institutionFace.setFansCount(institutionFansMapper.getFansCount(institutionId));
        institutionFace.setFansId(institutionFansMapper.getId(institutionId, userId));
        institutionFace.setCourseName(institutionMapper.getCourseNames(institutionId));
        institutionFace.setLoveCount(institutionLoveMapper.getInstitutionLoveCount(institutionId));
        institutionFace.setLoveId(institutionLoveMapper.getLoveId(institutionId, userId));
        return institutionFace;
    }

    public void addInstitutionFans(InstitutionFans institutionFans) throws Exception {
        institutionFans.setCreateTime(new Date());
        institutionFansMapper.add(institutionFans);
    }

    public void deleteInstitutionFans(Integer fansId) throws Exception {
        institutionFansMapper.delete(fansId);
    }

    public Object getInstitutionManagerList(String institutionId, String key)
            throws Exception {
        if ("".equals(key))
            key = null;
        return institutionMapper.getInstitutionManagerList(institutionId, key);
    }

    public List<ChildInstitutionList> getUnMyChildInstitution(
            String institutionId, String key) throws Exception {
        if ("".equals(key))
            key = null;
        return institutionMapper.getUnMyChildInstitution(institutionId, key);
    }

    public String addBatchMyChildInstitution(String institutionId,
                                             List<String> childIds, String credence) throws Exception {
        InstitutionEntity institutionEntity = institutionMapper.getInstitutionById(credence);
        if (institutionEntity == null || !institutionEntity.getId().equals(childIds.get(0)))
            return "添加失败，请确认填写的子机构凭证是正确的";
        if (institutionEntity.getParentId() != null)
            return "添加失败，请确认被添加的子机构没有被添加过";
        InstitutionEntity institutionParent = institutionMapper.getInstitutionById(institutionId);
        if (institutionParent.getParentId() != null)
            return "已是分机构的不能再添加分机构";
        if (childIds != null && childIds.size() != 0)
            institutionMapper.addBatchMyChildInstitution(institutionId, childIds);
        return null;
    }

    public void deleteBatchMyChildInstitution(String institutionId,
                                              List<String> childIds) throws Exception {
        if (childIds != null && childIds.size() != 0)
            institutionMapper.deleteBatchMyChildInstitution(institutionId, childIds);
    }

    public Object getInstitutionUnManagerList(String institutionId, String key)
            throws Exception {
        if ("".equals(key))
            key = null;
        return institutionMapper.getInstitutionUnManagerList(institutionId, key);
    }

    public String addInstitutionManagerBatch(String institutionId,
                                             List<String> userIds) throws Exception {
        StringBuffer m = new StringBuffer();
        if (userIds != null && userIds.size() != 0) {
            for (String userId : userIds) {
                // TODO
                //是否选择了多个机构
                if (institutionMapper.getMyInstitutionCount(userId) > 1) {
                    m.append(userId);
                    continue;
                }
                institutionMapper.updateMyOldType(userId);
                institutionMapper.addInstitutionManagerBatch(userId);
            }
        }
        return m.toString();
    }

    public String deleteInstitutionManagerBatch(String institutionId,
                                                List<String> userIds) throws Exception {
        String m = null;
        if (userIds != null && userIds.size() != 0) {
            for (String userId : userIds) {
                //主管理员不能删除
                if (institutionMapper.getMyOldType(userId) == null) {
                    m = "主管理员不能删除";
                    continue;
                }
                institutionMapper.updateBackMyOldType(userId);
            }
        }
        return m;
    }

    public int getInstitutionCount(String key) throws Exception {
        if ("".equals(key))
            key = null;
        return institutionMapper.getInstitutionCount(key);
    }

    public void deleteInstitution(String institutionId) throws Exception {
        institutionMapper.deleteInstitution(institutionId);
        //删除机构的公告
        announcementMapper.deleteByInstitutionId(institutionId);
        //删除机构公告读
        announcementReadMapper.deleteByInstitutionId(institutionId);
        //删除班级
        classMapper.deleteByInstitutionId(institutionId);
        //删除班级报名
        classSignMapper.deleteByInstitutionId(institutionId);
        classSignMapper.deleteSignByInstitutionId(institutionId);
        //删除机构fans
        institutionFansMapper.deleteByInstitutionId(institutionId);
        //删除机构love
        institutionLoveMapper.deleteByInstitutionId(institutionId);
        //删除机构propa
        propaMapper.deleteByInstitutionId(institutionId);
        //删除机构的管理员
        List<UserEntity> userEntitys = userMapper.getInsAdminByInsId(institutionId);
        if (userEntitys != null && userEntitys.size() != 0) {
            userMapper.deleteById(userEntitys.get(0).getId());
            //删除环信账号
            chatService.deleteUser(userEntitys.get(0).getId());
        }
        //删除机构user
        institutionMapper.deleteReleationByDeletedInstitution(institutionId);
    }
}
