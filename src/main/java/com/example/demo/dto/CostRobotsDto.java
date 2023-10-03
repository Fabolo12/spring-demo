package com.example.demo.dto;

import lombok.Getter;

@Getter
public class CostRobotsDto {
    private final Long count;
    private final Long cost;

    public CostRobotsDto(final Long count, final Long cost) {
        this.count = count;
        this.cost = cost;
    }
}
