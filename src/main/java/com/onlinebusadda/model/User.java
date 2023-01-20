package com.onlinebusadda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userLoginId;
	
	private String userName;
	
	@Size(min = 6, message="Password length must be between 6 to 10 character")
	@Size(max = 10, message = "Password length must be between 6 to 10 character")
	private String password;

	private String firstName;
	
	private String lastName;
	
	private Long contact;
	
	@Email(message = "Please enter valid email Id")
	private String email;
	
	@JsonIgnore
	@OneToOne
	private Reservation reservation;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userLoginId, String userName,
			@Size(min = 6, message = "Password length must be between 6 to 10 character") @Size(max = 10, message = "Password length must be between 6 to 10 character") String password,
			String firstName, String lastName, Long contact,
			@Email(message = "Please enter valid email Id") String email, Reservation reservation) {
		super();
		this.userLoginId = userLoginId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.reservation = reservation;
	}
	
	

	public Integer getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(Integer userLoginId) {
		this.userLoginId = userLoginId;
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

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public Reservation getReservation() {
		return reservation;
	}
	
	

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	

	@Override
	public String toString() {
		return "User [userLoginId=" + userLoginId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", contact=" + contact + ", email=" + email + ", reservation="
				+ reservation + "]";
	}
	
	
	
	
	

}
