package com.pp.customers.services;

import com.pp.customers.Customer;
import com.pp.customers.exceptions.CustomerNotFoundException;
import com.pp.customers.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {

        var it = customerRepository.findAll();

        var customers = new ArrayList<Customer>();
        it.forEach(e -> customers.add(e));

        return customers;
    }

    public Long count() {
        return customerRepository.count();
    }

    public Customer save(Customer customer) {
        customerRepository.save(customer);

        return customer;
    }

    public Customer find(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer updateCustomer(Customer newCustomer, Long id) {
        return customerRepository.findById(id).map(Customer -> {
                    Customer.setName(newCustomer.getName());
                    Customer.setRole(newCustomer.getRole());
                    return this.save(Customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return this.save(newCustomer);
                });
    }

    public void deleteById(Long customerId) {

        customerRepository.deleteById(customerId);
    }

}
