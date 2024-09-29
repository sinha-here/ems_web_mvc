<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String salary = request.getParameter("salary");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
	
	%>
	
	<form action="update_emp" method = "post">
	
		<input type = "hidden" name = "id" value = "<%=id%>"><br>
		Name : <input type = "text" name = "name" value = "<%=name%>"><br>
		Salary : <input type = "text" name = "salary" value = "<%=salary%>"><br>
		Phone : <input type = "tel" name = "phone" value = "<%=phone%>"><br>
		Password : <input type = "text" name = "password" value = "<%=password%>"><br>
		role : <input type = "text" name = "role" value = "<%=role%>"><br>
		<input type = "submit" value = "update">
		
		
	
	</form>
	
	
	
	
	
	
</body>
</html>