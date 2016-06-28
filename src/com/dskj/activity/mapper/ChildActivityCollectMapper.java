package com.dskj.activity.mapper;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.activity.entity.ChildActivityCollect;
import com.dskj.user.entity2_0.MyCollect;

@Repository
public interface ChildActivityCollectMapper {
    public void add(ChildActivityCollect childActivityCollect) throws Exception;

    public Integer getId(String userId, int activiytId) throws Exception;

    public void delete(int id) throws Exception;
    
    public List<MyCollect> getUserCollectList2_0(String userId) throws Exception;
}