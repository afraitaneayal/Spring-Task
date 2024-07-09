/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.customer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;

/**
 *
 * @author afrai
 */
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	} 
    public List<Customer> getCustomers() {
		    return customerRepository.findAll();
	}

	public Customer getCustomer(Long customerId){
		return customerRepository.findById(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with id " + customerId + " does not exist"));
	}

	public void addNewCustomer(Customer customer){
		Optional<Customer> customerByNameAndPhone =  customerRepository.findCustomerByNameAndPhone(customer.getName(), customer.getPhone());
		if (customerByNameAndPhone.isPresent()){
			throw new IllegalStateException ("Customer already existing");
		}
		Optional<Customer> customerByPhone =  customerRepository.findCustomerByPhone(customer.getPhone());
		if (customerByPhone.isPresent()){
			throw new IllegalStateException ("Customers Can't have the same Phone Number");
		}
		customerRepository.save(customer);
	}

	public void deleteCustomer(Long customerId){
		boolean exists = customerRepository.existsById(customerId);
		if (!exists){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with id " + customerId + " does not exists");
		}
		customerRepository.deleteById(customerId);
	}

	@Transactional
	public void updateCustomer(Long customerId, String name, String phone){
		Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with id " + customerId + " does not exists"));
		if (name != null && name.length()> 0 && !Objects.equals(customer.getName(), name)){
			customer.setName(name);
		}
		if (phone != null && phone.length()> 0 && !Objects.equals(customer.getPhone(), phone)){
			Optional<Customer> customerPhone = customerRepository.findCustomerByPhone(phone);
			if (customerPhone.isPresent()){
				throw new IllegalStateException("Phone number already taken");
			}
			customer.setPhone(phone);
		}
	}

}
