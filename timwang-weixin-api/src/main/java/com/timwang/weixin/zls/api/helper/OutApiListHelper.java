package com.timwang.weixin.zls.api.helper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.timwang.weixin.zls.api.convertors.OutApiListConvertor;
import com.timwang.weixin.zls.api.dao.OutApiListMapper;
import com.timwang.weixin.zls.api.dto.OutApiListDTO;
import com.timwang.weixin.zls.api.model.OutApiList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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

    public OutApiListDTO queryByMatchName(String name) {
        LambdaQueryWrapper<OutApiList> queryWrapper = new LambdaQueryWrapper<OutApiList>()
                .eq(OutApiList::getStatus, 1)
                .eq(OutApiList::getMatchName, name);
        List<OutApiList> outApiLists = outApiListMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(outApiLists)) {
            return null;
        }
        return OutApiListConvertor.translate(outApiLists.get(0));
    }

}
