package com.jooq.feature.web.v1;

import com.jooq.core.rest.ApiResponse;
import com.jooq.feature.mapper.ItemMapper;
import com.jooq.feature.mapper.OrderItemMapper;
import com.jooq.feature.mapper.OrderMapper;
import com.jooq.feature.model.domain.OrderItem;
import com.jooq.feature.model.dto.ItemDto;
import com.jooq.feature.model.dto.OrderDto;
import com.jooq.feature.model.dto.OrderItemDto;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.model.request.OrderRequest;
import com.jooq.feature.service.ItemService;
import com.jooq.feature.service.OrderService;
import com.jooq.my_schema.tables.pojos.Items;
import com.jooq.my_schema.tables.pojos.Orders;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    /**
     * Get orders by customer.
     *
     * @param customerId
     * @return
     */
    @ApiOperation(
            value = "Get orders by customer Id"
    )
    @GetMapping(
            value = "/customers/{customerId}/orders",
            produces = APPLICATION_JSON_VALUE
    )
    public List<OrderItemDto> getOrdersByCustomerId(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId) {
        List<OrderItem> orders = this.orderService.getOrdersByCustomerId(customerId);
        return this.orderItemMapper.mapToOrderItemDtoList(orders);
    }

    /**
     * Add customer order.
     *
     * @param customerId
     * @param orderRequest
     * @return
     */
    @ApiOperation(
            value = "Add customer order"
    )
    @PostMapping(
            value = "/customers/{customerId}/orders",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ApiResponse<OrderDto> addCustomerOrder(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId,
                                                  @ApiParam(value = "Order details", required = true) @RequestBody OrderRequest orderRequest) {
        Orders orders = this.orderService.addCustomerOrder(customerId, this.orderMapper.mapToOrders(orderRequest.getOrder()), orderRequest.getItemIds());
        return new ApiResponse<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(this.orderMapper.mapToOrderDto(orders))
        );
    }

    /**
     * Get list of orders.
     *
     * @return
     */
    @ApiOperation(
            value = "Get all orders"
    )
    @GetMapping(
            value = "/orders",
            produces = APPLICATION_JSON_VALUE
    )
    public List<OrderItemDto> getAllOrders() {
        List<OrderItem> orders = this.orderService.getAllOrders();
        return this.orderItemMapper.mapToOrderItemDtoList(orders);
    }

    /**
     * Get order by id.
     *
     * @param orderId
     * @return
     */
    @ApiOperation(
            value = "Get order by Id"
    )
    @GetMapping(
            value = "/orders/{orderId}",
            produces = APPLICATION_JSON_VALUE
    )
    public OrderItemDto getOrderById(@ApiParam(value = "Order Id", required = true) @PathVariable("orderId") Long orderId) {
        OrderItem orderItem = this.orderService.getOrderById(orderId);
        return this.orderItemMapper.mapToOrderItemDto(orderItem);
    }

    /**
     * Get customer order by status.
     *
     * @param customerId
     * @param status
     * @return
     */
    @ApiOperation(
            value = "Get customer order by status"
    )
    @GetMapping(
            value = "/customers/{customerId}/orders",
            params = "status",
            produces = APPLICATION_JSON_VALUE
    )
    public List<OrderItemDto> getCustomerOrderByStatus(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId,
                                                       @ApiParam(value = "Order status", required = true) @RequestParam("status") OrderStatusEnum status) {
        List<OrderItem> orders = this.orderService.getCustomerOrderByStatus(customerId, status);
        return this.orderItemMapper.mapToOrderItemDtoList(orders);
    }

    /**
     * Get order by status.
     *
     * @param status
     * @return
     */
    @ApiOperation(
            value = "Get order by status"
    )
    @GetMapping(
            value = "/orders",
            params = "status",
            produces = APPLICATION_JSON_VALUE
    )
    public List<OrderItemDto> getOrdersByStatus(@ApiParam(value = "Order status", required = true) @RequestParam("status") OrderStatusEnum status) {
        List<OrderItem> orders = this.orderService.getOrdersByStatus(status);
        return this.orderItemMapper.mapToOrderItemDtoList(orders);
    }

    /**
     * Delete order by id.
     *
     * @param orderId
     * @return
     */
    @ApiOperation(
            value = "Delete order by Id"
    )
    @DeleteMapping(
            value = "/orders/{orderId}",
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> removeOrderById(@ApiParam(value = "Order Id", required = true) @PathVariable("orderId") Long orderId) {
        this.orderService.removeOrderById(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Get items by order id.
     *
     * @param orderId
     * @return
     */
    @ApiOperation(
            value = "Get items by order Id"
    )
    @GetMapping(
            value = "/orders/{orderId}/items",
            produces = APPLICATION_JSON_VALUE
    )
    public List<ItemDto> getItemsByOrderId(@ApiParam(value = "Order Id", required = true) @PathVariable(name = "orderId") Long orderId) {
        List<Items> items = this.itemService.getItemsByOrderId(orderId);
        return this.itemMapper.mapToItemDtoList(items);
    }
}
