package com.dskj.activity.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.activity.entity.ChildActivity;
import com.dskj.activity.entity.ChildActivityAsk;
import com.dskj.util.Page;

@Repository
public interface ChildActivityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ChildActivity record);

    int insertSelective(ChildActivity record);

    ChildActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChildActivity record);

    int updateByPrimaryKey(ChildActivity record);


    List<ChildActivity> selectAll(@Param("page") Page page);

    List<ChildActivity> selectBySearch(@Param("searchItem") String searchItem, @Param("page") Page page);

    public void delete(List<Integer> ids) throws Exception;
    
    public int getChildActivityCount() throws Exception; 
    
    public void addChildActivityAsk(ChildActivityAsk childActivityAsk) throws Exception;
    
    public List<ChildActivityAsk> getActivityMyAsk(@Param("activityId") Integer activityId,@Param("userId") String userId,@Param("page") Page page) throws Exception;
    
    public void addChildActivityAskAnswer(int askId,int activityId,String userId,String context) throws Exception;
    
    public ChildActivityAsk getAsk(int askId) throws Exception;
    
    public int getActivityMyAskCount(@Param("activityId") Integer activityId,@Param("userId") String userId) throws Exception;
    
    public List<ChildActivityAsk> getActivityFeedbackList(@Param("page") Page page) throws Exception;
    
    public int getActivityFeedbackCount() throws Exception;
    
    public void deleteActivityMyAsk(int askId) throws Exception;

    public void deleteAllActivityMyAsk(String userId,int activityId) throws Exception;
    
    public List<Integer> getAllActivityMyAnswerAsk(String userId,int activityId) throws Exception;
    
    public void deleteAllActivityMyAnswerAsk(List<Integer> ids) throws Exception;

}