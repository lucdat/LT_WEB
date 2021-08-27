package shoesstore.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import shoesstore.entities.OrderDetails;
import shoesstore.entities.Product;

@SessionScope
@Service
public class CardService {
	@Autowired
	private ProductService<Product, Integer> productService;
	Map<Integer, OrderDetails> map = new HashMap<Integer,OrderDetails>();
	
	public void add(Integer id,int size,String color) {
		OrderDetails details = map.get(id);
		if(details==null) {
			details = new OrderDetails();
			Product p = productService.findById(Product.class, id);
			details.setColor(color);
			details.setSize(size);
			details.setProduct(p);
			details.setQuantity(1);
			map.put(id, details);
		}else {
			details.setQuantity(details.getQuantity()+1);
			map.put(id, details);
		}
	}
	public void add(Integer id,int size,String color,int qty) {
		OrderDetails details = map.get(id);
		if(details==null) {
			details = new OrderDetails();
			Product p = productService.findById(Product.class, id);
			details.setColor(color);
			details.setSize(size);
			details.setProduct(p);
			details.setQuantity(qty);
			map.put(id, details);
		}else {
			details.setQuantity(details.getQuantity()+1);
			map.put(id, details);
		}
	}
	public void remove(Integer id) {
		map.remove(id);
	}
	
	public void update(Integer id,int qty) {
		OrderDetails orderDetails= map.get(id);
		orderDetails.setQuantity(qty);
		map.remove(id);
		map.put(id, orderDetails);
	}
	
	public void clear() {
		map.clear();
	}
	public int getCount() {
		Collection<OrderDetails> details = this.getItems();
		int count =0;
		for(OrderDetails detail:details) {
			count+=detail.getQuantity();
		}
		return count;
	}
	public double getAmount() {
		Collection<OrderDetails> details = this.getItems();
		double amount =0;
		for(OrderDetails detail:details) {
			amount+=(double)(detail.getQuantity()
					*detail.getProduct().getPrice()*(double)(1-detail.getProduct().getSale()));
		}
		return amount;
	}
	public Collection<OrderDetails> getItems(){
		return map.values();
	}
}
