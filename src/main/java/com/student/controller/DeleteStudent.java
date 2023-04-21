package com.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.dao.StudentDao;
import com.student.dto.Admin;
import com.student.dto.Student;

@WebServlet("/deleteStudent") // this url should match with viewstrudent
public class DeleteStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession();
		Admin admin= (Admin) session.getAttribute("admin");
		if(admin!=null) {
		
		String StudentId = (String) req.getParameter("studentId");
		
		int id = Integer.parseInt(StudentId);

		StudentDao dao = new StudentDao();

		dao.deleteStudent(id);

		List<Student> students = dao.getAllStudents(admin);
		
		req.setAttribute("students", students);

		req.getRequestDispatcher("viewStudents.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("AdminLogin.jsp");
		}
	}
}
