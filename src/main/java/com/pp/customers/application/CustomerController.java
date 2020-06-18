package com.pp.customers.application;

import java.util.List;

import com.pp.customers.Customer;
import com.pp.customers.services.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService service;

    CustomerController(CustomerService service) {
        this.service = service;
    }

    // Aggregate root
    @GetMapping("/customers")
    List<Customer> all() {
        return service.findAll();
    }

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return service.save(newCustomer);
    }

    // Single item
    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id) {
        return service.find(id);
    }

    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return service.updateCustomer(newCustomer, id);
    }

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        service.deleteById(id);
    }
}
