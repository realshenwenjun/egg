package com.dskj.user.entity;

import java.io.Serializable;
import java.util.List;

public class Province implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7697521694342480977L;
    private int id;
    private String name;
    private String location;
    private int parentId;
    private List<RegionEntity> cities;

    public List<RegionEntity> getCities() {
        return cities;
    }

    public void setCities(List<RegionEntity> cities) {
        this.cities = cities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

}
