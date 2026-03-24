package com.distributed_order_system.distributed_order_system.Product.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Product.entity.Product;

public interface ProductService {
    Product create(Product product);
    Product update(Long id, Product product);
    void delete(Long id);
    Product getById(Long id);
    List<Product> getAll();
}
