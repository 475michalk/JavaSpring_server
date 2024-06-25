package com.example.javaspring.Controller;

import com.example.javaspring.Model.OrderItem;
import com.example.javaspring.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ArrayList<OrderItem> getAllOrderItems() {
        return this.orderItemService.getOrderItems();
    }

    @PostMapping
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return this.orderItemService.addOrderItem(orderItem);
    }

    @GetMapping(path = "/{id}")
    public Optional<OrderItem> getOrderItemById(@PathVariable("id") Long id) {
        return this.orderItemService.getOrderItemById(id);
    }

    @PutMapping(path = "/{id}")
    public OrderItem updateOrderItem(@RequestBody OrderItem orderItem, @PathVariable("id") Long id) {
        return this.orderItemService.updateOrderItem(orderItem, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteOrderItem(@PathVariable("id") Long id) {
        boolean ok = this.orderItemService.deleteOrderItem(id);
        if (ok) {
            return "OrderItem with id " + id + " deleted";
        } else {
            return "Error, we have a problem";
        }
    }
}
