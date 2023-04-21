package com.student.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String StudentName;
	private String StudentEmail;
	private long StudentPhone;
	private double StudentFee;
	
	@ManyToOne
	@JoinColumn
	private Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	public String getStudentEmail() {
		return StudentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}
	public long getStudentPhone() {
		return StudentPhone;
	}
	public void setStudentPhone(long studentPhone) {
		StudentPhone = studentPhone;
	}
	public double getStudentFee() {
		return StudentFee;
	}
	public void setStudentFee(double studentFee) {
		StudentFee = studentFee;
	}
	
	
	
	
}
