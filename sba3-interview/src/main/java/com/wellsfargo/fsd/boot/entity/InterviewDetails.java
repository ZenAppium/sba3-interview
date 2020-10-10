package com.wellsfargo.fsd.boot.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="interviewdetails")
public class InterviewDetails {
	@Id
	@NotNull(message="Interview Id is required")
	//@Min(value=1,message="Interview Id can not be negative")
	private Integer interviewId;
	
	@Column(name="interviewerName")
	@NotNull(message="Interviewer Name is required")
	@NotBlank(message="Interviewer Name is required")
	@Size(min=5,max=30,message="Interviewer Name must be more than 5 character and should be less than 30")
	private String interviewerName;
	
	@Column(name="interviewName")
	@NotNull(message="Interview Name is required")
	@NotBlank(message="Interview Name is required")
	@Size(min=3,max=30,message="Interview Name must be more than 3 character and should be less than 30")
	private String interviewName;
	
	@Column(name="usersSkill")
	@NotNull(message="Users Skill is required")
	@NotBlank(message="Users Skill is required")
	@Size(min=5,max=30,message="Users Skill must be more than 5 character and should be less than 30")
	private String usersSkill;
	
	@Column(name="time")
	private LocalDateTime time;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="interviewStatus")
	@NotNull(message="Interview Status is required")
	@NotBlank(message="Interview Status is required")
	@Size(min=5,max=100,message="Interview Status must be more than 5 character and should be less than 100")
	private String interviewStatus;
	
	@Column(name="remarks")
	@NotNull(message="Remarks is required")
	@NotBlank(message="Remarks is required")
	@Size(min=5,max=100,message="Remarks must be more than 5 character and should be less than 100")
	private String remarks;
	
	
	public InterviewDetails() {
		//left unimplemented.
	}


	public InterviewDetails(@NotNull(message = "Interview Id is required") Integer interviewId,
			@NotNull(message = "Interviewer Name is required") @NotBlank(message = "Interviewer Name is required") @Size(min = 5, max = 30, message = "Interviewer Name must be more than 5 character and should be less than 30") String interviewerName,
			@NotNull(message = "Interview Name is required") @NotBlank(message = "Interview Name is required") @Size(min = 3, max = 30, message = "Interview Name must be more than 3 character and should be less than 30") String interviewName,
			@NotNull(message = "Users Skill is required") @NotBlank(message = "Users Skill is required") @Size(min = 5, max = 30, message = "Users Skill must be more than 5 character and should be less than 30") String usersSkill,
			LocalDateTime time, LocalDate date,
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


	public LocalDateTime getTime() {
		return time;
	}


	public void setTime(LocalDateTime time) {
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
}
