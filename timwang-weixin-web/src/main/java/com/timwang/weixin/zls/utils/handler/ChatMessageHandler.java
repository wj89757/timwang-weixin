package com.timwang.weixin.zls.utils.handler;

import com.foxinmy.weixin4j.handler.WeixinMessageHandler;
import com.foxinmy.weixin4j.qy.chat.WeixinChatMessage;
import com.foxinmy.weixin4j.request.WeixinMessage;
import com.foxinmy.weixin4j.request.WeixinRequest;
import com.foxinmy.weixin4j.response.BlankResponse;
import com.foxinmy.weixin4j.response.WeixinResponse;

import java.util.Set;

public class ChatMessageHandler implements WeixinMessageHandler {
    @Override
    public boolean canHandle(WeixinRequest request, WeixinMessage message, Set<String> nodeNames) {
        return nodeNames.contains("PackageId");
    }

    public WeixinResponse doHandle(WeixinRequest request, WeixinMessage message) {
        // 转换为实体
        WeixinChatMessage chatMessage = null;
        return BlankResponse.global;
    }

    public int weight() {
        return 0;
    }
}
