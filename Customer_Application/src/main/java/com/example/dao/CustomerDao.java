package com.example.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.example.exception.ResourceNotFoundException;

import com.example.Entity.Customer;

@Component
public class CustomerDao {

	@Autowired
	public CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.insert(customer);
	}

	public ResponseEntity<Customer> getCustomerById(int id) {
		// TODO Auto-generated method stub
		
		Customer customer=customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

    public Collection<Customer> getAllCustomers() {
		return customerRepository.findAll();
    }
}
