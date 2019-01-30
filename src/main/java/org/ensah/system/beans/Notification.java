package org.ensah.system.beans;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table  // no need to mention table name by default it takes class name
public class Notification {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)// it will generate unique Id automatically
	private int n_id;
	
	@Column
	private int n_user;
	
	@Column
	private int n_post;
	
	@Column
	private String n_text;
	
	@Column
	private Date n_date;
	
	@Column
	private boolean n_situation;
	
	//setters and getters
	public int getN_id() {
		return n_id;
	}
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	public int getN_user() {
		return n_user;
	}
	public void setN_user(int user) {
		this.n_user = user;
	}
	public int getN_post() {
		return n_post;
	}
	public void setN_post(int post) {
		this.n_post = post;
	}
	public String getN_text() {
		return n_text;
	}
	public void setN_text(String txt) {
		this.n_text = txt;
	}
	public Date getN_date() {
		return n_date;
	}
	public void setN_date(Date d) {
		this.n_date = d;
	}

	public boolean getN_situation() {
		return n_situation;
	}
	public void setN_situation(boolean situation) {
		this.n_situation = situation;
	}
}