package com.dskj.user.mapper;

import java.util.List;

import com.dskj.user.entity.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.util.Page;

@Repository
public interface InstitutionMapper extends CacheBean {
    public void addInstitution(InstitutionEntity institutionEntity) throws Exception;

    public void addInstitutionUser(String institutionId, String userId) throws Exception;

    public void addInstitutionUserEntity(InstitutionUserEntity institutionUserEntity) throws Exception;

    public InstitutionEntity getInstitutionByName(String name) throws Exception;

    public InstitutionEntity getInstitutionById(String id) throws Exception;

    public void updateInstitutionLogo(String logo, String id) throws Exception;

    public void updateInstitutionInfo(InstitutionEntity institutionEntity) throws Exception;

    public List<InstitutionEntity> getInstitutionListPage(Page page) throws Exception;

    public List<InstitutionEntity> getMyInstitution(String id) throws Exception;

    public void registInstitutions(List<InstitutionUserEntity> institutionUserEntities) throws Exception;

    public List<InstitutionEntity> getOtherInstitution(@Param("id") String id, @Param("page") Page page) throws Exception;

    public List<InstitutionEntity> getInstitutionListByName(@Param("name") String name, @Param("page") Page page) throws Exception;

    public void deleteMyInstitution(String userId, String institutionId) throws Exception;

    public List<ChildInstitutionList> getMyChildInstitution(@Param("institutionId") String institutionId,@Param("key") String key) throws Exception;

    public void deleteMyChildInstitution(String institutionId) throws Exception;

    public int getChildInstitutionCourseCount(String institutionId) throws Exception;

    public void deleteInstitutionUser(String institutionId) throws Exception;

    public void updateInstitutionFace(String institutionId, String face) throws Exception;

    public List<InstitutionEntity> getOtherInstitutionSearch(@Param("id") String id, @Param("key") String key) throws Exception;

    public List<InstitutionUserEntity> getMyInstitutionUser(String userId) throws Exception;

    public void addCurrentInstitution(InstitutionUserEntity institutionUserEntity) throws Exception;

    public void deleteAllCurrentInstitution(String userId) throws Exception;

    public List<InstitutionWithCurrent> getMyInstitutionWithCurrent(String id) throws Exception;

    /**
     * 慎用此接口
     *
     * @throws Exception
     */
    public void updateCurrentStatus(String userId) throws Exception;

    public List<InstitutionWithPropa> getInstitutionWithPropaListPage(@Param("key") String key,@Param("regionId") Integer regionId,@Param("page") Page page) throws Exception;

    public InstitutionFace getById(String id) throws Exception;

    public List<String> getCourseNames(String institutionId) throws Exception;

    public void updateVisitCount(String institutionId) throws Exception;

    public List<UserEntity> getInstitutionTeacherSearch2_0(@Param("institutionId") String  institutionId,@Param("key") String key,@Param("page") Page page) throws Exception;

    public void deleteInstitutionTeacherSearchBatch2_0(@Param("institutionId") String institutionId,@Param("teacherIds") List<String> teacherIds) throws Exception;

    public void addInstitutionTeacherSearchBatch2_0(@Param("teacherIds") List<InstitutionUserEntity> teacherIds) throws Exception;
    
    public List<String> getInstitutionStudentAll2_0(@Param("institutionId") String  institutionId,@Param("page") Page page) throws Exception;
    
    public List<UserEntity> getInstitutionStudentSearch2_0(@Param("institutionId") String  institutionId,@Param("key") String key,@Param("page") Page page) throws Exception;
    
    public List<InstitutionWithPropa> getUserMyInstitution2_0(@Param("userId") String userId,@Param("page") Page page) throws Exception;
    
    public List<InstitutionWithPropa> getUserMyInstitutionSearch2_0(@Param("userId") String userId,@Param("key") String key,@Param("page") Page page) throws Exception;
    
    public void addUserMyInstitution(@Param("institutionIds") List<InstitutionUserEntity> institutionIds) throws Exception;
    
    public int getUserMyInstitutionCount(String userId) throws Exception;
    
    public List<InstitutionWithPropa> getUserNotInstitutionSearch2_0(@Param("userId") String userId,@Param("key") String key,@Param("page") Page page) throws Exception;
    
    public void deleteUserMyInstitution2_0(@Param("userId") String userId,@Param("institutionIds") List<String> institutionIds) throws Exception;
    
    public List<UserEntity> getInstitutionManagerList(@Param("institutionId") String institutionId,@Param("key") String key) throws Exception;
    
    public List<ChildInstitutionList> getUnMyChildInstitution(@Param("institutionId") String institutionId,@Param("key") String key) throws Exception;
    
    public void addBatchMyChildInstitution(@Param("institutionId") String institutionId,
			@Param("childIds") List<String> childIds) throws Exception;
    
    public void deleteBatchMyChildInstitution(@Param("institutionId") String institutionId,
			@Param("childIds") List<String> childIds) throws Exception;
    
    public List<UserEntity> getInstitutionUnManagerList(@Param("institutionId") String institutionId,@Param("key") String key) throws Exception;
    
    public void addInstitutionManagerBatch(String userId) throws Exception;
    
    public int getMyInstitutionCount(String userId) throws Exception;
    
    public void updateMyOldType(String userId) throws Exception;
    
    public void updateBackMyOldType(String userId) throws Exception;
    
    public Integer getMyOldType(String userId) throws Exception;
    
    public int getInstitutionCount(@Param("key") String key) throws Exception;
    
    public void deleteInstitution(String institutionId) throws Exception;

    public void deleteReleationByDeletedInstitution(String institutionId) throws Exception;
}
