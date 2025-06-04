package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.UserException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.Hash;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	@Transactional(readOnly = true) //標註為只讀事務
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public User getUserById(Integer userId) throws UserException{
		return userRepository.findById(userId)
				.orElseThrow(() -> new UserException("找不到id為"+ userId +"的使用者"));
	}

	@Override
	@Transactional  //默認唯讀寫事務
	public void addUser(User user) throws UserException{
		//檢查用戶銘是否已存在(假設username 是唯一的)
		if(user.getUsername() != null && userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new UserException("用戶名 '" + user.getUsername() +"' 已存在");
		}
		userRepository.save(user);
	}
	
	
	@Override
	@Transactional
	public void addUser2(String username, String userAccount, String password, Boolean active, Integer roleId) throws UserException {
		String salt = Hash.getSalt();
		String passwordHash = Hash.getHash(password, salt);
		User user = new User(null, username, userAccount, passwordHash, salt, active,  null, roleId);
		userRepository.save(user);
	}
	
	
	@Override
	@Transactional
	public void updateUsername(Integer userId, String newUsername) throws UserException{
		User user = userRepository.findById(userId)
				    .orElseThrow(() -> new UserException("找不到id為" + userId + "的使用者，無法更新用戶名"));
		//檢查用戶名是否已被其他用戶使用 (如果 username 是唯一的且不是當前用戶)
		Optional<User> existingUserWithNewUsername = userRepository.findByUsername(newUsername);
		if(existingUserWithNewUsername.isPresent() && !existingUserWithNewUsername.get().getUserId().equals(userId)) {
			throw new UserException("用戶名 '" + newUsername + "' 已被其他用戶使用");
		}
		user.setUsername(newUsername);
		userRepository.save(user); //JPA 會自動判斷是新增還是更新
	}

	@Override
	@Transactional
	public void updateUserActive(Integer userId, Boolean active) throws UserException{
		User user = userRepository.findById(userId)
				   .orElseThrow(() -> new UserException("找不到ID為"+ userId + "的使用者，無法更新啟用狀態"));
		user.setActive(active);
		userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteUser(Integer userId) throws UserException{
		if(!userRepository.existsById(userId)) {
			throw new UserException("找不到ID為" + userId +"的使用者，無法刪除");
		}
		userRepository.deleteById(userId);		
	}

	

}
