package shoesstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shoesstore.entities.OrderDetails;
import shoesstore.entities.Orders;
import shoesstore.entities.Product;
import shoesstore.entities.User;
import shoesstore.service.CardService;
import shoesstore.service.OrderDetailService;
import shoesstore.service.OrderService;
import shoesstore.service.ProductService;
import shoesstore.service.UserService;

@Controller
@RequestMapping("card")
public class OrderController {
	
	@Autowired
	private CardService card;
	@Autowired
	private UserService<User, Integer> userService;
	@Autowired
	private OrderService<Orders, Integer> orderService;
	@Autowired
	private OrderDetailService<OrderDetails, Integer> orderDetailService;
	@Autowired
	private ProductService<Product, Integer> productService;
	@Autowired
	private MailSender mailSender;
	
	@RequestMapping(value="add/{id}/size/{size}/color/{color}",method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Object add(@PathVariable("id") Integer id,
					  @PathVariable("size") int size,
			          @PathVariable("color") String color) {
		card.add(id,size,color);
		Object[] info = {card.getCount(),card.getAmount()};
		return info;
	}
	@RequestMapping(value="add/{id}/size/{size}/color/{color}/quantity/{qty}",method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Object adds(@PathVariable("id") Integer id,
					  @PathVariable("size") int size,
			          @PathVariable("color") String color,
			          @PathVariable("qty") int qty) {
		card.add(id,size,color,qty);
		Object[] info = {card.getCount(),card.getAmount()};
		return info;
	}
	@RequestMapping(value="update/{id}/quantity/{qty}",method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Object update(@PathVariable("id") Integer id,
			             @PathVariable("qty") int qty) {
		card.update(id,qty);
		Object[] info = {card.getCount(),card.getAmount()};
		return info;
	}
	
	@RequestMapping(value="remove/{id}",method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Object remove(@PathVariable("id") Integer id) {
		card.remove(id);
		Object[] info = {card.getCount(),card.getAmount()};
		return info;
	}
	
	@GetMapping("checkout")
	public String checkoutForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("url", "../card/checkout");
		return "checkout-form";
	}
	
	@RequestMapping(value="checkout",method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Object checkout(@ModelAttribute("user") User user,@RequestParam("address")String address) {
		userService.insert(user);
		Orders order = new Orders();
		order.setAddress(address);
		order.setStatus(0);
		order.setUser(user);
		order.setSumPrice(card.getAmount());
		orderService.insert(order);
		user.getOrders().add(order);
		userService.update(user);
		for(OrderDetails detail:card.getItems()) {
			order.getOrderDetails().add(detail);
			detail.setOrder(order);
			detail.getProduct().getOrderDetails().add(detail);
			orderDetailService.insert(detail);
			productService.update(detail.getProduct());
			orderService.update(order);
		}
		Object info = "Please check your mail!";
		SimpleMailMessage message = new SimpleMailMessage();
	    message.setFrom("shoesstore@gmail.com");
	    message.setTo(user.getEmail());
	    message.setSubject("Your order code"+order.getId());
	    message.setText("Your order will be sent soon!");
	    // sending message
	    mailSender.send(message);
		return info;
	}
}
