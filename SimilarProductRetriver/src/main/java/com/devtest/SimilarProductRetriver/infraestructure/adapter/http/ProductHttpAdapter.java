package com.devtest.SimilarProductRetriver.infraestructure.adapter.http;

import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;
import com.devtest.SimilarProductRetriver.domain.exception.InvalidDomainException;
import com.devtest.SimilarProductRetriver.domain.exception.ProductNotFoundException;
import com.devtest.SimilarProductRetriver.domain.port.SimilarProductSearcher;
import com.devtest.SimilarProductRetriver.infraestructure.dto.ProductDto;
import com.devtest.SimilarProductRetriver.infraestructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/product")
public class ProductHttpAdapter {

    private final SimilarProductSearcher similarProductSearcher;

    private final ProductMapper productMapper;

    @Autowired
    public ProductHttpAdapter(SimilarProductSearcher similarProductSearcher, ProductMapper productMapper) {
        this.similarProductSearcher = similarProductSearcher;
        this.productMapper = productMapper;
    }

    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<ProductDto>> searchSimilarProducts(@PathVariable String productId) {
        try {
            return ResponseEntity.ok(getSimilarProductDto(new ProductId(productId)));
        }
        catch (InvalidDomainException | ProductNotFoundException exception) {
            return ResponseEntity.notFound().header("Product not found").build();
        }

    }

    private List<ProductDto> getSimilarProductDto(ProductId id) {
        return similarProductSearcher.search(id)
                                     .stream()
                                     .map(productMapper::map)
                                     .collect(Collectors.toList());
    }
}
