package br.com.darkroom.is.dao;

import java.util.List;

import javax.persistence.EntityManager;


import javax.persistence.Query;

import br.com.darkroom.Exception.JPQLException;
import br.com.darkroom.model.User;
import br.com.darkroom.repository.Repository;

public class UserDAO {
	EntityManager emD;
	
	public UserDAO(){asd
		emD = Repository.getEntityManagerMDarkroomDB();
	}
	
	public User authenticateUser(String username, String password){
		String jpql = "FROM User us";
		Query query = emD.createQuery(jpql);
		query.setMaxResults(1);
		List<User> userList = query.getResultList();
		for (User us : userList ){
			if (us.authenticate(username, password))
				return us;
		}
		
		return null;
	}
	
	public User searchUsername(String username){
		String jpql = "FROM User us";
		Query query = emD.createQuery(jpql);
		List<User> userList = query.getResultList();
		for (User us : userList){
			if (us.getUsername().equals(username))
				return new User(us.getId(), us.getUsername(), us.getPassword());
		}
		return null;
	}
	
	public void insertUser(String username, String password) throws JPQLException{
		User user = new User(username, password);
		System.out.println("Adicionando ao banco: "+user);
		if (searchUsername(username) == null){
			emD.getTransaction().begin();
			emD.persist(user);
			emD.getTransaction().commit();
			emD.flush();
		}else{
			throw new JPQLException("Um usuário com este nome já existe. Por favor selecione outro usuário válido.");
		}
	}
}
