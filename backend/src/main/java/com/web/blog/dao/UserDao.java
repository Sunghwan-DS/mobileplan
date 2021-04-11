package com.web.blog.dao;

import com.web.blog.dto.User;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

	User getUserByEmail(String email);

	User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	int insertUser(User user);

	int updateUser(User user);

	int deleteUser(String uid);

}
