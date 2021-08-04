package com.henry;

import com.henry.mapper.CarMapper;
import com.henry.model.Car;
import com.henry.model.CarDto;
import org.junit.jupiter.api.Test;
import com.google.common.collect.ImmutableList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTest {

    @Test
    void should_basic_map() {
        // given
        final Car car = Car.builder()
                .name("test")
                .setCount(2)
                .tags("java,web,css")
                .passengers("张三&李四&王五")
                .build();

        // when
        final CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

        // then
        System.out.print(carDto.toString());
        assertEquals(carDto.getTags(), ImmutableList.of("java", "web", "css"));
    }
}
