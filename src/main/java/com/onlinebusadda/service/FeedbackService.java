package com.onlinebusadda.service;

import com.onlinebusadda.exception.FeedbackException;
import com.onlinebusadda.model.Feedback;

import java.util.List;

public interface FeedbackService {

    public Feedback addFeedback(Feedback feedback) throws FeedbackException;
    public Feedback updateFeedback(Feedback feedback) throws FeedbackException;
    public Feedback viewFeedback(Integer feedbackId) throws FeedbackException;
    public List<Feedback> viewAllFeedback() throws FeedbackException;
}
