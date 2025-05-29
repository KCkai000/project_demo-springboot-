package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
public class Test_User {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void addUser() {
		//尋找使用者
		Optional<User> optUser = userRepository.findById(1);
		if(optUser.isEmpty()) {
			System.out.println("查無使用者");
			return;
		}
	}
}
