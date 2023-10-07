package com.leiber.market.persistence.crud;

import com.leiber.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
    Optional<List<Producto>> findByEstado(boolean estado);
    Optional<List<Producto>> findByPrecioVentaGreaterThanOrderByNombreAsc(BigDecimal precioVenta);
}
