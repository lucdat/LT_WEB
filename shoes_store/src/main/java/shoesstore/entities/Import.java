package shoesstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Import {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private int type;
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false)
	private int activeFlag;	
	
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id",nullable = true)
	private Product product;
	@ManyToOne
	@JoinColumn(name = "invoice_id",referencedColumnName = "id",nullable = true)
	private Invoice invoice;
	public Import() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Import(Double price, int type, int quantity, int activeFlag, Product product, Invoice invoice) {
		super();
		this.price = price;
		this.type = type;
		this.quantity = quantity;
		this.activeFlag = activeFlag;
		this.product = product;
		this.invoice = invoice;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}
	
}
