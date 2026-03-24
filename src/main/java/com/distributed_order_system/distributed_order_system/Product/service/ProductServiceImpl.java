package com.distributed_order_system.distributed_order_system.Product.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Product.entity.Product;
import com.distributed_order_system.distributed_order_system.Product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product existing = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setAvailableQuantity(product.getAvailableQuantity());
        return productRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
