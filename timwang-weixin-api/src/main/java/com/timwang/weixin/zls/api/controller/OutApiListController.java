package com.timwang.weixin.zls.api.controller;

import com.timwang.weixin.zls.api.dto.OutApiListDTO;
import com.timwang.weixin.zls.api.helper.OutApiListHelper;
import com.timwang.weixin.zls.api.util.JsonReturn;
import com.timwang.weixin.zls.api.vo.OutApiListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
        List<OutApiListVO> voList = outApiListDTOS.stream().map(OutApiListVO::translate).collect(Collectors.toList());
        return JsonReturn.successInstance(voList);
    }

    @RequestMapping("/queryByName")
    public JsonReturn queryByName(@RequestParam("name") String name) {
        OutApiListDTO outApiListDTO = outApiListHelper.queryByMatchName(name);
        OutApiListVO outApiListVO = OutApiListVO.translate(outApiListDTO);
        return JsonReturn.successInstance(outApiListVO);
    }
}
