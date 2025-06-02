package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;  //使用者id
	@Column(name="user_name", nullable = false, length =60)
	private String username; //使用者姓名
	@Column(name = "user_account", unique = true, length = 30, nullable = false)
	private String userAccount; // 使用者帳號
	@Column(name= "password_hash", nullable = false)
	private String passwordHash; //使用者密碼
	@Column(name = "salt", nullable = false)
	private String salt;  //鹽
	@Column(name = "active")  
	private Boolean active;   //是否啟用
	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	private List<LeaveApplicationForm> leaveApplicationForms;  //laForm 表示請假單
}
