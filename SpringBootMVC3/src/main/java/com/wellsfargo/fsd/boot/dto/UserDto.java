package com.wellsfargo.fsd.boot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
	
	@NotNull(message="User Id is required")
	//@Min(value=1,message="User Id can not be negative")
	private Integer userId;
	
	@NotNull(message="First Name is required")
	@NotBlank(message="First Name is required")
	@Size(min=5,max=30,message="First Name must be more than 5 character and should be less than 30")
	private String firstName;
	
	@NotNull(message="Last Name is required")
	@NotBlank(message="Last Name is required")
	@Size(min=3,max=25,message="Last Name must be more than 3 character and should be less than 25")
	private String lastName;
	
	@NotNull(message="Email is required")
	@Email(message="Please provide correct email id")
	//@Pattern(regexp = ".+@.+\\+", message = "Enter valid email")
	private String email;
	
	@NotNull(message="Mobile Number is required")
	@NotBlank(message="Mobile Number is required")
	@Pattern(regexp="[1-9][0-9]{9}", message="mobile number must be of 10 digits")
	private String mobile;
	
	public UserDto() {}
	
	public UserDto(@NotNull(message = "User Id is required") Integer userId,
			@NotNull(message = "First Name is required") @NotBlank(message = "First Name is required") @Size(min = 5, max = 30, message = "First Name must be more than 5 character and should be less than 30") String firstName,
			@NotNull(message = "Last Name is required") @NotBlank(message = "Last Name is required") @Size(min = 3, max = 25, message = "Last Name must be more than 3 character and should be less than 25") String lastName,
			@NotNull(message = "Email is required") @Email(message = "Please provide correct email id") @Pattern(regexp = ".+@.+\\+", message = "Enter valid email") String email,
			@NotNull(message = "Mobile Number is required") @NotBlank(message = "Mobile Number is required") @Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number must be of 10 digits") String mobile) {
		super();
		this.userId = userId;
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
