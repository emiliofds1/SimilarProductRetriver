package com.devtest.SimilarProductRetriver.infraestructure.repository;

import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;
import com.devtest.SimilarProductRetriver.domain.exception.ProductNotFoundException;
import com.devtest.SimilarProductRetriver.domain.repository.ProductRepository;
import com.devtest.SimilarProductRetriver.infraestructure.client.http.SimilarProductApiClient;
import com.devtest.SimilarProductRetriver.infraestructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final SimilarProductApiClient similarProductApiClient;

    private final ProductMapper productMapper;

    @Autowired
    public ProductRepositoryImpl(SimilarProductApiClient similarProductApiClient, ProductMapper productMapper) {
        this.similarProductApiClient = similarProductApiClient;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findSimilarProductsOf(ProductId id) {
        try {
            return searchSimilarProductsIds(id.getValue()).stream()
                    .map(this::searchProductById)
                    .collect(Collectors.toList());
        }
        catch (HttpStatusCodeException exception) {
            if (exception.getRawStatusCode() == HttpStatus.NOT_FOUND.value())
                throw new ProductNotFoundException("product not found");
            throw exception;
        }
    }

    private List<String> searchSimilarProductsIds(String id) {
        return Arrays.asList(similarProductApiClient.searchSimilarProductIdsOf(id));
    }

    private Product searchProductById(String id) {
        return productMapper.map(similarProductApiClient.findProductById(id));
    }
}
