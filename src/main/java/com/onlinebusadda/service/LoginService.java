package com.onlinebusadda.service;

import com.onlinebusadda.exception.LoginException;
import com.onlinebusadda.model.LoginDTO;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto) throws LoginException;
	
	public String logOutFromAccount(String key) throws LoginException;
}
