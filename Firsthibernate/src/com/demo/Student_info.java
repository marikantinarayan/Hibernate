package com.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;



@Entity
@Table(name="STUDENT_INFORMATION")
public class Student_info {
	@Id 
	@GeneratedValue
	private int rollNo;
	//@Transient//complt value are not showing on table 
	@Column(name="fullName", nullable=false)
	private String Name ;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
	private StudentDetails studentdetails;

	
	public StudentDetails getStudentdetails() {
		return studentdetails;
	}
	public void setStudentdetails(StudentDetails studentdetails) {
		this.studentdetails = studentdetails;
	}
	//studentAddress class 
	@ManyToOne(cascade = CascadeType.ALL)
	private StudentAddress studentaddress;
	
	public StudentAddress getStudentaddress() {
		return studentaddress;
	}
	public void setStudentaddress(StudentAddress studentaddress) {
		this.studentaddress = studentaddress;
	}
	//studentCertification
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<StudentCertication>student=new HashSet<StudentCertication>();
	
	public Set<StudentCertication> getStudent() {
		return student;
	}
	public void setStudent(Set<StudentCertication> student) {
		this.student = student;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	

}
