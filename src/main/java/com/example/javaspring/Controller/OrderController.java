package com.example.javaspring.Controller;

import com.example.javaspring.Model.Order;
import com.example.javaspring.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ArrayList<Order> getAllOrders() {
        return this.orderService.getOrders();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return this.orderService.addOrder(order);
    }

    @GetMapping(path = "/{id}")
    public Optional<Order> getOrderById(@PathVariable("id") Long id) {
        return this.orderService.getOrderById(id);
    }

    @PutMapping(path = "/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable("id") Long id) {
        return this.orderService.updateOrder(order, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        boolean ok = this.orderService.deleteOrder(id);
        if (ok) {
            return "Order with id " + id + " deleted";
        } else {
            return "Error, we have a problem";
        }
    }
}
