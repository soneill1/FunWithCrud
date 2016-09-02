package edu.neu.cs5200.ide.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CustomerDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpasec1");
	EntityManager em = null;
	
	public CustomerDao() {
		em = factory.createEntityManager();
	}
	
	public void createCustomer(Customer customer) {
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
	}
	
	public void updateCustomer(Customer customer) {
		em.getTransaction().begin();
		//customer.setLast(newLastName);
		em.merge(customer);
		em.getTransaction().commit();
	}
	
	public Customer findCustomerById(int id) {
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, id);
		em.getTransaction().commit();
		return customer;
	}
	
	public void removeCustomerById(int id) {
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, id);
		em.remove(customer);
		em.getTransaction().commit();
	}
	
	public List<Customer> selectAll() {
		em.getTransaction().begin();
		Query q = em.createNamedQuery("Customer.selectAll");
		List<Customer> customers = q.getResultList();
		em.getTransaction().commit();
		return customers;
	}
	
	public List<Customer> findByName(String name) {
		em.getTransaction().begin();
		Query q = em.createQuery("select c from Customer c where c.firstname LIKE :name OR c.lastname LIKE :name OR c.email LIKE :name OR c.country LIKE :name OR c.phone LIKE :name");
		q.setParameter("name", "%"+name+"%");
//		Student student = (Student) q.getSingleResult();
		List<Customer> customers = q.getResultList();
		em.getTransaction().commit();
//		return student;
		return customers;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		List<Customer> customers = dao.selectAll();
		
		for(Customer c: customers) {
			System.out.println(c);
		}
	}

}
