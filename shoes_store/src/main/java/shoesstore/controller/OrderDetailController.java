package shoesstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import shoesstore.entities.OrderDetails;
import shoesstore.entities.Orders;
import shoesstore.entities.Paging;
import shoesstore.service.OrderDetailService;
import shoesstore.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderDetailController {
	@Autowired
	private OrderService<Orders, Integer> orderService;
	@Autowired
	private OrderDetailService<OrderDetails, Integer> detailService;
	
	@GetMapping("list")
	public String redirectOrderList() {
		return "redirect:/order/list/1";
	}

	@GetMapping("list/{indexPage}")
	public String findAll(@PathVariable("indexPage") int indexPage, Model model) {
		Paging paging = new Paging(indexPage);
		List<Orders> orders = orderService.findAll(paging);
		model.addAttribute("orders", orders);
		model.addAttribute("paging", paging);
		return "order-list";
	}
	@RequestMapping(value="status/{id}",method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Object update(@PathVariable("id")Integer id ) {
		Orders orders = orderService.findById(Orders.class, id);
		orders.setStatus(1);
		orderService.update(orders);
		Object info = 1;
		return info;
	}
	@RequestMapping(value="delete/{id}",method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Object remoce(@PathVariable("id")Integer id ) {
		Orders orders = orderService.findById(Orders.class, id);
		for(OrderDetails detail : orders.getOrderDetails()) {
			detailService.delete(detail);
		}
		orders.getUser().getOrders().remove(orders);
		orderService.delete(orders);
		return "delete susscess!";
	}

}
