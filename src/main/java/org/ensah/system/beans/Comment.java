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
public class Comment {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)// it will generate unique Id automatically
	private int c_id;
	
	@Column
	private int c_user;
	
	@Column
	private int c_post;
	
	@Column
	private String c_text;
	
	@Column
	private Date c_date;
	
	@Column
	private double c_rating;
	
	//setters and getters
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getC_user() {
		return c_user;
	}
	public void setC_user(int user) {
		this.c_user = user;
	}
	public int getC_post() {
		return c_post;
	}
	public void setC_post(int post) {
		this.c_post = post;
	}
	public String getC_text() {
		return c_text;
	}
	public void setC_text(String txt) {
		this.c_text = txt;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date d) {
		this.c_date = d;
	}

	public double getC_rating() {
		return c_rating;
	}
	public void setC_rating(double d) {
		this.c_rating = d;
	}
}