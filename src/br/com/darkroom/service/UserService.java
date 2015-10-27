package br.com.darkroom.service;

import br.com.darkroom.Exception.JPQLException;
import br.com.darkroom.model.User;
import br.com.darkroom.repository.Repository;

public class UserService {
	private static UserService us;
	
	private UserService(){

	}
	
	public static UserService getInstance(){
		if (UserService.us == null)
			UserService.us = new UserService();
		return UserService.us;
	}
	
	public User authenticate(String username, String password){
		return Repository.getUserDAO().authenticateUser(username, password);
	}
	
	public void insertUser(String username, String password) throws JPQLException{
		Repository.getUserDAO().insertUser(username, password);
	}
}
