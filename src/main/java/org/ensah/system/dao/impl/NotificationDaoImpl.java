package org.ensah.system.dao.impl;

import java.util.List;

import org.ensah.system.beans.Notification;
import org.ensah.system.dao.NotificationDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificationDaoImpl implements NotificationDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	public void saveNotification(Notification notification) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(notification!=null){
			try {
				session.save(notification);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public List<Notification> getAllNotifications(int userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query q =session.createQuery("from notification where n_user=:id order by n_date DESC");
			q.setParameter("id", userId);
			List<Notification> lc =(List<Notification>) q.list();
			tx.commit();
			session.close();
			return lc;
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return null;
	}

}
