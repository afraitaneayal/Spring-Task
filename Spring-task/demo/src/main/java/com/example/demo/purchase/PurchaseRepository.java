package com.example.demo.purchase;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
    @Query("SELECT p FROM Purchase p WHERE p.date>=?1 AND p.date<?2")
    List<Purchase> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
