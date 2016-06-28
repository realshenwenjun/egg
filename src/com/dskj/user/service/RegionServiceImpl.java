package com.dskj.user.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.user.entity.RegionConfig;
import com.dskj.user.entity.RegionEntity;
import com.dskj.user.mapper.RegionMapper;

@Service
public class RegionServiceImpl extends Base implements RegionService, InitializingBean {
    @Autowired
    private RegionMapper regionMapper;
    private Map<String, Object> configs = new ConcurrentHashMap<String, Object>();

    public List<RegionEntity> getRegionsByParentId(Integer parentId) throws Exception {
        if (parentId == null)
            parentId = 0;
        List<RegionEntity> regions = regionMapper.getByParentId(parentId);
        return regions;
    }

    public RegionEntity getRegionById(Integer id) throws Exception {
        return regionMapper.getById(id);
    }

    public void addRegion(RegionEntity regionEntity) throws Exception {
        logger.info(objToString(regionEntity));
        regionMapper.add(regionEntity);
    }

    public RegionEntity getRegionByLocation(String location) throws Exception {
        return regionMapper.getByLocation(location);
    }

    public void deleteAllRegion() throws Exception {
        regionMapper.deleteAll();
    }

    public void afterPropertiesSet() throws Exception {
        List<RegionConfig> list = regionMapper.getRegionConfigs();
        for (RegionConfig config : list) {
            configs.put(config.getKey(), config.getValue());
        }
        logger.info("region config init success.");
    }

    public int getRegionVersion() throws Exception {
        return Integer.valueOf((String) configs.get("region_version"));
    }

    public void updateRegionVersion(int version) throws Exception {
        regionMapper.updateRegionVersion(version);
        configs.put("region_version", String.valueOf(version));
    }

}
