package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Collection;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Bean
    ApplicationRunner runner (CustomerRepository repository) {
        return args -> repository.findAll().forEach(System.out::println); 
    }
}


interface CustomerRepository extends ListCrudRepository<Customer, Integer> {
}

record Customer(@Id int id, String name, Set<Cart> carts) {
}

record Cart(@Id int id, Set<LineItem> lineItems) {
}

record LineItem(@Id int id, String sku) {
}