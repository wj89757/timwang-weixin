package com.timwang.weixin.zls.api.controller;

import com.timwang.weixin.zls.api.dto.OutApiListDTO;
import com.timwang.weixin.zls.api.helper.OutApiListHelper;
import com.timwang.weixin.zls.api.util.JsonReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangjun
 * @date 2020-06-20
 */
@RestController
@RequestMapping("/weixin/outApiList")
public class OutApiListController {
    @Autowired
    private OutApiListHelper outApiListHelper;

    @RequestMapping("/queryAll")
    public JsonReturn queryAll() {
        List<OutApiListDTO> outApiListDTOS = outApiListHelper.queryAll();
        return JsonReturn.successInstance(outApiListDTOS);
    }
}
