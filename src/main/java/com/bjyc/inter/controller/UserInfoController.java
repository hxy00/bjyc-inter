package com.bjyc.inter.controller;

import com.alibaba.fastjson.JSONObject;
import com.bjyc.inter.pojo.dto.ReturnObject;
import com.bjyc.inter.pojo.dto.UserInfoDto;
import com.bjyc.inter.sv.IUserInfoSv;
import com.bjyc.inter.util.http.HttpRequest;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = "/user", produces = "application/json; charset=UTF-8")
public class UserInfoController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserInfoSv iUserInfoSv;

    /**
     * 获取openId
     * @param code
     * @return
     */
    @RequestMapping(value = "/getOpenId")
    public ReturnObject getOpenId(@RequestParam("code") String code){
        if (code == null || code.length() == 0) {
            logger.error("code参数为空");
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "参数为空", null, 1);
        }
        try {
            //小程序唯一标识   (在微信小程序管理后台获取)
            String appId = "wx2308094fa8c1c0cf";
            //小程序的 app secret (在微信小程序管理后台获取)
            String appSecret = "dd5678f3c7509561159beee1da97c5ef";
            //授权（必填）
            String grant_type = "authorization_code";

            //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
            //请求参数
            String params = "appid=" + appId + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=" + grant_type;
            //发送请求
            String result = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
            //解析相应内容（转换成json对象）
            JSONObject json = JSONObject.parseObject(result);
            return new ReturnObject(ReturnObject.SuccessEnum.success, "获取openId成功", json, 1);
        } catch (Exception e) {
            logger.error("获取openId出错：" + e.getMessage());
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "获取openId出错：" + e.getMessage(), null, 1);
        }
    }

    /**
     * 用户注册
     * @param userInfoDto
     * @return
     */
    @RequestMapping("/register")
    public ReturnObject register(@Valid UserInfoDto userInfoDto) {
        if (null == userInfoDto) {
            logger.error("用户参数为空");
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "用户参数为空", userInfoDto, 1);
        }
        String openId = userInfoDto.getOpenId();
        if (StringUtil.isEmpty(openId)) {
            logger.error("openId参数为空");
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "openId参数为空", userInfoDto, 1);
        }
        //查询数据库中该openid是否存在
        Map<String, Object> userMap = null;
        try {
            userMap = iUserInfoSv.queryOpenIdIsExist(openId);
        } catch (Exception e) {
            logger.error("查询数据是否存在出错:{}", e.getMessage());
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "查询数据出错:" + e.getMessage(), userInfoDto, 1);
        }

        if (MapUtils.isEmpty(userMap)) { //用户openid未存在
            try {
                int retInt = iUserInfoSv.saveUserInfo(userInfoDto);
                logger.info("保存用户信息，返回：" + retInt);
                if (retInt > 0) {
                    return new ReturnObject(ReturnObject.SuccessEnum.success, "用户注册成功", userInfoDto, 1);
                }
            } catch (Exception e) {
                logger.error("保存用户数据出错：" + e.getMessage());
                return new ReturnObject(ReturnObject.SuccessEnum.fail, "用户注册失败：" + e.getMessage(), userInfoDto, 1);
            }
        } else { // 存在
            try {
                iUserInfoSv.update(userInfoDto);
                return new ReturnObject(ReturnObject.SuccessEnum.success, "用户注册成功", userInfoDto, 1);
            } catch (Exception e) {
                logger.error("修改用户数据出错：" + e.getMessage());
                return new ReturnObject(ReturnObject.SuccessEnum.fail, "用户注册失败：" + e.getMessage(), userInfoDto, 1);
            }
        }
        return new ReturnObject(ReturnObject.SuccessEnum.fail, "用户注册失败", userInfoDto, 1);
    }

    /**
     * 获取用户信息
     * @param userInfoDto
     * @return
     */
    @RequestMapping("/getUserInfoPage")
    public ReturnObject getUserInfoPage(@Valid UserInfoDto userInfoDto) {
        try {
            PageInfo<?> pageInfo = iUserInfoSv.getUserInfoPage(userInfoDto);
            return new ReturnObject(ReturnObject.SuccessEnum.success, "获取数据获取成功", pageInfo, 1);
        } catch (Exception e) {
            logger.error("获取用户数据失败：" + e.getMessage());
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "获取数据获取失败：" + e.getMessage(), null, 1);
        }
    }

    /**
     * 保存用户信息（暂无用）
     * @param userInfoDto
     * @return
     */
    @RequestMapping("/saveUserInfo")
    public ReturnObject saveUserInfo(@Valid UserInfoDto userInfoDto) {
        if (null == userInfoDto || StringUtil.isEmpty(userInfoDto.getNickName()))
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "保存用户数据失败：参数为空", 0, 1);

        try {
            int retInt = iUserInfoSv.saveUserInfo(userInfoDto);
            if (retInt > 0) {
                return new ReturnObject(ReturnObject.SuccessEnum.success, "保存用户数据成功", retInt, 1);
            } else {
                return new ReturnObject(ReturnObject.SuccessEnum.fail, "保存用户数据失败", retInt, 1);
            }
        } catch (Exception e) {
            logger.error("保存用户数据失败：" + e.getMessage());
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "保存用户数据失败：" + e.getMessage(), 0, 1);
        }
    }

}
