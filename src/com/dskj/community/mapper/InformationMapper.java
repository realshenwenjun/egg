package com.dskj.community.mapper;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.Information;
import com.dskj.community.entity.InformationCollect;
import com.dskj.user.entity2_0.MyCollect;
import com.dskj.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationMapper extends CacheBean {

    public void add(Information information) throws Exception;

    public void delete(int id) throws Exception;

    public List<Information> getList(@Param("userId") String userId, @Param("page") Page page) throws Exception;

    public Information get(@Param("id") int id, @Param("userId") String userId) throws Exception;

    public void addInformationCollect(InformationCollect informationCollect) throws Exception;

    public void deleteInformationCollect(int infoId, String userId) throws Exception;

    public void addInformationComment(int infoId, int commentId) throws Exception;

    public void deleteInformationComment(int infoId, int commentId) throws Exception;

    public List<Integer> getInformationCommentIds(@Param("infoId") int infoId, @Param("page") Page page) throws Exception;

    public int getInformationCount() throws Exception;

    public void update(@Param("title") String title, @Param("summary") String summary, @Param("context") String context, @Param("id") int id) throws Exception;

    public List<MyCollect> getInfoCollectList2_0(String userId) throws Exception;

    public void deleteInformationCollect(int collectId) throws Exception;
}
