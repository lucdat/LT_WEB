package shoesstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shoesstore.dao.ProductDao;
import shoesstore.entities.Paging;
import shoesstore.entities.Product;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductDao<Product, Integer> productDao;

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
		return "product/product-list";
	}

}
