package br.com.darkroom.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User("Thiago", "123");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dkr_server");
		System.out.println("donet");
	}

}
