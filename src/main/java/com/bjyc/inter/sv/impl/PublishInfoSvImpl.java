package com.bjyc.inter.sv.impl;

import com.bjyc.inter.dao.IPublishInfoMapper;
import com.bjyc.inter.pojo.dto.PublishInfoDto;
import com.bjyc.inter.sv.IPublishInfoSv;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PublishInfoSvImpl implements IPublishInfoSv {

    @Autowired
    private IPublishInfoMapper iPublishInfoMapper;

    @Override
    public PageInfo<?> getPublishInfoPage(PublishInfoDto publishInfoDto) throws Exception {
        PageHelper.startPage(publishInfoDto.getPageNum(), publishInfoDto.getPageSize());
        List<Map<String, Object>> records = iPublishInfoMapper.getListMap(publishInfoDto);
        return new PageInfo<>(records);
    }

    @Override
    public List<Map<String, Object>> getPublishInfoList(PublishInfoDto publishInfoDto) throws Exception {
        return iPublishInfoMapper.getListMap(publishInfoDto);
    }

    @Override
    public Map<String, Object> getPublishInfo(PublishInfoDto publishInfoDto) throws Exception {
        List<Map<String, Object>> records = iPublishInfoMapper.getListMap(publishInfoDto);
        return CollectionUtils.isEmpty(records) ? new HashMap<>() : records.get(0);
    }

    @Override
    public Integer save(PublishInfoDto publishInfoDto) throws Exception {
        return iPublishInfoMapper.save(publishInfoDto);
    }

    @Override
    public Integer delete(PublishInfoDto publishInfoDto) throws Exception {
        return iPublishInfoMapper.delete(publishInfoDto);
    }

}
