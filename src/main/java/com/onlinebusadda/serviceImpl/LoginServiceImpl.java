package com.onlinebusadda.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.CurrentUserSession;
import com.onlinebusadda.repository.CurrentUserSessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebusadda.exception.LoginException;
import com.onlinebusadda.DTO.LoginDTO;
import com.onlinebusadda.model.User;
import com.onlinebusadda.repository.UserRepo;
import com.onlinebusadda.service.LoginService;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserRepo uRepo;

	@Autowired
	private CurrentUserSessionRepo crepo;
	


	@Override
	public CurrentUserSession logIntoAccount(LoginDTO dto) throws LoginException {
		User existingUser = uRepo.findByEmail(dto.getEmail());

		if(existingUser == null) throw new LoginException("User Not exist");

		Optional<CurrentUserSession>  validUser = Optional.ofNullable(crepo.findByEmail(dto.getEmail()));

		if(validUser.isPresent()){
			throw  new LoginException("User Already login");


		}

		if(existingUser.getPassword().equals(dto.getPassword())){

			String key = RandomString.make(8);

			CurrentUserSession currentUserSession = new CurrentUserSession(dto.getEmail(), key, LocalDateTime.now(),
					dto.getUserType());

			crepo.save(currentUserSession);

			return  currentUserSession;

		}else {

			throw new LoginException("Plz enter valid password");
		}


	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		CurrentUserSession currentUserSession = crepo.findByUuid(key);

		if(currentUserSession == null){
			throw  new LoginException("User not logged in");
		}

		crepo.delete(currentUserSession);

		return "Logged out succesfully";
	}

}
