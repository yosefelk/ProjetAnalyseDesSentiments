package org.ensah.system.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table  // no need to mention table name by default it takes class name
public class Wordpolarity {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)// it will generate unique Id automatically
	private int w_id;
	
	@Column
	private String w_text;
	
	@Column
	private double w_polarity;
	
	//setters and getters
	public int getW_id() {
		return w_id;
	}
	public void setW_id(int w_id) {
		this.w_id = w_id;
	}
	public String getW_text() {
		return w_text;
	}
	public void setW_text(String txt) {
		this.w_text = txt;
	}
	public double getW_polarity() {
		return w_polarity;
	}
	public void setW_polarity(double rating) {
		this.w_polarity = rating;
	}
}