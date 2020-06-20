package com.timwang.weixin.zls.response;

import java.io.Serializable;

/**
 * @author wangjun
 * @date 2020-06-20
 */
public class TencentAIAnswer implements Serializable {
    private String ret;
    private String msg;
    private TecentAiAnswerItem data;

    public String getAnswer() {
        return data.getAnswer();
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public TecentAiAnswerItem getData() {
        return data;
    }

    public void setData(TecentAiAnswerItem data) {
        this.data = data;
    }
}
