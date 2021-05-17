package com.example.Controller;
import java.util.Collection;
import java.util.Optional;

import com.example.Entity.CustomerUpdateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

	@DeleteMapping("/{id}")
	public void delByCustomerId(@PathVariable("id") int id)
	{
		logger.info("Inside Controller's delCustomerById method");
		customerService.delByCustomerId(id);
	}


	@PutMapping("/{id}")
	public Optional<Customer> updateCustomerById(@PathVariable("id") int id, @RequestBody CustomerUpdateInfo
			customerUpdateInfo)
	{
		return customerService.updateCustomerById(id, customerUpdateInfo);
	}

	

}
