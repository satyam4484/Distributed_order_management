package com.distributed_order_system.distributed_order_system.Inventory.repository;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Inventory.entity.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, Long> {
    List<InventoryTransaction> findByProductId(Long productId);
}
