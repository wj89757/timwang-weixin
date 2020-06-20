package com.timwang.weixin.zls.response;

import java.io.Serializable;

/**
 * @author wangjun
 * @date 2020-06-20
 */
public class TecentAiAnswerItem implements Serializable {
    private String session;
    private String answer;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
