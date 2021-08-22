package shoesstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

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
	private byte[] image;
	@Column(nullable = false)
	private int activeFlag;
	
	@ManyToOne
	@JoinColumn(name = "role_id",referencedColumnName = "id")
	private Role role;
	
	public User() {
	}
	public User(String name, String email, String password, byte[] image, int activeFlag, Role role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.image = image;
		this.activeFlag = activeFlag;
		this.role = role;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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
