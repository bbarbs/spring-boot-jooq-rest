package com.jooq.feature.web.v1;

import com.jooq.core.rest.ApiResponse;
import com.jooq.core.util.RestUtil;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.model.wrapper.OrderContext;
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
import static org.springframework.http.MediaType.sortBySpecificity;

@RestController
@RequestMapping(value = "/api/v1")
public class OrderController {

    @Inject
    OrderService orderService;

    @Inject
    RestUtil restUtil;

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
    public List<OrderContext> getOrdersByCustomerId(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId) {
        return this.orderService.getOrdersByCustomerId(customerId);
    }

    /**
     * Add customer order.
     *
     * @param customerId
     * @param context
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
    public ApiResponse addCustomerOrder(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId,
                                        @ApiParam(value = "Customer orders", required = true) @RequestBody OrderContext context) {
        OrderContext orderContext = this.orderService.addCustomerOrder(customerId, context);
        return this.restUtil.createApiResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED, Arrays.asList(orderContext));
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
    public List<OrderContext> getAllOrders() {
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
    public OrderContext getOrderById(@ApiParam(value = "Order Id", required = true) @PathVariable("orderId") Long orderId) {
        return this.orderService.getOrderById(orderId);
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
    public List<OrderContext> getCustomerOrderByStatus(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId,
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
    public List<OrderContext> getOrdersByStatus(@ApiParam(value = "Order status", required = true) @RequestParam("status") OrderStatusEnum status) {
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
}
