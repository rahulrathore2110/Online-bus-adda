package com.onlinebusadda.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentUserSession {
	
	
	
	@Id
	@Column(unique = true)
	private Integer userId;
	private String type;
	private String uuid;
	private LocalDateTime localDateTime;
	
	
	
	public CurrentUserSession() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CurrentUserSession(Integer userId, String type, String uuid, LocalDateTime localDateTime) {
		super();
		this.userId = userId;
		this.type = type;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getUuid() {
		return uuid;
	}



	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}



	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}



	@Override
	public String toString() {
		return "CurrentUserSession [userId=" + userId + ", type=" + type + ", uuid=" + uuid + ", localDateTime="
				+ localDateTime + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(localDateTime, type, userId, uuid);
	}



	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		CurrentUserSession other = (CurrentUserSession) obj;
		
		return Objects.equals(localDateTime, other.localDateTime) && Objects.equals(type, other.type)
				&& Objects.equals(userId, other.userId) && Objects.equals(uuid, other.uuid);
	}
	
	

	
	
}
