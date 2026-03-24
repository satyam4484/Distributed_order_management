package com.distributed_order_system.distributed_order_system.Product.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private int availableQuantity;
}
