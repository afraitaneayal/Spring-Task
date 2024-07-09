package com.example.demo.purchase;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import com.example.demo.product.Product;
import com.example.demo.product.ProductRepository;


@Service
public class PurchaseService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    private final PurchaseRepository purchaseRepository;

	@Autowired
	public PurchaseService(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	} 

    public void addNewPurchase(PurchaseRequest purchaseRequest){
       Customer customer = customerRepository.findById(purchaseRequest.getCustomerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with id " + purchaseRequest.getCustomerId() + " does not exists"));
       Product product = productRepository.findById(purchaseRequest.getProductId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + purchaseRequest.getProductId() + " does not exists"));
       Purchase purchase = new Purchase();
       purchase.setCustomer(customer);
       purchase.setProduct(product);
       purchase.setAmount(purchaseRequest.getAmount());
       purchase.setDate(LocalDateTime.now());
       purchaseRepository.save(purchase);
    }
}
