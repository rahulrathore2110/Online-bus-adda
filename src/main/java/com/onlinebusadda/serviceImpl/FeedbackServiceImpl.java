package com.onlinebusadda.serviceImpl;

import com.onlinebusadda.exception.BusException;
import com.onlinebusadda.exception.FeedbackException;
import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.Bus;
import com.onlinebusadda.model.CurrentUserSession;
import com.onlinebusadda.model.Feedback;
import com.onlinebusadda.model.User;
import com.onlinebusadda.repository.BusRepo;
import com.onlinebusadda.repository.CurrentUserSessionRepo;
import com.onlinebusadda.repository.FeedbackRepo;
import com.onlinebusadda.repository.UserRepo;
import com.onlinebusadda.service.FeedbackService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private CurrentUserSessionRepo crepo;

    @Autowired
    private UserRepo urepo;

    @Autowired
    private BusRepo brepo;

    @Autowired
    private FeedbackRepo frepo;



    @Override
    public Feedback addFeedback(Feedback feedback, String key,Integer busId) throws FeedbackException,UserException,
            BusException {
        CurrentUserSession existingUser = crepo.findByUuid(key);

        if(existingUser == null){
            throw new UserException("User Not logged in");
        }

        User user = urepo.findByEmail(existingUser.getEmail());

       feedback.setUser(user);

        Optional<Bus> bus  = brepo.findById(busId);

        if(bus.isPresent()){

            Bus existingBus = bus.get();

            feedback.setBus(existingBus);

            frepo.save(feedback);

            return feedback;


        }else {
            throw new BusException("Bus not found with this Bus Id");
        }



    }

    @Override
    public Feedback updateFeedback(Feedback feedback, String key) throws FeedbackException ,UserException{
        CurrentUserSession existingUser = crepo.findByUuid(key);

        if(existingUser == null){
            throw new UserException("User Not logged in");
        }
        if (existingUser.getEmail().equals(feedback.getUser().getEmail())){
            frepo.save(feedback);

            return feedback;
        }else {
            throw new UserException("you Can't update with this email Id plz change");
        }



    }

    @Override
    public Feedback viewFeedback(Integer feedbackId, String key) throws FeedbackException, UserException {

        CurrentUserSession existingUSer = crepo.findByUuid(key);

        if(existingUSer == null){
            throw new UserException("Plz login ");
        }



        Optional<Feedback> feedback = frepo.findById(feedbackId);

        if(feedback.isPresent()){



            Feedback fd = feedback.get();

            if(fd.getUser().getEmail().equals(existingUSer.getEmail())){
                return fd;

            }else {
                throw new UserException("User does not match with this Email plz user other email");
            }


        }else {
            throw new FeedbackException("Feedback not found with this Id");
        }
    }

    @Override
    public Feedback deleteFeedback(Integer feedbackId, String key) throws FeedbackException, UserException {
        CurrentUserSession existingUser = crepo.findByUuid(key);

        if(existingUser == null){
            throw new UserException("User Not logged in");
        }

        Optional<Feedback> feedback = frepo.findById(feedbackId);

        if(feedback.isPresent()){

            Feedback fd = feedback.get();

            if(fd.getUser().getEmail().equals(existingUser.getEmail())){

                frepo.delete(fd);

                return fd;

            }else {
                throw new UserException("User does not match with this Email plz user other email");
            }


        }else {
            throw new FeedbackException("Feedback not found with this Id");
        }
    }

    @Override
    public List<Feedback> viewAllFeedback(String key) throws FeedbackException, UserException {

        CurrentUserSession existingUSer = crepo.findByUuid(key);

        if(existingUSer == null){
            throw new UserException("Plz login ");
        }

        if (existingUSer.getUserType().name().equals("ADMIN")){
            List<Feedback> feedbacks = frepo.findAll();

            if (feedbacks.size() > 0){
                return feedbacks;
            }else {
                throw new FeedbackException("No feedbacks found");
            }


        }else {
            throw new UserException("Plz login as admin");
        }

    }
}
