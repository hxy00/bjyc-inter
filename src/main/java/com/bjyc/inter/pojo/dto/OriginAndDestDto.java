package com.bjyc.inter.pojo.dto;

import com.bjyc.inter.pojo.base.RestPageQueryReqDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "OriginAndDestDto", description = "出发地和目的地表")
public class OriginAndDestDto extends RestPageQueryReqDTO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "主键", example = "")
    private Long id;

    @ApiModelProperty(name = "uid", value = "uid", example = "")
    private String uid;

    @ApiModelProperty(name = "origin", value = "出发地", example = "")
    private String origin;

    @ApiModelProperty(name = "destination", value = "目的地", example = "")
    private String destination;

    @ApiModelProperty(name = "createAt", value = "创建时间", example = "")
    private Date createAt;

    @ApiModelProperty(name = "isDefault", value = "是否默认", example = "")
    private Integer isDefault;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}
