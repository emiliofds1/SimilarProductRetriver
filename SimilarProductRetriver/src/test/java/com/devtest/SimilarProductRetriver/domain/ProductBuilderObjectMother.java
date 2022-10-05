package com.devtest.SimilarProductRetriver.domain;

import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;


public class ProductBuilderObjectMother {

    public static Product.Builder withMandatoryFields() {
        return Product.builder().withId(new ProductId("validId"))
                .withName("three socks")
                .withPrice(2.00f)
                .withAvailability(true);
    }

}
