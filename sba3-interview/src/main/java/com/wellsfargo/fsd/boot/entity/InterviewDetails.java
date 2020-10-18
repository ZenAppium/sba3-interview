package com.wellsfargo.fsd.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interviewdetails")
public class InterviewDetails {
	@Id
	private Integer interviewId;
	
	@Column(name="interviewerName")
	private String interviewerName;
	
	@Column(name="interviewName")
	private String interviewName;
	
	@Column(name="usersSkill")
	private String usersSkill;
	
	@Column(name="time")
	private String time;
	
	@Column(name="date")
	private String date;
	
	@Column(name="interviewStatus")
	private String interviewStatus;
	
	@Column(name="remarks")
	private String remarks;
	
	/*
	 * @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy
	 * ="interviewdetails" ) private Set<User> users = new HashSet<>();
	 */
	
	
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


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
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
