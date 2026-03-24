package com.distributed_order_system.distributed_order_system.Payment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.distributed_order_system.distributed_order_system.Order.entity.Order;
import com.distributed_order_system.distributed_order_system.Order.repository.OrderRepository;
import com.distributed_order_system.distributed_order_system.Payment.dto.PaymentRequest;
import com.distributed_order_system.distributed_order_system.Payment.dto.PaymentResponse;
import com.distributed_order_system.distributed_order_system.Payment.entity.Payment;
import com.distributed_order_system.distributed_order_system.Payment.mapper.PaymentMapper;
import com.distributed_order_system.distributed_order_system.Payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentResponse create(PaymentRequest paymentRequest) {
        Order order = orderRepository.findById(paymentRequest.getOrderId())
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(paymentRequest.getAmount());
        payment.setPaymentMethod(paymentRequest.getPaymentMethod());
        payment.setStatus("COMPLETED"); // Default status for simulation
        payment.setTransactionTime(LocalDateTime.now());

        return paymentMapper.paymentToPaymentResponse(paymentRepository.save(payment));
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public PaymentResponse getById(Long id) {
        return paymentRepository.findById(id)
                .map(paymentMapper::paymentToPaymentResponse)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found"));
    }

    @Override
    public List<PaymentResponse> getAll() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::paymentToPaymentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponse getByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId)
                .map(paymentMapper::paymentToPaymentResponse)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found for order"));
    }
}
