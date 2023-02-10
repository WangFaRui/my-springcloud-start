package com.wfr.springcloud.gateway;

import com.wfr.springcloud.gateway.filter.RequestTimeGatewayFilterFactory;
import com.wfr.springcloud.gateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    // http://localhost:5001/server/hi?token=1
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

}