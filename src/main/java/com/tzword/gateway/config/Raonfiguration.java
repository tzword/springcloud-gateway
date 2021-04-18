package com.tzword.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author jianghy
 * @Description:
 * @date 2021/4/18 21:15
 */
@Configuration
public class Raonfiguration {
    /**
     * 按照Path限流
     *
     * @return key
     */
    @Bean
    public KeyResolver pathKeyResolver() {
        return exchange -> Mono.just(
                exchange.getRequest()
                        .getPath()
                        .toString()
        );
    }
}
