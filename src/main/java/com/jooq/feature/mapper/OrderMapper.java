package com.jooq.feature.mapper;

import com.jooq.feature.model.dto.OrderDto;
import com.jooq.my_schema.tables.pojos.Orders;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {ItemMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OrderMapper {

    @Mappings({
            @Mapping(target = "id", source = "orderId"),
            @Mapping(target = "amount", source = "orderAmount"),
            @Mapping(target = "dateOrder", source = "orderDate"),
            @Mapping(target = "status", source = "orderStatus")
    })
    Orders mapToOrders(OrderDto source);

    @IterableMapping(elementTargetType = Orders.class)
    List<Orders> mapToOrdersList(List<OrderDto> source);

    @Mappings({
            @Mapping(target = "orderId", source = "id"),
            @Mapping(target = "orderDate", source = "dateOrder"),
            @Mapping(target = "orderAmount", source = "amount"),
            @Mapping(target = "orderStatus", source = "status")
    })
    OrderDto mapToOrderDto(Orders source);

    @IterableMapping(elementTargetType = OrderDto.class)
    List<OrderDto> mapToOrderDtoList(List<Orders> source);
}
