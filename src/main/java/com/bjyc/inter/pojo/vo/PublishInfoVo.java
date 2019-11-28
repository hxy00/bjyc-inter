package com.bjyc.inter.pojo.vo;

import com.bjyc.inter.pojo.base.BaseVO;

import java.util.Date;

public class PublishInfoVo extends BaseVO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private Date createdAt;

    private Date publishedAt;

    private String cellPhone;

    private String title;

    private String desc;

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
