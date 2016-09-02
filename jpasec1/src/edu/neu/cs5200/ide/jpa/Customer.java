package edu.neu.cs5200.ide.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@NamedQueries({		@NamedQuery(name="Customer.selectAll", query="select c from Customer c"),
					@NamedQuery(name="Customer.findAll2", query="select s from Customer s")
})

public class Customer implements Serializable {

	   
	@Id
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String country;
	private String creditcard;
	private String phone;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}   
	
	public Customer(int id, String firstname, String lastname, String email, String country, String creditcard,
			String phone) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.creditcard = creditcard;
		this.phone = phone;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}   
	public String getCreditcard() {
		return this.creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", country=" + country + ", creditcard=" + creditcard + ", phone=" + phone + "]";
	}
	
	
   
}
