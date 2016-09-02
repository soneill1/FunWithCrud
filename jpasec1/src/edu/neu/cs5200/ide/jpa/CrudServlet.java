package edu.neu.cs5200.ide.jpa;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrudServlet
 */

public class CrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CrudServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao dao = new CustomerDao();
		
		//System.out.println(request.getParameter("id"));
		
		
		
		if (request.getParameter("delete") != null) {
			
			String value = request.getParameter("delete");
			int foo = Integer.parseInt(value);
			System.out.println(""+foo);
            dao.removeCustomerById(foo);
            response.sendRedirect("/jpasec1/customers.jsp");
        
		} else if(request.getParameter("add") != null) {
        	dao.createCustomer(new Customer(Integer.parseInt(request.getParameter("id")), request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"), request.getParameter("country"), request.getParameter("creditcard"), request.getParameter("phone")));
        	response.sendRedirect("/jpasec1/customers.jsp");
        
        } else if(request.getParameter("update") != null) {
        	dao.updateCustomer(new Customer(Integer.parseInt(request.getParameter("id")), request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"), request.getParameter("country"), request.getParameter("creditcard"), request.getParameter("phone")));
        	response.sendRedirect("/jpasec1/customers.jsp");
        
        } else if(request.getParameter("edit") != null) {
        	Customer customer = dao.findCustomerById(Integer.parseInt(request.getParameter("edit")));
        	request.setAttribute("customer", customer);
        	System.out.println(customer.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/editCustomer.jsp");
			dispatcher.forward(request, response);
        
        } else if(request.getParameter("search") != null) {
        	System.out.println(request.getParameter("searchtext"));
        	List<Customer> customers = dao.findByName(request.getParameter("searchtext"));
        	System.out.println(customers);
        	request.setAttribute("customers", customers);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/customers.jsp");
			dispatcher.forward(request, response);
        	
        }
		
		

        //request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
	}

}
