package com.timwang.weixin.zls.utils.config;

import com.foxinmy.weixin4j.cache.FileCacheStorager;
import com.foxinmy.weixin4j.model.WeixinAccount;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.timwang.weixin.zls.utils.handler.ApiListTextMessageHandler;
import com.timwang.weixin.zls.utils.handler.ChatMessageHandler;
import com.timwang.weixin.zls.utils.handler.CustomMessageHandler;
import com.timwang.weixin.zls.utils.handler.HelloMessageHandler;
import com.timwang.weixin.zls.utils.handler.SubscribeMessageHandler;
import com.timwang.weixin.zls.utils.handler.TextMessageHandler;
import com.timwang.weixin.zls.utils.handler.VoiceMessageHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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

    @Bean
    public ApiListTextMessageHandler apiListTextMessageHandler() {
        return new ApiListTextMessageHandler();
    }

    @Bean
    public ChatMessageHandler chatMessageHandler() {
        return new ChatMessageHandler();
    }

    @Bean
    public CustomMessageHandler customMessageHandler() {
        return new CustomMessageHandler();
    }

    @Bean
    public HelloMessageHandler helloMessageHandler() {
        return new HelloMessageHandler();
    }

    @Bean
    public SubscribeMessageHandler subscribeMessageHandler() {
        return new SubscribeMessageHandler();
    }

    @Bean
    public TextMessageHandler textMessageHandler() {
        return new TextMessageHandler();
    }

    @Bean
    public VoiceMessageHandler voiceMessageHandler() {
        return new VoiceMessageHandler();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
