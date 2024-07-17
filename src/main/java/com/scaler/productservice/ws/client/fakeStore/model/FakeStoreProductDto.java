package com.scaler.productservice.ws.client.fakeStore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDto {
    private String id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
