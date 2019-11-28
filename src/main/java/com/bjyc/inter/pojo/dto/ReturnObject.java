package com.bjyc.inter.pojo.dto;


import com.bjyc.inter.pojo.base.BaseDTO;

public class ReturnObject extends BaseDTO {
    public int retCode;
    public String retMsg;
    public Object data;
    public int count;
    public Object messages;

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getMessages() {
        return this.messages;
    }

    public void setMessages(Object messages) {
        this.messages = messages;
    }

    public ReturnObject(ReturnObject.SuccessEnum success, String message, Object object, int count) {
        this.retCode = success.getSuccessEnum();
        this.retMsg = message;
        this.data = object;
        this.count = count;
    }

    public ReturnObject(ReturnObject.SuccessEnum success, Object messages, Object object, int count) {
        this.retCode = success.getSuccessEnum();
        this.messages = messages;
        this.data = object;
        this.count = count;
    }

    public ReturnObject() {
        this.retCode = 0;
        this.retMsg = "成功";
        this.data = null;
        this.count = 0;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public void fail(String msg) {
        this.retCode = 1;
        this.retMsg = msg;
        this.data = null;
        this.count = 0;
    }

    public static enum SuccessEnum {
        success(0),
        fail(1),
        signFail(2);

        private int successEnum;

        private SuccessEnum(int successEnum) {
            this.successEnum = successEnum;
        }

        public int getSuccessEnum() {
            return this.successEnum;
        }
    }
}
