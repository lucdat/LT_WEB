package shoesstore.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shoesstore.dao.CategoryDao;
import shoesstore.dao.ProductDao;
import shoesstore.entities.Category;
import shoesstore.entities.Import;
import shoesstore.entities.Paging;
import shoesstore.entities.Product;

@Controller
@RequestMapping("shop")
public class ShopController {

	@Autowired
	private ProductDao<Product, Integer> productDao;
	@Autowired
	private CategoryDao<Category, Integer> categoryDao;
	@GetMapping
	public String defaultShop( Model model) {
		//lay ve 10 sp
		List<Category> listCategories = categoryDao.findAll();
		model.addAttribute("categories", listCategories);
		Paging paging = new Paging(1);
		List<Product> products = productDao.findAll(paging);
		model.addAttribute("list", products);
		model.addAttribute("paging", paging);
		//set de cho no ra ben ngoai
		return "shop";
	}
	@GetMapping("list/{indexPage}")
	public String findAll(@PathVariable("indexPage") int indexPage, Model model) {
		List<Category> listCategories = categoryDao.findAll();
		model.addAttribute("categories", listCategories);
		Paging paging = new Paging(indexPage);
		List<Product> products = productDao.findAll(paging);
		model.addAttribute("list", products);
		model.addAttribute("paging", paging);
		return "shop";
	}
	//load product folow by category id
	@GetMapping("/{id}")
	public String productByCategory(@PathVariable("id") int  id , Model model) {
		System.out.println(id);
		Category category= categoryDao.findById(Category.class, id);
		Set<Product> products = category.getProducts();
		List<Category> listCategories = categoryDao.findAll();
		model.addAttribute("categories", listCategories);
		Paging paging = new Paging(1);
		paging.setTotalPages(1);
		model.addAttribute("list", products);
		model.addAttribute("id", id);
		return "shop";
	}
}
