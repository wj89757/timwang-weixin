package com.timwang.weixin.zls.web.controller;

import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.foxinmy.weixin4j.mp.message.NotifyMessage;
import com.foxinmy.weixin4j.tuple.NotifyTuple;
import com.foxinmy.weixin4j.tuple.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin")
public class WeixinController {
	/**
	 * 注解微信接口实现类
	 */
	@Autowired
	private WeixinProxy weixinProxy;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@ResponseBody
	@RequestMapping("/notify")
	public String sendNotify() throws WeixinException {
		NotifyTuple tuple = new Text("hello world");
		NotifyMessage notify = new NotifyMessage("用户openid", tuple);
		weixinProxy.sendNotify(notify);
		return "success";
	}
}
