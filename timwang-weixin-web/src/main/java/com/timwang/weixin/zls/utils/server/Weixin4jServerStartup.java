package com.timwang.weixin.zls.utils.server;

import com.foxinmy.weixin4j.handler.DebugMessageHandler;
import com.foxinmy.weixin4j.logging.InternalLoggerFactory;
import com.foxinmy.weixin4j.spring.SpringBeanFactory;
import com.foxinmy.weixin4j.startup.WeixinServerBootstrap;
import com.foxinmy.weixin4j.util.AesToken;
import com.timwang.weixin.zls.utils.handler.ApiListTextMessageHandler;
import com.timwang.weixin.zls.utils.handler.ChatMessageHandler;
import com.timwang.weixin.zls.utils.handler.CustomMessageHandler;
import com.timwang.weixin.zls.utils.handler.HelloMessageHandler;
import com.timwang.weixin.zls.utils.handler.SubscribeMessageHandler;
import com.timwang.weixin.zls.utils.handler.TextMessageHandler;
import com.timwang.weixin.zls.utils.handler.VoiceMessageHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class Weixin4jServerStartup implements ApplicationContextAware {
	@Value("${weixin4j.server.port}")
	private int port;
	@Value("${weixin4j.server.weixinId}")
	private String weixinId;
	@Value("${weixin4j.server.token}")
	private String token;
	@Value("${weixin4j.server.aesKey}")
	private String aesKey;
	@Value("${weixin4j.server.handlerPackage}")
	private String handlerPackage;

	private ApplicationContext applicationContext;

	@Autowired
	private ApiListTextMessageHandler apiListTextMessageHandler;
	@Autowired
	private ChatMessageHandler chatMessageHandler;
	@Autowired
	private CustomMessageHandler customMessageHandler;
	@Autowired
	private HelloMessageHandler helloMessageHandler;
	@Autowired
	private SubscribeMessageHandler subscribeMessageHandler;
	@Autowired
	private TextMessageHandler textMessageHandler;
	@Autowired
	private VoiceMessageHandler voiceMessageHandler;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	private ExecutorService executor;

	public void start() {
		AesToken aesToken = new AesToken(weixinId, token, aesKey);
		executor = Executors.newCachedThreadPool();
		executor.execute(new Runnable() {
			@Override
			public void run() {
				try {
						new WeixinServerBootstrap(aesToken)
							.handlerPackagesToScan(handlerPackage)
							.resolveBeanFactory(new SpringBeanFactory(applicationContext))
							.addHandler(DebugMessageHandler.global)
							.addHandler(apiListTextMessageHandler)
							.addHandler(chatMessageHandler)
							.addHandler(customMessageHandler)
							.addHandler(helloMessageHandler)
							.addHandler(subscribeMessageHandler)
							.addHandler(textMessageHandler)
							.addHandler(voiceMessageHandler)
							.openAlwaysResponse().startup(port);
				} catch (Exception e) {
					InternalLoggerFactory.getInstance(getClass()).error("weixin4j server startup:FAIL", e);
				}
			}
		});
	}

	public void stop() {
		executor.shutdown();
	}
}
