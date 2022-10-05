package com.devtest.SimilarProductRetriver.application;

import com.devtest.SimilarProductRetriver.domain.ProductBuilderObjectMother;
import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;
import com.devtest.SimilarProductRetriver.domain.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SimilarProductSearcherTest {

    @InjectMocks
    private SimilarProductSearcherImpl similarProductSearcher;
    @Mock
    private ProductRepository productRepository;

    @Test
    public void assestServiceRetriveSimilar(){
        //given
        ProductId productId = new ProductId("validId");
        Product product = ProductBuilderObjectMother.withMandatoryFields().build();
        List<Product> expectedProducts = Arrays.asList(product);

        //when
        Mockito.when(productRepository.findSimilarProductsOf(productId))
               .thenReturn(expectedProducts);

        //assert
        assertEquals(similarProductSearcher.search(productId), expectedProducts);
    }
}
