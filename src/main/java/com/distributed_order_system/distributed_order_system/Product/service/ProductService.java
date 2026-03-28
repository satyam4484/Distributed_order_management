package com.distributed_order_system.distributed_order_system.Product.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Order.dto.OrderItemRequest;
import com.distributed_order_system.distributed_order_system.Product.dto.ProductDTO;
import com.distributed_order_system.distributed_order_system.Product.entity.Product;

public interface ProductService {
    ProductDTO create(ProductDTO productDTO);
    ProductDTO update(Long id, ProductDTO productDTO);
    void delete(Long id);
    ProductDTO getById(Long id);
    List<ProductDTO> getAll();

    // handles
    List<Product> validateAndReserve(List<OrderItemRequest> items);

}
