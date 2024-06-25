package com.example.javaspring.Controller;

import com.example.javaspring.Model.Customer;
import com.example.javaspring.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ArrayList<Customer> getAllCustomers() {
        return this.customerService.getCustomers();
    }
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return this.customerService.addCustomer(customer);
    }
    @GetMapping(path = "/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id") Long id) {
        return this.customerService.getCustomerById(id);
    }

    @PutMapping(path = "/{id}")
    public Customer updateCustomer(@RequestBody Customer customer,@PathVariable("id") Long id) {
        return  this.customerService.updateCustomer(customer,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        boolean ok=this.customerService.deleteCustomer(id);
        if(ok){
            return "Customer with id"+" "+id+" "+"deleted";
        }else {
            return "Error, we have a problem";
        }
    }
}
