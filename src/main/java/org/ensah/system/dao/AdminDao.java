package org.ensah.system.dao;

import org.ensah.system.beans.Admin;

public interface AdminDao {
	
	
	public void removeUser(int id);
	
	public void removePost(int id);

	public Admin loginAdmin(Admin admin);
	

}
