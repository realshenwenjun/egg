package com.dskj.user.mapper;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.user.entity.InstitutionLove;

@Repository
public interface InstitutionLoveMapper extends CacheBean {
    public void add(InstitutionLove institutionLove) throws Exception;

    public void delete(int id) throws Exception;

    public int getInstitutionLoveCount(String institutionId) throws Exception;

    public Integer getLoveId(String institutionId, String userId) throws Exception;
}
