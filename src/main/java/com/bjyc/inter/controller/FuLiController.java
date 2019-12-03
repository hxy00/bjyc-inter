package com.bjyc.inter.controller;

import com.alibaba.fastjson.JSON;
import com.bjyc.inter.pojo.dto.ReturnObject;
import com.bjyc.inter.util.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/fuli", produces = "application/json; charset=UTF-8")
public class FuLiController {
    Logger logger = LoggerFactory.getLogger(getClass());
    private static final String REQ_URL = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9";
    private static final int PAGE_SIZE = 10;

    @RequestMapping("/getFuLi")
    public ReturnObject getFuLi(int pageNum) {
        StringBuffer reqUrl = new StringBuffer(REQ_URL);
        reqUrl.append("/").append(PAGE_SIZE);
        reqUrl.append("/").append(pageNum);
        try {
            String result = HttpRequest.sendGet(reqUrl.toString(), null);
            logger.debug(result);

            Map row = JSON.parseObject(result, Map.class);
            List<Map<String, Object>> lst = (List<Map<String, Object>>) row.get("results");

            return new ReturnObject(ReturnObject.SuccessEnum.success, "数据获取成功", lst, 0);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return new ReturnObject(ReturnObject.SuccessEnum.fail, "数据获取失败", null, 0);
    }

}
