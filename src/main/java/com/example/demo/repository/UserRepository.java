package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
//	//1.取得使用者
//	@Query(value ="select user_id, user_name, password_hash, salt, active from users where user_name = :username", nativeQuery = true)
//	User getUserName(@Param("username") String username);
//	
//	@Query(value = "select user_id, user_name, password_hash , salt, active from users where user_id = :userid", nativeQuery = true)
//	User getUserById(@Param("userId") Integer userId);
	
//	@Query(value = "select * from users", nativeQuery = true)
//	List<User> findAllUsers();  原生JPA裡面有
	//2.用 JPA 衍生查詢方法
	Optional<User>  findByUsername(String username);	
	Optional<User> findByUserAccount(String userAccount);
	
	
}
