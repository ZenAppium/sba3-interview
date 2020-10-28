package com.wellsfargo.fsd.boot.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="interviewdetails")
public class InterviewDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer interviewId;
	
	@Column(name="interviewerName")
	private String interviewerName;
	
	@Column(name="interviewName")
	private String interviewName;
	
	@Column(name="usersSkill")
	private String usersSkill;
	
	@Column(name="time")
	private LocalTime time;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="interviewStatus")
	private String interviewStatus;
	
	@Column(name="remarks")
	private String remarks;
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY ) 
	@JoinTable(name="attendees_details",joinColumns = @JoinColumn(name="interviewId", referencedColumnName = "interviewid"),
	inverseJoinColumns = @JoinColumn(name="userId",referencedColumnName = "userId"))  
	private List<User> attendees;
	 
	public InterviewDetails() {}
	
	public InterviewDetails(Integer interviewId, String interviewerName, String interviewName, String usersSkill,
			LocalTime time, LocalDate date, String interviewStatus, String remarks) {
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
	
	public InterviewDetails(Integer interviewId, String interviewerName, String interviewName, String usersSkill,
			LocalTime time, LocalDate date, String interviewStatus, String remarks, List<User> attendees) {
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

	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}
	
}
