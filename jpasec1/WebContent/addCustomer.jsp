<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <link href="css/bootstrap.css" rel="stylesheet"/>
</head>
<body>

<%System.out.println(request.getParameter("test")); %>

<br>
<h1><center>Add a Customer</center></h1>
<form action ="crudAction" method="post" class="form-horizontal">
 
  <div class="form-group">
    <label class="control-label col-sm-2" for="email"><b>ID:</b></label>
    <div class="col-sm-8">
      <input type="text" name="id" class="form-control">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="email"><strong>First Name:</strong></label>
    <div class="col-sm-8">
      <input type="text" name="firstname" value="Mickey" class="form-control">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="email"><strong>Last Name:</strong></label>
    <div class="col-sm-8">
      <input type="text" name="lastname" value="Mickey" class="form-control">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="email"><strong>Email:</strong></label>
    <div class="col-sm-8">
      <input type="text" name="email" class="form-control">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="email"><strong>Country:</strong></label>
    <div class="col-sm-8">
      <input type="text" name="country" class="form-control">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="email"><strong>Credit Card:</strong></label>
    <div class="col-sm-8">
      <input type="text" name="creditcard" class="form-control">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="email"><strong>Phone #:</strong></label>
    <div class="col-sm-8">
      <input type="text" name="phone" class="form-control">
    </div>
  </div>
  
  
  
  
  
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label><input type="checkbox"> Remember me</label>
      </div>
    </div>
  </div>
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" name="add" value="Submit" class="btn btn-default">Submit</button>
      <a class="btn btn-primary" href="/jpasec1/customers.jsp">Back</a>
    </div>
  </div>
</form>

</body>
</html>