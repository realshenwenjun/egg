package com.dskj.comment.controll;

import com.dskj.base.Base;
import com.dskj.comment.entity.Comment;
import com.dskj.comment.entity.CommentLove;
import com.dskj.comment.service.CommentService;
import com.dskj.message.mq.MqManager;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentControll extends Base {
    @Autowired
    private CommentService commentService;
    @Autowired
    private MqManager mqManager;

    /*
     * 获取下级评论列表 comment={"id":1,"userId":"","pageNo":0,"pageSize":10}
     */
    @RequestMapping("/comment/child/list")
    public void getCommentChildList(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("comment");
        logger.info(jsoString);
        Page page = new Page();
        page.setPageNo(readTreeAsInt(jsoString, "pageNo"));
        page.setPageSize(readTreeAsInt(jsoString, "pageSize"));
        Object o = commentService.getChildrenComments(
                readTreeAsInt(jsoString, "id"),
                readTree(jsoString, "userId"), page);
        write(response, null, null, null, o);
    }

    /*
     * 增加一条下级评论
     * comment={"parentId":1,"userId":"","context":"内容","isPublic":true,
     * "videoPaths":["",""],"imagePaths":["",""]}
     * 选填：isPublic,videoPaths，imagePaths
     */
    @RequestMapping("/comment/child/add")
    public void addCommentChild(HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("comment");
        logger.info(jsoString);
        Comment comment = new Comment();
        comment.setContext(readTree(jsoString, "context"));
        comment.setParentId(readTreeAsInt(jsoString, "parentId"));
        comment.setUserId(readTree(jsoString, "userId"));
        comment.setIsOriginal(true);
        comment.setIsPublic(readTreeAsBoolean(jsoString, "isPublic"));
        comment.setCreateTime(new Date());
        String videoPaths = readTree(jsoString, "videoPaths");
        String imagePaths = readTree(jsoString, "imagePaths");
        commentService.addChildComment(comment, videoPaths, imagePaths);
        Comment commentParent = commentService.getByCommentId(comment
                .getParentId());
        if (commentParent != null) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("parentUserId", commentParent.getUserId());
            map.put("parentCommentId", commentParent.getId());
            map.put("userId", comment.getUserId());
            map.put("commentId", comment.getId());
            mqManager.getMqList().get(0).put(map);
        }
        write(response, null, null, null, comment);
    }

    /*
     * 关注一条评论 comment={"commentId":1,"userId":""}
     */
    @RequestMapping("/comment/love/add")
    public void addCommentLove(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("comment");
        logger.info(jsoString);
        CommentLove commentLove = stringToObj(jsoString, CommentLove.class);
        commentLove.setCreateTime(new Date());
        commentService.addCommentLove(commentLove);
        write(response, null, null, null, commentLove);
    }

    /*
     * 取消关注一条评论 comment={"commentId":1,"userId":""}
     */
    @RequestMapping("/comment/love/delete")
    public void deleteCommentLove(HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("comment");
        logger.info(jsoString);
        CommentLove commentLove = stringToObj(jsoString, CommentLove.class);
        commentService.deleteCommentLove(commentLove.getCommentId(),
                commentLove.getUserId());
        write(response, null, null, null, null);
    }

    /*
     * 获取跟评 comment={"commentId":1,"pageNo":0,"pageSize":10}
     */
    @RequestMapping("/comment/child/get")
    public void getChildComments(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("comment");
        logger.info(jsoString);
        Page page = new Page();
        page.setPageNo(readTreeAsInt(jsoString, "pageNo"));
        page.setPageSize(readTreeAsInt(jsoString, "pageSize"));
        write(response,
                null,
                null,
                null,
                commentService.getChildComments(
                        readTreeAsInt(jsoString, "commentId"), page));
    }

    /*
     * 删除评论 comment={"id":1}
     */
    @RequestMapping("/comment/delete")
    public void deleteComment(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("comment");
        logger.info(jsoString);
        commentService.deleteComment(readTreeAsInt(jsoString, "id"));
        write(response, null, null, null, null);
    }

    /*
     * 获取评论详情 comment={"id":1,"userId":""}
     */
    @RequestMapping("/comment/detail")
    public void getCommentDetail(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("comment");
        logger.info(jsoString);
        write(response,
                null,
                null,
                null,
                commentService.getCommentVOById(
                        readTreeAsInt(jsoString, "id"),
                        readTree(jsoString, "userId")));
    }

    /*
     * 获取评论消息 comment={"userId":"","pageNo":0,"pageSize":10}
     */
    @RequestMapping("/comment/message/list")
    public void getCommentMessageList(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("comment");
        logger.info(jsoString);
        Page page = new Page();
        page.setPageNo(readTreeAsInt(jsoString, "pageNo"));
        page.setPageSize(readTreeAsInt(jsoString, "pageSize"));
        Object o = commentService.getCommentMessageList(
                readTree(jsoString, "userId"), page);
        write(response, null, null, null, o);
    }

    /*
     * 获取新评论消息个数 comment={"userId":""}
     */
    @RequestMapping("/comment/message/new/count")
    public void getCommentMessageNewCount(HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("comment");
        logger.info(jsoString);
        write(response, null, null, null, commentService.getCommentMessageNewCount(readTree(jsoString, "userId")));
    }

    /*
     * 读评论消息 comment={"messageId":1}
     */
    @RequestMapping("/comment/message/read")
    public void addCommentMessageRead(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("comment");
        logger.info(jsoString);
        commentService.addCommentMessageRead(readTreeAsInt(jsoString,
                "messageId"));
        write(response, null, null, null, null);
    }
}
