package br.com.darkroom.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.darkroom.service.UserService;

public class RegisterCommand implements Command {

	@Override
	public void action(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		try{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			UserService.getInstance().insertUser(username, password);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
