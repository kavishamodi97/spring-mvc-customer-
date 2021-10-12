package com.mymvcapp.service;

import java.util.List;

import com.mymvcapp.entity.Customer;
import com.mymvcapp.exception.ResourceNotFoundException;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId) throws ResourceNotFoundException;

	public void deleteCustomer(int theId) throws ResourceNotFoundException;
}
