package com.wfr.springcloud.gateway.predicate;

import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteDefinitionRouteLocator;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;

/**
 * 基于{@link RoutePredicateFactory}的理解示例
 *
 * @see RouteDefinitionRouteLocator#lookup 
 *
 * @author wangfarui
 * @since 2023/2/9
 */
public class RoutePredicateFactoryDemo implements RoutePredicateFactory<String> {

    public static void main(String[] args) {
        // RoutePredicateFactory作为一个FunctionalInterface，
        // 抽象方法为Predicate<ServerWebExchange> apply(C config);

        /** 
         * predicate在初始化时，都会经过{@link RoutePredicateFactory#applyAsync}
         */
    }

    @Override
    public Predicate<ServerWebExchange> apply(String config) {
        // String config 中的String类型对应的就是范型C，
        // 也就是RoutePredicateFactory继承的接口Configurable的configClass属性。

        // 返回是否可匹配
        return t -> t.getRequest().getQueryParams().containsKey(config);
    }
}
