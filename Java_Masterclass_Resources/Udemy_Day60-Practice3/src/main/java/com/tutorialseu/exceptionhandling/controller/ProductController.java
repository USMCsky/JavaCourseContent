package com.tutorialseu.exceptionhandling.controller;

import com.tutorialseu.exceptionhandling.exception.InvalidInputException;
import com.tutorialseu.exceptionhandling.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Map<String, String> PRODUCTS = new HashMap<>();

    static {
        PRODUCTS.put("1", "Laptop");
        PRODUCTS.put("2", "Smartphone");
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable String id) {
        String product = PRODUCTS.get(id);
        if (product == null) {
            throw new ResourceNotFoundException("Product with ID " + id + " not found");
        }
        return product;
    }

    @PostMapping
    public String createProduct(@RequestParam String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Product name cannot be empty");
        }
        String id = String.valueOf(PRODUCTS.size() + 1);
        PRODUCTS.put(id, name);
        return "Product created with ID " + id;
    }
}
