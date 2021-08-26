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
@RequestMapping("shop")
public class ShopController {

	@Autowired
	private ProductDao<Product, Integer> productDao;
	@GetMapping
	public String defaultShop( Model model) {
		//lay ve 10 sp
		Paging paging = new Paging(1);
		List<Product> products = productDao.findAll(paging);
		model.addAttribute("list", products);
		model.addAttribute("paging", paging);
		//set de cho no ra ben ngoai
		return "shop";
	}
	@GetMapping("list/{indexPage}")
	public String findAll(@PathVariable("indexPage") int indexPage, Model model) {
		Paging paging = new Paging(indexPage);
		List<Product> products = productDao.findAll(paging);
		model.addAttribute("list", products);
		model.addAttribute("paging", paging);
		return "shop";
	}
	
}
