package com.jooq.feature.mapper;

import com.jooq.feature.model.dto.PassportDto;
import com.jooq.my_schema.tables.pojos.Passport;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PassportMapper {

    @Mappings({
            @Mapping(target = "id", source = "passportId"),
            @Mapping(target = "passportNumber", source = "passportNumber"),
    })
    Passport mapToPassport(PassportDto source);

    @IterableMapping(elementTargetType = Passport.class)
    List<Passport> mapToPassportList(List<PassportDto> sources);

    @Mappings({
            @Mapping(target = "passportId", source = "id"),
            @Mapping(target = "passportNumber", source = "passportNumber")
    })
    PassportDto mapToPassportDto(Passport source);

    @IterableMapping(elementTargetType = PassportDto.class)
    List<PassportDto> mapToPassportDtoList(List<Passport> sources);
}
