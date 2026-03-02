package com.microservices.payment_service.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final List<Map<String, Object>> payments = new ArrayList<>();

    public PaymentController() {
        payments.add(Map.of("id", 1, "orderId", 1, "status", "PAID"));
    }

    @GetMapping
    public List<Map<String, Object>> getAllPayments() {
        return payments;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getPaymentById(@PathVariable int id) {
        return payments.stream()
                .filter(p -> (int) p.get("id") == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @PostMapping("/process")
    public Map<String, Object> processPayment(@RequestBody Map<String, Object> payment) {
        // Auto-generate ID if not provided
        if (!payment.containsKey("id") || payment.get("id") == null) {
            int nextId = payments.stream()
                    .mapToInt(p -> ((Number) p.get("id")).intValue())
                    .max()
                    .orElse(0) + 1;
            payment.put("id", nextId);
        }
        payments.add(payment);
        return Map.of(
                "status", "success",
                "message", "Payment processed successfully",
                "data", payment
        );
    }
}
