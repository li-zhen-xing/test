package com.work.service;

import com.work.pojo.User;

import java.util.List;

public interface UserService {
	
	public List<User> getUserList(User user, Integer page, Integer limit);
	public Integer getUserListCount(User user);
	public void addUser(User user);
	public User getUserById(Integer userId);
	public void updateUser(User user);
	public User getUser(User user);
	public User getUserByNickName(User user);
	
}
