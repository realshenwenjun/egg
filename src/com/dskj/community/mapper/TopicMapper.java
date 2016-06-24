package com.dskj.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.Topic;
import com.dskj.util.Page;

@Repository
public interface TopicMapper extends CacheBean {

    public void add(Topic topic) throws Exception;

    public List<Topic> getList(@Param("page") Page page) throws Exception;

    public void update(Topic topic) throws Exception;

    public void delete(Integer id) throws Exception;
}
