package com.example.demo.purchase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PurchaseConfig {

    @Bean
    CommandLineRunner commandLineRunnerPurchase(PurchaseRepository repository) {
        return args -> {};
    }
}
