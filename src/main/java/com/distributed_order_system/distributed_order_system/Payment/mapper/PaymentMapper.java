package com.distributed_order_system.distributed_order_system.Payment.mapper;

import com.distributed_order_system.distributed_order_system.Payment.dto.PaymentResponse;
import com.distributed_order_system.distributed_order_system.Payment.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "order.id", target = "orderId")
    PaymentResponse paymentToPaymentResponse(Payment payment);
}
