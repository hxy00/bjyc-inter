package com.bjyc.inter.sv.impl;

import com.bjyc.inter.dao.IOriginAndDestMapper;
import com.bjyc.inter.pojo.dto.OriginAndDestDto;
import com.bjyc.inter.sv.IOriginAndDestSv;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OriginAndDestSvImpl implements IOriginAndDestSv {

    @Autowired
    private IOriginAndDestMapper iOriginAndDestMapper;

    @Override
    public PageInfo<?> getOriginAndDestPage(OriginAndDestDto originAndDestDto) throws Exception {
        PageHelper.startPage(originAndDestDto.getPageNum(), originAndDestDto.getPageSize());
        List<Map<String, Object>> records = iOriginAndDestMapper.getListMap(originAndDestDto);
        return new PageInfo<>(records);
    }

    @Override
    public List<Map<String, Object>> getOriginAndDestList(OriginAndDestDto originAndDestDto) throws Exception {
        return iOriginAndDestMapper.getListMap(originAndDestDto);
    }

    @Override
    public Map<String, Object> getOriginAndDest(OriginAndDestDto originAndDestDto) throws Exception {
        List<Map<String, Object>> records = iOriginAndDestMapper.getListMap(originAndDestDto);
        return CollectionUtils.isEmpty(records) ? new HashMap<>() : records.get(0);
    }

    @Override
    public Integer save(OriginAndDestDto originAndDestDto) throws Exception {
        return iOriginAndDestMapper.save(originAndDestDto);
    }

    @Override
    public Integer delete(OriginAndDestDto originAndDestDto) throws Exception {
        return iOriginAndDestMapper.delete(originAndDestDto);
    }
}
