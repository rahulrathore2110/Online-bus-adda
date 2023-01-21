package com.onlinebusadda.service;

import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.FeedbackException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackService {

    public Feedback addFeedback(Feedback feedback,String key,Integer busId) throws FeedbackException, UserException,
            BusException;
    public Feedback updateFeedback(Feedback feedback,String key) throws FeedbackException,UserException;
    public Feedback viewFeedback(Integer feedbackId) throws FeedbackException;
    public List<Feedback> viewAllFeedback() throws FeedbackException;
}
