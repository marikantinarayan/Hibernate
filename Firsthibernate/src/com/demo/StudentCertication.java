package com.demo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="studentCertication")
public class StudentCertication {
 
	private int Certification_id;
	 private String Certification_name;
	 
	public int getCertification_id() {
		return Certification_id;
	}
	public void setCertification_id(int certification_id) {
		Certification_id = certification_id;
	}
	public String getCertification_name() {
		return Certification_name;
	}
	public void setCertification_name(String certification_name) {
		Certification_name = certification_name;
	}
	 
	
}
