package com.example.demo.enums;

public enum LeaveApplicationStatus {
	PENDING("待審核"),  //待審核
	APPROVED("已批准"), //已批准
	REJECTED("已拒絕"), //已拒絕
	CANCELLED("已取消"), //已取消
	PROCESSING("處理中");
	
	private final String displayName;
	
	private LeaveApplicationStatus(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	@Override
	public String toString() {
		return this.name();
	}

	
}
