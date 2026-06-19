package com.tutorialseu.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    // Simulating a product repository using a HashMap
    private Map<Long, Product> productRepository = new HashMap<>();

    // Constructor to add some sample products
    public ProductController() {
        Product laptop = new Product();
        laptop.setId(1L);
        laptop.setName("Laptop");
        laptop.setPrice(999.99);

        Product smartphone = new Product();
        smartphone.setId(2L);
        smartphone.setName("Smartphone");
        smartphone.setPrice(499.99);

        productRepository.put(laptop.getId(), laptop);
        productRepository.put(smartphone.getId(), smartphone);
    }

    // POST method to create a new product
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        // Simulate saving the product to a database
        return new ResponseEntity<>("Product created: " + product.getName(), HttpStatus.CREATED);
    }

    // PUT method to update an existing product
    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        // Simulate updating the product in a database
        return new ResponseEntity<>("Product updated: " + product.getName(), HttpStatus.OK);
    }

    @PostMapping("/echo")
    public ResponseEntity<String> echoMessage(@RequestBody String message) {
        return new ResponseEntity<>("You sent: " + message, HttpStatus.OK);
    }

    @PostMapping("/bulk-products")
    public ResponseEntity<String> createProducts(@RequestBody List<Product> products) {
        // Simulate saving multiple products
        return new ResponseEntity<>("Created " + products.size() + " products", HttpStatus.CREATED);
    }

    // DELETE method to remove a product by ID
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        // Check if the product exists in the "repository"
        if (productRepository.containsKey(id)) {
            // Simulate deleting the product
            productRepository.remove(id);
            return new ResponseEntity<>("Product with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            // Return 404 if the product doesn't exist
            return new ResponseEntity<>("Product with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
}