package com.cloudnative.productservice;

import com.cloudnative.productservice.model.Product;
import com.cloudnative.productservice.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductServiceTest {
    private final ProductService productService = new ProductService();
    @Test
    void shouldReturnAllProducts() {
        List<Product> products = productService.getAllProducts();

        assertEquals(3, products.size());
    }

    @Test
    void shouldReturnProductById() {
        Product product = productService.getProductById(1L).orElseThrow();

        assertEquals("Laptop", product.getName());
        assertEquals(399999, product.getPrice());
    }

     @Test
    void shouldReturnEmptyWhenProductDoesNotExist() {
        assertTrue(productService.getProductById(99L).isEmpty());
    }
}