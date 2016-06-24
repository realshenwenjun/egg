package com.dskj.sms.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.sms.entity.SmsConfig;

@Repository
public interface SmsConfigMapper {
	public List<SmsConfig> getSmsConfig();
}
