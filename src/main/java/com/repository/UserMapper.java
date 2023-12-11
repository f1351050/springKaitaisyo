package com.repository;

import org.apache.ibatis.annotations.Mapper;

import com.domain.user.model.MUser;


@Mapper
public interface UserMapper {
	
	public int insertOne(MUser user);
 
}
