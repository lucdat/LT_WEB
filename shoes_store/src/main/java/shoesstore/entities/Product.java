package shoesstore.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	@Column(nullable = true)
	private float sale;
	@Column(nullable = true)
	private Double price;
	@Column(nullable = true)
	private int quantity;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	@Column(nullable = true,length = 100)
	private String description;
	
	@Transient
	private MultipartFile file;
	
	@ManyToOne()
	@JoinColumn(name = "cate_id",referencedColumnName = "id",nullable = true)
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Import> imports = new  HashSet<Import>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<FeedBack> feedBacks = new HashSet<FeedBack>();
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	
	public Product(String code, String name, float sale, Double price, int quantity, String image, String description,
			MultipartFile file, Category category, Set<Import> imports, Set<OrderDetails> orderDetails,
			Set<FeedBack> feedBacks) {
		this.code = code;
		this.name = name;
		this.sale = sale;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.file = file;
		this.category = category;
		this.imports = imports;
		this.orderDetails = orderDetails;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Set<Import> getImports() {
		return imports;
	}


	public void setImports(Set<Import> imports) {
		this.imports = imports;
	}


	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Set<FeedBack> getFeedBacks() {
		return feedBacks;
	}

	public void setFeedBacks(Set<FeedBack> feedBacks) {
		this.feedBacks = feedBacks;
	}	
}
