package com.example.demo.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leave_application_form")
public class LeaveApplicationForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer laFormId;  //請假單Id
	@Column(length = 100, nullable = false)
	private String title;
	@Column(length = 200, nullable = false)
	private String content;
	@ManyToOne
	@JoinColumn(name="sender_id", nullable = false)
	private User sender;
	@Column(name = "creat_time" , nullable = false)
	private LocalDateTime createTime;

	private String status;
}
