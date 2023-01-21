package com.onlinebusadda.service;

import com.onlinebusadda.exception.LoginException;
import com.onlinebusadda.DTO.LoginDTO;
import com.onlinebusadda.model.CurrentUserSession;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
	
	//login and logout methods 
	public CurrentUserSession logIntoAccount(LoginDTO dto) throws LoginException;
	
	public String logOutFromAccount(String key) throws LoginException;
}
