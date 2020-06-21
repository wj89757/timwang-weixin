package com.timwang.weixin.zls.api.convertors;

import com.timwang.weixin.zls.api.dto.OutApiListDTO;
import com.timwang.weixin.zls.api.model.OutApiList;

/**
 * @author wangjun
 * @date 2020-06-20
 */
public class OutApiListConvertor {
    public static OutApiListDTO translate(OutApiList outApiList) {
        OutApiListDTO outApiListDTO = new OutApiListDTO();
        outApiListDTO.setId(outApiList.getId());
        outApiListDTO.setName(outApiList.getName());
        outApiListDTO.setLinkUrl(outApiList.getLinkUrl());
        outApiListDTO.setStatus(outApiList.getStatus());
        outApiListDTO.setCreateTime(outApiList.getCreateTime());
        outApiListDTO.setLinkUrl(outApiList.getLinkUrl());
        return outApiListDTO;
    }
}
