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

    @ApiModelProperty(name = "content", value = "content", example = "")
    private String content;

    @ApiModelProperty(name = "uId", value = "uId", example = "")
    private String uId;

//    @ApiModelProperty(name = "isValid", value = "isValid", example = "")
//    private Integer isValid;

    @ApiModelProperty(name = "direction", value = "方向", example = "")
    private String direction;

    @ApiModelProperty(name = "goTime", value = "出行时间", example = "")
    private String goTime;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getGoTime() {
        return goTime;
    }

    public void setGoTime(String goTime) {
        this.goTime = goTime;
    }
}
