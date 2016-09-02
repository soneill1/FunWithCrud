package edu.neu.cs5200.ide.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQueries({		@NamedQuery(name="User.findUserByName", query="select s from User s where s.username = :username1"),
					@NamedQuery(name="User.findUserByNameAndPass", query="select s from User s where s.username = :username1 AND s.password = :password1"),
					@NamedQuery(name="User.findAll", query="select s from User s")})

public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
}
