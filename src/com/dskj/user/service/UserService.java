package com.dskj.user.service;

import com.dskj.user.entity.*;
import com.dskj.user.entity2_0.MyCollect;
import com.dskj.user.entity2_0.MyFans;
import com.dskj.user.entity2_0.UserAsk;
import com.dskj.user.entity2_0.UserGroup;
import com.dskj.util.Page;

import java.util.List;

/**
 * service方法参数尽量不要传对象或者json字符串
 *
 * @author Administrator
 */
public interface UserService {
    public Boolean getCheckPhone(String phone) throws Exception;

    public String addUser(UserEntity userEntity) throws Exception;

    public Object getRegistedPhones(String json) throws Exception;

    public UserEntity getUserLogin(String phone, String password) throws Exception;

    public void updatePassword(String phone, String password) throws Exception;

    public UserEntity getUserById(String id) throws Exception;

    public void updateUserPhoto(String id, String photo) throws Exception;

    public void updateUserInfo(UserEntity userEntity) throws Exception;

    public UserEntity getUserQQLogin(String qqOpenId) throws Exception;

    public UserEntity getUserSinaLogin(String sinaOpenId) throws Exception;

    public UserEntity getUserWeiXinLogin(String weixinOpenId) throws Exception;

    public void updateUserBindQQ(String qqOpenId, String id) throws Exception;

    public void updateUserBindSina(String sinaOpenId, String id) throws Exception;

    public void updateUserBindWeiXin(String weixinOpenId, String id) throws Exception;

    public List<InstitutionEntity> getMyInstitution(String id) throws Exception;

    public void addRegistInstitutions(List<InstitutionUserEntity> institutionUserEntities, String userId) throws Exception;

    public List<UserEntity> getUserListPage(Page page) throws Exception;

    public void addUserLoginLog(UserEntity userEntity) throws Exception;

    public List<InstitutionEntity> getOtherInstitution(String id, Page page) throws Exception;

    public List<UserEntity> getManageTeacherList(String institutionId) throws Exception;

    public List<UserEntity> getManageTeacherSearch(String institutionId, String key, Page page) throws Exception;

    public List<UserEntity> getManageUserSearch(String institutionId, String key, Page page) throws Exception;

    public List<UserEntity> getManageStudentSearch(String institutionId, String key, Page page) throws Exception;

    public int getMyClassCountByInstitution(String userId, String institutionId) throws Exception;

    public void deleteMyInstitution(String userId, String institutionId) throws Exception;

    public List<UserEntity> getSystemUser(String key, Page page) throws Exception;

    public int getAllUserCount() throws Exception;

    public List<UserEntity> getFriendList(List<String> ids) throws Exception;

    public void addCollect(Collect collect) throws Exception;

    public List<CollectInstitution> getCollectList(String userId, String columnKey, Page page) throws Exception;

    public List<InstitutionEntity> getOtherInstitutionSearch(String id, String key) throws Exception;

    public void deleteCollect(int id) throws Exception;

    public List<InstitutionEntity> getCollectInstitutionSearch(String userId, String key, Page page) throws Exception;

    public void addCurrentInstitution(InstitutionUserEntity institutionUserEntity) throws Exception;

    public List<InstitutionWithCurrent> getMyInstitutionWithCurrent(String id) throws Exception;

    public List<UserEntity> getSupperAdminList(String userId,String key, Page page) throws Exception;

    public List<UserEntity> getSystemUserAll(String key, Page page) throws Exception;

    public void addUserCircle(UserCircle userCircle) throws Exception;

    public void deleteUserCircle(int userCircleId) throws Exception;

    public List<UserCircle> getMyCircle(String userId) throws Exception;

    public UserFace updateGetUserFace(String userId, String beenUserId) throws Exception;

    public void addBeenUserFans(UserFans userFans) throws Exception;

    public void deleteBeenUserFans(Integer fansId) throws Exception;

    public List<UserEntity> getInstitutionTeacherSearch2_0(String  institutionId,String key,Page page) throws Exception;

    public void deleteInstitutionTeacherSearchBatch2_0(String institutionId,List<String> teacherIds) throws Exception;

    public void addInstitutionTeacherSearchBatch2_0(String institutionId,List<String> teacherIds) throws Exception;
    
    
    public List<UserEntity> getInstitutionStudentAll2_0(String  institutionId,Page page) throws Exception;
    
    public List<UserEntity> getInstitutionStudentSearch2_0(String  institutionId,String key,Page page) throws Exception;
    
    public Object getUserMyInstitution2_0(String userId,Page page) throws Exception;
    
    public Object getUserMyInstitutionSearch2_0(String userId,String key,Page page) throws Exception;
    
    public void addUserMyInstitution2_0(String userId,List<String> institutionId) throws Exception;
    
    public Object getUserNotInstitutionSearch2_0(String userId,String key,Page page) throws Exception;
    
    public void deleteUserMyInstitution2_0(String userId,List<String> institutionId) throws Exception;
    
    public List<MyFans> getUserFansList2_0(String userId) throws Exception;
    
    public void deleteUserFans2_0(int fansId,int type) throws Exception;
    
    public List<MyCollect> getUserCollectList2_0(String userId) throws Exception;
    
    public void deleteUserCollectList2_0(int collectId,int type) throws Exception;
    
    public List<UserEntity> getUnfirendSearch2_0(String key,List<String> ids,Page page) throws Exception;
    
    public List<UserEntity> getFirendSearch2_0(String key,List<String> ids) throws Exception;

    public void addUserPhoto(List<String> urls,String userId) throws Exception;

    public void deleteUserPhoto(List<Integer> ids) throws Exception;

    public Object getUserPhotot2_0(String userId) throws Exception;

    public void addUserAsk(UserAsk userAsk) throws Exception;

    public Object getUserAskList2_0(String institutionId,Page page) throws Exception;
    
    public void addUserGroup(UserGroup userGroup) throws Exception;
    
    public UserGroup getUserGroup(String uid) throws Exception;
    
    public List<UserEntity> getplatformsList(Page page) throws Exception;
    
    public int getplatformsCount() throws Exception;
    
    public int getSupperAdminCount(String userId,String key) throws Exception;
    
    public List<UserEntity> getNomalUserSearch(String key,Page page) throws Exception;
    
    public int getNomalUserSearchCount(String key) throws Exception;
    
    public String addPlatformsAdmin(String userId) throws Exception;
    
    public String deletePlatformsAdmin(String userId) throws Exception;
}
