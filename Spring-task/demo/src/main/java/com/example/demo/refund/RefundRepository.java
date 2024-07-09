package com.example.demo.refund;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {
    @Query("SELECT r FROM Refund r WHERE r.date>=?1 AND r.date<?2")
    List<Refund> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
