package com.timwang.weixin.zls.model;

import java.io.Serializable;

/**
 * @author wangjun
 * @date 2020-06-20
 */
public class User implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
