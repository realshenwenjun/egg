package com.dskj.activity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dskj.activity.entity.CancelReason;
import com.dskj.activity.mapper.CancelReasonMapper;
@Service
public class CancelResonServiceImpl implements CancelResonService {

	private CancelReasonMapper cancelReasonMapper;

	public void add(CancelReason cancelReason) throws Exception {
		cancelReasonMapper.insert(cancelReason);
	}

	public void update(CancelReason cancelReason) throws Exception {
		cancelReasonMapper.updateByPrimaryKey(cancelReason);
	}

	public CancelReason get(Integer id) throws Exception {
		return cancelReasonMapper.selectByPrimaryKey(id);
	}

	public List<CancelReason> getAll() throws Exception {
		return null;
	}
	
}
