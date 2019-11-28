package com.bjyc.inter.pojo.dto;

import com.bjyc.inter.pojo.base.RestPageQueryReqDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "PublishInfoDto", description = "发布信息表")
public class PublishInfoDto extends RestPageQueryReqDTO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "主键", example = "")
    private Long id;

    @ApiModelProperty(name = "createdAt", value = "createdAt", example = "")
    private Date createdAt;

    @ApiModelProperty(name = "publishedAt", value = "publishedAt", example = "")
    private Date publishedAt;

    @ApiModelProperty(name = "cellPhone", value = "cellPhone", example = "")
    private String cellPhone;

    @ApiModelProperty(name = "title", value = "title", example = "")
    private String title;

    @ApiModelProperty(name = "desc", value = "desc", example = "")
    private String desc;

    @ApiModelProperty(name = "uId", value = "desc", example = "")
    private Long uId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }


}
