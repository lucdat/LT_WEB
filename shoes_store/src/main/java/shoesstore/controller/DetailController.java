package shoesstore.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shoesstore.dao.ManagerFeedBackDao;
import shoesstore.dao.ProductDao;
import shoesstore.dao.UserDao;
import shoesstore.entities.FeedBack;
import shoesstore.entities.Import;
import shoesstore.entities.Product;
import shoesstore.entities.User;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequestMapping("detail")
public class DetailController {

	@Autowired
	private ManagerFeedBackDao<FeedBack, Integer> feedBackDao;
	@Autowired
	private UserDao<User, Integer> userDao;
	@Autowired
	private ProductDao<Product, Integer> productDao;
	
	@GetMapping("/{id}")
	public String defaultFeedback(@PathVariable("id") int id , Model model) {
		Product product = productDao.findById(Product.class, id);
		Set<FeedBack> lisFeedBacks = product.getFeedBacks();
		model.addAttribute("product", product);
		model.addAttribute("feedbacks", lisFeedBacks);
		return "detail";
	}
	
	@PostMapping("post/{id}")
	public String addFeedback(@RequestParam("content") String content ,@PathVariable("id") int id , Model model ) {
		 Date date = new Date();  
		try {
			User user = userDao.findById(User.class, 7);
			Product product = productDao.findById(Product.class, id);
			FeedBack feedBack = new FeedBack();
			feedBack.setContent(content);
			feedBack.setDate(date);
			feedBack.setUser(user);
			feedBack.setProduct(product);
			feedBackDao.insert(feedBack);
		} catch (Exception e) {
			System.out.println("loi roi ");
			model.addAttribute("ERROR", 1);
		}
		return "redirect:../../detail/"+id;
	}
}
