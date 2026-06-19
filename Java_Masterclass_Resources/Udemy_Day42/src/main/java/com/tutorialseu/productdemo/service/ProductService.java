package com.tutorialseu.productdemo.service;

import com.tutorialseu.productdemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // List simulating an in-memory database of products
    private List<Product> productList = new ArrayList<>();

    // Method to retrieve all products
    public List<Product> getAllProducts() {
        return productList;
    }

    // Method to retrieve a product by ID
    public Optional<Product> getProductById(Long id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    // Method to add a new product
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Method to update an existing product
    public boolean updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = getProductById(id);
        if (existingProduct.isPresent()) {
            existingProduct.get().setName(updatedProduct.getName());
            existingProduct.get().setPrice(updatedProduct.getPrice());
            return true;  // Return true if the update was successful
        }
        return false;  // Return false if the product was not found
    }

    // Method to delete a product by ID
    public boolean deleteProduct(Long id) {
        return productList.removeIf(product -> product.getId().equals(id));
    }
}
