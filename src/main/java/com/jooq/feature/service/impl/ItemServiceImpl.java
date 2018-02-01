package com.jooq.feature.service.impl;

import com.jooq.feature.model.ItemDto;
import com.jooq.feature.repository.ItemRepository;
import com.jooq.feature.service.ItemService;
import com.jooq.my_schema.tables.records.ItemsRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Inject
    ItemRepository itemRepository;


    @Override
    public ItemDto addItem(ItemDto dto) {
        ItemsRecord record = new ItemsRecord();
        record.setCode(dto.getItemCode());
        record.setItemName(dto.getItemName());
        record.setDescription(dto.getItemDescription());
        return this.itemRepository.save(record).map(res -> new ItemDto().map((ItemsRecord) res));
    }
}
