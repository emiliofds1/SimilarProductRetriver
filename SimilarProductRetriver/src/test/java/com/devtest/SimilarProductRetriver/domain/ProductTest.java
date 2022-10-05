package com.devtest.SimilarProductRetriver.domain;

import com.devtest.SimilarProductRetriver.domain.entity.product.Product;
import com.devtest.SimilarProductRetriver.domain.entity.product.ProductId;
import com.devtest.SimilarProductRetriver.domain.exception.InvalidDomainException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {


    @Test
    public void ProductWithoutIdThrowsInvalidDomainException() {
        //given
        Product.Builder builder = ProductBuilderObjectMother.withMandatoryFields().withId(null);

        //assert
        assertThrows( InvalidDomainException.class, () -> builder.build());
    }


    @Test
    public void ProductWithoutNameThrowsInvalidDomainException() {
        //given
        Product.Builder builder = ProductBuilderObjectMother.withMandatoryFields().withName(null);

        //assert
        assertThrows( InvalidDomainException.class, () -> builder.build());
    }
    @Test
    public void ProductWithoutPriceThrowsInvalidDomainException() {
        //given
        Product.Builder builder = ProductBuilderObjectMother.withMandatoryFields().withPrice(null);

        //assert
        assertThrows( InvalidDomainException.class, () -> builder.build());
    }
    @Test
    public void ProductWithoutAvailabilityThrowsInvalidDomainException() {
        //given
        Product.Builder builder = ProductBuilderObjectMother.withMandatoryFields().withAvailability(null);

        //assert
        assertThrows( InvalidDomainException.class, () -> builder.build());
    }

    @Test
    public void ProductIdtWithoutValueThrowsInvalidDomainException() {
        assertThrows( InvalidDomainException.class, () -> new ProductId(null));
    }
}
