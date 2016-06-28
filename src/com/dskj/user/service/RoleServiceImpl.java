package com.dskj.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.user.entity.Role;
import com.dskj.user.mapper.RoleMapper;

@Service
public class RoleServiceImpl extends Base implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getList() throws Exception {
        return roleMapper.getList();
    }

    public Role get(int id) throws Exception {
        return roleMapper.get(id);
    }

    public void add(Role role) throws Exception {
        roleMapper.add(role);
    }

    public void update(Role role) throws Exception {
        roleMapper.update(role);
    }

    public void delete(int id) throws Exception {
        roleMapper.delete(id);
    }

}
