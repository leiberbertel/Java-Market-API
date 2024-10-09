package com.leiber.market.product;

import com.leiber.market.domain.Product;
import com.leiber.market.domain.repository.ProductRepository;
import com.leiber.market.domain.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Class in charge of testing the methods of ProductService
 * Created on 08/10/2024 at 11:05:00 pm
 *
 * @author Leiber Bertel
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    Product product;
    List<Product> products;
    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;
    private Integer productId;

    @BeforeEach
    public void setup() {
        product = new Product();
        product.setName("Milk");
        product.setProductId(1);

        products = new ArrayList<>();
        products.add(product);

        productId = 1;
    }

    @Test
    void testGetAll_NotNull() {
        when(productRepository.getAll()).thenReturn(products);

        List<Product> result = productService.getAll();

        assertNotNull(result);
    }

    @Test
    void testGetAll_ListLengthOne() {
        when(productRepository.getAll()).thenReturn(products);

        List<Product> result = productService.getAll();

        assertEquals(1, result.size());
    }

    @Test
    void testGetProduct_Success() {
        when(productRepository.getProduct(productId)).thenReturn(Optional.ofNullable(product));

        Optional<Product> result = productService.getProduct(productId);

        assertNotNull(result);
    }

    @Test()
    void testGetProduct_NumberFormatException() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            productService.getProduct(null);
        });

        assertEquals("The product id cannot be null", exception.getMessage());
    }
}
