package com.devtest.SimilarProductRetriver.domain.entity.product;

import com.devtest.SimilarProductRetriver.domain.exception.InvalidDomainException;
import org.apache.commons.lang3.StringUtils;

public class ProductId {

    private final String value;

    public ProductId(String value) {
        this.value = value;
        checkInvariants();
    }

    public String getValue() {
        return value;
    }

    private void checkInvariants() {
        if(StringUtils.isBlank(value))
            throw new InvalidDomainException("Id cant by blank");
    }
}
