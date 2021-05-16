package com.example.Controller;

import java.util.Collection;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Customer;
import com.example.service.CustomerService;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.Entity.Customer;
import com.example.Entity.CustomerUpdateInfo;
@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	public CustomerService customerService;
	@GetMapping("/getAll")
	public Collection<Customer>  getAllCustomers(){
		logger.info("Inside getAllCustomers method of CustomerController");

		return customerService.getAllCustomers();
	}


	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		
		logger.info("Inside Controller's addCustomer method");

		return customerService.addCustomer(customer);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id)
	{
		
		
		return customerService.getCustomerById(id);
	}
	

	
	@DeleteMapping("/{id}")
	public void delByCustomerId(@PathVariable("id") int id)
	{
		logger.info("Inside Controller's delCustomerById method");
		customerService.delByCustomerId(id);
	}
	

	 @PutMapping("/{id}")
    	public Customer updateCustomerById(@PathVariable("id") int id, @RequestBody Customer
            customer) 
	{
        	return customerService.updateCustomerById(id, customer);
    	}


}
