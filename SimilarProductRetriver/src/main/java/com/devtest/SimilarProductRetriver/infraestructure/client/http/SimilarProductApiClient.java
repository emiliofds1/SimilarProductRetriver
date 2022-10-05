package com.devtest.SimilarProductRetriver.infraestructure.client.http;

import com.devtest.SimilarProductRetriver.infraestructure.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SimilarProductApiClient {

    private final RestTemplate restTemplate;

    @Autowired
    public SimilarProductApiClient() {
        this.restTemplate =  new RestTemplate();
    }

    public String[] searchSimilarProductIdsOf(String productId) {
        String searchSimilarPath = "http://localhost:3001/product/" + productId + "/similarids";
        return restTemplate.getForObject(searchSimilarPath, String[].class);

    }

    public ProductDto findProductById(String productId) {
        String searchProductPath = "http://localhost:3001/product/" + productId;
        return restTemplate.getForObject(searchProductPath, ProductDto.class);
    }
}
