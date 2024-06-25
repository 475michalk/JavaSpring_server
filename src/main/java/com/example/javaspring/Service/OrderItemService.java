package com.example.javaspring.Service;

import com.example.javaspring.Model.OrderItem;
import com.example.javaspring.Repository.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepository;

    public ArrayList<OrderItem> getOrderItems() {
        return (ArrayList<OrderItem>) orderItemRepository.findAll();
    }

    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem updateOrderItem(OrderItem orderItem, Long id) {
        OrderItem existingOrderItem = orderItemRepository.findById(id).orElse(null);
        if (existingOrderItem != null) {
            existingOrderItem.setOrder(orderItem.getOrder());
            existingOrderItem.setProduct(orderItem.getProduct());
            existingOrderItem.setQuantity(orderItem.getQuantity());
            return orderItemRepository.save(existingOrderItem);
        } else {
            return null;
        }
    }

    public Boolean deleteOrderItem(Long id) {
        try {
            orderItemRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
