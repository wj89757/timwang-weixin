package com.timwang.weixin.zls.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangjun
 * @date 2020-06-20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MiniProgramWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiniProgramWebApplication.class, args);
    }
}
