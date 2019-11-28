package com.bjyc.inter.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.List;
import java.util.Map;

public class JSONUtil {
    public static final SerializerFeature[] DEFAULT_FORMAT;

    private JSONUtil() {
    }

    public static Object getStringFromJSONObject(final String json, final String key) {
        return JSON.parseObject(json).getString(key);
    }

    public static JSONObject getJSONFromString(final String jsonString) {
        return JSON.parseObject(jsonString);
    }

    public static <T> T toBean(String jsonStr, Class<T> beanClass) {
        return JSON.parseObject(jsonStr, beanClass);
    }

    public static <T> T toBean(String jsonStr, TypeReference<T> type) {
        return JSON.parseObject(jsonStr, type, new Feature[0]);
    }

    public static <T> List<T> toBeans(String jsonStr, Class<T> beanClass) {
        return JSON.parseArray(jsonStr, beanClass);
    }

    public static <T> String toJson(T obj) {
        return JSON.toJSONString(obj, DEFAULT_FORMAT);
    }

    public static <T> String toJson(T obj, ValueFilter valueFilter) {
        return JSON.toJSONString(obj, valueFilter, DEFAULT_FORMAT);
    }

    public static String toJson(Enum<?>... values) {
        SerializeConfig config = new SerializeConfig();
        Class<? extends Enum>[] enumClasses = (Class[]) (new Class[values.length]);
        int i = 0;
        Enum[] var4 = values;
        int var5 = values.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            Enum<?> temp = var4[var6];
            enumClasses[i] = temp.getClass();
            ++i;
        }

        config.configEnumAsJavaBean(enumClasses);
        return JSON.toJSONString(values, config, new SerializerFeature[0]);
    }

    public static String toJson(Map<String, Object> map) {
        return JSON.toJSONString(map, DEFAULT_FORMAT);
    }

    public static String prettyFormatJson(String jsonString) {
        return JSON.toJSONString(getJSONFromString(jsonString), true);
    }

    public static Map<String, Object> toMap(String jsonString) {
        return getJSONFromString(jsonString);
    }

    static {
        DEFAULT_FORMAT = new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteEnumUsingToString, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.QuoteFieldNames, SerializerFeature.SkipTransientField, SerializerFeature.SortField, SerializerFeature.PrettyFormat};
    }
}

