package com.dskj.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.system.entity.TokenConfig;

@Repository
public interface TokenMapper {
	public List<TokenConfig> getTokenConfig() throws Exception;

	public void updateToken(String token, Long expiresIn) throws Exception;
}
