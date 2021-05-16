package com.example.dao;
import com.example.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Customer;


@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer>{

}
