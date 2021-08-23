package shoesstore.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import shoesstore.dao.CategoryDao;
import shoesstore.dao.ProductDao;
import shoesstore.entities.Category;
import shoesstore.entities.Paging;
import shoesstore.entities.Product;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductDao<Product, Integer> productDao;
	@Autowired
	private CategoryDao<Category, Integer> categoryDao;
	@Autowired
	ServletContext servletContext;

	@GetMapping("list")
	public String ridirectFindAll() {
		return "redirect:list/1";
	}

	@GetMapping("list/{indexPage}")
	public String findAll(@PathVariable("indexPage") int indexPage, Model model) {
		Paging paging = new Paging(indexPage);
		List<Product> products = productDao.findAll(paging);
		model.addAttribute("list", products);
		model.addAttribute("paging", paging);
		System.out.println(paging);
		return "product";
	}

	@GetMapping("add")
	public String formProduct(Model model) {
		model.addAttribute("product", new Product());
		List<Category> categories = categoryDao.findAll(null);
		model.addAttribute("categories", categories);
		return "product/product-form";
	}

	@PostMapping("add")
	public String addNewProduct(@ModelAttribute("product") Product product) {
		MultipartFile file = product.getFile();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
		}
		try {
			product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (product.getCategory().getId() != null) {
			int categoryId = product.getCategory().getId();
			Category category = categoryDao.findById(Category.class, categoryId);
			category.getProducts().add(product);
			product.setCategory(category);
		}
		product.setActiveFlag(1);
		productDao.insert(product);
		return "redirect:list";
	}

}
