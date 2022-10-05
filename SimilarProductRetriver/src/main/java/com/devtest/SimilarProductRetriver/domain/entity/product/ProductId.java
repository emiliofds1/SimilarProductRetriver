package com.devtest.SimilarProductRetriver.domain.entity.product;

import com.devtest.SimilarProductRetriver.domain.exception.InvalidDomainException;

public class ProductId {

    private final String id;

    public ProductId(String id) {
        this.id = id;
        checkInvariants();
    }

    private void checkInvariants() {
        if(id.isBlank())
            throw new InvalidDomainException("Id cant by blank");
    }
}
