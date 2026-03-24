package com.distributed_order_system.distributed_order_system.Order.service;

import com.distributed_order_system.distributed_order_system.Order.dto.OrderCreateRequest;
import com.distributed_order_system.distributed_order_system.Order.dto.OrderResponse;
import com.distributed_order_system.distributed_order_system.Order.entity.Order;
import com.distributed_order_system.distributed_order_system.Order.entity.OrderItem;
import com.distributed_order_system.distributed_order_system.Order.enums.OrderStatus;
import com.distributed_order_system.distributed_order_system.Order.mapper.OrderMapper;
import com.distributed_order_system.distributed_order_system.Order.repository.OrderRepository;
import com.distributed_order_system.distributed_order_system.Product.entity.Product;
import com.distributed_order_system.distributed_order_system.Product.repository.ProductRepository;
import com.distributed_order_system.distributed_order_system.User.entity.User;
import com.distributed_order_system.distributed_order_system.User.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponse create(OrderCreateRequest orderCreateRequest, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        double totalPrice = 0;
        for (var itemRequest : orderCreateRequest.getItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setPrice(product.getPrice());
            order.addItem(orderItem);

            totalPrice += product.getPrice() * itemRequest.getQuantity();
        }

        order.setPrice(totalPrice);
        return orderMapper.orderToOrderResponse(orderRepository.save(order));
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderResponse getById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::orderToOrderResponse)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    @Override
    public List<OrderResponse> getAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::orderToOrderResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResponse> getByUserId(Long userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(orderMapper::orderToOrderResponse)
                .collect(Collectors.toList());
    }
}
