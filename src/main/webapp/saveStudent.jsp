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
	<form action="save" method="post">
	<input name="studentName" placeholder="Enter student Name" type="text">
	<input name="studentEmail" placeholder="Enter student Email" type="email">
	<input name="studentPhoneNumber" placeholder="Enter student Phone" type="text">
	<input type="submit" value="Submit">
	</form>
	<%}else{
		response.sendRedirect("AdminLogin.jsp");
		}%>
	
</body>
</html>