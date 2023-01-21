package com.onlinebusadda.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Feedback {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedBackId;
    private Integer driverRating;
    private Integer serviceRating;
    private  Integer overallRating = (driverRating + serviceRating )/2;
    private String comments;
    private LocalDateTime localDateTime;
    
//    @OneToOne
    private User user;
    
//    @OneToOne
    private Bus bus;

    public Feedback() {
    }

    public Feedback(Integer feedBackId, Integer driverRating, Integer serviceRating, Integer overallRating, String comments, LocalDateTime localDateTime, User user, Bus bus) {
        this.feedBackId = feedBackId;
        this.driverRating = driverRating;
        this.serviceRating = serviceRating;
        this.overallRating = overallRating;
        this.comments = comments;
        this.localDateTime = localDateTime;
        this.user = user;
        this.bus = bus;
    }

    public Integer getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(Integer feedBackId) {
        this.feedBackId = feedBackId;
    }

    public Integer getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(Integer driverRating) {
        this.driverRating = driverRating;
    }

    public Integer getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(Integer serviceRating) {
        this.serviceRating = serviceRating;
    }

    public Integer getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Integer overallRating) {
        this.overallRating = overallRating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
