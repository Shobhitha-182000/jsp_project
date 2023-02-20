<%@page import="com.ty_jsp_prc_employye.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Employee employee=(Employee)request.getAttribute("employee"); %>
	<form action="edit" method="post">
			<label for="id">id</label>
		 <input type="number" name="id" placeholder="enter you phoneNumber" value=<%= employee.getId() %> readonly="readonly">
		<br>
		
		<label for="name">First Name</label> 
		<input type="text" name="name"placeholder="enter first name" value=<%= employee.getName() %>><br>
		<label for="address">Address</label> 
		<input type="text" name="address"placeholder="enter your address" value=<%= employee.getAddress() %>><br>
		
		<label for="email">Email</label>
		 <input type="email" name="email" placeholder="enter your email" value=<%= employee.getEmail() %>><br>
		 
			 <label for="password">Password</label>
		<input type="password" name="password" placeholder="enter your password" value=<%= employee.getPassword() %>>
		<br> 
		<label for="phone">Phone</label>
		 <input type="number" name="phone" placeholder="enter you phoneNumber" value=<%= employee.getPhone() %>><br> <input
			type="submit">
	</form>	
</body>
</html>