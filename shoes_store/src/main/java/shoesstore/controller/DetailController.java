package shoesstore.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.velocity.runtime.directive.Foreach;
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
import shoesstore.entities.OrderDetails;
import shoesstore.entities.Orders;
import shoesstore.entities.Product;
import shoesstore.entities.User;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

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
		List<Product> products = productDao.findByProperty("category.id",product.getCategory().getId());
		model.addAttribute("products", products);
		return "detail";
	}
	
	@PostMapping("post/{id}")
	public String addFeedback(@RequestParam("content") String content ,@PathVariable("id") int id , Model model , HttpSession session ) {
		User user1=  (User) session.getAttribute("customerC");
		if(user1 != null) {
			try {
				User user = userDao.findById(User.class, user1.getId());
				Product product = productDao.findById(Product.class, id);
				//lay ve list order cua customer
				Set<Orders> orders = user.getOrders();
				if(orders.size() >0) {
					for(Orders orders2 : orders) {
						Set<OrderDetails> details = orders2.getOrderDetails();
						if (details.size() >0) {
							for (OrderDetails orders3 : details) {
								Product product1 = orders3.getProduct();
								if(product1.getId() == product.getId()) {
									Date date = new Date();
									FeedBack feedBack = new FeedBack();
									feedBack.setContent(content);
									feedBack.setDate(date);
									feedBack.setUser(user);
									feedBack.setProduct(product);
									feedBackDao.insert(feedBack);
									break;
								}
							}
						}
					}
					
				}
				
			} catch (Exception e) {
				model.addAttribute("erorr", 2);
			}
		}
		   

		return "redirect:../../detail/"+id;
	}
}
