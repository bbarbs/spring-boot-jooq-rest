package com.jooq.feature.mapper;

import com.jooq.feature.model.dto.CustomerDto;
import com.jooq.my_schema.tables.pojos.Customer;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CustomerMapper {

    @Mappings({
            @Mapping(target = "id", source = "customerId"),
            @Mapping(target = "firstname", source = "firstname"),
            @Mapping(target = "lastname", source = "lastname")
    })
    Customer mapToCustomer(CustomerDto source);

    @IterableMapping(elementTargetType = Customer.class)
    List<Customer> mapToCustomerList(List<CustomerDto> sources);

    @Mappings({
            @Mapping(target = "customerId", source = "id"),
            @Mapping(target = "firstname", source = "firstname"),
            @Mapping(target = "lastname", source = "lastname")
    })
    CustomerDto mapToCustomerDto(Customer source);

    @IterableMapping(elementTargetType = CustomerDto.class)
    List<CustomerDto> mapToCustomerDtoList(List<Customer> sources);
}
