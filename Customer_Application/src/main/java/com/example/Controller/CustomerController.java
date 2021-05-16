package com.example.Controller;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Customer;
import com.example.service.CustomerService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	


	

}
