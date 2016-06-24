package com.dskj.spread.service;

import java.util.List;

import com.dskj.spread.entity.Propagate;
import com.dskj.util.Page;

public interface PropaService {
public void add(Propagate propagate) throws Exception;
	
	public void update(Propagate propagate) throws Exception;
	
	public List<Propagate> getList(String institutionId,Page page) throws Exception;
	
	public void deleteById(int id) throws Exception;
	
	public Propagate get(int id) throws Exception;

}
