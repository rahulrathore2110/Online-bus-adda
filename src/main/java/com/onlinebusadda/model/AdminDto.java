package com.onlinebusadda.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class AdminDto {
	
	@NotNull(message ="Username cannot be null.")
	private String userName;
	@NotNull(message ="Password cannot be null.")
	private String password;
	
	
	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AdminDto(@NotNull(message = "Username cannot be null.") String userName,
			@NotNull(message = "Password cannot be null.") String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "AdminDto [userName=" + userName + ", password=" + password + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(password, userName);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminDto other = (AdminDto) obj;
		return Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}
	
	
	
	
}
