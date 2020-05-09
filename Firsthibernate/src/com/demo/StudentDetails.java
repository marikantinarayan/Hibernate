package com.demo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity 
@Table(name="studentDteails")
public class StudentDetails {
	@Id
	@GeneratedValue(generator ="NewGenerator")
	@GenericGenerator(name="NewGenerator",strategy = "foreign",parameters = {@Parameter(value="Student_info",name="property")})
	private int student_id;
	private String student_mobile_number;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rollNo")
	private Student_info student;
	
	public Student_info getStudent() {
		return student;
	}
	
	public void setStudent(Student_info student) {
		this.student = student;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_mobile_number() {
		return student_mobile_number;
	}
	public void setStudent_mobile_number(String student_mobile_number) {
		this.student_mobile_number = student_mobile_number;
	}
	

}
