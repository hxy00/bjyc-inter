package com.bjyc.inter.pojo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
        value = "RestReqBaseDTO",
        description = "基础查询对象"
)
public class RestReqBaseDTO extends BaseDTO {
    private static final long serialVersionUID = 7357738173138221521L;
    @ApiModelProperty(
            name = "editFlag",
            value = "编辑标识（0：新增，1：修改，2：删除）",
            hidden = true,
            example = "1"
    )
    private Integer editFlag = 0;

    public RestReqBaseDTO() {
    }

    public Integer getEditFlag() {
        return this.editFlag;
    }

    public void setEditFlag(Integer editFlag) {
        this.editFlag = editFlag;
    }
}