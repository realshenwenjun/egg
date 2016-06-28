package com.dskj.user.mapper;

import com.dskj.base.CacheBean;
import com.dskj.user.entity.UserEntity;
import com.dskj.user.entity2_0.UserAsk;
import com.dskj.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAskMapper extends CacheBean {

    public void add(UserAsk userAsk) throws Exception;

    public List<UserEntity> getUserAskList2_0(@Param("institutionId") String institutionId,@Param("page") Page page) throws Exception;
}
