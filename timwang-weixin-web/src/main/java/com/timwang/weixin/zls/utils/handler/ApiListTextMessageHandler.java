package com.timwang.weixin.zls.utils.handler;

import cn.hutool.http.HttpUtil;
import com.foxinmy.weixin4j.message.TextMessage;
import com.foxinmy.weixin4j.request.WeixinRequest;
import com.foxinmy.weixin4j.response.TextResponse;
import com.foxinmy.weixin4j.response.WeixinResponse;
import com.google.common.collect.Maps;
import com.timwang.weixin.zls.api.util.JsonReturn;
import com.timwang.weixin.zls.api.util.JsonUtils;
import com.timwang.weixin.zls.api.vo.OutApiListVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Component
public class ApiListTextMessageHandler extends TextMessageHandler {
    @Autowired
    private RestTemplate restTemplate;
    private static Logger logger = LoggerFactory.getLogger(ApiListTextMessageHandler.class);

    @Override
    public boolean canHandle0(WeixinRequest request, TextMessage message) {
        JsonReturn result = restTemplate.getForObject("http://timwang-weixin-api/weixin/outApiList/queryAll", JsonReturn.class);
        if (result == null || !result.isSuccess()) {
            return false;
        }
        logger.info("====== api list = " + JsonUtils.toJson(result));
        List<OutApiListVO> apiList = JsonUtils.fromJsonArray(result.getData().toString(), OutApiListVO.class);
        logger.info("api list = " + JsonUtils.toJson(apiList));
        List<String> nameList = apiList.stream().map(OutApiListVO::getName).collect(Collectors.toList());
        return nameList.contains(message.getContent());
    }

    @Override
    public WeixinResponse doHandle0(TextMessage message) {
       try {
           Map<String, Object> uriVariables = Maps.newHashMap();
           uriVariables.put("name", message.getContent());
           JsonReturn result = restTemplate.getForObject("http://timwang-weixin-api/weixin/outApiList/queryByName", JsonReturn.class, uriVariables);
           logger.info("result = " + result);
           if (result == null || !result.isSuccess()) {
               return new TextResponse("出bug了。。你找小王");
           }
           OutApiListVO outApiListDTO = JsonUtils.fromJson(result.getData().toString(), OutApiListVO.class);
           if (outApiListDTO == null) {
               return new TextResponse("出bug了。。你找小王");
           }
           if (outApiListDTO.getId().equals(4)) {
               String linkUrl = outApiListDTO.getLinkUrl();
               String requestUrl = String.format(linkUrl, message.getContent());
               String returnResult = HttpUtil.get(requestUrl);
               return new TextResponse(returnResult);
           }
           return new TextResponse(HttpUtil.get(outApiListDTO.getLinkUrl()));
       } catch (Exception e) {
           logger.error("text response ex", e);
           return new TextResponse("出bug了。。你找小王");
       }
    }

    @Override
    public int weight() {
        return super.weight() + 2;
    }
}
