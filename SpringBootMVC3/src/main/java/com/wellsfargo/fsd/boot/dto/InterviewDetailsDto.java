package com.wellsfargo.fsd.boot.dto;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


public class InterviewDetailsDto {
	@NotNull(message="Interview Id is required")
	private Integer interviewId;
	
	@NotNull(message="Interviewer Name is required")
	@NotBlank(message="Interviewer Name is required")
	@Size(min=5,max=30,message="Interviewer Name must be more than 5 character and should be less than 30")
	private String interviewerName;
	
	@NotNull(message="Interview Name is required")
	@NotBlank(message="Interview Name is required")
	@Size(min=3,max=30,message="Interview Name must be more than 3 character and should be less than 30")
	private String interviewName;
	
	@NotNull(message="Users Skill is required")
	@NotBlank(message="Users Skill is required")
	@Size(min=5,max=30,message="Users Skill must be more than 5 character and should be less than 30")
	private String usersSkill;
	
	@NotNull(message="Time is required")
	@DateTimeFormat(iso=ISO.TIME)
	private LocalTime time = LocalTime.now();
	
	@NotNull(message="Date is required")
	@PastOrPresent(message = "Date can not be future date")
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate date = LocalDate.now();
	
	@NotNull(message="Interview Status is required")
	@NotBlank(message="Interview Status is required")
	@Size(min=5,max=100,message="Interview Status must be more than 5 character and should be less than 100")
	private String interviewStatus;
	
	@NotNull(message="Remarks is required")
	@NotBlank(message="Remarks is required")
	@Size(min=5,max=100,message="Remarks must be more than 5 character and should be less than 100")
	private String remarks;
	
	@Valid
	private List<UserDto> attendees;
	public InterviewDetailsDto() {}
	
	public InterviewDetailsDto(@NotNull(message = "Interview Id is required") Integer interviewId,
			@NotNull(message = "Interviewer Name is required") @NotBlank(message = "Interviewer Name is required") @Size(min = 5, max = 30, message = "Interviewer Name must be more than 5 character and should be less than 30") String interviewerName,
			@NotNull(message = "Interview Name is required") @NotBlank(message = "Interview Name is required") @Size(min = 3, max = 30, message = "Interview Name must be more than 3 character and should be less than 30") String interviewName,
			@NotNull(message = "Users Skill is required") @NotBlank(message = "Users Skill is required") @Size(min = 5, max = 30, message = "Users Skill must be more than 5 character and should be less than 30") String usersSkill,
			@NotNull(message = "Time is required") LocalTime time,
			@NotNull(message = "Date is required") @PastOrPresent(message = "Date can not be future date") LocalDate date,
			@NotNull(message = "Interview Status is required") @NotBlank(message = "Interview Status is required") @Size(min = 5, max = 100, message = "Interview Status must be more than 5 character and should be less than 100") String interviewStatus,
			@NotNull(message = "Remarks is required") @NotBlank(message = "Remarks is required") @Size(min = 5, max = 100, message = "Remarks must be more than 5 character and should be less than 100") String remarks) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkill = usersSkill;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
	}
	
	public InterviewDetailsDto(@NotNull(message = "Interview Id is required") Integer interviewId,
			@NotNull(message = "Interviewer Name is required") @NotBlank(message = "Interviewer Name is required") @Size(min = 5, max = 30, message = "Interviewer Name must be more than 5 character and should be less than 30") String interviewerName,
			@NotNull(message = "Interview Name is required") @NotBlank(message = "Interview Name is required") @Size(min = 3, max = 30, message = "Interview Name must be more than 3 character and should be less than 30") String interviewName,
			@NotNull(message = "Users Skill is required") @NotBlank(message = "Users Skill is required") @Size(min = 5, max = 30, message = "Users Skill must be more than 5 character and should be less than 30") String usersSkill,
			@NotNull(message = "Time is required") LocalTime time,
			@NotNull(message = "Date is required") @PastOrPresent(message = "Date can not be future date") LocalDate date,
			@NotNull(message = "Interview Status is required") @NotBlank(message = "Interview Status is required") @Size(min = 5, max = 100, message = "Interview Status must be more than 5 character and should be less than 100") String interviewStatus,
			@NotNull(message = "Remarks is required") @NotBlank(message = "Remarks is required") @Size(min = 5, max = 100, message = "Remarks must be more than 5 character and should be less than 100") String remarks,
			@Valid List<UserDto> attendees) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkill = usersSkill;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
		this.attendees = attendees;
	}

	public Integer getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public String getInterviewName() {
		return interviewName;
	}
	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}
	public String getUsersSkill() {
		return usersSkill;
	}
	public void setUsersSkill(String usersSkill) {
		this.usersSkill = usersSkill;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<UserDto> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<UserDto> attendees) {
		this.attendees = attendees;
	}
	
}
