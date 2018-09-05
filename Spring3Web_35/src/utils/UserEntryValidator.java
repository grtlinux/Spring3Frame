package utils;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import logic.User;

public class UserEntryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) command;

		if (!StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required");
		}

		if (!StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required");
		}

		if (!StringUtils.hasLength(user.getUserName())) {
			errors.rejectValue("userName", "error.required");
		}

		if (!StringUtils.hasText(user.getPostCode())) {
			errors.rejectValue("postCode", "error.required");
		}

		if (!StringUtils.hasText(user.getAddress())) {
			errors.rejectValue("address", "error.required");
		}

		if (!StringUtils.hasText(user.getEmail())) {
			errors.rejectValue("email", "error.required");
		}

		if (errors.hasErrors()) {
			// 오류가 있으면 메세지 입력 오류 메세지를 추가
			errors.reject("error.input.user");
		}
	}

}
