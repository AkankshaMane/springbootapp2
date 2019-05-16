package com.sapiens.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapiens.customer.Customer;
import com.sapiens.policy.Policy;
import com.sapiens.repository.CustomerRepository;
import com.sapiens.repository.PolicyRepository;


@Service
public class CustServiceImpl implements CustService {

	@Autowired
    CustomerRepository custRepository; 
	@Autowired
    PolicyRepository polRepository; 
	
	@Override
	public List<Customer> getCustomers() {
		
		List<Customer> list=new ArrayList<>();
	    custRepository.findAll().forEach(list:: add);	
		return list;
	}

	@Override
	public void saveCustomer(Customer cust) {
		
		custRepository.save(cust);
	}

	@Override
	public Optional<Customer> getById(long id) {
		
		return custRepository.findById(id); 
	}

	@Override
	public void savePolicy(Policy policy) {
		
		polRepository.save(policy);
	}

	
}
