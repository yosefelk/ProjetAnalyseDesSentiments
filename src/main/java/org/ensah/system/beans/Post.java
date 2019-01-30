package org.ensah.system.beans;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table  // no need to mention table name by default it takes class name
public class Post {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)// it will generate unique Id automatically
	private int p_id;
	
	@Column
	private int p_user;
	
	@NotEmpty
	@Column
	private String p_text;
	
	@Column
	private Date p_date;
	
	@Column
	private int p_place;
	
	@Column
	private int p_polarity;
	
	@Column
	private byte[] p_image;

	@Column
	private String base64Encoded;
	
	//setters and getters
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getP_user() {
		return p_user;
	}
	public void setP_user(int user) {
		this.p_user = user;
	}
	public String getP_text() {
		return p_text;
	}
	public void setP_text(String txt) {
		this.p_text = txt;
	}
	public Date getP_date() {
		return p_date;
	}
	public void setP_date(Date date) {
		this.p_date = date;
	}

	public int getP_place() {
		return p_place;
	}
	public void setP_place(int place) {
		this.p_place = place;
	}
	
	public int getP_polarity() {
		return p_polarity;
	}
	public void setP_polarity(int d) {
		this.p_polarity = d;
	}
	
    public byte[] getP_image() {
        return p_image;
    }
    public void setP_image(byte[] data) {
        this.p_image = data;
    }
    public String getBase64image() {
		return this.base64Encoded;
	}
	public void setBase64image(String base64Encoded) {
		this.base64Encoded = base64Encoded;
	}
}