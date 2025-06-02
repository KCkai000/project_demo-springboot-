package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
public class Test_UserAdd {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void addUser() {
		User user = new User();
	    user.setUserAccount("kai111");
	    user.setUsername("Kai01");
	    user.setPasswordHash("hashed-password"); // 暫時塞假的
	    user.setSalt("random-salt"); // 也是假的
	    user.setActive(false);

	    User savedUser = userRepository.save(user);
	    assertNotNull(savedUser.getUserId());
	    
	    User user1 = new User();
	    user1.setUserAccount("kai222");
	    user1.setUsername("Kai02");
	    user1.setPasswordHash("hashed-password"); // 暫時塞假的
	    user1.setSalt("random-salt"); // 也是假的
	    user1.setActive(true);

	    User savedUser1 = userRepository.save(user1);
	    assertNotNull(savedUser.getUserId());
	}
}
