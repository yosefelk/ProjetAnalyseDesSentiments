package org.ensah.system.dao;

import org.ensah.system.beans.Wordpolarity;

public interface WordpolarityDao {

	public double getTextPolarity(String tokens);

	public void addWord(Wordpolarity word);

}
