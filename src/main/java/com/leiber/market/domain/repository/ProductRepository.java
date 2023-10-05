package com.leiber.market.domain.repository;

import com.leiber.market.domain.Product;
import com.leiber.market.errors.ResourceNotFoundException;
import com.leiber.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
    Producto updateProducto(int id, Producto productoActualizado);

}
