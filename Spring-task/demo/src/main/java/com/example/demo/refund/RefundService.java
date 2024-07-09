package com.example.demo.refund;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import com.example.demo.product.Product;
import com.example.demo.product.ProductRepository;
import com.example.demo.purchase.Purchase;
import com.example.demo.purchase.PurchaseRepository;

@Service
public class RefundService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    private final RefundRepository refundRepository;

	@Autowired
	public RefundService(RefundRepository refundRepository) {
		this.refundRepository = refundRepository;
	}

    public void addNewRefund(RefundRequest refundRequest){
       Customer customer = customerRepository.findById(refundRequest.getCustomerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with id " + refundRequest.getCustomerId() + " does not exists"));
       Product product = productRepository.findById(refundRequest.getProductId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + refundRequest.getProductId() + " does not exists"));
       Purchase purchase = purchaseRepository.findById(refundRequest.getPurchaseId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Purchase with id " + refundRequest.getPurchaseId() + " does not exists"));
       Refund refund = new Refund();
       refund.setCustomer(customer);
       refund.setProduct(product);
       refund.setPurchase(purchase);
       refund.setAmount(refundRequest.getAmount());
       refund.setDate(LocalDateTime.now());
       refundRepository.save(refund);
    }
}
