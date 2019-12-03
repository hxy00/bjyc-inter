package com.bjyc.inter.controller;

import com.bjyc.inter.pojo.dto.ReturnObject;
import com.bjyc.inter.util.ToolsUtil;
import com.bjyc.inter.util.http.HttpBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/test", produces = "application/json; charset=UTF-8")
@RestController
public class TestController extends HttpBase {
    Logger logger = LoggerFactory.getLogger(getClass());
    private static final String REQ_URL = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9";
    private static final int PAGE_NUM = 1;
    private static final int PAGE_SIZE = 10;

    @RequestMapping("/testConnect")
    public String testConnect() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("retCode", "0");
        result.put("retMsg", "connect success.");


        return ToolsUtil.mapToJson(result);
    }


    @RequestMapping("/getFuLi")
    public ReturnObject getFuLi() {
        StringBuffer reqUrl = new StringBuffer(REQ_URL);
        reqUrl.append("/").append(PAGE_SIZE);
        reqUrl.append("/").append(PAGE_NUM);
        try {
            ReturnObject result = getExecute(reqUrl.toString(), new HashMap<String, Object>(), ReturnObject.class);
            logger.debug(result.toString());

            return result;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "数据获取失败：" + e.getMessage(), null, 0);
        }
    }

}
