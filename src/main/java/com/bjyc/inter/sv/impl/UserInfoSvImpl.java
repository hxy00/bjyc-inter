package com.bjyc.inter.sv.impl;

import com.bjyc.inter.dao.IUserInfoMapper;
import com.bjyc.inter.pojo.dto.UserInfoDto;
import com.bjyc.inter.sv.IUserInfoSv;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoSvImpl implements IUserInfoSv {

    @Autowired
    private IUserInfoMapper iUserInfoMapper;

    @Override
    public PageInfo<?> getUserInfoPage(UserInfoDto userInfoDto) {
        PageHelper.startPage(userInfoDto.getPageNum(), userInfoDto.getPageSize());
        List<Map<String, Object>> records = iUserInfoMapper.getListMap(userInfoDto);
        return new PageInfo<>(records);
    }

    @Override
    public Map<String, Object> getUserInfo(UserInfoDto userInfoDto) {
        List<Map<String, Object>> records = iUserInfoMapper.getListMap(userInfoDto);
        return CollectionUtils.isEmpty(records) ? new HashMap<>() : records.get(0);
    }

    @Override
    public Integer saveUserInfo(UserInfoDto userInfoDto) throws Exception {
        Map<String, Object> row = getUserInfo(userInfoDto);
        if (MapUtils.isEmpty(row))
            return iUserInfoMapper.saveUserInfo(userInfoDto);
        else
            throw new Exception("数据已存在");
    }

    @Override
    public Map<String, Object> queryOpenIdIsExist(String openId) {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setOpenId(openId);
        Map<String, Object> row = getUserInfo(userInfoDto);
        return row;
    }
}
