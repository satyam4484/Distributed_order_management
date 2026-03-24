package com.distributed_order_system.distributed_order_system.Inventory.entity;

import com.distributed_order_system.distributed_order_system.Product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "inventory_transactions")
public class InventoryTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantityChanged;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public enum TransactionType {
        RESERVE,
        RELEASE,
        DEDUCT
    }
}