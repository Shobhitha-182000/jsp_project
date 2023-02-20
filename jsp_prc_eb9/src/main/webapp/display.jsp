<%@page import="com.ty_jsp_prc_employye.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String name=(String)request.getAttribute("value"); %>
 	<%
 		List<Employee> list=(List)request.getAttribute("list");
 	%>
 	changed by<%= name %>
 	<table border="2px" height="400px" width="600px">
	 	<tr>
	 		<th>id</th>
	 		<th>name</th>
	 		<th>address</th>
	 		<th>phone</th>
	 		<th>email</th>
	 		<th>Password</th>
\\\\\\\\\	 		
	 		<th>delete</th>
	 		<th>update</th>
	 	</tr>
	 	 
	 		<% for(Employee employee:list){ %>
	 	<tr>
	 			<td><%= employee.getId() %></td>
	 			<td><%= employee.getName() %></td>
	 			<td><%= employee.getAddress() %></td>
	 			<td><%= employee.getPhone() %></td>
	 			<td><%= employee.getEmail() %></td>
	 			<td><%=employee.getPassword() %></td>
	 			<td><a href="./delete?id=<%= employee.getId() %>"><button style="background-color: red; color: white;">Delete</button> </a></td>
	 			<td><a href="./update?id=<%= employee.getId() %>"><button style="background-color: red; color: white;">update</button> </a></td>
	 	</tr>	
	 		<%} %>
	 	 
 	</table>
</body>
</html>