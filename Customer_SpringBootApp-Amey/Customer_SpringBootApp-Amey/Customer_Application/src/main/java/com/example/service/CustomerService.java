package com.example.service;

import java.util.Collection;

import java.util.Optional;

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
		// TODO Auto-generated method stub
		return customerDao.addCustomer(customer);
	}

//	public ResponseEntity<Customer> getCustomerById(int id) {
//		// TODO Auto-generated method stub
//		return customerDao.getCustomerById(id);
//	}

    public Collection<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
    }

	public ResponseEntity<Customer> getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(id);
	}
	
	public void delByCustomerId(int id)
	{
		customerDao.delByCustomerId(id);
	}
	
	 public Customer updateCustomerById(int id, Customer customer) 
	 {
        	return customerDao.updateCustomerById(id, customer);
    	}
}
