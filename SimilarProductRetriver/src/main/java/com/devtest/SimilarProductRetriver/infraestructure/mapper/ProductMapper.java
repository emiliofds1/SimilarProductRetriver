package com.devtest.SimilarProductRetriver.infraestructure.mapper;

import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;
import com.devtest.SimilarProductRetriver.infraestructure.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto map(Product product) {
        ProductDto dto = new ProductDto();
        dto.id = product.getId().getValue();
        dto.name = product.getName();
        dto.price = product.getPrice();
        dto.availability = product.getAvailability();
        return dto;
    }

    public Product map(ProductDto dto) {
        return Product.builder().withId(new ProductId(dto.id))
                                .withName(dto.name)
                                .withPrice(dto.price)
                                .withAvailability(dto.availability)
                                .build();
    }
}
