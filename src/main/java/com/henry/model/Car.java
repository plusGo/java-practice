package com.henry.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Car {
    private String name;
    private Integer setCount;
    private String tags;
    private String passengers;
    private String nullValue;
}
