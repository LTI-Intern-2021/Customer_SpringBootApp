package com.example.dao;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.Entity.CustomerUpdateInfo;
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
		return customerRepository.insert(customer);
	}

	public ResponseEntity<Customer> getCustomerById(int id) {
		
		Customer customer=customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Customer with id = " + id));
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

	public Optional<Customer> updateCustomerById(int id, CustomerUpdateInfo customerUpdateInfo)
	{
		Optional<Customer> findCustomerInfo = customerRepository.findById(id);

		findCustomerInfo.ifPresent(info-> info.setCustomerId(customerUpdateInfo.getCustomerId()));
		findCustomerInfo.ifPresent(info->info.setCustomerName(customerUpdateInfo.getCustomerName()));
		findCustomerInfo.ifPresent(info->info.setCustomerEmail(customerUpdateInfo.getCustomerEmail()));
		findCustomerInfo.ifPresent(info-> info.setCustomerLocation(customerUpdateInfo.getCustomerLocation()));
		findCustomerInfo.ifPresent(info->customerRepository.save(info));

		return findCustomerInfo;

	}
}
