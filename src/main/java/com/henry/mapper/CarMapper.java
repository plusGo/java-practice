package com.henry.mapper;

import com.henry.model.Car;
import com.henry.model.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "setCount", target = "numberOfSet")
    @Mapping(source = "tags", target = "tags", qualifiedByName = "tagsToTags")
    @Mapping(source = "passengers", target = "passengers", qualifiedByName = "passengersToPassengers")
    CarDto carToCarDto(final Car car);

    @Named("tagsToTags")
    default List<String> tagsToTags(final String tags) {
        System.out.println(tags);
        return Optional.ofNullable(tags)
                .map(tagStr -> Arrays.asList(tags.split(",")))
                .orElse(null);
    }

    @Named("passengersToPassengers")
    default List<String> passengersToPassengers(final String passengers) {
        System.out.println(passengers);
        return Optional.ofNullable(passengers)
                .map(tagStr -> Arrays.asList(passengers.split("&")))
                .orElse(null);
    }
}
