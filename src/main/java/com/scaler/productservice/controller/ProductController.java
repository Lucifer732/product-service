package com.scaler.productservice.controller;

import com.scaler.productservice.service.ProductService;
import com.scaler.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable String productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{productId}")
    public String deleteProductById(@PathVariable String productId) {
        return productService.deleteProductById(productId);
    }

}
