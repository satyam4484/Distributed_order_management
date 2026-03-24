package com.distributed_order_system.distributed_order_system.Inventory.controller;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Inventory.entity.InventoryTransaction;
import com.distributed_order_system.distributed_order_system.Inventory.service.InventoryTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryTransactionController {

    private final InventoryTransactionService service;

    public InventoryTransactionController(InventoryTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InventoryTransaction> create(@RequestBody InventoryTransaction t) {
        return ResponseEntity.ok(service.create(t));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryTransaction> update(@PathVariable Long id, @RequestBody InventoryTransaction t) {
        return ResponseEntity.ok(service.update(id, t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryTransaction> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<InventoryTransaction>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<InventoryTransaction>> getByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(service.getByProductId(productId));
    }
}
