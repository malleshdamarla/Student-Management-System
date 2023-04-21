<%@page import="com.student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
	<% Student student=(Student)request.getAttribute("student"); %>
	<form action="saveUpdatedStudent" method="post">
		<input name="StudentId" value="<%= student.getStudentId()%>" readonly="readonly">
		<input name="studentName" value="<%= student.getStudentName() %>" placeholder="Enter student Name" type="text">
		<input name="studentEmail" value="<%= student.getStudentEmail() %>" placeholder="Enter student Email" type="email"> 
		<input name="studentPhoneNumber" value="<%= student.getStudentPhone() %>" placeholder="Enter student Phone" type="text"> 
		<input name="studentFee" value="<%= student.getStudentFee()  %> " readonly="readonly" type="text"> 
		
		<input type="submit" value="Submit">
	</form>
</body>
</html>
<!-- body {
height: SCvh;
wicEh: 1 OOvw;
display: flex;
flex—direction: e
align- i tens: cent
ustify—content :
padding: . Sem 2 em;
font—size:
border: 2px solid
border-radius: 50
t ex— —decor at ion :
color: *SOSOSO;
margin :
. 5 ran;
font —si ze: 7rem;
color: #565656; -->