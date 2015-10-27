package br.com.darkroom.controller.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.darkroom.Exception.LoginException;
import br.com.darkroom.model.User;
import br.com.darkroom.service.UserService;

public class LoginCommand implements Command {

	@Override
	public void action(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try{
			String username = req.getParameter("username");
				if (username == null) throw new NullPointerException("Username cannot be null");
			String password = req.getParameter("password");
				if (password == null) throw new NullPointerException("Password cannot be null");
			try{
				User user = UserService.getInstance().authenticate(username, password);
					if (user == null) throw new LoginException("Usuário não existe ou senha incorreta.");
				req.getSession().setAttribute("user", user);
				System.out.println("Usuário na sessão");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return;
		}catch(NullPointerException npe){
			npe.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			try{
				rd.forward(req, resp);
			}catch(Exception ioe){
				ioe.printStackTrace();
			}
		}
	}
	

}
