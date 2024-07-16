package com.scaler.productservice.ws.client.fakeStore.mapper;

import com.scaler.productservice.model.Product;
import com.scaler.productservice.ws.client.fakeStore.model.FakeStoreProductDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductToFakeStoreProductDtoMapper {

    public FakeStoreProductDto productTransformer(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        if (Objects.nonNull(product)) {
            fakeStoreProductDto.setTitle(product.getName());
            fakeStoreProductDto.setPrice(product.getPrice());
            if (Objects.nonNull(product.getCategory())) {
                fakeStoreProductDto.setCategory(product.getCategory().getName());
            }
            fakeStoreProductDto.setDescription(product.getDescription());
            fakeStoreProductDto.setImage(product.getImageUrl());
        }
        return fakeStoreProductDto;
    }
}
