package com.leiber.market.persistence;

import com.leiber.market.domain.Product;
import com.leiber.market.domain.repository.ProductRepository;
import com.leiber.market.errors.GenericException;
import com.leiber.market.errors.ResourceNotFoundException;
import com.leiber.market.persistence.crud.ProductoCrudRepository;
import com.leiber.market.persistence.entity.Producto;
import com.leiber.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private final ProductoCrudRepository productoCrudRepository;

    private final ProductMapper productMapper;

    public ProductoRepository(ProductoCrudRepository productoCrudRepository, ProductMapper productMapper) {
        this.productoCrudRepository = productoCrudRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(productMapper::toProducts);
    }


    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(productMapper::toProduct);
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public Optional<List<Product>> getProductExpensive(BigDecimal precioVenta) {
        return productoCrudRepository.findByPrecioVentaGreaterThanOrderByNombreAsc(precioVenta)
                .map(productMapper::toProducts);
    }

    @Override
    public Optional<List<Product>> getProductAvailable() {
        Optional<List<Producto>> productos = productoCrudRepository.findByEstado(false);
        return productos.map(productMapper::toProducts);
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

    public Product updateProduct(int id, Product updateProduct) {
        try {
            Product product = getProduct(id).orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));

            product.setName(updateProduct.getName());
            product.setCategory(updateProduct.getCategory());
            product.setPrice(updateProduct.getPrice());
            product.setStock(updateProduct.getStock());
            product.setActive(updateProduct.isActive());

            return save(product);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GenericException("Error inesperado al actualizar el producto: ", e);
        }
    }

}
