package com.wellsfargo.fsd.boot.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	private Integer userId;
	
	@Column(name="fname")
	private String firstName;
	
	@Column(name="lname")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private String mobile;
	
	/*
	 * @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name="post_tags", joinColumns = {@JoinColumn(name="user_id")},
	 * inverseJoinColumns = {@JoinColumn(name="interview_id")}) private
	 * Set<InterviewDetails> interviewDetails = new HashSet<>();
	 */
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/*
	 * public Set<InterviewDetails> getInterviewDetails() { return interviewDetails;
	 * }
	 * 
	 * public void setInterviewDetails(Set<InterviewDetails> interviewDetails) {
	 * this.interviewDetails = interviewDetails; }
	 */
}
