package shoesstore.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shoesstore.entities.User;
import shoesstore.service.UserService;

@Component
public class UserValidate implements Validator {

	@Autowired
	private UserService<User, Integer> userService;
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		ValidationUtils.rejectIfEmpty(errors, "name", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "phone", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "password", "msg.required");
//		if(user!=null) {
//			if(!user.getEmail().matches("^(.+)@(\\S+)$")) {
//				errors.reject("email","msg.wrong.email.format");
//			}else {
//				List<User> emailExit = userService.findByProperty("email", user.getEmail());
//				if(emailExit!=null && !emailExit.isEmpty()) {
//					errors.reject("email","msg.email.exit");
//				}
//			}
//			
//			if(!user.getPhone().matches("//d{10}")){
//				errors.reject("phone","msg.wrong.phone.format");
//			}else {
//				List<User> phoneExist = userService.findByProperty("phone", user.getPhone());
//				if(phoneExist!=null && !phoneExist.isEmpty()) {
//					errors.reject("phone","msg.phone.exit");
//				}
//			}
//		}
	}

}
