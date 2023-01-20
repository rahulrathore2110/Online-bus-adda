package com.onlinebusadda.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentAdminSession {

	@Id
	@Column(unique = true)
	private Integer adminId;
	
	private String uuid;
	
	private LocalDateTime dateTime;
	
	public CurrentAdminSession() {
		// TODO Auto-generated constructor stub
	}

	public CurrentAdminSession(Integer adminId, String uuid, LocalDateTime dateTime) {
		super();
		this.adminId = adminId;
		this.uuid = uuid;
		this.dateTime = dateTime;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "CurrentAdminSession [adminId=" + adminId + ", uuid=" + uuid + ", dateTime=" + dateTime + "]";
	}
	
	
	
}
