package com.jooq.feature.mapper;

import com.jooq.feature.model.dto.AddressDto;
import com.jooq.my_schema.tables.pojos.Address;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AddressMapper {

    @Mappings({
            @Mapping(target = "id", source = "addressId"),
            @Mapping(target = "type", source = "addressType"),
            @Mapping(target = "address", source = "address")
    })
    Address mapToAddress(AddressDto source);

    @IterableMapping(elementTargetType = Address.class)
    List<Address> mapToAddressList(List<AddressDto> sources);

    @Mappings({
            @Mapping(target = "addressId", source = "id"),
            @Mapping(target = "addressType", source = "type"),
            @Mapping(target = "address", source = "address")
    })
    AddressDto mapToAddressDto(Address source);

    @IterableMapping(elementTargetType = AddressDto.class)
    List<AddressDto> mapToAddressDtoList(List<Address> sources);
}
