<%@page import="com.student.dto.Admin"%>
<%@page import="com.student.dto.Student"%>
<%@page import="java.util.List"%>
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
	Admin admin=(Admin)session.getAttribute("admin");
	if(admin!= null){
	List<Student> students = (List) request.getAttribute("students");
	%>
	<h1>Student list</h1>

	<table border="" cellPadding="10px" cellSpacing="0">
		<tr>
			<th>Student_Id</th>
			<th>Student_Name</th>
			<th>Student_Email</th>
			<th>Student_Phone</th>
			<th>Student_Fee</th>
			<th>Update_Student</th>
			<th>Delete_Student</th>
		</tr>
		<%
		for (Student student : students) {
		%>
		<tr>
			<td><%=student.getStudentId()%></td>
			<td><%=student.getStudentName()%></td>
			<td><%=student.getStudentEmail()%></td>
			<td><%=student.getStudentPhone()%></td>
			<td><%=student.getStudentFee()%></td>
			<td><a
				href="updateStudent?studentId=<%=student.getStudentId()%>">Update</a></td>
			<td><a
				href="deleteStudent?studentId=<%=student.getStudentId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<%}else{
		response.sendRedirect("AdminLogin.jsp");
		}%>
</body>
</html>