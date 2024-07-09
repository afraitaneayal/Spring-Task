package com.example.demo.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunnerProduct(ProductRepository repository) {
        return args -> {};
    }
}
