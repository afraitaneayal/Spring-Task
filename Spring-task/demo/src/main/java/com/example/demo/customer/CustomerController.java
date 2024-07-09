/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author afrai
 */
@RestController
@RequestMapping(path="/customer")
public class CustomerController {

	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	} 

    @GetMapping
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping(path = "{customerId}")
	public Customer getCustomer(@PathVariable("customerId") Long id) {
		return customerService.getCustomer(id);
	}

	@PostMapping
	public void registerNewCustomer(@RequestBody Customer customer){
		customerService.addNewCustomer(customer);
	}

	@DeleteMapping(path = "{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Long id){
		customerService.deleteCustomer(id);
	}
	
	@PutMapping(path = "{customerId}")
	public void updateCustomer(
		@PathVariable("customerId") Long customerId,
		@RequestParam(required = false) String name,
		@RequestParam(required= false) String phone
	) {
		customerService.updateCustomer(customerId, name, phone);
	}
}
