package com.onlinebusadda.service;

import com.onlinebusadda.exception.LoginException;
import com.onlinebusadda.model.AdminDto;

public interface AdminLoginService {
	
	public String logIntoAccount(AdminDto dto) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
