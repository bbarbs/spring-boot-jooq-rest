package com.jooq.feature.web.v1;

import com.jooq.core.rest.ApiResponse;
import com.jooq.feature.mapper.ItemMapper;
import com.jooq.feature.model.dto.ItemDto;
import com.jooq.feature.service.ItemService;
import com.jooq.my_schema.tables.pojos.Items;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class ItemController {

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ItemService itemService;

    /**
     * Get list of items.
     *
     * @return
     */
    @ApiOperation(
            value = "Get all items"
    )
    @GetMapping(
            value = "/items",
            produces = APPLICATION_JSON_VALUE
    )
    public List<ItemDto> getAllItems() {
        List<Items> items = this.itemService.getAllItems();
        return this.itemMapper.mapToItemDtoList(items);
    }

    /**
     * Add item.
     *
     * @param dto
     * @return
     */
    @ApiOperation(
            value = "Add new item"
    )
    @PostMapping(
            value = "/items",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ItemDto> addItem(@ApiParam(value = "Item details", required = true) @RequestBody ItemDto dto) {
        Items item = this.itemService.addItem(this.itemMapper.mapToItems(dto));
        return new ApiResponse<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(this.itemMapper.mapToItemDto(item))
        );
    }
}
