package com.leiber.market.web.controller;

import com.leiber.market.domain.Product;
import com.leiber.market.domain.service.ProductService;
import com.leiber.market.errors.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getAll() {
        return productService.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productService.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productService.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity) {
        return productService.getScarseProducts(quantity);
    }

    public Product save(Product product) {
        return productService.save(product);
    }

    public boolean delete(int productId) {
        try {
            productService.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public Product updateProduct(int productId, Product productoActualizado) {
        try {
            Product product = productService.getProduct(productId).orElseThrow(() -> {
                return new ResourceNotFoundException("Producto", "id", productId);
            });

            product.setName(productoActualizado.getName());
            product.setPrice(productoActualizado.getPrice());

            return productService.save(product);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al actualizar el producto", e);
        }
    }

}
