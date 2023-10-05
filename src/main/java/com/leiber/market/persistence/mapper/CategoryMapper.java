package com.leiber.market.persistence.mapper;

import com.leiber.market.domain.Category;
import com.leiber.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") // Componente de tipo spring
public interface CategoryMapper {

    @Mappings({
            @Mapping(source="idCategoria", target="categoryId"),
            @Mapping(source="descripcion", target="category"),
            @Mapping(source="estado", target="active"),
    })
    Category toCategory(Categoria categoria);

    // Configuracion inversa Category -> Categoria
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
