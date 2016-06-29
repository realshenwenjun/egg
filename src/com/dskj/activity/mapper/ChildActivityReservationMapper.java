package com.dskj.activity.mapper;

import java.util.List;

import com.dskj.activity.entity.UserActivitySign;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.activity.entity.CancelReason;
import com.dskj.activity.entity.ChildActivityReservation;
import com.dskj.util.Page;

@Repository
public interface ChildActivityReservationMapper {
    int deleteByPrimaryKey(Integer id);

    void delete(List<Integer> ids);

    int insert(ChildActivityReservation record);

    int insertSelective(ChildActivityReservation record);

    ChildActivityReservation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChildActivityReservation record);

    int updateByPrimaryKey(ChildActivityReservation record);

    public int isReserveChildActivity(@Param("userId") String userId, @Param("childActivityId") int childActivityId) throws Exception;


    List<ChildActivityReservation> selectListBySelective(@Param("record") ChildActivityReservation record, @Param("page") Page page);
    
    
    List<ChildActivityReservation> selectListBySelectiveNoPage(@Param("record") ChildActivityReservation record);
    
    public List<CancelReason> getCancelCensus() throws Exception;

    List<UserActivitySign> getActivityUserSign(@Param("activityId") Integer activityId,@Param("page") Page page) throws Exception;
}