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

    /**
     * Aggregate root. Return all customers
     * @return
     */
    @GetMapping("/customers")
    List<Customer> all() {
        return service.findAll();
    }

    /**
     * Create new customer
     * @param newCustomer
     * @return
     */
    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return service.save(newCustomer);
    }

    /**
     * Get information for single customer
     * @param id
     * @return
     */
    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id) {
        return service.find(id);
    }

    /**
     * Create new customer based on id of already existing one
     * @param newCustomer
     * @param id
     * @return
     */
    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return service.updateCustomer(newCustomer, id);
    }

    /**
     * Delete customer
     * @param id
     */
    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        service.deleteById(id);
    }
}
