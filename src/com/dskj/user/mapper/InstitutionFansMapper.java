package com.dskj.user.mapper;

import java.util.List;

import com.dskj.base.CacheBean;
import com.dskj.user.entity.InstitutionFans;
import com.dskj.user.entity2_0.MyFans;

import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionFansMapper extends CacheBean {
    public void add(InstitutionFans institutionFans) throws Exception;

    public int getFansCount(String institutionId) throws Exception;

    public Integer getId(String institutionId, String userId) throws Exception;

    public void delete(Integer id) throws Exception;
    
    public List<MyFans> getUserFansList2_0(String userId) throws Exception;
}
