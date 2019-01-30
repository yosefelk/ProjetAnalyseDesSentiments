package org.ensah.system.validation;

import org.ensah.system.beans.Comment;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CommentValidation implements Validator{
	
	public boolean supports(Class<?> arg0) {

		return Comment.class.equals(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

	

}
