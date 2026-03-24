package com.distributed_order_system.distributed_order_system.Product.mapper;

import com.distributed_order_system.distributed_order_system.Product.dto.ProductDTO;
import com.distributed_order_system.distributed_order_system.Product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product);

    Product productDTOToProduct(ProductDTO productDTO);
}
