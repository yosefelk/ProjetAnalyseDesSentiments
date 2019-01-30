package org.ensah.system.service;

import org.ensah.system.beans.Admin;

public interface AdminService {
	
	public void removeUser(int id);
	public void removePost(int id);
	public Admin loginAdmin(Admin admin);

}
