package com.bjyc.inter.pojo.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wx.auth")
public class WxAuthDto {
    private String appId, appSecret, grantType, grantUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getGrantUrl() {
        return grantUrl;
    }

    public void setGrantUrl(String grantUrl) {
        this.grantUrl = grantUrl;
    }
}
