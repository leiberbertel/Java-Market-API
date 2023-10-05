package com.leiber.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.Serializable;

@Embeddable // Para que se pueda embeber
public class ComprasProductoPK implements Serializable {

    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}