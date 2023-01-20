package com.onlinebusadda.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebusadda.exception.LoginException;
import com.onlinebusadda.model.CurrentUserSession;
import com.onlinebusadda.model.LoginDTO;
import com.onlinebusadda.model.User;
import com.onlinebusadda.repository.SessionRepo;
import com.onlinebusadda.repository.UserRepo;
import com.onlinebusadda.service.LoginService;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private SessionRepo sRepo;

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		User user=uRepo.findByUserName(dto.getUserName());
		
		if(user==null) {
			throw new LoginException("Please Enter a valid username.");
		}
		
		Optional<CurrentUserSession> validUserSessionOpt =sRepo.findById(user.getUserLoginId());
		
		if(validUserSessionOpt.isPresent()) {
			throw new LoginException("User already Logged in with this username.");
		}
		
		if(user.getPassword().equals(dto.getPassword())) {
			String key=RandomString.make(6);
			CurrentUserSession currentUserSession=new CurrentUserSession(user.getUserLoginId(),"user",key,LocalDateTime.now());
			sRepo.save(currentUserSession);
			return currentUserSession.toString();
		}
		
		else {
			throw new LoginException("Please Enter a valid password");
		}
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
		CurrentUserSession validUserSession=sRepo.findByUuid(key);
		
		if(validUserSession==null) {
			throw new LoginException("User not logged in with this username.");
		}
		
		sRepo.delete(validUserSession);
		return "Logged out successfully.";
	}

}
