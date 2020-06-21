package com.timwang.weixin.zls.web;

import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.timwang.weixin.zls.web.server.Weixin4jServerStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wangjun
 * @date 2020-06-20
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(
    basePackages = {
        "com.foxinmy.weixin4j.mp",
        "com.foxinmy.weixin4j.payment",
        "com.timwang.weixin.zls.web.controller",
        "com.timwang.weixin.zls.web.config"
    }
)
public class WeixinWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeixinWebApplication.class, args);
    }

    @Bean(initMethod="start",destroyMethod="stop")
    public Weixin4jServerStartup weixin4jServerStartup() {
        return new Weixin4jServerStartup();
    }
}
