package com.dskj.comment.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/12.
 */
public class CommentMessage implements Serializable {
    private static final long serialVersionUID = 2828060687444500781L;

    private Integer id;
    private Integer commentId;
    private String userId;
    private String userLevelId;
    private String userName;
    private String userPhoto;
    private Integer sex;
    private String context;
    private boolean isPublic = true;
    private boolean isOriginal = true;
    private Integer parentId;
    private List<String> voidePaths;
    private List<String> imagePaths;
    private List<CommentChildVO> commentChilds;
    private int loveCount;
    private int commentCount;
    private Integer readId;
    private Integer myloveId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(String userLevelId) {
        this.userLevelId = userLevelId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public boolean isOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(boolean isOriginal) {
        this.isOriginal = isOriginal;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<String> getVoidePaths() {
        return voidePaths;
    }

    public void setVoidePaths(List<String> voidePaths) {
        this.voidePaths = voidePaths;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public List<CommentChildVO> getCommentChilds() {
        return commentChilds;
    }

    public void setCommentChilds(List<CommentChildVO> commentChilds) {
        this.commentChilds = commentChilds;
    }

    public int getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(int loveCount) {
        this.loveCount = loveCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getReadId() {
        return readId;
    }

    public void setReadId(Integer readId) {
        this.readId = readId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getMyloveId() {
		return myloveId;
	}

	public void setMyloveId(Integer myloveId) {
		this.myloveId = myloveId;
	}

    
}
