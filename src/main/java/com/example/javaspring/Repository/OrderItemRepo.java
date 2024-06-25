package com.example.javaspring.Repository;

import com.example.javaspring.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {
}
