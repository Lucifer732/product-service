package com.scaler.productservice.service.impl;

import com.scaler.productservice.service.ProductService;
import com.scaler.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealStoreProductService implements ProductService {

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(String productId, Product product) {
        return null;
    }

    @Override
    public Product getProductById(String productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public String deleteProductById(String productId) {
        return "";
    }
}
