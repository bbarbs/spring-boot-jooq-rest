package com.jooq.feature.model;

import com.jooq.my_schema.tables.records.ItemsRecord;
import org.jooq.RecordMapper;

public class ItemDto implements RecordMapper<ItemsRecord, ItemDto> {

    private Integer id;
    private String  code;
    private String  itemName;
    private String  description;

    public ItemDto() {
    }

    public ItemDto(Integer id, String code, String itemName, String description) {
        this.id = id;
        this.code = code;
        this.itemName = itemName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public ItemDto map(ItemsRecord record) {
        return new ItemDto(record.getId(), record.getCode(), record.getItemName(), record.getDescription());
    }
}
