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
public class FeedBack {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date date;
	@Column(nullable = false,length = 200)
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id",nullable = true)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "user_id",referencedColumnName = "id",nullable = true)
	private User user;
	public FeedBack() {
		// TODO Auto-generated constructor stub
	}
	
	public FeedBack(Date date, String content, Product product, User user) {
		this.date = date;
		this.content = content;
		this.product = product;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
