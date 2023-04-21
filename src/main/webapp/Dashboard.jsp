<%@page import="com.student.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Admin admin=(Admin)session.getAttribute("admin"); 
if(admin!= null){
%>
	
	<h1>Welcome Admin</h1>
	<h3>U can manage Student date here!!</h3>
	<div>
		<a href="saveStudent.jsp">Save_Student</a><br><br>
		<a href="viewStudents">View_Student</a>
	</div>
	<%}else{
		response.sendRedirect("AdminLogin.jsp");
	}
		%><br>
	<div><a href="adminLogout">LogOut</a></div>
</body>
</html>