package com.tutorialseu.productdemo.model;

import lombok.Getter;
import lombok.Setter;

// Model class for Product with Lombok annotations to generate getters and setters automatically
@Getter
@Setter
public class Product {
    private Long id;      // Unique identifier for the product
    private String name;   // Name of the product
    private Double price;  // Price of the product
}
