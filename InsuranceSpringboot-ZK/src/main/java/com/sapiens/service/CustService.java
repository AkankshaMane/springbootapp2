package com.sapiens.service;

import java.util.List;
import java.util.Optional;

import com.sapiens.customer.Customer;
import com.sapiens.policy.Policy;

public interface CustService {

	public List<Customer> getCustomers();
	public void saveCustomer(Customer cust);
	public void savePolicy(Policy policy);
	public Optional<Customer> getById(long id);
	
}
