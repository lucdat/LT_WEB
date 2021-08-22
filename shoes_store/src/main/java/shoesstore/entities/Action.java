package shoesstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Action {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false,length = 50)
	private String name;
	@Column(unique = true,nullable = false,length = 150)
	private String url;
	@Column(nullable = false)
	private int activeFlag;
	
	@ManyToOne
	@JoinColumn(name = "role_id",referencedColumnName = "id")
	private Role role;
	
	public Action() {
		// TODO Auto-generated constructor stub
	}

	public Action(String name, String url, int activeFlag, Role role) {
		this.name = name;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
