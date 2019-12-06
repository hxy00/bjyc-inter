package com.bjyc.inter.sv;

import com.bjyc.inter.pojo.dto.UserInfoDto;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface IUserInfoSv {

    PageInfo<?> getUserInfoPage(UserInfoDto userInfoDto) throws Exception ;

    Map<String, Object> getUserInfo(UserInfoDto userInfoDto) throws Exception ;

    Integer saveUserInfo(UserInfoDto userInfoDto) throws Exception ;

    Map<String, Object> queryOpenIdIsExist(String openId) throws Exception;

    Integer update(UserInfoDto userInfoDto) throws Exception ;
}
