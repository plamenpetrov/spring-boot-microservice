package com.pp.customers.configuration;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.pp.customers.Customer;
import com.pp.customers.repositories.CustomerRepository;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
        Logger log = LoggerFactory.getLogger(LoadDatabase.class);

        return args -> {
            log.info("Preloading " + repository.save(new Customer("Plamen Petrov", "human")));
            log.info("Preloading " + repository.save(new Customer("Ivan Ivanov", "ork")));
        };
    }
}
