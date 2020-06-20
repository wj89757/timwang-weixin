package com.timwang.weixin.zls.helper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.timwang.weixin.zls.convertors.OutApiListConvertor;
import com.timwang.weixin.zls.dao.OutApiListMapper;
import com.timwang.weixin.zls.dto.OutApiListDTO;
import com.timwang.weixin.zls.model.OutApiList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutApiListHelper {

    @Autowired
    private OutApiListMapper outApiListMapper;

    public List<OutApiListDTO> queryAll() {
        LambdaQueryWrapper<OutApiList> queryWrapper = new LambdaQueryWrapper<OutApiList>()
                .eq(OutApiList::getStatus, 1);
        Collection<OutApiList> demands = outApiListMapper.selectList(queryWrapper);
        return demands.stream().map(OutApiListConvertor::translate).collect(Collectors.toList());
    }

}
