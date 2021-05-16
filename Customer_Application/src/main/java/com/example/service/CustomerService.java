package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Entity.Customer;
import com.example.dao.CustomerDao;

@Service
public class CustomerService {

	@Autowired
	public CustomerDao customerDao;
	
	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}


    public Collection<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
    }

	public ResponseEntity<Customer> getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}
}
