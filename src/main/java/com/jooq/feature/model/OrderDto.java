package com.jooq.feature.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.my_schema.tables.records.OrdersRecord;
import org.jooq.RecordMapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDto implements RecordMapper<OrdersRecord, OrderDto> {

    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    private Date dateOrder;
    private OrderStatusEnum status;
    private BigDecimal amount;

    public OrderDto() {
    }

    public OrderDto(Integer id, Date dateOrder, OrderStatusEnum status, BigDecimal amount) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.status = status;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public OrderDto map(OrdersRecord record) {
        return new OrderDto(record.getId(), record.getDateOrder(), OrderStatusEnum.valueOf(record.getStatus()), record.getAmount());
    }
}
