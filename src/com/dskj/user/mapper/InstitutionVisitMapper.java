package com.dskj.user.mapper;

import com.dskj.base.CacheBean;
import com.dskj.user.entity.InstitutionVisit;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionVisitMapper extends CacheBean {
    public void add(InstitutionVisit institutionVisit) throws Exception;

    public int getUserVisitCount(String institutionId, String userId) throws Exception;
}
