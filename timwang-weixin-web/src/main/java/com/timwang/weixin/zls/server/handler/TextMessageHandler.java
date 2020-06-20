package com.timwang.weixin.zls.server.handler;

import com.timwang.weixin.zls.util.JsonUtils;
import com.timwang.weixin.zls.util.NlpTextChatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.foxinmy.weixin4j.handler.MessageHandlerAdapter;
import com.foxinmy.weixin4j.message.TextMessage;
import com.foxinmy.weixin4j.request.WeixinRequest;
import com.foxinmy.weixin4j.response.TextResponse;
import com.foxinmy.weixin4j.response.WeixinResponse;

/**
 * 文本消息处理
 *
 * @className TextMessageHandler
 * @author jinyu(foxinmy@gmail.com)
 * @date 2015年11月18日
 * @since JDK 1.6
 */
@Component
public class TextMessageHandler extends MessageHandlerAdapter<TextMessage> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public WeixinResponse doHandle0(TextMessage message) {
        logger.info("message info = " + JsonUtils.toJson(message));
        String aiAnswer = NlpTextChatUtil.getAiAnswer(message.getContent());
        return new TextResponse(aiAnswer);
    }
}
