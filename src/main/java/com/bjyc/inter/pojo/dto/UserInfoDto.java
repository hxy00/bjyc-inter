package com.bjyc.inter.pojo.dto;

import com.bjyc.inter.pojo.base.RestPageQueryReqDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "UserInfoDto", description = "用户信息表")
public class UserInfoDto extends RestPageQueryReqDTO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "主键", example = "")
    private Long id;

    @ApiModelProperty(name = "nickName", value = "昵称", example = "")
    private String nickName;

    @ApiModelProperty(name = "avatarUrl", value = "头像", example = "")
    private String avatarUrl;

    @ApiModelProperty(name = "gender", value = "性别（0未知，1男，2女）", example = "")
    private Integer gender;

    @ApiModelProperty(name = "country", value = "country", example = "")
    private String country;

    @ApiModelProperty(name = "province", value = "province", example = "")
    private String province;

    @ApiModelProperty(name = "city", value = "city", example = "")
    private String city;

    @ApiModelProperty(name = "lang", value = "lang", example = "")
    private String lang;

    @ApiModelProperty(name = "createAt", value = "创建时间", example = "")
    private Date createAt;

    @ApiModelProperty(name = "openId", value = "openId", example = "")
    private String openId;

    @ApiModelProperty(name = "updateAt", value = "更新时间", example = "")
    private Date updateAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
