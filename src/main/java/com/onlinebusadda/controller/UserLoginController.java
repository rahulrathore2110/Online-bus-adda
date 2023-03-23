package com.onlinebusadda.controller;


import com.onlinebusadda.model.CurrentUserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebusadda.exception.LoginException;
import com.onlinebusadda.DTO.LoginDTO;
import com.onlinebusadda.service.LoginService;



@RestController
@RequestMapping("/user")
public class UserLoginController {
	@Autowired
	private LoginService lService;
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> userLoginHandler(@Valid @RequestBody LoginDTO dto) throws LoginException{
		CurrentUserSession msg=lService.logIntoAccount(dto);
		return new ResponseEntity<CurrentUserSession>(msg,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> userLogoutHandler(@RequestParam String key) throws LoginException{
		String msg=lService.logOutFromAccount(key);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
}
