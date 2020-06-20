package com.timwang.weixin.zls.util;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author wangjun
 * @date 2020-06-20
 */
public class SignUtil {
    private static Logger logger = LoggerFactory.getLogger(NlpTextChatUtil.class);

    public static String getSignature(Map<String, Object> params, String config) {
        try {
            Map<String, Object> sortedParams = new TreeMap<>(params);
            Set<Map.Entry<String, Object>> entrys = sortedParams.entrySet();
            StringBuilder baseString = new StringBuilder();
            for (Map.Entry<String, Object> param : entrys) {
                if (param.getValue() != null && !"".equals(param.getKey().trim()) && !"sign".equals(param.getKey().trim()) && !"".equals(param.getValue().toString().trim())) {
                    baseString.append(param.getKey().trim()).append("=").append(URLEncoder.encode(param.getValue().toString().trim(), "UTF-8")).append("&");
                }
            }
            if (baseString.length() > 0) {
                baseString.deleteCharAt(baseString.length() - 1).append("&app_key=").append(config);
            }
            return MD5Util.getMD5(baseString.toString());
        } catch (Exception e) {
            logger.error("get sign ex", e);
            return "";
        }
    }
}
