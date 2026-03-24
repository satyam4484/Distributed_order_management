package com.distributed_order_system.distributed_order_system.Order.controller;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Order.dto.OrderCreateRequest;
import com.distributed_order_system.distributed_order_system.Order.dto.OrderResponse;
import com.distributed_order_system.distributed_order_system.Order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody OrderCreateRequest orderCreateRequest, @RequestParam Long userId) {
        return ResponseEntity.ok(orderService.create(orderCreateRequest, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponse>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getByUserId(userId));
    }
}
