package com.dskj.community.service;

import java.util.List;

import com.dskj.community.entity.Information;
import com.dskj.util.Page;



public interface InformationService {
	
    public Integer addInformation(String userId,String title,String context,List<String> imgUrls) throws Exception;
    
    public void deleteInformation(int infoId) throws Exception;
    
    public List<Information> getInformationList(String userId,Page page) throws Exception;

    public Information getInformation(int infoId,String userId) throws Exception;

    public Integer addInformationLove(int infoId,String userId) throws Exception;

    public void deleteInformationLove(int infoId,String userId) throws Exception;

    public void addInformationCollect(int infoId,String userId) throws Exception;

    public void deleteInformationCollect(int infoId,String userId) throws Exception;

    public void addInformationComment(int infoId,String userId,String context) throws Exception;

    public void deleteInformationComment(int infoId,int commentId) throws Exception;

    public Object getInformationComments(int infoId,String userId,Page page) throws Exception;
    
    public int getInformationCount() throws Exception;
    
    public void updateInformation(int infoId,String title,String context,String imgUrl) throws Exception;
}
