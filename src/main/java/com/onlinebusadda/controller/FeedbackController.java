package com.onlinebusadda.controller;

import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.FeedbackException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Feedback;
import com.onlinebusadda.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/feedback/{id}/{key}")
    public ResponseEntity<Feedback> getFeedbackHandler(@Valid @PathVariable("id") Integer id,
                                                       @PathVariable("key") String key) throws FeedbackException, UserException {

        Feedback feedback1 = fservice.viewFeedback(id,key);

        return new ResponseEntity<Feedback>(feedback1, HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/feedback/{id}/{key}")
    public ResponseEntity<Feedback> deleteFeedbackHandler(@Valid @PathVariable("id") Integer id,
                                                       @PathVariable("key") String key) throws FeedbackException, UserException {

        Feedback feedback1 = fservice.deleteFeedback(id, key);

        return new ResponseEntity<Feedback>(feedback1, HttpStatus.ACCEPTED);

    }

    @GetMapping("/feedbacks/{key}")
    public ResponseEntity<List<Feedback>> getFeedbackHandler(@Valid @PathVariable("key") String key) throws FeedbackException, UserException {

        List<Feedback> feedback1 = fservice.viewAllFeedback(key);

        return new ResponseEntity<List<Feedback>>(feedback1, HttpStatus.ACCEPTED);

    }
}
