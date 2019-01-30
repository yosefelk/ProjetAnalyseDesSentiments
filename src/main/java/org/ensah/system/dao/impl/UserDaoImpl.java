package org.ensah.system.dao.impl;

import java.util.List;

import org.ensah.system.beans.User;
import org.ensah.system.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(user!=null){
			try {
				session.save(user);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}

	}

	public User loginUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from org.ensah.system.beans.User as u where u.u_email =? and u.u_password =?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getU_email());
			query.setParameter(1, user.getU_password());
			user = (User) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return user;
		
	}

	public User getUser(int userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			User u =(User) session.get(User.class, userId);
			tx.commit();
			session.close();
			return u;
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> users = null ;
		try {
			users=(List<User>) session.createQuery("from User order by u_id").list();
			tx.commit();
			session.close();
			return users;
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return null;
		
	}

}
