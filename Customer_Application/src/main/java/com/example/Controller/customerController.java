package com.example.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Customer;
import com.example.service.CustomerService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/customer")
@Slf4j
public class customerController {
	
	Logger logger = LoggerFactory.getLogger(customerController.class);
	@Autowired
	public CustomerService customerService;
	
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		
		logger.info("Inside Controller's addCustomer method");

		return customerService.addCustomer(customer);
	}
	
	
	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") int id)
	{
		logger.info("Inside Controller's getCustomerById method");
		return customerService.getCustomerById(id);
	}
	

}
