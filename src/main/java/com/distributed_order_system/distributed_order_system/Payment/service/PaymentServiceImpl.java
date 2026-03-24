package com.distributed_order_system.distributed_order_system.Payment.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Payment.entity.Payment;
import com.distributed_order_system.distributed_order_system.Payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Long id, Payment payment) {
        Payment existing = paymentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Payment not found"));
        existing.setAmount(payment.getAmount());
        existing.setStatus(payment.getStatus());
        existing.setPaymentMethod(payment.getPaymentMethod());
        existing.setTransactionTime(payment.getTransactionTime());
        return paymentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Payment not found"));
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId)
            .orElseThrow(() -> new EntityNotFoundException("Payment not found for order"));
    }
}
