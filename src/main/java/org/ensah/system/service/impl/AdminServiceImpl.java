
package org.ensah.system.service.impl;

import org.ensah.system.beans.Admin;
import org.ensah.system.dao.AdminDao;
import org.ensah.system.service.AdminService;

public class AdminServiceImpl implements AdminService {

	
	private AdminDao adminDao ;
	
	
	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		adminDao.removeUser(id);
		
	}

	@Override
	public void removePost(int id) {
		// TODO Auto-generated method stub
		adminDao.removePost(id);
		
	}

	public void setAdminDao(AdminDao admindao) {
		this.adminDao = admindao;
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.loginAdmin(admin);
	}
	

}
