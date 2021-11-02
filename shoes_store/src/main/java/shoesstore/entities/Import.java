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
	private Integer size;
	@Column(nullable = false,length = 30)
	private String color;
	@Column(nullable = false)
	private int type;
	@Column(nullable = false)
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id",nullable = true)
	private Product product;
	@ManyToOne
	@JoinColumn(name = "invoice_id",referencedColumnName = "id",nullable = true)
	private Invoice invoice;
	public Import() {
		// TODO Auto-generated constructor stub
	}
	public Import(Double price, Integer size, String color, int type, Integer quantity, Product product, Invoice invoice) {
		this.price = price;
		this.size = size;
		this.color = color;
		this.type = type;
		this.quantity = quantity;
		this.product = product;
		this.invoice = invoice;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
