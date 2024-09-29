<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action= "add_emp" method = "post">
			
			Name : <input type = "text" name = "name"> <br>
			Salary : <input type = "text" name = "salary"> <br>
			Phone : <input type = "tel" name = "phone"><br>
			Password : <input type = "text" name = "password"><br>
			Role : <input type = "text" name = "role"><br>
			<input type = "submit">	
			
		
		</form>
		
		<%
	
		String message = (String)request.getAttribute("message");
	
		if(message != null){
	
	%>
		<h6> <mark> <%= message %> </mark></h6>
	
	<%
		} 
	
	%>
		
		
		
		
		
</body>
</html>