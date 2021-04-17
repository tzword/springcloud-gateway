package com.tzword.gateway;

import com.tzword.gateway.config.TimeBetweenConfig;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author jianghy
 * @Description:
 * @date 2021/4/17 21:34
 */
@Component
public class TimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeBetweenConfig> {

    public TimeBetweenRoutePredicateFactory() {
        super(TimeBetweenConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(TimeBetweenConfig config) {
        LocalTime start = config.getStart();
        LocalTime end = config.getEnd();
        return exchange -> {
            LocalTime now = LocalTime.now();
            return now.isAfter(start) && now.isBefore(end);
        };
    }

    /**
     * @Description: 控制配置类和配置文件的映射关系
     * @param  1
     * @return java.util.List<java.lang.String>
     * @throws
     * @author jianghy
     * @date 2021/4/17 21:42
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("start","end");
    }
}
