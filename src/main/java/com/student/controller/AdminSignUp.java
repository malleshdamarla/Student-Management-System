package com.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.AdminDao;
import com.student.dto.Admin;

@WebServlet("/signUp")
public class AdminSignUp extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("AdminName");
		String email=req.getParameter("AdminEmail");
		String password=req.getParameter("AdminPassword");
		
		Admin admin = new Admin();
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		admin.setAdminPassword(password);
		
		new AdminDao().AdminSignUp(admin);
		
		req.getRequestDispatcher("AdminLogin.jsp").forward(req, resp);
	}
}
