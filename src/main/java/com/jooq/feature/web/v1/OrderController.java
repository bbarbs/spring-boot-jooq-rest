package com.jooq.feature.web.v1;

import com.jooq.core.rest.ApiResponse;
import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.ItemDto;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.model.wrapper.CustomerOrderContext;
import com.jooq.feature.model.wrapper.OrderReqContext;
import com.jooq.feature.model.wrapper.OrderResContext;
import com.jooq.feature.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class OrderController {

    @Inject
    OrderService orderService;

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
    public List<OrderResContext> getOrdersByCustomerId(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId) {
        return this.orderService.getOrdersByCustomerId(customerId);
    }

    /**
     * Add customer order.
     *
     * @param customerId
     * @param reqContext
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
    public ApiResponse<OrderResContext> addCustomerOrder(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId,
                                                         @ApiParam(value = "Order details", required = true) @RequestBody OrderReqContext reqContext) {
        OrderResContext orderResContext = this.orderService.addCustomerOrder(customerId, reqContext.getOrder(), reqContext.getItemIds());
        return new ApiResponse<>(HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(orderResContext));
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
    public List<CustomerOrderContext> getAllOrders() {
        return this.orderService.getAllOrders();
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
    public CustomerOrderContext getOrderById(@ApiParam(value = "Order Id", required = true) @PathVariable("orderId") Long orderId) {
        OrderResContext resContext = this.orderService.getOrderById(orderId);
        CustomerDto customerDto = this.orderService.getCustomerByOrderId(orderId);
        return new CustomerOrderContext(customerDto, resContext);
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
    public List<OrderResContext> getCustomerOrderByStatus(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId,
                                                          @ApiParam(value = "Order status", required = true) @RequestParam("status") OrderStatusEnum status) {
        return this.orderService.getCustomerOrderByStatus(customerId, status);
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
    public List<OrderResContext> getOrdersByStatus(@ApiParam(value = "Order status", required = true) @RequestParam("status") OrderStatusEnum status) {
        return this.orderService.getOrdersByStatus(status);
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
        return this.orderService.getItemsByOrderId(orderId);
    }
}
