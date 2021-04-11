package com.web.blog.service;

import com.web.blog.dto.User;

public interface UserService {

	boolean isExistEmail(String email);

	User findUserByEmailAndPassword(String email, String password);
	
	boolean insertUser(User user);
	
	boolean modifyUser(User user);
	
	boolean deleteUser(String uid);

}
