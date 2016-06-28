package com.dskj.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.user.entity.Role;

@Repository
public interface RoleMapper {
    public List<Role> getList() throws Exception;

    public Role get(int id) throws Exception;

    public void add(Role role) throws Exception;

    public void update(Role role) throws Exception;

    public void delete(int id) throws Exception;

}
