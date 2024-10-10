package com.leiber.market.domain.service;

import com.leiber.market.domain.Product;
import com.leiber.market.domain.repository.ProductRepository;
import com.leiber.market.util.Utils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(Integer productId) {
        if (Utils.isNull(productId)) {
            throw new IllegalArgumentException("The product id cannot be null");
        }
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(Integer categoryId) {
        if (Utils.isNull(categoryId)) {
            throw new IllegalArgumentException("The category id cannot be null");
        }
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(Integer quantity) {
        if (Utils.isNull(quantity)) {
            throw new IllegalArgumentException("The quantity cannot be null");
        }
        return productRepository.getScarseProducts(quantity);
    }

    public Optional<List<Product>> getProductExpensive(BigDecimal price) {
        return productRepository.getProductExpensive(price);
    }

    public Optional<List<Product>> getProductAvailable() {
        return productRepository.getProductAvailable();
    }

    public Product save(Product product) {
        if (Objects.isNull(product)) {
            throw new IllegalArgumentException("Product cannot be null and void");
        }

        if (product.getName() == null || product.getPrice() == null) {
            throw new IllegalArgumentException("Product name and price cannot be null");
        }
        return productRepository.save(product);
    }

    public boolean delete(Integer productId) {
        if (Utils.isNull(productId)) {
            throw new IllegalArgumentException("The product id cannot be null");
        }
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }

    public Product updateProduct(Integer productId, Product updateProduct) {
        if (Objects.isNull(updateProduct)) {
            throw new IllegalArgumentException("Update Product cannot be null and void");
        }

        return productRepository.updateProduct(productId, updateProduct);
    }

}
