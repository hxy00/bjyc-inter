package com.bjyc.inter.pojo.base;

import com.bjyc.inter.util.JSONUtil;

import java.util.Map;

public class BaseSerializable {
    private static final long serialVersionUID = -4471422565459113097L;

    public BaseSerializable() {
    }

    public String toJson() {
        return JSONUtil.toJson(this);
    }

    public Map<String, Object> toMap() {
        return JSONUtil.toMap(this.toJson());
    }

    public String toString() {
        return this.toJson();
    }
}
