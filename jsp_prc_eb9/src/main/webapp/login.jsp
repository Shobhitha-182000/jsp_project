<%@page import="com.google.protobuf.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div color="red">
<% String message=(String)request.getAttribute("message"); 
%>
<%
if(message!=null){ 
%>
	<%= message %>
<%} %>
</div>
 
<br>
 <form action="login" method="post">
	 
		<label for="email">Email</label> 
		 <input type="email" name="email"
			placeholder="enter your email"><br> <label for="password">Password</label>
		<input type="password" name="password" placeholder="enter your password">
		<br> 
		<input type="submit" value="submit">
		 
	</form>

</body>
</html>