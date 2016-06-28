package com.dskj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.user.entity.Collect;
import com.dskj.user.entity.CollectInstitution;
import com.dskj.user.entity.InstitutionEntity;
import com.dskj.util.Page;

@Repository
public interface CollectMapper {
    public void add(Collect collect) throws Exception;

    public List<CollectInstitution> list(@Param("userId") String userId, @Param("columnKey") String columnKey, @Param("page") Page page) throws Exception;

    public void delete(int id) throws Exception;

    public List<InstitutionEntity> getCollectInstitutionSearch(@Param("userId") String userId, @Param("key") String key, @Param("page") Page page) throws Exception;

    public int getCollectCount(String institutionId) throws Exception;

    public Integer getId(String institutionId, String userId) throws Exception;

    public int getUserCollectCount(String userId) throws Exception;

    public Integer getUserCollectId(String userId, String beenUserId) throws Exception;
    
    public Integer getClassCollectId(int classId,String userId) throws Exception;
}
