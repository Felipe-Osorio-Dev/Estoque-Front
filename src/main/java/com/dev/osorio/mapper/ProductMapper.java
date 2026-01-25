package com.dev.osorio.mapper;

import com.dev.osorio.dto.response.ProductResponse;
import com.dev.osorio.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductModel toModel(ProductResponse response);

}
