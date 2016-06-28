package com.dskj.user.mapper;

import com.dskj.user.entity2_0.UserPhoto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPhotoMapper {
    public void add(@Param("photos") List<UserPhoto> photos) throws Exception;

    public void delete(List<Integer> ids) throws Exception;

    public List<UserPhoto> list(String userId) throws Exception;

}
