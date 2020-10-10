package com.wellsfargo.fsd.boot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@NotNull(message="User Id is required")
	//@Min(value=1,message="contact Id can not be negative")
	private Integer userId;
	
	@Column(name="fname")
	@NotNull(message="First Name is required")
	@NotBlank(message="First Name is required")
	@Size(min=5,max=30,message="First Name must be more than 5 character and should be less than 30")
	private String firstName;
	
	@Column(name="lname")
	@NotNull(message="Last Name is required")
	@NotBlank(message="Last Name is required")
	@Size(min=3,max=25,message="Last Name must be more than 3 character and should be less than 25")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	@Pattern(regexp="[1-9][0-9]{9}", message="mobile number must be of 10 digits")
	private String mobile;
	
	public User() {
		//left unimplemented.
	}
	
	public User(@NotNull(message = "User Id is required") Integer usertId,
			@NotNull(message = "First Name is required") @NotBlank(message = "First Name is required") @Size(min = 5, max = 30, message = "First Name must be more than 5 character and should be less than 30") String firstName,
			@NotNull(message = "Last Name is required") @NotBlank(message = "Last Name is required") @Size(min = 3, max = 25, message = "Last Name must be more than 3 character and should be less than 25") String lastName,
			@PastOrPresent(message = "Email can not be future date") String email,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number must be of 10 digits") String mobile) {
		super();
		this.userId = usertId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

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
}
