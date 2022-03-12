package com.osf.lojaosf.controllers;

import com.osf.lojaosf.models.entities.Customer;
import com.osf.lojaosf.models.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<Customer> getCustomersByName(@PathVariable String partName) {
        return customerRepository.searchByNameLike(partName);
    }

    @GetMapping("/page/{numberPage}/{qtdPage}")
    public Iterable<Customer> getCustomersPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
        if (qtdPage >= 5) {
            qtdPage = 5;
        }
        Pageable page = PageRequest.of(numberPage, 2);
        return customerRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomersById(@PathVariable int id) {
        return customerRepository.findById(id);
    }

    @PostMapping
    public @ResponseBody
    Customer saveCustomers(@Valid Customer Customer) {
        customerRepository.save(Customer);
        return Customer;
    }

    @PutMapping
    public Customer changeCustomer(@Valid Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomersById(@PathVariable int id) {
        customerRepository.deleteById(id);
    }
}
