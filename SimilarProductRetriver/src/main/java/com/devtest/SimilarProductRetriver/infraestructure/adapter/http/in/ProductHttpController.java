package com.devtest.SimilarProductRetriver.infraestructure.adapter.http.in;

import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;
import com.devtest.SimilarProductRetriver.domain.exception.InvalidDomainException;
import com.devtest.SimilarProductRetriver.domain.port.SimilarProductSearcher;
import com.devtest.SimilarProductRetriver.infraestructure.dto.ProductDto;
import com.devtest.SimilarProductRetriver.infraestructure.mapper.out.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/product")
public class ProductHttpController {

    private final SimilarProductSearcher similarProductSearcher;

    private final ProductMapper productMapper;

    @Autowired
    public ProductHttpController(SimilarProductSearcher similarProductSearcher, ProductMapper productMapper) {
        this.similarProductSearcher = similarProductSearcher;
        this.productMapper = productMapper;
    }

    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<ProductDto>> searchSimilarProducts(@PathVariable String productId) {
        try {
            return ResponseEntity.ok(similarProductSearcher.search(new ProductId(productId))
                                                           .stream()
                                                           .map(productMapper::map)
                                                           .collect(Collectors.toList()));
        }
        catch (InvalidDomainException exception) {
            return ResponseEntity.badRequest().header("Product not found").build();
        }
    }
}
