package br.com.darkroom.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.darkroom.is.dao.UserDAO;

public class Repository {
	private static EntityManagerFactory emfDarkroomDB = Persistence.createEntityManagerFactory("DarkroomDB");
	private static UserDAO udao = new UserDAO();
	
	public static EntityManager getEntityManagerMDarkroomDB(){
		return emfDarkroomDB.createEntityManager();
	}
	public static UserDAO getUserDAO(){
		return udao;
	}
	
}
