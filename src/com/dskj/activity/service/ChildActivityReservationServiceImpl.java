package com.dskj.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.activity.entity.ChildActivityReservation;
import com.dskj.activity.mapper.ChildActivityReservationMapper;
import com.dskj.base.Base;
import com.dskj.util.Page;

@Service
public class ChildActivityReservationServiceImpl extends Base implements ChildActivityReservationService {

    @Autowired
    private ChildActivityReservationMapper childActivityReservationMapper;

    public void add(ChildActivityReservation childActivityReservation) throws Exception {
        childActivityReservationMapper.insert(childActivityReservation);
    }

    public void update(ChildActivityReservation childActivityReservation) throws Exception {
        childActivityReservationMapper.updateByPrimaryKeySelective(childActivityReservation);
    }

    /**
     * 将state更新为0（失效，并非数据删除）
     */
    public void delete(List<Integer> ids) throws Exception {
        childActivityReservationMapper.delete(ids);
    }

    public ChildActivityReservation get(Integer id) throws Exception {
        return childActivityReservationMapper.selectByPrimaryKey(id);
    }

    //是否预定
    public boolean isReserveChildActivity(String userId, int childActivityId) throws Exception {
        int count = childActivityReservationMapper.isReserveChildActivity(userId, childActivityId);
        if (count > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<ChildActivityReservation> getList(
            ChildActivityReservation record, Page page) throws Exception {
        return childActivityReservationMapper.selectListBySelective(record, page);
    }

}
