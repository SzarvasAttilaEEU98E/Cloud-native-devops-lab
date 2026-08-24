package com.cloudnative.productservice.service;

import com.cloudnative.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final List<Product> products = List.of(
        new Product(1L, "Laptop", 399999),
        new Product(2L, "Keyboard", 24999),
        new Product(3L, "Monitor", 89999)   
    );

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id){
        return products.stream()
        .filter(product -> product.getId().equals(id))
        .findFirst();
    }
}