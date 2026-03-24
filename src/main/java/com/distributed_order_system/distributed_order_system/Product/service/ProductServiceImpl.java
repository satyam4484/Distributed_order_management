package com.distributed_order_system.distributed_order_system.Product.service;

import java.util.List;
import java.util.stream.Collectors;

import com.distributed_order_system.distributed_order_system.Product.dto.ProductDTO;
import com.distributed_order_system.distributed_order_system.Product.entity.Product;
import com.distributed_order_system.distributed_order_system.Product.mapper.ProductMapper;
import com.distributed_order_system.distributed_order_system.Product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        return productMapper.productToProductDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product existing = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        existing.setName(productDTO.getName());
        existing.setPrice(productDTO.getPrice());
        existing.setAvailableQuantity(productDTO.getAvailableQuantity());
        return productMapper.productToProductDTO(productRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO getById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::productToProductDTO)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }
}
