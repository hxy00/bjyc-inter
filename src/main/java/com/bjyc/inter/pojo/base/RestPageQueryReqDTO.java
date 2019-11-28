package com.bjyc.inter.pojo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
        value = "RestPageQueryReqDTO",
        description = "分页对象"
)
public class RestPageQueryReqDTO extends RestReqBaseDTO {
    private static final long serialVersionUID = 1205709689790569047L;
    @ApiModelProperty(
            name = "pageNum",
            value = "起始页码，默认为1",
            example = "1",
            position = 3
    )
    private Integer pageNum = 1;
    @ApiModelProperty(
            name = "pageSize",
            value = "页面大小",
            example = "10",
            position = 4
    )
    private Integer pageSize = 10;
    @ApiModelProperty(
            name = "isPage",
            hidden = true
    )
    private boolean isPage = true;

    public RestPageQueryReqDTO() {
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isPage() {
        return this.isPage;
    }

    public void setPage(boolean isPage) {
        this.isPage = isPage;
    }
}

