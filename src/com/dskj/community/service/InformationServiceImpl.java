package com.dskj.community.service;

import com.dskj.base.Base;
import com.dskj.comment.entity.Comment;
import com.dskj.comment.mapper.CommentMapper;
import com.dskj.community.entity.Information;
import com.dskj.community.entity.InformationCollect;
import com.dskj.community.entity.InformationImg;
import com.dskj.community.entity.InformationLove;
import com.dskj.community.mapper.InformationImgMapper;
import com.dskj.community.mapper.InformationLoveMapper;
import com.dskj.community.mapper.InformationMapper;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InformationServiceImpl extends Base implements InformationService {

    @Autowired
    private InformationMapper informationMapper;
    @Autowired
    private InformationImgMapper informationImgMapper;
    @Autowired
    private InformationLoveMapper informationLoveMapper;
    @Autowired
    private CommentMapper commentMapper;

    public Integer addInformation(String userId, String title, String summary, String context,
                                  List<String> imgUrls) throws Exception {
        Information information = new Information();
        information.setTitle(title);
        information.setSummary(summary);
        information.setContext(context);
        information.setCreateTime(new Date());
        information.setUserId(userId);
        informationMapper.add(information);
        if (imgUrls != null && imgUrls.size() != 0) {
            List<InformationImg> informationImgs = new ArrayList<InformationImg>();
            for (String imgUrl : imgUrls) {
                InformationImg informationImg = new InformationImg();
                informationImg.setInfoId(information.getId());
                informationImg.setUrl(imgUrl);
                informationImgs.add(informationImg);
            }
            informationImgMapper.add(informationImgs);
        }
        return information.getId();
    }

    public void deleteInformation(int infoId) throws Exception {
        informationMapper.delete(infoId);
        informationImgMapper.delete(infoId);
    }

    public List<Information> getInformationList(String userId, Page page)
            throws Exception {
        return informationMapper.getList(userId, page);
    }

    public Information getInformation(int infoId, String userId)
            throws Exception {
        return informationMapper.get(infoId, userId);
    }

    public InformationLove addInformationLove(int infoId, String userId)
            throws Exception {
        InformationLove informationLove = new InformationLove();
        informationLove.setInfoId(infoId);
        informationLove.setUserId(userId);
        informationLoveMapper.add(informationLove);
        return informationLove;
    }

    @Override
    public void deleteInformationLove(int infoId, String userId)
            throws Exception {
        informationLoveMapper.delete(infoId, userId);
    }

    @Override
    public InformationCollect addInformationCollect(int infoId, String userId)
            throws Exception {
        InformationCollect informationCollect = new InformationCollect();
        informationCollect.setInfoId(infoId);
        informationCollect.setUserId(userId);
        informationMapper.addInformationCollect(informationCollect);
        return informationCollect;
    }

    @Override
    public void deleteInformationCollect(int infoId, String userId)
            throws Exception {
        informationMapper.deleteInformationCollect(infoId, userId);
    }

    @Override
    public void addInformationComment(int infoId, String userId, String context)
            throws Exception {
        Comment comment = new Comment();
        comment.setContext(context);
        comment.setCreateTime(new Date());
        comment.setIsOriginal(false);
        comment.setUserId(userId);
        commentMapper.add(comment);
        informationMapper.addInformationComment(infoId, comment.getId());
    }

    @Override
    public void deleteInformationComment(int infoId, int commentId)
            throws Exception {
        commentMapper.delete(commentId);
        informationMapper.deleteInformationComment(infoId, commentId);
    }

    @Override
    public Object getInformationComments(int infoId, String userId, Page page)
            throws Exception {
        List<Integer> commentIds = informationMapper.getInformationCommentIds(
                infoId, page);
        if (commentIds != null && commentIds.size() != 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", commentIds);
            map.put("userId", userId);
            Object o = commentMapper.getCommentsByIds(map);
            return o;
        }
        return null;
    }

    public int getInformationCount() throws Exception {
        return informationMapper.getInformationCount();
    }

    public void updateInformation(int infoId, String title, String summary, String context, String imgUrl)
            throws Exception {
        informationMapper.update(title, summary, context, infoId);
        informationImgMapper.delete(infoId);
        if (imgUrl != null) {
            List<InformationImg> informationImgs = new ArrayList<InformationImg>();
            InformationImg informationImg = new InformationImg();
            informationImg.setInfoId(infoId);
            informationImg.setUrl(imgUrl);
            informationImgs.add(informationImg);
            informationImgMapper.add(informationImgs);
        }
    }

}
