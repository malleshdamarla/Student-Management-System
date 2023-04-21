package com.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.dao.AdminDao;
import com.student.dao.StudentDao;
import com.student.dto.Admin;
import com.student.dto.Student;

@WebServlet("/save")
public class saveStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Admin admin = (Admin) httpSession.getAttribute("admin");
		if (admin != null) {
			String name = req.getParameter("studentName");
			String email = req.getParameter("studentEmail");
			String StringPhoneNumber = req.getParameter("studentPhoneNumber");

			long phoneNumber = Long.parseLong(StringPhoneNumber);

			ServletContext context = getServletContext();
			String fee = context.getInitParameter("StudentFee");

			double studentFee = Double.parseDouble(fee);

			Student student = new Student();
			student.setStudentName(name);
			student.setStudentEmail(email);
			student.setStudentPhone(phoneNumber);
			student.setStudentFee(studentFee);
			student.setAdmin(admin);// if i want too see student details after adding the admin i have set the admin also

			new StudentDao().save(student);
			// after saving the student assgin the syudent to the related admin
			List<Student> students = admin.getStudents();
			students.add(student);
			new AdminDao().UpdateAdmin(admin);
			
			
			resp.sendRedirect("Dashboard.jsp");
		} else {
			resp.sendRedirect("AdminLogin.jsp");
		}
	}
}
