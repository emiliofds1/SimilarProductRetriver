package com.devtest.SimilarProductRetriver.infraestructure.mapper.out;

import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.infraestructure.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto map(Product product) {
        return new ProductDto(product.getId().getValue(),
                              product.getName(),
                              product.getPrice(),
                              product.getAvailability());
    }
}
