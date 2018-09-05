package utils;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserEntryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object command, Errors errors) {
		// TODO Auto-generated method stub

	}

}
