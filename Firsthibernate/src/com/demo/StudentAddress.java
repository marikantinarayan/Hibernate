package com.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="studentAdress")
public class StudentAddress {
	@Id
	@GeneratedValue
	private int address_id ;
	private String address_name;
	private Set <Student_info>student=new HashSet<Student_info>();
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "StudentAddress")
	public Set<Student_info> getStudent() {
		return student;
	}
	public void setStudent(Set<Student_info> student) {
		this.student = student;
	}
	
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	

}
