<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="signup" method="post">
		<label for="name">First Name</label> 
		<input type="text" name="name"placeholder="enter first name"><br>
		<label for="address">Address</label> 
		<input type="text" name="address"placeholder="enter your address"><br>
		
		<label for="email">Email</label>
		 <input type="email" name="email" placeholder="enter your email"><br>
		 
			 <label for="password">Password</label>
		<input type="password" name="password" placeholder="enter your password">
		<br> 
		<label for="phone">Phone</label>
		 <input type="number" name="phone" placeholder="enter you phoneNumber"><br><input
		 
			type="submit">
	</form>	
</body>
</html>