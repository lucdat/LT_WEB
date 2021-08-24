package shoesstore.validator;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shoesstore.dao.ProductDao;
import shoesstore.entities.Product;

@Component
public class ProductValidator implements Validator {

	@Autowired
	private ProductDao<Product, Integer> productDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == Product.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		ValidationUtils.rejectIfEmpty(errors, "code", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "name", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "sale", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "price", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "quantity", "msg.required");

		List<Product> codeExist = productDao.findByProperty("code", product.getCode());
		if (codeExist != null && !codeExist.isEmpty()) {
			if (codeExist.listIterator().next().getCode().equals(product.getCode())) {
				errors.rejectValue("code", "msg.code.exist");
			}
		}
	}

}
