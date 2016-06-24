package com.dskj.activity.service;

import java.util.List;

import com.dskj.activity.entity.ChildActivityReservation;
import com.dskj.util.Page;

public interface ChildActivityReservationService {

    public void add(ChildActivityReservation childActivityReservation) throws Exception;

    public void update(ChildActivityReservation childActivityReservation) throws Exception;

    public void delete(List<Integer> ids) throws Exception;

    public ChildActivityReservation get(Integer id) throws Exception;

    public boolean isReserveChildActivity(String userId, int childActivityId) throws Exception;

    public List<ChildActivityReservation> getList(ChildActivityReservation record, Page page) throws Exception;
}
