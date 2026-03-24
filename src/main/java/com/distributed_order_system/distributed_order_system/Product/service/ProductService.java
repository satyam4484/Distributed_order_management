package com.distributed_order_system.distributed_order_system.Product.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Product.dto.ProductDTO;

public interface ProductService {
    ProductDTO create(ProductDTO productDTO);
    ProductDTO update(Long id, ProductDTO productDTO);
    void delete(Long id);
    ProductDTO getById(Long id);
    List<ProductDTO> getAll();
}
