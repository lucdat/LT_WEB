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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true,nullable = false,length = 15)
	private String code;
	@Column(nullable = false,length = 50)
	private String name;
	@Column(nullable = false)
	private float sale;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private int quantity;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	@Column(nullable = false,length = 100)
	private String description;
	@Column(nullable = false)
	private int activeFlag;
	
	@Transient
	private MultipartFile file;
	
	@ManyToOne()
	@JoinColumn(name = "cate_id",referencedColumnName = "id",nullable = true)
	private Category category;
	
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Invoice> invoices = new  HashSet<Invoice>();
	
	@ManyToMany(mappedBy = "products", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Orders> orders = new HashSet<Orders>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<FeedBack> feedBacks = new HashSet<FeedBack>();
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String code, String name, float sale, Double price, int quantity, String image, String description,
			int activeFlag, MultipartFile file, Category category, Set<Invoice> invoices, Set<Orders> orders,
			Set<FeedBack> feedBacks) {
		this.code = code;
		this.name = name;
		this.sale = sale;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.activeFlag = activeFlag;
		this.file = file;
		this.category = category;
		this.invoices = invoices;
		this.orders = orders;
		this.feedBacks = feedBacks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSale() {
		return sale;
	}

	public void setSale(float sale) {
		this.sale = sale;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	public Set<FeedBack> getFeedBacks() {
		return feedBacks;
	}

	public void setFeedBacks(Set<FeedBack> feedBacks) {
		this.feedBacks = feedBacks;
	}	
}
