package com.dskj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.user.entity.InstitutionComment;
import com.dskj.util.Page;

@Repository
public interface InstitutionCommentMapper extends CacheBean {

    public void add(InstitutionComment institutionComment) throws Exception;

    public List<Integer> getInstitutionCommentIds(@Param("institutionId") String institutionId,
                                                  @Param("page") Page page) throws Exception;

    public int getCommentCount(String institutionId) throws Exception;

}
