package shoesstore.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Double sumPrice;
	@Column(nullable = false)
	private int status;
	@Column(nullable = false, length = 100)
	private String address;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "order_details", 
			joinColumns = {@JoinColumn(name = "order_id",referencedColumnName = "id") }, 
			inverseJoinColumns = { @JoinColumn(name = "product_id",referencedColumnName = "id") })
	private Set<Product> products = new HashSet<Product>();

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true, insertable = false, updatable = false)
	private User user;

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(Double sumPrice, int status, String address, Set<Product> products, User user) {
		this.sumPrice = sumPrice;
		this.status = status;
		this.address = address;
		this.products = products;
		this.user = user;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
