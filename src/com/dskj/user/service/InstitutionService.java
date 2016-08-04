package com.dskj.user.service;

import java.util.List;

import com.dskj.user.entity.*;
import com.dskj.util.Page;

public interface InstitutionService {
    public String addInstitution(InstitutionEntity institutionEntity, UserEntity userEntity) throws Exception;

    public InstitutionEntity getInstitutionByName(String name) throws Exception;

    public InstitutionEntity getInstitutionById(String id) throws Exception;

    public void updateInstitutionLogo(String logo, String id) throws Exception;

    public void updateInstitutionInfo(InstitutionEntity institutionEntity) throws Exception;

    public String addChildInstitution(InstitutionEntity institutionEntity, UserEntity userEntity) throws Exception;

    public List<InstitutionEntity> getInstitutionListPage(Page page) throws Exception;

    public List<InstitutionEntity> getInstitutionListByName(String name, Page page) throws Exception;

    public List<ChildInstitutionList> getMyChildInstitution(String institutionId,String key) throws Exception;

    public void deleteMyChildInstitution(String institutionId) throws Exception;

    public List<UserEntity> getMyChildInstitutionAdmin(String institutionId) throws Exception;

    public void updateInstitutionFace(String institutionId, String face) throws Exception;

    public List<InstitutionWithPropa> getInstitutionWithPropaListPage(String key, Integer regionId,Page page) throws Exception;

    public void addComment(String userId, String institutionId, String context) throws Exception;

    public Object getInstitutionComments(String institutionId, String userId, Page page) throws Exception;

    public void addInstitutionLove(InstitutionLove institutionLove) throws Exception;

    public void deleteInstitutionLove(int loveId) throws Exception;

    public InstitutionFace updateAndGetInstitutionFaceById(String institutionId, String userId) throws Exception;

    public void addInstitutionFans(InstitutionFans institutionFans) throws Exception;

    public void deleteInstitutionFans(Integer fansId) throws Exception;
    
    public Object getInstitutionManagerList(String institutionId,String key) throws Exception;
    
    public Object getInstitutionUnManagerList(String institutionId,String key) throws Exception;
    
    public String addInstitutionManagerBatch(String institutionId,List<String> userIds) throws Exception;
    
    public String deleteInstitutionManagerBatch(String institutionId,List<String> userIds) throws Exception;
    
    public List<ChildInstitutionList> getUnMyChildInstitution(String institutionId,String key) throws Exception;
    
    public boolean addBatchMyChildInstitution(String institutionId,List<String> childIds,String credence) throws Exception;
    
    public void deleteBatchMyChildInstitution(String institutionId,List<String> childIds) throws Exception;
    
    public int getInstitutionCount(String key) throws Exception;
    
    public void deleteInstitution(String institutionId) throws Exception;
}
