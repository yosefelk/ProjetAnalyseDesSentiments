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
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)// it will generate unique Id automatically
	private int u_id;
	
	@NotEmpty
	@Column
	private String u_name;
	
	@NotEmpty
	@Column
	private String u_mobile;
	
	@NotEmpty
	@Column
	private String u_gender;
	
	@NotEmpty
	@Column
	private String u_email;
	
	@NotEmpty
	@Column
	private String u_password;
	
	@Column
	private byte[] u_image;

	@Column
	private String base64Encoded;
	
	//setters and getters
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_mobile() {
		return u_mobile;
	}
	public void setU_mobile(String u_mobile) {
		this.u_mobile = u_mobile;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	
    public byte[] getU_image() {
        return u_image;
    }
    public void setU_image(byte[] data) {
        this.u_image = data;
    }
    public String getBase64image() {
		return this.base64Encoded;
	}
	public void setBase64image(String base64Encoded) {
		this.base64Encoded = base64Encoded;
	}
}