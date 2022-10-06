package com.devtest.SimilarProductRetriver.domain.entity.product;

import com.devtest.SimilarProductRetriver.domain.exception.InvalidDomainException;
import org.apache.commons.lang3.StringUtils;


public class Product {

    private final ProductId id;

    private final String name;

    private final Float price;

    private final Boolean availability;

    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.availability = builder.availability;
        checkInvariants();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private ProductId id;

        private String name;

        private Float price;

        private Boolean availability;

        private Builder() {}

        public Builder withId(ProductId id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }


        public Builder withPrice(Float price) {
            this.price = price;
            return this;
        }


        public Builder withAvailability(Boolean availability) {
            this.availability = availability;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }

    public ProductId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    private void checkInvariants() {
        if (id == null || StringUtils.isBlank(name) || price == null || availability == null)
            throw new InvalidDomainException("missing required field");
    }
}
