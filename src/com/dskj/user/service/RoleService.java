package com.dskj.user.service;

import java.util.List;

import com.dskj.user.entity.Role;

public interface RoleService {
    public List<Role> getList() throws Exception;

    public Role get(int id) throws Exception;

    public void add(Role role) throws Exception;

    public void update(Role role) throws Exception;

    public void delete(int id) throws Exception;

}
