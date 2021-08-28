package shoesstore.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shoesstore.dao.ManagerFeedBackDao;
import shoesstore.dao.ProductDao;
import shoesstore.entities.FeedBack;
import shoesstore.entities.Product;
import shoesstore.entities.User;

@Controller
public class ManagerFBContronller {

	@Autowired
	private ProductDao<Product, Integer> productDao;
	
	@Autowired
	private ManagerFeedBackDao<FeedBack, Integer> managerFeedBackDao;
	@RequestMapping("manager-feeback/{id}")
	public String defaullt(@PathVariable("id") int id , Model model) {
		Product product = productDao.findById(Product.class, id);
		Set<FeedBack> lisFeedBacks = product.getFeedBacks();
		model.addAttribute("product", product);
		model.addAttribute("feedbacks", lisFeedBacks);
		for (FeedBack feedBack : lisFeedBacks) {
			System.out.println(feedBack.getUser().getName());
		}
		return "feedback-admin";
	}
	
//	delete 
	@RequestMapping("manager-feeback/delete/{id}")
	public String delete(@PathVariable("id") int id , Model model ) {
		
		FeedBack feedBack = managerFeedBackDao.findById(FeedBack.class, id);
		int idP = feedBack.getProduct().getId();
		managerFeedBackDao.delete(feedBack);
		return "redirect:../../manager-feeback/" + idP;
	}
}
