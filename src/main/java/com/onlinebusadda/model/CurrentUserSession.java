package com.onlinebusadda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class CurrentUserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer currentId;
    private String email;
    private String uuid;
    private LocalDateTime localDateTime;
    private UserType userType;

    public CurrentUserSession() {
    }

    public CurrentUserSession(Integer currentId, String email, String uuid, LocalDateTime localDateTime, UserType userType) {
        this.currentId = currentId;
        this.email = email;
        this.uuid = uuid;
        this.localDateTime = localDateTime;
        this.userType = userType;
    }

    public CurrentUserSession(String email, String uuid, LocalDateTime localDateTime, UserType userType) {
        this.email = email;
        this.uuid = uuid;
        this.localDateTime = localDateTime;
        this.userType = userType;
    }

    public Integer getCurrentId() {
        return currentId;
    }

    public void setCurrentId(Integer currentId) {
        this.currentId = currentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
