package com.example.javaspring.Service;

import com.example.javaspring.Model.Customer;
import com.example.javaspring.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public ArrayList<Customer> getCustomers() {
        return (ArrayList<Customer>) customerRepo.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepo.findById(id);
    }

    public Customer updateCustomer(Customer customer,Long id) {
        Customer customerOptional = customerRepo.findById(id).get();

        customer.setName(customer.getName());
        customer.setAddress(customer.getAddress());
        customer.setCity(customer.getCity());
        customer.setPhone(customer.getPhone());
        customer.setEmail(customer.getEmail());
        customer.setPassword(customer.getPassword());
        return customerOptional;
    }

    public Boolean deleteCustomer(Long id) {
        try {
            customerRepo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
