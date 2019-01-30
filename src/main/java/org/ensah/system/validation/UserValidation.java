package org.ensah.system.validation;

import org.ensah.system.beans.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidation implements Validator{
	
	public boolean supports(Class<?> arg0) {

		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

	

}
