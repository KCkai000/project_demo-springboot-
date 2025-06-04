package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.UserException;
import com.example.demo.model.entity.User;

public interface UserService {
	
	List<User> findAllUsers();
	User getUserById(Integer userId) throws UserException;
	public void addUser(User user) throws UserException;
	public void addUser2(String username, String userAccount, String password, Boolean active, Integer roleId) throws UserException;
	public void updateUsername(Integer userId, String username) throws UserException;
	public void updateUserActive(Integer userId, Boolean active)throws UserException;
	public void deleteUser(Integer userId) throws UserException;
}
