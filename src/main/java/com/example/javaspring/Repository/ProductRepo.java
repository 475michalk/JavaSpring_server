package com.example.javaspring.Repository;

import com.example.javaspring.Model.Branches;
import com.example.javaspring.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
