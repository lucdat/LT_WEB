package shoesstore.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Double sumPrice;
	@Column(nullable = false)
	private int status;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();
	
	@ManyToOne
	@JoinColumn(name = "customer_id",insertable = false,updatable = false)
	private Customer customer;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(Double sumPrice, int status, Set<OrderDetails> orderDetails, Customer customer) {
		this.sumPrice = sumPrice;
		this.status = status;
		this.orderDetails = orderDetails;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
