package com.wfr.springcloud.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局
 *
 * @author wangfarui
 * @since 2023/2/8
 */
@Configuration(proxyBeanMethods = false)
public class GlobalRouteLocator {

    private static final String HTTP_URI = "http://httpbin.org:80";;

    @Bean
    public RouteLocator pathRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(fn -> fn
                        .path("/get")
                        .filters(f -> f
                                .addRequestHeader("Hello", "World")
                                .addRequestParameter("num", "1")
                        )
                        .uri(HTTP_URI)
                ).build();
    }

    @Bean
    public RouteLocator hostRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(fn -> fn
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback"))
                        )
                        .uri(HTTP_URI)
                ).build();
    }
}
