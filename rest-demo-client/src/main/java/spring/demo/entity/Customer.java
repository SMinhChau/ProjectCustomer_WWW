package spring.demo.entity;

import javax.validation.constraints.NotBlank;

public class Customer {
	private int id;
	
	@NotBlank(message = "first name khong duoc rong")
	private String firstName;
	
	@NotBlank(message = "last name khong duoc rong")
	private String lastName;
	
	@NotBlank(message = "email khong duoc rong")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer() {
		super();
	}
	public Customer(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	

}
