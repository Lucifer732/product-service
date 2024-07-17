package com.scaler.productservice.service;

import com.scaler.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(String productId, Product product);

    Product getProductById(String productId);

    List<Product> getAllProducts();

    String deleteProductById(String productId);

}
