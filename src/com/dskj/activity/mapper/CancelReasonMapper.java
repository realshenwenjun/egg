package com.dskj.activity.mapper;

import java.util.List;

import com.dskj.activity.entity.CancelReason;

public interface CancelReasonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CancelReason record);

    int insertSelective(CancelReason record);

    CancelReason selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CancelReason record);

    int updateByPrimaryKey(CancelReason record);
    
	List<CancelReason> getAll();
}