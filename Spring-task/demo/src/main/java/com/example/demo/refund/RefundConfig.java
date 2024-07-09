package com.example.demo.refund;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.purchase.PurchaseRepository;

@Configuration
public class RefundConfig {
@Bean
    CommandLineRunner commandLineRunnerRefund(PurchaseRepository repository) {
        return args -> {};
    }
}
