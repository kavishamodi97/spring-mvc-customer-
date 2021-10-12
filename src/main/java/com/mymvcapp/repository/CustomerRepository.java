package com.mymvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymvcapp.entity.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
