package com.bjyc.inter.util.http;

import com.alibaba.fastjson.JSONObject;
import com.bjyc.inter.pojo.dto.ReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * http请求远程接口
 *
 * @author Mr.Huang
 */
public class HttpBase {
    private static Logger logger = LoggerFactory.getLogger(com.rms.base.http.HttpBase.class);

    @Autowired(required = true)
    private RestTemplate restTemplate;

    /**
     * http post请求远程接口，返回规定类型对象
     *
     * @param url
     * @param request
     * @param responseType
     * @param <T>
     * @return
     * @throws Exception
     */
    protected <T> T postExecute(String url, Object request, Class<T> responseType) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, String> multiValueMap = buildMultiValueMap(request);

        HttpEntity<MultiValueMap<String, String>> testRequest = new HttpEntity<MultiValueMap<String, String>>(multiValueMap, headers);
        String responseStr = restTemplate.postForObject(url, JSONObject.toJSONString(request), String.class);
        JSONObject json = JSONObject.parseObject(responseStr);
        return JSONObject.toJavaObject(json, responseType);
    }

    /**
     * 组装请求参数
     *
     * @param obj
     * @return
     * @throws Exception
     */
    private MultiValueMap<String, String> buildMultiValueMap(Object obj) throws Exception {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (!key.equals("class")) {
                Method getter = property.getReadMethod();
                Object value = getter.invoke(obj);
                List<String> valueList = new ArrayList<String>();
                valueList.add(value == null ? "" : value.toString());
                multiValueMap.put(key, valueList);
            }
        }
        return multiValueMap;
    }

    /**
     * http post返回ReturnObject
     *
     * @param url
     * @param uriVariables
     * @return
     */
    protected ReturnObject postExecute(String url, Object... uriVariables) {
        try {
            ReturnObject returnObject = restTemplate.postForObject(url, null, ReturnObject.class, uriVariables);
            return returnObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
