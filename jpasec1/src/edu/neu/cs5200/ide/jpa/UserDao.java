package edu.neu.cs5200.ide.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpasec1");
	EntityManager em = null;
	
	public UserDao() {
		em = factory.createEntityManager();
	}
	
	public void createUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	public void updateUser(User user, String password) {
		em.getTransaction().begin();
		user.setPassword(password);
		em.merge(user);
		em.getTransaction().commit();
	}
	
	public User findUserById(int id) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.getTransaction().commit();
		return user;
	}
	
	public void removeUserById(int id) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.remove(user);
		em.getTransaction().commit();
	}
	
	public User findUserByName(String name) {
		
		try {
			Query q = em.createNamedQuery("User.findUserByName");
			q.setParameter("username1", name);
			return (User) q.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public User findUserByNameAndPass(String name, String password) {
		em.getTransaction().begin();
		Query q = em.createNamedQuery("User.findUserByNameAndPass");
		q.setParameter("username1", name);
		q.setParameter("password1", password);
		try {
			List<User> users = (List<User>) q.getResultList();
			
			for(User i: users){ 
				i = users.get(0);
		         if (i == null){
		             return null;
		         }
		         else return i;
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	public static void main(String[] args) {
		User user1 = new User("alice", "alice");
		User user2 = new User("charlie", "charlie");
		User user3 = new User("bob", "bob");
		
		UserDao dao = new UserDao();
//		dao.createUser(user1);
//		dao.createUser(user2);
//		dao.createUser(user3);
		
		User a = dao.findUserById(1);
		dao.updateUser(a, "alice2");
		
		dao.em.close();
		dao.factory.close();
		
		System.out.println(a.getUsername());
		
		


		
	}

}
