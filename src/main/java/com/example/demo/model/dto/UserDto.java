package com.example.demo.model.dto;

import lombok.Data;

@Data
public class UserDto {
	private Integer userId;
	private String username;
	private Boolean active;
}
