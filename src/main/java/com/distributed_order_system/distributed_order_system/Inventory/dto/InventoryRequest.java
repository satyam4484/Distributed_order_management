package com.distributed_order_system.distributed_order_system.Inventory.dto;

import com.distributed_order_system.distributed_order_system.Inventory.entity.InventoryTransaction.TransactionType;
import lombok.Data;

@Data
public class InventoryRequest {
    private Long productId;
    private int quantityChanged;
    private TransactionType type;
}
