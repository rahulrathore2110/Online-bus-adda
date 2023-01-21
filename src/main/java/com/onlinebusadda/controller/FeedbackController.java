package com.onlinebusadda.controller;

import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.FeedbackException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Feedback;
import com.onlinebusadda.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService fservice;


    @PostMapping("/feedback/{key}/{busId}")
    public ResponseEntity<Feedback> addFeedbackHandler(@Valid @RequestBody Feedback feedback,
                                                       @PathVariable("key") String key, @PathVariable("busId") Integer busId) throws FeedbackException,UserException,BusException {

        Feedback feedback1 = fservice.addFeedback(feedback, key, busId);

        return new ResponseEntity<Feedback>(feedback1, HttpStatus.ACCEPTED);

    }

    @PutMapping("/feedback/{key}")
    public ResponseEntity<Feedback> updateFeedbackHandler(@Valid @RequestBody Feedback feedback,
                                                          @PathVariable("key") String key) throws FeedbackException,
            UserException {

        Feedback feedback1 = fservice.updateFeedback(feedback, key);

        return new ResponseEntity<Feedback>(feedback1, HttpStatus.ACCEPTED);

    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedbackHandler(@Valid @PathVariable("id") Integer id) throws FeedbackException{

        Feedback feedback1 = fservice.viewFeedback(id);

        return new ResponseEntity<Feedback>(feedback1, HttpStatus.ACCEPTED);

    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> getFeedbackHandler() throws FeedbackException{

        List<Feedback> feedback1 = fservice.viewAllFeedback();

        return new ResponseEntity<List<Feedback>>(feedback1, HttpStatus.ACCEPTED);

    }
}
