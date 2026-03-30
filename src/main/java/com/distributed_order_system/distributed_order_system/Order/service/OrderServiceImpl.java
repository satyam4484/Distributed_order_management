package com.distributed_order_system.distributed_order_system.Order.service;

import com.distributed_order_system.distributed_order_system.Notification.service.NotificationService;
import com.distributed_order_system.distributed_order_system.Order.dto.OrderCreateRequest;
import com.distributed_order_system.distributed_order_system.Order.dto.OrderItemRequest;
import com.distributed_order_system.distributed_order_system.Order.dto.OrderResponse;
import com.distributed_order_system.distributed_order_system.Order.entity.Order;
import com.distributed_order_system.distributed_order_system.Order.entity.OrderItem;
import com.distributed_order_system.distributed_order_system.Order.enums.OrderStatus;
import com.distributed_order_system.distributed_order_system.Order.mapper.OrderMapper;
import com.distributed_order_system.distributed_order_system.Order.repository.OrderRepository;
import com.distributed_order_system.distributed_order_system.Product.entity.Product;
import com.distributed_order_system.distributed_order_system.Product.service.ProductService;
import com.distributed_order_system.distributed_order_system.User.entity.User;
import com.distributed_order_system.distributed_order_system.User.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductService productService;
    private final NotificationService notificationService;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponse create(OrderCreateRequest request, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order must contain items");
        }

        // Step 1: Reserve products
        List<Product> reservedProducts = productService.validateAndReserve(request.getItems());

        // Step 2: Create productId → quantity map
        Map<Long, Integer> quantityMap = request.getItems()
                .stream()
                .collect(Collectors.toMap(
                        OrderItemRequest::getProductId,
                        OrderItemRequest::getQuantity));

        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        double totalPrice = 0;

        // Step 3: Build order items correctly
        for (Product product : reservedProducts) {

            int quantity = quantityMap.get(product.getId());

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setPrice(product.getPrice());

            order.addItem(orderItem);

            totalPrice += product.getPrice() * quantity;
        }

        order.setPrice(totalPrice);

        orderRepository.save(order);

        String message = String.format(
                "Your order #%d totaling $%.2f has been placed successfully. Expected delivery: %s",
                order.getId(),
                order.getPrice(),
                order.getCreatedAt().plusDays(5).toLocalDate());
        notificationService.sendOrderNotification(user.getId(), message);

        return orderMapper.orderToOrderResponse(order);
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
