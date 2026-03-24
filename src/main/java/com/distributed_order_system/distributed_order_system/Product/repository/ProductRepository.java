package com.distributed_order_system.distributed_order_system.Product.repository;

import com.distributed_order_system.distributed_order_system.Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
