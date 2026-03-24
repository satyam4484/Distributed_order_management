package com.distributed_order_system.distributed_order_system.Inventory.controller;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Inventory.dto.InventoryRequest;
import com.distributed_order_system.distributed_order_system.Inventory.dto.InventoryResponse;
import com.distributed_order_system.distributed_order_system.Inventory.service.InventoryTransactionService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryTransactionController {

    private final InventoryTransactionService service;

    @PostMapping
    public ResponseEntity<InventoryResponse> create(@RequestBody InventoryRequest inventoryRequest) {
        return ResponseEntity.ok(service.create(inventoryRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<InventoryResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<InventoryResponse>> getByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(service.getByProductId(productId));
    }
}
