package com.tzword.gateway.config;

import lombok.Data;

import java.time.LocalTime;

/**
 * @author jianghy
 * @Description:
 * @date 2021/4/17 21:35
 */
@Data
public class TimeBetweenConfig {
    private LocalTime start;
    private LocalTime end;
}
