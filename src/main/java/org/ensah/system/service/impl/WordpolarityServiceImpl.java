package org.ensah.system.service.impl;

import org.ensah.system.beans.Wordpolarity;
import org.ensah.system.dao.WordpolarityDao;
import org.ensah.system.service.WordpolarityService;

public class WordpolarityServiceImpl implements WordpolarityService {
	
	private WordpolarityDao wordpolarityDao;

	public void setWordpolarityDao(WordpolarityDao wordpolarityDao) {
		this.wordpolarityDao = wordpolarityDao;
	}
	
	public double getTextPolarity(String tokens) {
		return wordpolarityDao.getTextPolarity(tokens);
	}

	public void addWord(Wordpolarity word) {
		wordpolarityDao.addWord(word);
	}

}
