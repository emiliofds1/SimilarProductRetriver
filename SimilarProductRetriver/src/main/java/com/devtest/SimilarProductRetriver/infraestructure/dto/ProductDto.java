package com.devtest.SimilarProductRetriver.infraestructure.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {

    public String id;

    public String name;

    public float price;

    public boolean availability;
;
    public ProductDto(String id, String name, float price, boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availability = availability;
    }
}
