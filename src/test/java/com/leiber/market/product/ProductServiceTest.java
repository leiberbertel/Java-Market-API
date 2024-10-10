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

import java.math.BigDecimal;
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
    private Integer categoryId;
    private Integer quantity;
    private BigDecimal price;
    private Product newProduct;

    @BeforeEach
    public void setup() {
        product = new Product();
        product.setName("Milk");
        product.setProductId(1);

        products = new ArrayList<>();
        products.add(product);

        productId = 1;
        categoryId = 2;
        quantity = 200;
        price = new BigDecimal("200.000");

        newProduct = new Product();
        newProduct.setName("Bread");
        newProduct.setProductId(3);
        newProduct.setPrice(price);
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
    void testGetProduct_IllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> productService.getProduct(null));

        assertEquals("The product id cannot be null", exception.getMessage());
    }

    @Test
    void getByCategory_Success() {
        when(productRepository.getByCategory(categoryId)).thenReturn(Optional.ofNullable(products));

        Optional<List<Product>> result = productService.getByCategory(categoryId);

        assertNotNull(result);
    }

    @Test
    void getByCategory_IllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> productService.getByCategory(null));

        assertEquals("The category id cannot be null", exception.getMessage());
    }

    @Test
    void getScarsProducts_Success() {
        when(productRepository.getScarseProducts(quantity)).thenReturn(Optional.ofNullable(products));

        Optional<List<Product>> result = productService.getScarseProducts(quantity);

        assertNotNull(result);
    }

    @Test
    void getScarseProducts_IllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> productService.getScarseProducts(null));

        assertEquals("The quantity cannot be null", exception.getMessage());
    }

    @Test
    void getProductExpensive_NotNull() {
        when(productRepository.getProductExpensive(price)).thenReturn(Optional.ofNullable(products));

        Optional<List<Product>> result = productService.getProductExpensive(price);

        assertNotNull(result);
    }

    @Test
    void getProductAvailable_NotNull() {
        when(productRepository.getProductAvailable()).thenReturn(Optional.ofNullable(products));

        Optional<List<Product>> result = productService.getProductAvailable();

        assertNotNull(result);
    }

    @Test
    void save_Success() {
        when(productRepository.save(newProduct)).thenReturn(product);

        Product result = productService.save(newProduct);

        assertNotNull(result);
    }

    @Test
    void delete_IllegalArgumentException_When_ProductId_isNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> productService.delete(null));

        assertEquals("The product id cannot be null", exception.getMessage());
    }

    @Test
    void update_Success() {
        when(productRepository.updateProduct(productId, newProduct)).thenReturn(product);

        Product result = productService.updateProduct(productId, newProduct);

        assertNotNull(result);
    }

    @Test
    void update_IllegalArgumentException_When_Product_Update_isNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> productService.updateProduct(productId, null));

        assertEquals("Update Product cannot be null and void", exception.getMessage());
    }
}
