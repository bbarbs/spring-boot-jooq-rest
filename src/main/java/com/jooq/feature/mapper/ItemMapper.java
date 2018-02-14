package com.jooq.feature.mapper;

import com.jooq.feature.model.dto.ItemDto;
import com.jooq.my_schema.tables.pojos.Items;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ItemMapper {

    @Mappings({
            @Mapping(target = "id", source = "itemId"),
            @Mapping(target = "code", source = "itemCode"),
            @Mapping(target = "itemName", source = "itemName"),
            @Mapping(target = "description", source = "itemDescription")
    })
    Items mapToItems(ItemDto source);

    @IterableMapping(elementTargetType = Items.class)
    List<Items> mapToItemsList(List<ItemDto> source);

    @Mappings({
            @Mapping(target = "itemId", source = "id"),
            @Mapping(target = "itemCode", source = "code"),
            @Mapping(target = "itemName", source = "itemName"),
            @Mapping(target = "itemDescription", source = "description")
    })
    ItemDto mapToItemDto(Items source);

    @IterableMapping(elementTargetType = ItemDto.class)
    List<ItemDto> mapToItemDtoList(List<Items> source);
}
