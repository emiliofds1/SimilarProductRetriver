package com.devtest.SimilarProductRetriver.domain.repository;

import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;

import java.util.List;

public interface ProductRepository {

    List<Product> findSimilarProductsOf(ProductId id);

}
