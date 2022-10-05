package com.devtest.SimilarProductRetriver.domain.port;

import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;

import java.util.List;

public interface SimilarProductSearcher {

    List<Product> search(ProductId id);
}
