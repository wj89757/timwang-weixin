package com.timwang.weixin.zls.web.handler;

import com.foxinmy.weixin4j.handler.MessageHandlerAdapter;
import com.foxinmy.weixin4j.message.VoiceMessage;
import com.foxinmy.weixin4j.response.TextResponse;
import com.foxinmy.weixin4j.response.WeixinResponse;
import org.springframework.stereotype.Component;

/**
 * 只处理语音消息
 *
 * @className VoiceMessageHandler
 * @author jinyu(foxinmy@gmail.com)
 * @date 2015年11月18日
 * @since JDK 1.6
 */
@Component
public class VoiceMessageHandler extends MessageHandlerAdapter<VoiceMessage> {

    @Override
    public WeixinResponse doHandle0(VoiceMessage message) {
        /**
         * 返回一段文字给用户
         */
        return new TextResponse("你讲了一句话");
    }
}
