package com.sapiens.customer;

import javax.persistence.*;


@Entity
@Table(name="CUSTOMER123")

public class Customer {
  

	 @Id
	 @SequenceGenerator(name = "cust_seq", sequenceName = "c_seq", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
	 @Column(name="CID")
	 private long id;
	
	
  private String name;
  private String address;
  private String role;
 
public Customer() {
	super();
}

public Customer(long id, String name, String address, String role) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.role = role;
}


public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

@Column(name = "NAME") 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

@Column(name = "ADDRESS") 
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Column(name= "ROLE") 
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", role=" + role + "]";
}
  
  
	
}
