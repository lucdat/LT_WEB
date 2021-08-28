package shoesstore.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true,nullable = false,length = 50)
	private String name;
	@Column(nullable = false,length = 200)
	private String description;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<User> users =new HashSet<User>();
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(String name, String description, Set<User> users) {
		this.name = name;
		this.description = description;
		this.users = users;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
