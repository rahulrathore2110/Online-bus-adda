package com.onlinebusadda.DTO;

import com.onlinebusadda.model.UserType;

import javax.validation.constraints.NotNull;

public class LoginDTO {
	
	@NotNull(message ="Email cannot be null.")
	private String email;
	
	@NotNull(message ="Password cannot be null.")
	private String password;
	
	@NotNull(message ="User cannot be null.")
	private UserType userType;
	
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginDTO(String email, String password, UserType userType) {
		this.email = email;
		this.password = password;
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
