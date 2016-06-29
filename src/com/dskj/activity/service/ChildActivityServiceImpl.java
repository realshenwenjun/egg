package com.dskj.activity.service;

import com.dskj.activity.entity.*;
import com.dskj.activity.mapper.*;
import com.dskj.base.Base;
import com.dskj.comment.entity.Comment;
import com.dskj.comment.mapper.CommentMapper;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChildActivityServiceImpl extends Base implements ChildActivityService {

    @Autowired
    private ChildActivityMapper childActivityMapper;
    @Autowired
    private ChildActivityCollectMapper childActivityCollectMapper;
    @Autowired
    private ChildActivityCommentMapper childActivityCommentMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ChildActivityLoveMapper childActivityLoveMapper;
    @Autowired
    private ChildActivityImgMapper childActivityImgMapper;
    @Autowired
    private ChildActivityReservationMapper childActivityReservationMapper;

    public void add(ChildActivity ChildActivity) throws Exception {
        childActivityMapper.insert(ChildActivity);
    }

    public void update(ChildActivity childActivity) throws Exception {
        childActivityMapper.updateByPrimaryKey(childActivity);
    }

    public void delete(List<Integer> ids) throws Exception {
        childActivityMapper.delete(ids);
    }

    public ChildActivity get(Integer id, String userId) throws Exception {
        ChildActivity childActivity = childActivityMapper.selectByPrimaryKey(id);
        childActivity.setActivityCollectId(childActivityCollectMapper.getId(userId, id));
        childActivity.setCommentCount(childActivityCommentMapper.getCommentCount(id));
        childActivity.setLoveCount(childActivityLoveMapper.getLoveCount(id));
        childActivity.setActivityLoveId(childActivityLoveMapper.getByActivitylIdAndUserId(id, userId));

        ChildActivityReservation record = new ChildActivityReservation();
        record.setUserId(userId);
        record.setChildActivityId(id);
        List<ChildActivityReservation> reservationList = childActivityReservationMapper.selectListBySelectiveNoPage(record);
        childActivity.setActivityReserveId(reservationList.size() > 0 ? reservationList.get(0).getId() : null);

        return childActivity;
    }

    public List<ChildActivity> getList(Page page)
            throws Exception {
        return childActivityMapper.selectAll(page);
    }

    /**
     * 查询  亲子活动
     */
    public List<ChildActivity> getListBySearch(String searchItem, Page page)
            throws Exception {
        return childActivityMapper.selectBySearch(searchItem, page);
    }

    public void addChildActivityCollect(ChildActivityCollect childActivityCollect) throws Exception {
        childActivityCollectMapper.add(childActivityCollect);
    }

    public void addChildActivityComment(int activityId, String userId, String context) throws Exception {
        Comment comment = new Comment();
        comment.setContext(context);
        comment.setCreateTime(new Date());
        comment.setIsOriginal(false);
        comment.setUserId(userId);
        commentMapper.add(comment);
        ChildActivityComment childActivityComment = new ChildActivityComment();
        childActivityComment.setCreateTime(new Date());
        childActivityComment.setActivityId(activityId);
        childActivityComment.setCommentId(comment.getId());
        childActivityCommentMapper.add(childActivityComment);
    }

    public void deleteChildActivityCollect(int activityCollectId) throws Exception {
        childActivityCollectMapper.delete(activityCollectId);
    }

    public Object getActivityComments(int activityId, String userId, Page page) throws Exception {
        List<Integer> commentIds = childActivityCommentMapper.getActivityCommentIds(activityId, page);
        if (commentIds != null && commentIds.size() != 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", commentIds);
            map.put("userId", userId);
            Object o = commentMapper.getCommentsByIds(map);
            return o;
        }
        return null;
    }

    public void addActivityLove(ChildActivityLove childActivityLove)
            throws Exception {
        childActivityLoveMapper.add(childActivityLove);
    }

    public void deleteActivityLove(int activityId, String userId)
            throws Exception {
        childActivityLoveMapper.deleteById(activityId, userId);
    }

    public void addActivityImg(List<ChildActivityImg> activityImgs)
            throws Exception {
        childActivityImgMapper.add(activityImgs);
    }

    public void deleteActivityImg(int activityImgId) throws Exception {
        childActivityImgMapper.deleteById(activityImgId);
    }

    public List<ChildActivityImg> getActivityImgList(int activityId, Page page)
            throws Exception {
        return childActivityImgMapper.getList(activityId, page);
    }

    public int getChildActivityCount() throws Exception {
        return childActivityMapper.getChildActivityCount();
    }

    public void addChildActivityAsk(ChildActivityAsk childActivityAsk)
            throws Exception {
        childActivityMapper.addChildActivityAsk(childActivityAsk);
    }

    public List<ChildActivityAsk> getActivityMyAsk(Integer activityId, String userId, Page page)
            throws Exception {
        if (activityId == null || activityId == 0)
            activityId = null;
        if ("".equals(userId))
            userId = null;
        List<ChildActivityAsk> result = childActivityMapper.getActivityMyAsk(activityId, userId, page);
        if (activityId != null || userId != null) {
            List<ChildActivityAsk> childActivityAsks = new ArrayList<ChildActivityAsk>();
            if (result != null && result.size() != 0) {
                for (int i = result.size() - 1; i >= 0; i--) {
                    childActivityAsks.add(result.get(i));
                }
                return childActivityAsks;
            }
        }
        return result;
    }

    public void addChildActivityAskAnswer(int askId, String userId,
                                          String context) throws Exception {
        ChildActivityAsk childActivityAsk = childActivityMapper.getAsk(askId);
        if (childActivityAsk.getAnswer() != null)
            throw new RuntimeException("已经回复过了");
        childActivityMapper.addChildActivityAskAnswer(askId, childActivityAsk.getActivityId(), userId, context);
    }

    public int getActivityMyAskCount(Integer activityId, String userId)
            throws Exception {
        if (activityId == null || activityId == 0)
            activityId = null;
        if ("".equals(userId))
            userId = null;
        return childActivityMapper.getActivityMyAskCount(activityId, userId);
    }

    public List<ChildActivityAsk> getActivityFeedbackList(Page page)
            throws Exception {
        return childActivityMapper.getActivityFeedbackList(page);
    }

    public int getActivityFeedbackCount() throws Exception {
        return childActivityMapper.getActivityFeedbackCount();
    }

    public List<CancelReason> getCancelCensus() throws Exception {
        return childActivityReservationMapper.getCancelCensus();
    }

	public void deleteActivityMyAsk(int askId) throws Exception {
		ChildActivityAsk childActivityAsk = childActivityMapper.getAsk(askId);
		if (childActivityAsk.getAnswer() != null){
			childActivityMapper.deleteActivityMyAsk(childActivityAsk.getAnswer().getId());
		}
		childActivityMapper.deleteActivityMyAsk(askId);
	}

    @Override
    public void deleteAllActivityMyAsk(String userId, int activityId) throws Exception {
    	List<Integer> ids = childActivityMapper.getAllActivityMyAnswerAsk(userId, activityId);
    	if(ids != null && ids.size() != 0)
    		childActivityMapper.deleteAllActivityMyAnswerAsk(ids);
        childActivityMapper.deleteAllActivityMyAsk(userId,activityId);
    }

    @Override
    public List<ChildActivity> getMyActivityList(String userId, Page page) throws Exception {
        return childActivityMapper.getMyActivityList(userId,page);
    }

    @Override
    public List<UserActivitySign> getActivityUserSign(Integer activityId, Page page) throws Exception {
        if (activityId == 0)
            activityId = null;
        return childActivityReservationMapper.getActivityUserSign(activityId,page);
    }
}
