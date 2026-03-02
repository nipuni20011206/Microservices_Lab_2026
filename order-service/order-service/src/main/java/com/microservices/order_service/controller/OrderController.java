package com.microservices.order_service.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final List<Map<String, Object>> orders = new ArrayList<>();

    public OrderController() {
        orders.add(Map.of("id", 1, "itemId", 2, "quantity", 1));
    }

    @GetMapping
    public List<Map<String, Object>> getAllOrders() {
        return orders;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOrderById(@PathVariable int id) {
        return orders.stream()
                .filter(o -> (int) o.get("id") == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @PostMapping
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> order) {
        // Auto-generate ID if not provided
        if (!order.containsKey("id") || order.get("id") == null) {
            int nextId = orders.stream()
                    .mapToInt(o -> ((Number) o.get("id")).intValue())
                    .max()
                    .orElse(0) + 1;
            order.put("id", nextId);
        }
        orders.add(order);
        return Map.of(
                "status", "success",
                "message", "Order created successfully",
                "data", order
        );
    }
}
