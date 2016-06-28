package com.dskj.activity.service;

import java.util.List;

import com.dskj.activity.entity.CancelReason;
import com.dskj.activity.entity.ChildActivity;
import com.dskj.activity.entity.ChildActivityAsk;
import com.dskj.activity.entity.ChildActivityCollect;
import com.dskj.activity.entity.ChildActivityImg;
import com.dskj.activity.entity.ChildActivityLove;
import com.dskj.util.Page;

public interface ChildActivityService {

    public void add(ChildActivity ChildActivity) throws Exception;

    public void update(ChildActivity ChildActivity) throws Exception;

    public void delete(List<Integer> ids) throws Exception;

    public ChildActivity get(Integer id, String userId) throws Exception;

    public List<ChildActivity> getList(Page page) throws Exception;

    public List<ChildActivity> getListBySearch(String searchItem, Page page) throws Exception;


    public void addChildActivityCollect(ChildActivityCollect childActivityCollect) throws Exception;

    public void addChildActivityComment(int activityId, String userId, String context) throws Exception;

    public void deleteChildActivityCollect(int activityCollectId) throws Exception;

    public Object getActivityComments(int activityId, String userId, Page page) throws Exception;
    
    public void addActivityLove(ChildActivityLove childActivityLove) throws Exception;
    
    public void deleteActivityLove(int activityId,String userId) throws Exception;
    
    public void addActivityImg(List<ChildActivityImg> activityImgs) throws Exception;
    
    public void deleteActivityImg(int activityImgId) throws Exception;
    
    public List<ChildActivityImg> getActivityImgList(int activityId,Page page) throws Exception;
    
    public int getChildActivityCount() throws Exception;
    
    public void addChildActivityAsk(ChildActivityAsk childActivityAsk) throws Exception;
    
    public List<ChildActivityAsk> getActivityMyAsk(Integer activityId,String userId,Page page) throws Exception;
    
    public void addChildActivityAskAnswer(int askId,String userId,String context) throws Exception;
    
    public int getActivityMyAskCount(Integer activityId,String userId) throws Exception;
    
    public List<ChildActivityAsk> getActivityFeedbackList(Page page) throws Exception;
    
    public int getActivityFeedbackCount() throws Exception;
    
    public List<CancelReason> getCancelCensus() throws Exception;
    
    public void deleteActivityMyAsk(int askId) throws Exception;

    public void deleteAllActivityMyAsk(String userId,int activityId) throws Exception;

    public List<ChildActivity> getMyActivityList(String userId,Page page) throws Exception;
}
