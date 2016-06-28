package com.dskj.community.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.Circle;

@Repository
public interface CircleMapper extends CacheBean {
    public void add(Circle circle) throws Exception;

    public List<Circle> getList() throws Exception;

    public void update(Circle circle) throws Exception;

    public void delete(int id) throws Exception;

    public List<Integer> getUserCircles(String userId) throws Exception;
}
