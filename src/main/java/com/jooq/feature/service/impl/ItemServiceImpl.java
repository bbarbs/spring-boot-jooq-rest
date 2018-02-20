package com.jooq.feature.service.impl;

import com.jooq.feature.exception.OrderNotFoundException;
import com.jooq.feature.repository.ItemRepository;
import com.jooq.feature.repository.OrderRepository;
import com.jooq.feature.service.ItemService;
import com.jooq.my_schema.tables.pojos.Items;
import com.jooq.my_schema.tables.records.ItemsRecord;
import com.jooq.my_schema.tables.records.OrdersRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Items> getAllItems() {
        List<Items> items = new ArrayList<>();
        List<ItemsRecord> records = this.itemRepository.findAll();
        records.stream()
                .forEach(itemsRecord -> items.add(itemsRecord.into(Items.class)));
        return items;
    }

    @Override
    public Items addItem(Items items) {
        return this.itemRepository.save(items).into(Items.class);
    }

    @Override
    public List<Items> getItemsByOrderId(Long orderId) {
        OrdersRecord record = this.orderRepository.findOne(orderId);
        if (record == null) {
            throw new OrderNotFoundException("Order not found");
        }
        List<Items> list = new ArrayList<>();
        List<ItemsRecord> items = this.itemRepository.getItemsByOrderId(orderId);
        items.stream()
                .forEach(itemsRecord -> list.add(itemsRecord.into(Items.class)));
        return list;
    }
}
