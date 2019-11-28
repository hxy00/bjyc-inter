package com.bjyc.inter.dao;

import com.bjyc.inter.pojo.dto.UserInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface IUserInfoMapper {

    List<Map<String, Object>> getListMap(@Param("userInfoDto") UserInfoDto userInfoDto);

    Integer saveUserInfo(@Param("userInfoDto") UserInfoDto userInfoDto);
}
