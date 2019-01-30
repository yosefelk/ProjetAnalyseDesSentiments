package org.ensah.system.dao.impl;

import java.util.List;

import org.ensah.system.beans.Wordpolarity;
import org.ensah.system.dao.WordpolarityDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;

public class WordpolarityDaoImpl implements WordpolarityDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	@SuppressWarnings("unchecked")
	public List<Wordpolarity> getAllWords() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			return session.createCriteria(Wordpolarity.class).list();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return null;
	}

	public double getTextPolarity(String ptext) {
		String[] tokens = ptext.split(" ");

		if (tokens.length == 0) {
			return 0;
		}

		double moy = 0.0;

		for (String it : tokens) {
			moy += getWordPolarity(it);
		}
		
		return (double) (moy / tokens.length);
	}

	public void addWord(Wordpolarity word) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(word!=null){
			try {
				session.save(word);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
	}

	private double getWordPolarity(String pWord) {

		List<Wordpolarity> words = getAllWords();

		for (Wordpolarity it : words) {

			if (it.getW_text().equals(pWord)) {
				System.out.println(pWord);
				return it.getW_polarity();
			}
		}

		return 0;
	}
	
}
