package com.example.demo.model.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//使用者憑證
//登入成功之後會得到憑證資料(只有 getter)
@Getter
@AllArgsConstructor
@ToString
public class UserCert {
	
	private Integer userId;
	private String userAccount;
	private Integer roleId;
	Set<String> permission;  //gpt建議先保留未來權限設置後需要的
}
