package com.leiber.market.domain.service;

import com.leiber.market.domain.Product;
import com.leiber.market.domain.repository.ProductRepository;
import com.leiber.market.errors.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity) {
        return productRepository.getScarseProducts(quantity);
    }

    public Optional<List<Product>> getProductExpensive(BigDecimal price) {
        return productRepository.getProductExpensive(price);
    }

    public Optional<List<Product>> getProductAvailable() {
        return productRepository.getProductUnavailable();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }

    public Product updateProduct(int productId, Product updateProduct) {
        return productRepository.updateProduct(productId, updateProduct);
    }

}
