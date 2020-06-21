package com.timwang.weixin.zls.web.controller;

import com.timwang.weixin.zls.api.util.JsonReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foxinmy.weixin4j.mp.WeixinProxy;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private WeixinProxy weixinProxy;

	@RequestMapping("/index")
	public JsonReturn index() {
		return JsonReturn.successInstance("测试");
	}
	@RequestMapping("/test")
	@ResponseBody
	public JsonReturn test() {
		return null;
	}

}
