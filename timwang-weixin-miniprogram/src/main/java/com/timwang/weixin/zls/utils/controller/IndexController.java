package com.timwang.weixin.zls.utils.controller;

import com.timwang.weixin.zls.utils.util.JsonReturn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjun
 * @date 2020-07-05
 */
@RestController
@RequestMapping("/mini/index")
public class IndexController {


    @RequestMapping("/echo")
    public JsonReturn echo(String msg) {
        return JsonReturn.successInstance("echo = " + msg);
    }

}
