package com.scaler.productservice.service.mapper;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import com.scaler.productservice.ws.client.fakeStore.model.FakeStoreProductDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FakeStoreProductDtoToProductMapper {
    public Product productTransformer(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        if (Objects.nonNull(fakeStoreProductDto)) {
            product.setId(fakeStoreProductDto.getId());
            product.setName(fakeStoreProductDto.getTitle());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setImageUrl(fakeStoreProductDto.getImage());
            Category category = new Category();
            category.setName(fakeStoreProductDto.getCategory());
            product.setCategory(category);
        }
        return product;
    }
}
