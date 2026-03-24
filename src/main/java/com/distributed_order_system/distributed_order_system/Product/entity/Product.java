package com.distributed_order_system.distributed_order_system.Product.entity;

import java.util.ArrayList;
import java.util.List;

import com.distributed_order_system.distributed_order_system.Inventory.entity.InventoryTransaction;
import com.distributed_order_system.distributed_order_system.Order.entity.OrderItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private int availableQuantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InventoryTransaction> inventoryTransactions = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
}