package com.jooq.feature.web.v1;

import com.jooq.core.rest.ApiResponse;
import com.jooq.feature.model.ItemDto;
import com.jooq.feature.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class ItemController {

    @Inject
    ItemService itemService;

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
    public ApiResponse<ItemDto> addItem(@ApiParam(value = "Item details", required = true) @RequestBody ItemDto dto) {
        ItemDto item = this.itemService.addItem(dto);
        return new ApiResponse<>(HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(item));
    }
}
