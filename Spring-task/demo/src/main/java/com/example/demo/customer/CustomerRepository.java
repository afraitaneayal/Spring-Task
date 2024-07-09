package com.example.demo.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    @Query("SELECT c FROM Customer c WHERE c.name=?1 AND c.phone =?2")
    Optional<Customer> findCustomerByNameAndPhone(String name, String phone);

    @Query("SELECT c FROM Customer c WHERE c.phone =?1")
    Optional<Customer> findCustomerByPhone(String phone);

}
