package com.jooq.feature.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.my_schema.tables.records.OrdersRecord;
import io.swagger.annotations.ApiModelProperty;
import org.jooq.RecordMapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDto implements RecordMapper<OrdersRecord, OrderDto> {

    @ApiModelProperty(hidden = true)
    private Long orderId;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @ApiModelProperty(required = true)
    private Date orderDate;

    @ApiModelProperty(required = true)
    private OrderStatusEnum orderStatus;

    @ApiModelProperty(required = true)
    private BigDecimal orderAmount;

    public OrderDto() {
    }

    public OrderDto(Long orderId, Date orderDate, OrderStatusEnum orderStatus, BigDecimal orderAmount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public OrderDto map(OrdersRecord record) {
        return new OrderDto(Long.valueOf(record.getId()), record.getDateOrder(), OrderStatusEnum.valueOf(record.getStatus()), record.getAmount());
    }
}
