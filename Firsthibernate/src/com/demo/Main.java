package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//import org.hibernate.cfg.AnnotationConfiguration;


public class Main {
	
	public static void main(String[] args)  throws Exception
	{
		Student_info student= new Student_info();
		student.setName("Narayana");
		
	//	student.setRollNo(1);//primary key 
		
		//student details class :
		StudentDetails sd=new StudentDetails();
		sd.setStudent_mobile_number("9123XXXXXXX");
		sd.setStudent(student);
		student.setStudentdetails(sd);
		//student address obj  
		StudentAddress studentaddress=new StudentAddress();
		studentaddress.setAddress_name("hyderbad , india");
		
		Student_info student1=new Student_info();
		student1.setName("Abcd");
		student1.setStudentaddress(studentaddress);
		

		Student_info student2=new Student_info();
		student2.setName("NNNNNNN");
		student2.setStudentaddress(studentaddress);
		
		//student address of Collection set property
		(studentaddress.getStudent()).add(student1);
		(studentaddress.getStudent()).add(student2);
		//StudentCertication object
		StudentCertication Studentcertication=new StudentCertication();
		Studentcertication.setCertification_name("Core Java Certication Exam");
		StudentCertication Studentcertication1=new StudentCertication();
		Studentcertication1.setCertification_name("MySql Certication Exam");
		
		Student_info student3=new Student_info();
		student3.setName("Ramesh");
		(student3.getStudent()).add(Studentcertication);
		
		Student_info student4=new Student_info();
		student4.setName("Naresh");
		(student3.getStudent()).add(Studentcertication1);
		
		
		//configuration setting :
	Configuration con=new Configuration().configure().addAnnotatedClass(Student_info.class);
		
	SessionFactory sessionfactory =con.buildSessionFactory();
	Session session =sessionfactory.openSession();
	session.beginTransaction();
	//session.save(student);
	session.save(student); 
	//curd operation get ,save ,edit ,delete
	student=(Student_info) session.get(Student_info.class, 1);
	System.out.println("Student Object havig student name as "+student.getName());
	//update record 
	student.setName("ravi");
	
	//student address:
	session.save(student1);
	session.save(student2);
	//student address save records :
	session.save(studentaddress);
	//StudentCertication save records 
	session.save(student3);
	session.save(student4);
	session.getTransaction().commit();
	session.close();
	sessionfactory.close();
	}

}
