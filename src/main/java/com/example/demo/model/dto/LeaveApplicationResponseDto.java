package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.example.demo.enums.LeaveApplicationStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveApplicationResponseDto {
	private Integer laFormId;
	private String title;
	private String content;
	private String senderName; //發送人姓名
	private Integer senderId;  //前端可能需要
	private LocalDateTime createTime;
	private LeaveApplicationStatus status; //直接用列舉表示狀態
}
