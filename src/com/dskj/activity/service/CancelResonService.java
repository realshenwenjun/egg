package com.dskj.activity.service;

import java.util.List;

import com.dskj.activity.entity.CancelReason;

public interface CancelResonService {
	
	public void add(CancelReason cancelReason) throws Exception;

	public void update(CancelReason cancelReason) throws Exception;

	public CancelReason get(Integer id) throws Exception;
	
	public List<CancelReason> getAll() throws Exception;
	
	
}
