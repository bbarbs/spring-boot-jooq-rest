package com.jooq.feature.model;

import com.jooq.my_schema.tables.records.ItemsRecord;
import io.swagger.annotations.ApiModelProperty;
import org.jooq.RecordMapper;

public class ItemDto implements RecordMapper<ItemsRecord, ItemDto> {

    @ApiModelProperty(hidden = true)
    private Long itemId;

    @ApiModelProperty(required = true)
    private String itemCode;

    @ApiModelProperty(required = true)
    private String itemName;

    @ApiModelProperty(required = true)
    private String itemDescription;

    public ItemDto() {
    }

    public ItemDto(Long itemId, String itemCode, String itemName, String itemDescription) {
        this.itemId = itemId;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public ItemDto map(ItemsRecord record) {
        return new ItemDto(Long.valueOf(record.getId()), record.getCode(), record.getItemName(), record.getDescription());
    }
}
