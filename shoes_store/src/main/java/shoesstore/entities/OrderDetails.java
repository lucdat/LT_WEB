package shoesstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false)
	private int size;
	@Column(nullable = false,length = 30)
	private String color;
	
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id",nullable = true)
	private Product product;
	@ManyToOne
	@JoinColumn(name = "order_id",referencedColumnName = "id",nullable = true)
	private Orders order;
	
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(int quantity, Product product, Orders order) {
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	public Double getTotalPrice() {
		return this.getProduct().getPrice()*(1- this.getProduct().getSale()) * this.getQuantity();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
