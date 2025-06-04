package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.detail.UserDetailsImpl;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userAccount) throws UsernameNotFoundException {
		User user = userRepository.findByUserAccount(userAccount)
					.orElseThrow(() -> new UsernameNotFoundException(userAccount));
		if(user == null) {
			throw new UsernameNotFoundException("使用者不存在");
		}
		return new UserDetailsImpl(user);
	}

}
