package com.student.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDao;
import com.student.dto.Student;

@WebServlet("/updateStudent")
public class updateStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//You have to find the existing Student from the database,
		//then send the student to the jsp file
		//then get data from the jsp and save
		String id=req.getParameter("studentId");
		Student student=new StudentDao().getStudent(Integer.parseInt(id));
		req.setAttribute("student", student);
		
		req.getRequestDispatcher("updateStudent.jsp").forward(req, resp);
	}
}
