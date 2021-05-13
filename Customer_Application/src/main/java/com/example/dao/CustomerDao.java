package com.example.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Entity.Customer;

@Component
public class CustomerDao {

	@Autowired
	public CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.insert(customer);
	}

	public Optional<Customer> getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}

}
