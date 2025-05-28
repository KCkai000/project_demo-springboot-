package com.example.demo.model.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveApplicationRequestDto {
	
	@NotNull(message = "標題不得空白")
	@Size(min = 2, message ="標題不得低於2個字")
	private String title;
	@NotNull(message = "內文不得空白")
	@Size(min = 2, message ="內容不得低於2個字")
	private String content;
	@NotNull(message = "員工不得為空白")
	@Range(min = 1, message = "公司員工編號不得為0")
	private Integer senderId;
}
