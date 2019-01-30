package org.ensah.system.dao.impl;

import java.util.List;

import org.ensah.system.beans.Post;
import org.ensah.system.dao.PostDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class PostDaoImpl implements PostDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	public void savePost(Post post) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(post!=null){
			try {
				session.save(post);
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
	public List<Post> getAllPosts(int userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			List<Post> lp;
			if(userId==-1) lp=(List<Post>) session.createQuery("from Post order by p_date DESC").list();
			else{
				Query q =session.createQuery("from Post where p_user=:id order by p_date DESC");
				q.setParameter("id", userId);
				lp =(List<Post>) q.list();
			}
			tx.commit();
			session.close();
			return lp;
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return null;
	}

	public Post getPost(int postId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Post p =(Post) session.get(Post.class, postId);;
			tx.commit();
			session.close();
			return p;
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return null;
	}
	
	public void setPostPolarity(int p_id, int newPolarity) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
			try {
				Post post = (Post) session.get(Post.class, p_id);
				if(post!=null){
					post.setP_polarity(newPolarity);
					session.update(post);
				}
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
	}

}
