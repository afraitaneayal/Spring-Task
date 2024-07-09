package com.example.demo.purchase;


import java.time.LocalDateTime;

import com.example.demo.customer.Customer;
import com.example.demo.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Purchase {
    @Id
    @SequenceGenerator(
        name = "purchase_sequence",
        sequenceName = "purchase_sequence",
        allocationSize= 1
    )
    @GeneratedValue(
        strategy= GenerationType.SEQUENCE,
        generator= "purchase_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name="customerId", nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="productId", nullable=false)
    private Product product;

    private Long amount;

    private LocalDateTime date;

    public Purchase() {
    }

    public Purchase(Long amount, Customer customer, LocalDateTime date, Long id, Product product) {
        this.amount = amount;
        this.customer = customer;
        this.id = id;
        this.product = product;
        this.date = date;
    }

    public Purchase(Long amount, Customer customer, LocalDateTime date, Product product) {
        this.amount = amount;
        this.customer = customer;
        this.product = product;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    
}
