package com.sapiens.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapiens.customer.Customer;




@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
