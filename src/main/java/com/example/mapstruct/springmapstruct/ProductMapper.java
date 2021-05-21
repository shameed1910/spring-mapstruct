package com.example.mapstruct.springmapstruct;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "product.name", target = "desc", defaultValue = "product desc")
    ProductDto toDto(final Product product);


    List<ProductDto> toDtos(final List<Product> products);

    @InheritInverseConfiguration
    Product productDtoToProduct( final ProductDto productDto);





}
