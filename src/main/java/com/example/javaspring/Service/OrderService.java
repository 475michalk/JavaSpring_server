package com.example.javaspring.Service;

import com.example.javaspring.Model.Order;
import com.example.javaspring.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepository;

    public ArrayList<Order> getOrders() {
        return (ArrayList<Order>) orderRepository.findAll();
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Order order, Long id) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setCustomer(order.getCustomer());
            existingOrder.setOrderDate(order.getOrderDate());
            existingOrder.setTotalPrice(order.getTotalPrice());
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    public Boolean deleteOrder(Long id) {
        try {
            orderRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
