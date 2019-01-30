package org.ensah.system.validation;

import org.ensah.system.beans.Wordpolarity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class WordpolarityValidation implements Validator{
	
	public boolean supports(Class<?> arg0) {

		return Wordpolarity.class.equals(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		
	}

	

}
