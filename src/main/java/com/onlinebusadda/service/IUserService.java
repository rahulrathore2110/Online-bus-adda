package com.onlinebusadda.service;

import java.util.List;

import com.onlinebusadda.exception.UserException;
import com.onlinebusadda.model.User;
import org.springframework.stereotype.Service;


@Service
public interface IUserService {
	
	
	public User addUser(User user) throws UserException;
	
	public User updateUser(User user,String key) throws UserException;
	
	public User deleteUser(Integer userId,String key) throws UserException;
	
	public User viewUser(Integer userId,String key) throws UserException;
	
	public List<User> viewAllUsers(String key) throws UserException;
}