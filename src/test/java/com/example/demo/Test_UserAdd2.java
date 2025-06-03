package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.exception.UserException;
import com.example.demo.service.UserService;

@SpringBootTest
public class Test_UserAdd2 {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void userAdd() throws UserException {
		userService.addUser2("Kiki", "XX0123", "0000", true);
		System.out.println("USER ADD SUCCESSFULLY！ d(OUO)b");
	}
}
