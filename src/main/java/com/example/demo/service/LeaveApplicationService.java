package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.enums.LeaveApplicationStatus;
import com.example.demo.model.dto.LeaveApplicationRequestDto;
import com.example.demo.model.entity.LeaveApplicationForm;
import com.example.demo.model.entity.User;

public interface LeaveApplicationService {
	
	List<LeaveApplicationForm> findAll();
	List<LeaveApplicationForm> findBySenderUserId(Integer senderId);
	List<LeaveApplicationForm> findByStatus(LeaveApplicationStatus status);
	List<LeaveApplicationForm> findBySender(@Param("sender") User sender);
	List<LeaveApplicationForm> findByTitleContainingIgnoreCase(String titleKeyword);
	void createLeaveApplication(LeaveApplicationRequestDto requestDto);
	void updateLeaveApplication(Integer laFormId, LeaveApplicationRequestDto updateDto);
	boolean deleteLeaveApplicationForm(Integer laFormId);
}
