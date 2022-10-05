package com.devtest.SimilarProductRetriver.domain.entity.product;

import com.devtest.SimilarProductRetriver.domain.exception.InvalidDomainException;

public class Product {

    private final ProductId id;

    private final String name;

    private final Float price;

    private final Boolean availability;

    public Product(ProductId id, String name, Float price, Boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availability = availability;
        checkInvariants();
    }

    private void checkInvariants() {
        if (id == null || name.isBlank() || price == null || availability == null)
            throw new InvalidDomainException("missing required field");
    }
}
