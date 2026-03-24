package com.distributed_order_system.distributed_order_system.Inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import com.distributed_order_system.distributed_order_system.Inventory.dto.InventoryRequest;
import com.distributed_order_system.distributed_order_system.Inventory.dto.InventoryResponse;
import com.distributed_order_system.distributed_order_system.Inventory.entity.InventoryTransaction;
import com.distributed_order_system.distributed_order_system.Inventory.mapper.InventoryMapper;
import com.distributed_order_system.distributed_order_system.Inventory.repository.InventoryTransactionRepository;
import com.distributed_order_system.distributed_order_system.Product.entity.Product;
import com.distributed_order_system.distributed_order_system.Product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryTransactionServiceImpl implements InventoryTransactionService {

    private final InventoryTransactionRepository repository;
    private final ProductRepository productRepository;
    private final InventoryMapper mapper;

    @Override
    public InventoryResponse create(InventoryRequest inventoryRequest) {
        Product product = productRepository.findById(inventoryRequest.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        InventoryTransaction transaction = new InventoryTransaction();
        transaction.setProduct(product);
        transaction.setQuantityChanged(inventoryRequest.getQuantityChanged());
        transaction.setType(inventoryRequest.getType());

        return mapper.toResponse(repository.save(transaction));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public InventoryResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("InventoryTransaction not found"));
    }

    @Override
    public List<InventoryResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<InventoryResponse> getByProductId(Long productId) {
        return repository.findByProductId(productId).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
