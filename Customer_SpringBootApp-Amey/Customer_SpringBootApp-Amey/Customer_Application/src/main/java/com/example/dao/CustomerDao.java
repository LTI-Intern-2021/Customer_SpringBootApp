package com.example.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.NoSuchElementException;

import com.example.Entity.CustomerUpdateInfo;
import com.example.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.example.exception.ResourceNotFoundException;

import com.example.Entity.Customer;
import java.util.Optional;
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
	
	public void delByCustomerId(int id)
	{
		try {
			 customerRepository.deleteById(id);
			        } 
		catch (NoSuchElementException e) 
		{
			e.printStackTrace();
			        }
	}
	
	public Customer updateCustomerById(int id, Customer customer) 
	{
        	Optional<Customer> findCustomerInfo = customerRepository.findById(id);
        	Customer customerInfo= findCustomerInfo.get();
        	customerInfo.setCustomerId(customer.getCustomerId());
        	customerInfo.setCustomerName(customer.getCustomerName());
		customerInfo.setCustomerEmail(customer.getCustomerEmail());
		customerInfo.setCustomerLocation(customer.getCustomerLocation());
        	return customerRepository.save(customerInfo); 
	}
}
