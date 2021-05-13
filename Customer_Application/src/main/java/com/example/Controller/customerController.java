package com.example.Controller;

import java.util.Collection;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Customer;
import com.example.service.CustomerService;

@Slf4j
@RestController
@RequestMapping("/customer")
public class customerController {
	
	@Autowired
	public CustomerService customerService;

	@GetMapping("/getAll")
	public Collection<Customer>  getAllCustomers(){
		log.info("Inside getAllCustomers method of CustomerController");
		return customerService.getAllCustomers();
	}


	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}
	
	
	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") int id)
	{
		return customerService.getCustomerById(id);
	}
	

}
