package com.wqz.dao;

import java.util.List;

import com.wqz.pojo.User;

public interface UserDao {
public User findUserById(Integer id);
	
	public List<User> findUserByUserName(String username);
}
