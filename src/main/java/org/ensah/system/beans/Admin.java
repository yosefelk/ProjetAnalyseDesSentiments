package org.ensah.system.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table  // no need to mention table name by default it takes class name
public class Admin {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)// it will generate unique Id automatically
	private int a_id;
	
	@NotEmpty
	@Column
	private String a_name;
	

	
	@NotEmpty
	@Column
	private String a_email;
	
	@NotEmpty
	@Column
	private String a_password;

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_email() {
		return a_email;
	}

	public void setA_email(String a_email) {
		this.a_email = a_email;
	}

	public String getA_password() {
		return a_password;
	}

	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	
	
	
}