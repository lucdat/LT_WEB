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
	@Column(nullable = false,length = 100)
	private String password;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	@Column(nullable = false,length = 100)
	private String address;
	@Column(nullable = false)
	private int activeFlag;
	
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
	
	public User(String name, String email, String password, String image, int activeFlag, MultipartFile file,
			Role role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.image = image;
		this.activeFlag = activeFlag;
		this.file = file;
		this.role = role;
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

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
