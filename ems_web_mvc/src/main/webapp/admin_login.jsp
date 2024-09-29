<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="admin_login" method  = "post">
		
		Enter the Id : <input type = "number" name = "id"><br>
		Enter the Password : <input type = "text" name = "password"><br>
		<input type = "submit" value = "login"><br>
	</form>
	
	<%
	
		String message = (String)request.getAttribute("message");
	
		if(message != null){
	
	%>
		<h2> <%= message %> </h2>
	
	<%
		} 
	
	%>
	
	
</body>
</html>