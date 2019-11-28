package com.bjyc.inter.controller;

import com.bjyc.inter.util.ToolsUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/testConnect")
    public String testConnect() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("retCode", "0");
        result.put("retMsg", "connect success.");


        return ToolsUtil.mapToJson(result);
    }

}
