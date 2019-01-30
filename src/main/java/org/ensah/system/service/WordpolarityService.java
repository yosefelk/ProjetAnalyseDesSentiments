package org.ensah.system.service;

import org.ensah.system.beans.Wordpolarity;

public interface WordpolarityService {
	
	public double getTextPolarity(String tokens);
	
	public void addWord(Wordpolarity word);


}
