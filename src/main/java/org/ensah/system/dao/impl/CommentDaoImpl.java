package org.ensah.system.dao.impl;

import java.util.List;

import org.ensah.system.beans.Comment;
import org.ensah.system.dao.CommentDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentDaoImpl implements CommentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	public void saveComment(Comment comment) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(comment!=null){
			try {
				session.save(comment);
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
	public List<Comment> getAllComments(int postId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query q =session.createQuery("from Comment where c_post=:id order by c_date DESC");
			q.setParameter("id", postId);
			List<Comment> lc =(List<Comment>) q.list();
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
