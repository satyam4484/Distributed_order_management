package com.distributed_order_system.distributed_order_system.Inventory.service;

import com.distributed_order_system.distributed_order_system.Inventory.dto.InventoryRequest;
import com.distributed_order_system.distributed_order_system.Inventory.dto.InventoryResponse;

import java.util.List;

public interface InventoryTransactionService {
    InventoryResponse create(InventoryRequest inventoryRequest);
    void delete(Long id);
    InventoryResponse getById(Long id);
    List<InventoryResponse> getAll();
    List<InventoryResponse> getByProductId(Long productId);
}
