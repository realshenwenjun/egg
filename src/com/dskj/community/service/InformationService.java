package com.dskj.community.service;

import com.dskj.community.entity.Information;
import com.dskj.community.entity.InformationCollect;
import com.dskj.community.entity.InformationLove;
import com.dskj.util.Page;

import java.util.List;


public interface InformationService {

    public Integer addInformation(String userId, String title, String summary, String context, List<String> imgUrls) throws Exception;

    public void deleteInformation(int infoId) throws Exception;

    public List<Information> getInformationList(String userId, Page page) throws Exception;

    public Information getInformation(int infoId, String userId) throws Exception;

    public InformationLove addInformationLove(int infoId, String userId) throws Exception;

    public void deleteInformationLove(int infoId, String userId) throws Exception;

    public InformationCollect addInformationCollect(int infoId, String userId) throws Exception;

    public void deleteInformationCollect(int infoId, String userId) throws Exception;

    public void addInformationComment(int infoId, String userId, String context) throws Exception;

    public void deleteInformationComment(int infoId, int commentId) throws Exception;

    public Object getInformationComments(int infoId, String userId, Page page) throws Exception;

    public int getInformationCount() throws Exception;

    public void updateInformation(int infoId, String title, String summary, String context, String imgUrl) throws Exception;
}
