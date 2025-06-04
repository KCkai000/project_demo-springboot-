package com.example.demo.model.dto;

import lombok.Data;

@Data
public class UserDto {
	private Integer userId;
	private String username;
	private String userAccount;
	private Boolean active;
	private Integer roleId;
}
