package com.timwang.weixin.zls.web.server.handler;

import java.util.Set;

import com.foxinmy.weixin4j.handler.WeixinMessageHandler;
import com.foxinmy.weixin4j.qy.chat.WeixinChatMessage;
import com.foxinmy.weixin4j.request.WeixinMessage;
import com.foxinmy.weixin4j.request.WeixinRequest;
import com.foxinmy.weixin4j.response.BlankResponse;
import com.foxinmy.weixin4j.response.WeixinResponse;

public class ChatMessageHandler implements WeixinMessageHandler {

    public boolean canHandle(WeixinRequest request, WeixinMessage message, Set<String> nodeNames) {
        return nodeNames.contains("PackageId");
    }

    public WeixinResponse doHandle(WeixinRequest request, WeixinMessage message) {
        WeixinChatMessage chatMessage = null; // 转换为实体
        return BlankResponse.global;
    }

    public int weight() {
        return 0;
    }
}
