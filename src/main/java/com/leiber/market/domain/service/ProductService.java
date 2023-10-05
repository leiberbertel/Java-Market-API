package com.leiber.market.domain.service;

import com.leiber.market.domain.Product;
import com.leiber.market.domain.repository.ProductRepository;
import com.leiber.market.errors.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity) {
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        try {
            productRepository.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public Product updateProduct(int productId, Product productoActualizado) {
        try {
            Product product = productRepository.getProduct(productId).orElseThrow(() -> {
                return new ResourceNotFoundException("Producto", "id", productId);
            });

            product.setName(productoActualizado.getName());
            product.setPrice(productoActualizado.getPrice());

            return productRepository.save(product);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al actualizar el producto", e);
        }
    }

}
