package com.timwang.weixin.zls;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangjun
 * @date 2020-06-20
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.timwang.weixin.zls.dao")
public class WeixinApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinApiApplication.class, args);
    }
}
