package com.dskj.user.service;

import java.util.List;

import com.dskj.user.entity.RegionEntity;

public interface RegionService {
    public List<RegionEntity> getRegionsByParentId(Integer parentId) throws Exception;

    public RegionEntity getRegionById(Integer id) throws Exception;

    public void addRegion(RegionEntity regionEntity) throws Exception;

    public RegionEntity getRegionByLocation(String location) throws Exception;

    public void deleteAllRegion() throws Exception;

    public int getRegionVersion() throws Exception;

    public void updateRegionVersion(int version) throws Exception;
}
