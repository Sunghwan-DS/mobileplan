package com.web.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.blog.dao.UserDao;
import com.web.blog.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	@Override
	public boolean isExistEmail(String email) {
		
		if(dao.getUserByEmail(email) == null)
			return true;
		
		return false;
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		
		return dao.findUserByEmailAndPassword(email, password);
	}
	
	@Override
	public boolean insertUser(User user) {
		if(dao.insertUser(user) == 1)
			return true;
		return false;
	}

	@Override
	public boolean modifyUser(User user) {
		if(dao.updateUser(user) == 1)
			return true;
		return false;
	}

	@Override
	public boolean deleteUser(String uid) {
		if(dao.deleteUser(uid) == 1)
			return true;
		return false;
	}

}
