package com.timwang.weixin.zls.web.controller;

import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.foxinmy.weixin4j.mp.model.Menu;
import com.timwang.weixin.zls.api.util.JsonReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weixinWeb/menu")
public class MenuController {
	@Autowired
	private WeixinProxy weixinProxy;

	@RequestMapping("/queryAll")
	public JsonReturn index() throws Exception {
        List<Menu> allMenu = weixinProxy.getAllMenu();
        return JsonReturn.successInstance(allMenu);
	}
}
