package com.dskj.spread.service;

import com.dskj.base.Base;
import com.dskj.spread.entity.Propagate;
import com.dskj.spread.mapper.PropaMapper;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropaServiceImpl extends Base implements PropaService {
	@Autowired
	private PropaMapper propaMapper;

	public void add(Propagate propagate) throws Exception {
		propaMapper.add(propagate);
	}

	public void update(Propagate propagate) throws Exception {
		propaMapper.update(propagate);
	}

	public List<Propagate> getList(String institutionId,Page page) throws Exception {
		return propaMapper.getList(institutionId,page);
	}

	public void deleteById(int id) throws Exception {
		Propagate propagate = propaMapper.get(id);
		if (propagate != null)
			propaMapper.deleteById(id);
	}

	public Propagate get(int id) throws Exception {
		return propaMapper.get(id);
	}

}
