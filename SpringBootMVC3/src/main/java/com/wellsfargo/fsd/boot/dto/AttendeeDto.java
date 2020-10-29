package com.wellsfargo.fsd.boot.dto;

import javax.validation.constraints.NotNull;

public class AttendeeDto {
	@NotNull(message="User Id is required")
	private int userId;
	
	@NotNull(message="Interview Id is required")
	private int interviewId;
	public AttendeeDto() {}
	public AttendeeDto(int userId, int interviewId) {
		super();
		this.userId = userId;
		this.interviewId = interviewId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}
}
