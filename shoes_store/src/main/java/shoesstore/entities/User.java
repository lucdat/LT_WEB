package shoesstore.entities;

import java.util.HashSet;
import java.util.Set;

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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false,length = 50)
	private String name;
	@Column(unique = true,nullable = false,length = 100)
	private String email;
	@Column(nullable = false,length =10)
	private String phone;
	@Column(nullable = false,length = 100)
	private String password;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	
	@Transient
	private MultipartFile file;
	
	@ManyToOne
	@JoinColumn(name = "role_id",referencedColumnName = "id",nullable = true)
	private Role role;
	
	@OneToMany(mappedBy = "user")
	private Set<FeedBack> feedBacks = new HashSet<FeedBack>();
	@OneToMany(mappedBy = "user")
	private Set<Orders> orders = new HashSet<Orders>();
	
	
	public User() {
	}
	
	public User(String name, String email, String phone, String password, String image,
			MultipartFile file, Role role, Set<FeedBack> feedBacks, Set<Orders> orders) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.image = image;
		this.file = file;
		this.role = role;
		this.feedBacks = feedBacks;
		this.orders = orders;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	

	public String getImage() {
		return image;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<FeedBack> getFeedBacks() {
		return feedBacks;
	}

	public void setFeedBacks(Set<FeedBack> feedBacks) {
		this.feedBacks = feedBacks;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	
}
