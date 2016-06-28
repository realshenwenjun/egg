package com.dskj.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.user.entity.RegionConfig;
import com.dskj.user.entity.RegionEntity;

@Repository
public interface RegionMapper {
    public List<RegionEntity> getByParentId(Integer parentId) throws Exception;

    public RegionEntity getById(Integer id) throws Exception;

    public void add(RegionEntity regionEntity) throws Exception;

    public RegionEntity getByLocation(String location) throws Exception;

    public void deleteAll() throws Exception;

    public List<RegionConfig> getRegionConfigs() throws Exception;

    public void updateRegionVersion(int version) throws Exception;
}
