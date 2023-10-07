package com.leiber.market.domain.repository;

import com.leiber.market.domain.Product;
import com.leiber.market.persistence.entity.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<List<Product>> getProductExpensive(BigDecimal price);
    Optional<List<Product>> getProductUnavailable();
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
    Product updateProduct(int id, Product productActualizado);

}
