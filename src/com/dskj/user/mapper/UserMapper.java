package com.dskj.user.mapper;

import java.util.List;

import com.dskj.user.entity.UserFace;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.user.entity.UserEntity;
import com.dskj.util.Page;

@Repository
public interface UserMapper extends CacheBean {
    public void addUser(UserEntity userEntity) throws Exception;

    public Integer getUserCountByPhone(String phone) throws Exception;

    public List<UserEntity> getRegistedPhones(List<String> phones) throws Exception;

    public UserEntity userLogin(String phone, String password) throws Exception;

    public void updatePassword(String phone, String password) throws Exception;

    public UserEntity getById(String id) throws Exception;

    public void updatePhoto(String id, String photo) throws Exception;

    public void updateInfo(UserEntity userEntity) throws Exception;

    public UserEntity userQQLogin(String qqOpenId) throws Exception;

    public UserEntity userSinaLogin(String sinaOpenId) throws Exception;

    public UserEntity userWeiXinLogin(String weixinOpenId) throws Exception;

    public void userBindQQ(String qqOpenId, String id) throws Exception;

    public void userBindSina(String sinaOpenId, String id) throws Exception;

    public void userBindWeiXin(String weixinOpenId, String id) throws Exception;

    public List<UserEntity> getUserListPage(Page page) throws Exception;

    public List<UserEntity> getManageTeacherList(String institutionId) throws Exception;

    public List<UserEntity> getManageTeacherSearch(@Param("institutionId") String institutionId, @Param("key") String key, @Param("page") Page page) throws Exception;

    public List<UserEntity> getManageUserSearch(@Param("institutionId") String institutionId, @Param("key") String key, @Param("page") Page page) throws Exception;

    public List<UserEntity> getManageStudentSearch(@Param("institutionId") String institutionId, @Param("key") String key, @Param("page") Page page) throws Exception;

    public int getMyClassCountByInstitution(String userId, String institutionId) throws Exception;

    public List<UserEntity> getMyChildInstitutionAdmin(String institutionId) throws Exception;

    public List<UserEntity> getSystemUser(@Param("key") String key, @Param("page") Page page) throws Exception;

    public int getAllUserCount() throws Exception;

    public List<UserEntity> getFriendList(List<String> ids) throws Exception;

    public List<UserEntity> getSupperAdminList(@Param("userId") String userId,@Param("key") String key, @Param("page") Page page) throws Exception;

    public List<UserEntity> getSystemUserAll(@Param("key") String key, @Param("page") Page page) throws Exception;

    public UserFace getFaceById(String userId) throws Exception;

    public void updateUserVisitCount(String userId) throws Exception;
    
    public List<UserEntity> getInstitutionStudentAll2_0(@Param("userIds") List<String> userIds) throws Exception;
    
    public List<UserEntity> getUnfirendSearch2_0(@Param("key") String key,@Param("ids") List<String> ids,@Param("page") Page page) throws Exception;
    
    public List<UserEntity> getFirendSearch2_0(@Param("key") String key,@Param("ids") List<String> ids) throws Exception;
    
    public List<UserEntity> getplatformsList(@Param("page") Page page) throws Exception;
    
    public int getplatformsCount() throws Exception;
    
    public int getSupperAdminCount(@Param("userId") String userId,@Param("key") String key) throws Exception;
    
    public List<UserEntity> getNomalUserSearch(@Param("key") String key,@Param("page") Page page) throws Exception;
    
    public int getNomalUserSearchCount(@Param("key") String key) throws Exception;
    
    public void addPlatformsAdmin(String userId) throws Exception;
    
    public int getMyInstitutionCount(String userId) throws Exception;
    
    public void deletePlatformsAdmin(String userId) throws Exception;

    public  List<UserEntity> getInsAdminByInsId(String institutionId) throws Exception;

    public void deleteById(String userId) throws Exception;

}
