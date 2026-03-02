package com.microservices.item_service.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")

public class ItemController {

private final List<Map<String, Object>> items = new ArrayList<>();

    public ItemController() {
        items.add(Map.of("id", 1, "name", "Pen", "price", 50));
        items.add(Map.of("id", 2, "name", "Book", "price", 200));
    }

    @GetMapping
    public List<Map<String, Object>> getAllItems() {
        return items;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getItemById(@PathVariable int id) {
        return items.stream()
                .filter(i -> (int) i.get("id") == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @PostMapping
    public Map<String, Object> addItem(@RequestBody Map<String, Object> item) {
        // Auto-generate ID if not provided
        if (!item.containsKey("id") || item.get("id") == null) {
            int nextId = items.stream()
                    .mapToInt(i -> ((Number) i.get("id")).intValue())
                    .max()
                    .orElse(0) + 1;
            item.put("id", nextId);
        }
        items.add(item);
        return Map.of(
                "status", "success",
                "message", "Item created successfully",
                "data", item
        );
    }

}
