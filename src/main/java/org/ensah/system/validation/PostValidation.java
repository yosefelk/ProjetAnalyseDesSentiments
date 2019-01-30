package org.ensah.system.validation;

import org.ensah.system.beans.Post;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PostValidation implements Validator{
	
	public boolean supports(Class<?> arg0) {

		return Post.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

	

}
