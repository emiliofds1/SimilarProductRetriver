package com.devtest.SimilarProductRetriver.application;

import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;
import com.devtest.SimilarProductRetriver.domain.port.SearchSimilarProductsService;
import com.devtest.SimilarProductRetriver.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchSimilarProductsServiceImpl implements SearchSimilarProductsService {

    private final ProductRepository productRepository;

    @Autowired
    public SearchSimilarProductsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchSimilarProducts(ProductId id) {
        return productRepository.findSimilarProductsOf(id);
    }
}
