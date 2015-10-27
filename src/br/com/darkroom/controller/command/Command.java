package br.com.darkroom.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public void action(HttpServletRequest req, HttpServletResponse resp);
}
