package com.example.demo.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.enums.LeaveApplicationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leaveapplicationform")
public class LeaveApplicationForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "la_form_id") //建議欄位和變數名稱一致
	private Integer laFormId;  //請假單Id
	@Column(length = 100, nullable = false)
	private String title;
	@Column(length = 500, nullable = false)
	private String content;
	@ManyToOne
	@JoinColumn(name="sender_id", nullable = false)
	private User sender;
	@Column(name = "creat_time" , nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createTime;
	@Enumerated(EnumType.STRING)  //將列舉以字串形式儲存到資料庫
	@Column(name = "status", length = 20, nullable = false)
	private LeaveApplicationStatus status;  //建立ENUM放置狀態
	
	// JPA 生命週期回調 在持久畫前自動設置創建時間和初始狀態
	@PrePersist
	protected void onCreate() {
		if(createTime == null) {
			createTime = LocalDateTime.now();
		}
		if(status == null) {
			status = LeaveApplicationStatus.PENDING;  //DEFAULT表單送出後就是待審核
		}
	}
}
