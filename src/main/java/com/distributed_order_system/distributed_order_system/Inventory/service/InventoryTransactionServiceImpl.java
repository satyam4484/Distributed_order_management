package com.distributed_order_system.distributed_order_system.Inventory.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Inventory.entity.InventoryTransaction;
import com.distributed_order_system.distributed_order_system.Inventory.repository.InventoryTransactionRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventoryTransactionServiceImpl implements InventoryTransactionService {

    private final InventoryTransactionRepository repository;

    @Override
    public InventoryTransaction create(InventoryTransaction t) {
        return repository.save(t);
    }

    @Override
    public InventoryTransaction update(Long id, InventoryTransaction t) {
        InventoryTransaction existing = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("InventoryTransaction not found"));
        existing.setQuantityChanged(t.getQuantityChanged());
        existing.setType(t.getType());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public InventoryTransaction getById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("InventoryTransaction not found"));
    }

    @Override
    public List<InventoryTransaction> getAll() {
        return repository.findAll();
    }

    @Override
    public List<InventoryTransaction> getByProductId(Long productId) {
        return repository.findByProductId(productId);
    }
}
