package com.scaler.productservice.service.impl;

import com.scaler.productservice.service.ProductService;

import com.scaler.productservice.model.Product;
import com.scaler.productservice.service.mapper.FakeStoreProductDtoToProductMapper;
import com.scaler.productservice.ws.client.fakeStore.FakeStoreProductServiceWsClient;
import com.scaler.productservice.ws.client.fakeStore.model.FakeStoreProductDto;
import com.scaler.productservice.ws.client.fakeStore.mapper.ProductToFakeStoreProductDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class FakeStoreProductServiceImpl implements ProductService {

    private final FakeStoreProductServiceWsClient fakeStoreProductServiceWsClient;
    private final ProductToFakeStoreProductDtoMapper productToFakeStoreProductDtoMapper;
    private final FakeStoreProductDtoToProductMapper fakeStoreProductDtoToProductMapper;

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProduct = productToFakeStoreProductDtoMapper.productTransformer(product);
        fakeStoreProduct = fakeStoreProductServiceWsClient.createProduct(fakeStoreProduct);
        return fakeStoreProductDtoToProductMapper.productTransformer(fakeStoreProduct);
    }

    @Override
    public Product updateProduct(String productId, Product product) {
        FakeStoreProductDto fakeStoreProduct = productToFakeStoreProductDtoMapper.productTransformer(product);
        fakeStoreProduct = fakeStoreProductServiceWsClient.updateProductById(productId, fakeStoreProduct);
        return fakeStoreProductDtoToProductMapper.productTransformer(fakeStoreProduct);
    }

    @Override
    public Product getProductById(String productId) {
        FakeStoreProductDto fakeStoreProduct = fakeStoreProductServiceWsClient.getProductById(productId);
        return fakeStoreProductDtoToProductMapper.productTransformer(fakeStoreProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtoList= fakeStoreProductServiceWsClient.getAllProducts();
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList) {
            products.add(fakeStoreProductDtoToProductMapper.productTransformer(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public String deleteProductById(String productId) {
        return fakeStoreProductServiceWsClient.deleteProductById(productId);
    }
}
