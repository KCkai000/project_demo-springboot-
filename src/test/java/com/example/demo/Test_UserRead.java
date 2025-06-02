package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
public class Test_UserRead {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void read() {
		List<User> users = userRepository.findAll();
		users.forEach(user ->{
			System.out.printf("id:%d 使用者姓名:%s%n 使用者帳號:%s%n", user.getUserId(), user.getUsername(), user.getUserAccount());
		});
	}
}
