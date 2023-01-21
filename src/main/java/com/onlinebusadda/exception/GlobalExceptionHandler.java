package com.onlinebusadda.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Reservation Exception Handler

	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<MyErrorDetails> reservationExceptionHandler(ReservationException e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	
	// Routes Exception Handler
	
	@ExceptionHandler(RoutesException.class)
	public ResponseEntity<MyErrorDetails> routesExceptionHandler(RoutesException e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	
	
	// Login Exception Handler
	
		@ExceptionHandler(LoginException.class)
		public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException e, WebRequest req) {

			MyErrorDetails err = new MyErrorDetails();

			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(e.getMessage());
			err.setDetails(req.getDescription(false));

			return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

		}

	@ExceptionHandler(FeedbackException.class)
	public ResponseEntity<MyErrorDetails> feedbackExceptionHandler(FeedbackException e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	
	
	// User Exception Handler
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	
	// Bus Exception Handler
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyErrorDetails> busExceptionHandler(BusException e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	// Generic Exception Handler
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> genericExceptionHandler(Exception e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	// No Handler Found Exception Handler
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(NoHandlerFoundException e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	// Method Argument NotValid Exception Handler
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> MANVExceptionHandler(MethodArgumentNotValidException me) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setDetails("Validation Error");
		err.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

}
