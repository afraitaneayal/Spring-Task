package com.example.demo.refund;

import java.time.LocalDateTime;

import com.example.demo.customer.Customer;
import com.example.demo.product.Product;
import com.example.demo.purchase.Purchase;

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
public class Refund {
    @Id
    @SequenceGenerator(
        name = "refund_sequence",
        sequenceName = "refund_sequence",
        allocationSize= 1
    )
    @GeneratedValue(
        strategy= GenerationType.SEQUENCE,
        generator= "refund_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name="customerId", nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="productId", nullable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="purchaseId", nullable=false)
    private Purchase purchase;

    private Long amount;

    private LocalDateTime date;

    public Refund() {
    }

    public Refund(Long amount, Customer customer, LocalDateTime date, Long id, Product product, Purchase purchase) {
        this.amount = amount;
        this.customer = customer;
        this.id = id;
        this.product = product;
        this.purchase = purchase;
        this.date = date;
    }

    public Refund(Long amount, Customer customer, LocalDateTime date, Product product, Purchase purchase) {
        this.amount = amount;
        this.customer = customer;
        this.product = product;
        this.purchase = purchase;
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

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
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
