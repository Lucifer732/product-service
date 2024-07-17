package com.scaler.productservice.ws.client.fakeStore;

import com.scaler.productservice.ws.client.fakeStore.model.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.scaler.productservice.ws.client.fakeStore.constant.FakeStoreConstants.BASE_URL;

@Component
public class FakeStoreProductServiceWsClient {

    @Autowired
    RestTemplate restTemplate;

    public FakeStoreProductDto createProduct(FakeStoreProductDto fakeStoreProduct) {
        return restTemplate.postForObject(BASE_URL, fakeStoreProduct, FakeStoreProductDto.class);
    }

    public FakeStoreProductDto updateProductById(String fakeStoreProductId, FakeStoreProductDto fakeStoreProductDto) {
        HttpEntity<FakeStoreProductDto> requestBody = new HttpEntity<>(fakeStoreProductDto);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(BASE_URL+"{id}", HttpMethod.DELETE,
                                                        requestBody, FakeStoreProductDto.class, fakeStoreProductId);
        return response.getBody();
    }

    public FakeStoreProductDto getProductById(String fakeStoreProductId) {
        return restTemplate.getForObject(BASE_URL+fakeStoreProductId, FakeStoreProductDto.class);
    }

    public FakeStoreProductDto[] getAllProducts() {
        return restTemplate.getForObject(BASE_URL, FakeStoreProductDto[].class);
    }

    public String deleteProductById(String fakeStoreProductId) {
         ResponseEntity<Void> response = restTemplate.exchange(BASE_URL+"{id}", HttpMethod.DELETE, null,
                                                                Void.class, fakeStoreProductId);

         if (response.getStatusCode().equals(HttpStatus.OK)) {
             return "Product with Id: "+fakeStoreProductId+" has deleted Successfully";
         }
        return "Product with Id: "+fakeStoreProductId+" has not deleted, request Failed";
    }
}
