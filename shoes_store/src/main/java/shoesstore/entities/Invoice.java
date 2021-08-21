package shoesstore.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private int type;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false,length = 100)
	private Date date;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false,length = 200)
	private String description;
	@Column(nullable = false)
	private int activeFlag;	
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id",insertable = false,updatable = false)
	private Product product;
	
	public Invoice() {
		// TODO Auto-generated constructor stub
	}

	public Invoice(int type, Date date, Double price, int quantity, String description, int activeFlag,
			Product product) {
		this.type = type;
		this.date = date;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.activeFlag = activeFlag;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	

}
