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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false,length = 50)
	private String name;
	@Column(unique = true,nullable = false,length = 15)
	private String phone;
	@Column(length = 100)
	private String note;
	@Column(nullable = false,length = 100)
	private String address;
	
	@OneToMany(mappedBy = "customer")
	private Set<Orders> customers = new HashSet<Orders>();
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String phone, String note, String address, Set<Orders> customers) {
		this.name = name;
		this.phone = phone;
		this.note = note;
		this.address = address;
		this.customers = customers;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Orders> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Orders> customers) {
		this.customers = customers;
	}
	
}
