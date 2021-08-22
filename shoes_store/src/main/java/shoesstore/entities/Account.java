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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true,nullable = false,length = 100)
	private String email;
	@Column(nullable = false,length = 200)
	private String password;
	@Lob
	private byte[] image;
	
	@OneToOne
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	private Customer customer;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<FeedBack> feedBacks = new HashSet<FeedBack>();
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String email, String password, byte[] image, Customer customer, Set<FeedBack> feedBacks) {
		this.email = email;
		this.password = password;
		this.image = image;
		this.customer = customer;
		this.feedBacks = feedBacks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<FeedBack> getFeedBacks() {
		return feedBacks;
	}

	public void setFeedBacks(Set<FeedBack> feedBacks) {
		this.feedBacks = feedBacks;
	}
	
	
}
