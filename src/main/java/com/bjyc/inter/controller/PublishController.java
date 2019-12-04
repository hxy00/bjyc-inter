package com.bjyc.inter.controller;

import com.bjyc.inter.pojo.dto.PublishInfoDto;
import com.bjyc.inter.pojo.dto.ReturnObject;
import com.bjyc.inter.sv.IPublishInfoSv;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping(value = "/publish", produces = "application/json; charset=UTF-8")
public class PublishController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IPublishInfoSv iPublishInfoSv;

    /**
     * 保存
     * @param publishInfoDto
     * @return
     */
    @RequestMapping("/save")
    public ReturnObject save(@Valid PublishInfoDto publishInfoDto){
        if (StringUtil.isEmpty(publishInfoDto.getTitle())) {
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "参数为空[title]","", 1);
        }
        if (StringUtil.isEmpty(publishInfoDto.getContent())) {
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "参数为空[content]","", 1);
        }

        try {
            publishInfoDto.setPublishedAt(new Date());
            publishInfoDto.setIsValid(1); // 0无效，1有效
            int saveInt = iPublishInfoSv.save(publishInfoDto);
            if (saveInt > 0) {
                return new ReturnObject(ReturnObject.SuccessEnum.success, "保存成功", publishInfoDto, 1);
            }
        } catch (Exception e) {
            logger.error("保存出错：{}", e.getMessage());
        }
        return new ReturnObject(ReturnObject.SuccessEnum.fail, "保存失败","", 1);
    }

    /**
     * 获取数据
     * @param publishInfoDto
     * @return
     */
    @RequestMapping("/getPage")
    public ReturnObject getPage(@Valid PublishInfoDto publishInfoDto) {
        try {
            PageInfo pageInfo = iPublishInfoSv.getPublishInfoPage(publishInfoDto);
            return new ReturnObject(ReturnObject.SuccessEnum.success, "获取数据成功", pageInfo, 1);
        } catch (Exception e) {
            logger.error("获取数据失败：{}", e.getMessage());
        }
        return new ReturnObject(ReturnObject.SuccessEnum.fail, "获取数据失败","", 1);
    }

    /**
     * 删除数据
     * @param publishInfoDto
     * @return
     */
    @RequestMapping("/delete")
    public ReturnObject delete(@Valid PublishInfoDto publishInfoDto) {
        try {
            if(null == publishInfoDto.getId() && StringUtil.isEmpty(publishInfoDto.getuId())) {
                return new ReturnObject(ReturnObject.SuccessEnum.fail, "删除数据失败，参数为空[id]或[uId]","", 1);
            }
            int retInt = iPublishInfoSv.delete(publishInfoDto);
            if(retInt > 0) {
                return new ReturnObject(ReturnObject.SuccessEnum.success, "删除数据成功", "", 1);
            } else {
                return new ReturnObject(ReturnObject.SuccessEnum.fail, "删除数据失败","", 1);
            }
        } catch (Exception e) {
            logger.error("删除数据失败：{}", e.getMessage());
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "删除数据失败：" + e.getMessage(),"", 1);
        }
    }
}
