package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.LeaveApplicationForm;
import com.example.demo.model.entity.User;
import com.example.demo.enums.LeaveApplicationStatus;



@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplicationForm, Integer>{
	//Repository -> 讓JPA去幫我和資料庫打交道，可以在這裡寫一些搜尋方法
	
	//1. 用送請假單者的ID查詢
	List<LeaveApplicationForm> findBySenderUserId(Integer senderId);
	
	//2. 根據狀態查詢
	List<LeaveApplicationForm> findByStatus(LeaveApplicationStatus status);
	
	//3. 根據送單者查詢
	@Query("select u from LeaveApplicationForm u where u.sender  = :sender") //JPQL 中使用實體名和屬性名
	List<LeaveApplicationForm> findBySender(@Param("sender") User sender);
	
	//4.根據標題模糊查詢 (gemini推薦)
	List<LeaveApplicationForm> findByTitleContainingIgnoreCase(String titleKeyword);
	
}
