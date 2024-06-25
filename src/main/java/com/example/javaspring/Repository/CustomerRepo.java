package com.example.javaspring.Repository;

import com.example.javaspring.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
   }
