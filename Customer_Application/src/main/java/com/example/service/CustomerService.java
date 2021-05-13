package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Customer;
import com.example.dao.CustomerDao;

@Service
public class CustomerService {

	@Autowired
	public CustomerDao customerDao;
	
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.addCustomer(customer);
	}

	public Optional<Customer> getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(id);
	}

}
