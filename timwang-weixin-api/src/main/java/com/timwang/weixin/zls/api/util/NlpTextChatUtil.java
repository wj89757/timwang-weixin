package com.timwang.weixin.zls.api.util;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import com.google.common.collect.Maps;
import com.timwang.weixin.zls.api.config.NacosConfig;
import com.timwang.weixin.zls.api.constants.TecentAiConstants;
import com.timwang.weixin.zls.api.response.TencentAIAnswer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author wangjun
 * @date 2020-06-20
 */
public class NlpTextChatUtil {
    private static String ERROR_MSG = "我病了，现在不能回答你任何问题哦~";
    private static Logger logger = LoggerFactory.getLogger(NlpTextChatUtil.class);

    public static String getAiAnswer(String question) {
        String result;
        Map<String, Object> params = Maps.newHashMap();

        try {
            params.put("app_id", TecentAiConstants.TECENT_AI_OPEN_PLATFORM_API_ID);
            params.put("time_stamp", System.currentTimeMillis() / 1000 + "");
            params.put("nonce_str", RandomUtil.randomString(16));
            params.put("session", RandomUtil.randomString(16));
            params.put("question", question);
            params.put("sign", SignUtil.getSignature(params, TecentAiConstants.TECENT_AI_OPEN_PLATFORM_API_KEY));
            String rel = HttpUtil.post(TecentAiConstants.TECENT_AI_OPEN_PLATFORM_NLP_TEXTCHAT, params);
            if (StringUtils.isEmpty(rel)) {
                return ERROR_MSG;
            }
            TencentAIAnswer answer = JsonUtils.fromJson(rel, TencentAIAnswer.class);
            if (answer == null || !"0".equals(answer.getRet())) {
                return ERROR_MSG;
            }
            result = answer.getAnswer();
        } catch (Exception e) {
            logger.error("get ai answer ex", e);
            return ERROR_MSG;
        }
        return result;
    }
}
