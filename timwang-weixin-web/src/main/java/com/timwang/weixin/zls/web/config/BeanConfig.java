package com.timwang.weixin.zls.web.config;

import com.foxinmy.weixin4j.cache.CacheStorager;
import com.foxinmy.weixin4j.cache.FileCacheStorager;
import com.foxinmy.weixin4j.model.WeixinAccount;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author wangjun
 * @date 2020-06-21
 */
@Configuration
public class BeanConfig {
    @Value("${weixin4j.server.weixinId}")
    private String weixinId;
    @Value("${weixin4j.server.token}")
    private String token;
    @Value("${weixin4j.server.aesKey}")
    private String aesKey;

    @Bean
    public WeixinProxy weixinProxy() {
        WeixinAccount weixinAccount = new WeixinAccount(weixinId, aesKey);
        return new WeixinProxy(weixinAccount, new FileCacheStorager<>(token));
    }
}
