package shoesstore.entities;

import java.util.HashSet;
import java.util.Set;

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
	@Column(nullable = false)
	private int activeFlag;
	
	@OneToMany(mappedBy = "role")
	private Set<User> users =new HashSet<User>();
	@OneToMany(mappedBy = "role")
	private Set<Action> actions = new HashSet<Action>();
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(String name, String description, int activeFlag, Set<User> users, Set<Action> actions) {
		this.name = name;
		this.description = description;
		this.activeFlag = activeFlag;
		this.users = users;
		this.actions = actions;
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

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
	
	
}
