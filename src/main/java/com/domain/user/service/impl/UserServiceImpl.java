package com.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.user.model.MUser;
import com.domain.user.service.UserService;
import com.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public void signup(MUser user) {
		user.setDepartmentId(1);
		user.setRole("ROLE_GENERAL");
		mapper.insertOne(user);
	}
	
	@Override
	public List<MUser> getUsers(){
		return mapper.findMany();
	}
	
	@Override
	public MUser getUserOne(String userId) {
		return mapper.findOne(userId);
	}
	
	@Transactional
	@Override
	public void updateUserOne(String userId,String password,String userName) {
		mapper.updateOne(userId, password, userName);
		//int i = 1 /0;
	}
	
	@Override
	public void deleteUserOne(String userId) {
		int count = mapper.deleteOne(userId);
	}
}
