package com.timwang.weixin.zls.controller;

import com.timwang.weixin.zls.dto.OutApiListDTO;
import com.timwang.weixin.zls.helper.OutApiListHelper;
import com.timwang.weixin.zls.util.JsonReturn;
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
