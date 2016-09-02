<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.ide.jpa.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Customer Database</title>
<link href="css/bootstrap.css" rel="stylesheet" />

</head>
<body>

<script type="text/javascript">
function confirm_click()
{
return confirm("Are you sure ?");
}

</script>

<% 	
	CustomerDao dao = new CustomerDao();
	List<Customer> customers = dao.selectAll();
	
	if(request.getAttribute("customers") != null) {
		System.out.println("test");
		customers = (List<Customer>) request.getAttribute("customers");
	}

	
%>
<form action ="crudAction" method="post">
<table class ="table">
  <thead class="thead-inverse">
  <tr>
      <th colspan="8">
      <div class="form-inline">
      	<a class="btn btn-success" name="test" href="/jpasec1/addCustomer.jsp" value="1">Add</a>
      	<button type="submit" name= "search" class="btn btn-success" >Search</button>
		<input type="text" name= "searchtext" placeholder="Search" class="form-control">
		<a class="btn btn-success" href="/jpasec1/customers.jsp">Clear</a>
		</div>
      
      </th>
    </tr>
    <tr>
      <th>#</th>
      <th>First</th>
      <th>Last</th>
      <th>Email</th>
      <th>Country</th>
      <th>Credit Card</th>
      <th>Phone</th>
      <th></th>
    </tr>
  </thead>

<% for (Customer ap: customers) {
%>		<tr>
			<td ><%= ap.getId() %></td>
			<td><%= ap.getFirstname() %></td>
			<td><%= ap.getLastname() %></td>
			<td><%= ap.getEmail() %></td>
			<td><%= ap.getCountry() %></td>
			<td><%= ap.getCreditcard() %></td>
			<td><%= ap.getPhone() %></td>
			<td>
			<button class="btn btn-primary" name="delete" value="<%= ap.getId() %>" type="submit" onclick="return confirm_click();">Delete</button>
			<button class="btn btn-primary" name="edit" value="<%= ap.getId() %>" type="submit">Edit</button>
			</td>
			
		</tr>
<% 
	}
%>
	</table>
	</form>
</body>
</html>