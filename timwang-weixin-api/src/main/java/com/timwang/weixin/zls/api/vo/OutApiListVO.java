package com.timwang.weixin.zls.api.vo;

import cn.hutool.core.date.DateUtil;
import com.timwang.weixin.zls.api.dto.OutApiListDTO;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangjun
 * @date 2020-06-21
 */
public class OutApiListVO implements Serializable {
    private Integer id;
    private String name;
    private String matchName;
    private String linkUrl;
    private Integer status;
    private String createTime;

    public static OutApiListVO translate(OutApiListDTO outApiListDTO) {
        OutApiListVO outApiListVO = new OutApiListVO();
        outApiListVO.setId(outApiListDTO.getId());
        outApiListVO.setName(outApiListDTO.getName());
        outApiListVO.setMatchName(outApiListDTO.getMatchName());
        outApiListVO.setLinkUrl(outApiListDTO.getLinkUrl());
        outApiListVO.setStatus(outApiListDTO.getStatus());
        outApiListVO.setCreateTime(DateUtil.formatTime(outApiListDTO.getCreateTime()));
        return outApiListVO;
    }

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

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
