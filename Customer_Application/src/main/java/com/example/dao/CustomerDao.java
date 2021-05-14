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
	
	public Optional<Customer> delByCustomerId(int id)
	{
		Optional<Customer> customer = customerRepository.findById(id);
		customer.ifPresent(b -> customerRepository.delete(b));
         	return customer;
	}
	
	public Optional<Customer> updateCustomerById(int id, CustomerUpdateInfo customerUpdateInfo) 
	{
        	Optional<Customer> customer = customerRepository.findById(id);
        	customer.ifPresent(b -> b.setCustomerId(customerUpdateInfo.getCustomerId()));
        	customer.ifPresent(b -> b.setCustomerName(customerUpdateInfo.getCustomerName()));
		customer.ifPresent(b -> b.setCustomerEmail(customerUpdateInfo.getCustomerEmail()));
		customer.ifPresent(b -> b.setCustomerLocation(customerUpdateInfo.getCustomerLocation()));
        	customer.ifPresent(b -> customerRepository.save(b));
        	return customer;
	}
}
