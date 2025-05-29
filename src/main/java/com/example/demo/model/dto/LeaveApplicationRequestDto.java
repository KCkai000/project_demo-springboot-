package com.example.demo.model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank; //可以驗證字串非空白也只有空白
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveApplicationRequestDto {
	
	@NotBlank(message = "{LeaveApplicationRequestDto.title.notnull}")
	@Size(min = 2, max = 100, message ="{LeaveApplicationRequestDto.title.size}")
	private String title;
	@NotBlank(message = "{LeaveApplicationRequestDto.content.notnull}")
	@Size(min = 2, max = 500, message ="{LeaveApplicationRequestDto.content.size}")
	private String content;
	@NotNull(message = "{LeaveApplicationRequestDto.senderId.notnull}")
	@Min(value = 1, message = "{LeaveApplicationRequestDto.senderId.min}")
	private Integer senderId;
}
