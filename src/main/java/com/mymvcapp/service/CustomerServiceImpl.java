package com.mymvcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mymvcapp.entity.Customer;
import com.mymvcapp.exception.ResourceNotFoundException;
import com.mymvcapp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) throws ResourceNotFoundException {
		return customerRepository.findById(theId).orElseThrow(() -> new ResourceNotFoundException(theId));
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) throws ResourceNotFoundException {
		customerRepository.deleteById(theId);
	}

}
