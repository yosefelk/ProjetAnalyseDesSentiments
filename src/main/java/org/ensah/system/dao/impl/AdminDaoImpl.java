package org.ensah.system.dao.impl;

import org.ensah.system.beans.Admin;
import org.ensah.system.beans.Post;
import org.ensah.system.beans.User;
import org.ensah.system.dao.AdminDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}
	
	@Override
	public void removeUser(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User u =null;
		try {
			 u =(User) session.get(User.class, id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		if(u!=null){
			try {
				session.delete(u);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
		
	}
	
	
	@Override
	public void removePost(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Post p =null;
		try {
			 p =(Post) session.get(Post.class, id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		if(p!=null){
			try {
				session.delete(p);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
		
	}
	public Admin loginAdmin(Admin admin) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from org.ensah.system.beans.Admin as a where a.a_email =? and a.a_password =?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, admin.getA_email());
			query.setParameter(1, admin.getA_password());
			admin = (Admin) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return admin;
	

}
}
