package com.distributed_order_system.distributed_order_system.Inventory.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Inventory.entity.InventoryTransaction;

public interface InventoryTransactionService {
    InventoryTransaction create(InventoryTransaction t);
    InventoryTransaction update(Long id, InventoryTransaction t);
    void delete(Long id);
    InventoryTransaction getById(Long id);
    List<InventoryTransaction> getAll();
    List<InventoryTransaction> getByProductId(Long productId);
}
