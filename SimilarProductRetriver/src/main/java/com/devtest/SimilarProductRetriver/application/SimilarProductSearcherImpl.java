package com.devtest.SimilarProductRetriver.application;

import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;
import com.devtest.SimilarProductRetriver.domain.port.SimilarProductSearcher;
import com.devtest.SimilarProductRetriver.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimilarProductSearcherImpl implements SimilarProductSearcher {

    private final ProductRepository productRepository;

    @Autowired
    public SimilarProductSearcherImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> search(ProductId id) {
        return productRepository.findSimilarProductsOf(id);
    }
}
