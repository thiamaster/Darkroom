package br.com.darkroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="user")
public class User {
		
		public User(){
			
		}
		
		public User(String user, String pass){
			this.username = user;
			this.password = pass;
		}

		public User(long id, String user, String pass){
			this.username = user;
			this.password = pass;
		}
		
	@Id
	@Column(name = "user_id")
	@GeneratedValue
	private long id;
	
	@Column(name = "user_username")
	private String username;
	
	@Column(name = "user_password")
	private String password;
	
	public boolean authenticate(String username, String password){
		if ((this.username.equals(username)) && (this.password.equals(password)))
			return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+this.id+" | "+this.username+"]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj instanceof User))
			return false;
		User uc = (User)obj;
		if ((uc.id == this.id))
			return true;
		return false;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public long getId() {
		return id;
	}
	
	
}
