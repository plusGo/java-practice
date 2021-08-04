package com.henry.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CarDto {
    private String name;
    private Integer numberOfSet;
    private List<String> tags;
    private List<String> passengers;
    private String nullValue;
}
