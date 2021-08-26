package shoesstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shoesstore.dao.CategoryDao;
import shoesstore.entities.Category;
import shoesstore.entities.Paging;

@Controller
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryDao<Category, Integer> categoryDao;
	
	@GetMapping
	public String dafault() {
		return "redirect:list/1";
	}
	@GetMapping("list/{indexPage}")
	public String findAll(@PathVariable("indexPage") int indexPage, Model model) {
		Paging paging = new Paging(indexPage);
		List<Category> categories = categoryDao.findAll(paging);
		model.addAttribute("listCategory", categories);
		model.addAttribute("paging", paging);
		System.out.println(paging);
		return "category-list";
	}
	@GetMapping("add")
	public String showFormAddCategory(Model model) {
		model.addAttribute("url", "add");
		return "category-form";
	}
	@PostMapping("add")
	public String addNewCategory(@RequestParam("name") String nameCategory) {
		
		try {
			Category category = new Category(nameCategory,1);
			categoryDao.insert(category);
		} catch (Exception e) {
			return "category-form";
		}
		return "redirect:list/1";
		
	}
	
	@GetMapping("edit/{id}")
	public String showFormEditCategory(@PathVariable("id") int id , Model model) {
		Category category = categoryDao.findById(Category.class, id);
		model.addAttribute("nameEdit", category.getName());
		model.addAttribute("url", "../edit/"+category.getId());
		return "category-form";
	}
	@PostMapping("edit/{id}")
	public String editCategory(@RequestParam("name") String nameCategory , @PathVariable("id") int id) {
		Category category = categoryDao.findById(Category.class, id);
		category.setName(nameCategory);
		categoryDao.update(category);
		return "redirect:../list/1";
		
	}
	
	@GetMapping("delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		Category category = categoryDao.findById(Category.class, id);
		categoryDao.delete(category);
		return "redirect:../list/1";
	}

}
