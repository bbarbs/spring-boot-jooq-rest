package com.jooq.feature.mapper;

import com.jooq.feature.model.domain.OrderItem;
import com.jooq.feature.model.dto.OrderItemDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {ItemMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OrderItemMapper {

    @Mappings({
            @Mapping(target = "order.id", source = "orderId"),
            @Mapping(target = "order.status", source = "orderStatus"),
            @Mapping(target = "order.dateOrder", source = "orderDate"),
            @Mapping(target = "order.amount", source = "orderAmount")
    })
    OrderItem mapToOrderItem(OrderItemDto source);

    @IterableMapping(elementTargetType = OrderItem.class)
    List<OrderItem> mapToOrderItemList(List<OrderItemDto> source);

    @Mappings({
            @Mapping(target = "orderId", source = "order.id"),
            @Mapping(target = "orderStatus", source = "order.status"),
            @Mapping(target = "orderAmount", source = "order.amount"),
            @Mapping(target = "orderDate", source = "order.dateOrder")
    })
    OrderItemDto mapToOrderItemDto(OrderItem source);

    @IterableMapping(elementTargetType = OrderItemDto.class)
    List<OrderItemDto> mapToOrderItemDtoList(List<OrderItem> source);
}
