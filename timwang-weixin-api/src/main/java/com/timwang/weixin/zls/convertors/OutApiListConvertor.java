package com.timwang.weixin.zls.convertors;

import com.timwang.weixin.zls.dto.OutApiListDTO;
import com.timwang.weixin.zls.model.OutApiList;

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
        return outApiListDTO;
    }
}
