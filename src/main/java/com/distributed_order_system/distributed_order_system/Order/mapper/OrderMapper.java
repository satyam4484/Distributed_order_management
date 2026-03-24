package com.distributed_order_system.distributed_order_system.Order.mapper;

import com.distributed_order_system.distributed_order_system.Order.dto.OrderResponse;
import com.distributed_order_system.distributed_order_system.Order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper {

    @Mapping(source = "user.id", target = "userId")
    OrderResponse orderToOrderResponse(Order order);
}
