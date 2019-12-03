package com.bjyc.inter.controller;

import com.bjyc.inter.pojo.dto.OriginAndDestDto;
import com.bjyc.inter.pojo.dto.ReturnObject;
import com.bjyc.inter.sv.IOriginAndDestSv;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/originAndDest", produces = "application/json; charset=UTF-8")
public class OriginAndDestController {
    Logger logger = LoggerFactory.getLogger(getClass());

    private final int SAVE_COUNTS = 5; // 限制最多只能保存5条数据

    @Autowired
    private IOriginAndDestSv iOriginAndDestSv;

    /**
     * 获取用户方位信息
     * @param originAndDestDto
     * @return
     */
    @RequestMapping("/getPage")
    public ReturnObject getPage(@Valid OriginAndDestDto originAndDestDto) {
        try {
            PageInfo<?> pageInfo = iOriginAndDestSv.getOriginAndDestPage(originAndDestDto);
            return new ReturnObject(ReturnObject.SuccessEnum.success, "获取数据获取成功", pageInfo, 1);
        } catch (Exception e) {
            logger.error("获取数据失败：" + e.getMessage());
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "获取数据获取失败：" + e.getMessage(), null, 1);
        }
    }



    /**
     * 获取用户信息
     * @param originAndDestDto
     * @return
     */
    @RequestMapping("/getOriginAndDest")
    public ReturnObject getOriginAndDest(@Valid OriginAndDestDto originAndDestDto) {
        try {
            List<Map<String, Object>> lstData = iOriginAndDestSv.getOriginAndDestList(originAndDestDto);
            if (CollectionUtils.isEmpty(lstData)){
                return new ReturnObject(ReturnObject.SuccessEnum.fail, "获取数据获取失败：没有获取到数据", null, 1);
            }
            return new ReturnObject(ReturnObject.SuccessEnum.success, "获取数据获取成功", lstData, 1);
        } catch (Exception e) {
            logger.error("获取数据失败：" + e.getMessage());
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "获取数据获取失败：" + e.getMessage(), null, 1);
        }
    }

    @RequestMapping("/save")
    public ReturnObject save(@Valid OriginAndDestDto originAndDestDto) {
        if (null == originAndDestDto) {
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "保存数据失败：参数为空", 0, 1);
        }
        if (null == originAndDestDto.getUid()) {
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "保存数据失败：参数为空", 0, 1);
        }

        try {
            List<Map<String, Object>> lstData = iOriginAndDestSv.getOriginAndDestList(originAndDestDto);
            if(!CollectionUtils.isEmpty(lstData) && lstData.size() >= SAVE_COUNTS) {
                return new ReturnObject(ReturnObject.SuccessEnum.fail, "保存数据失败：该数据最多能保存5条", 0, 1);
            }
            int saveInt = iOriginAndDestSv.save(originAndDestDto);
            if (saveInt > 0) {
                return new ReturnObject(ReturnObject.SuccessEnum.success, "数据保存成功", 0, 1);
            }
        } catch (Exception e) {
            logger.error("保存数据失败：" + e.getMessage());
        }
        return new ReturnObject(ReturnObject.SuccessEnum.fail, "获取数据获取失败" , null, 1);
    }

    @RequestMapping("/delete")
    public ReturnObject delete(@Valid OriginAndDestDto originAndDestDto) {
        if(null == originAndDestDto) {
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "删除数据失败：参数为空[object]", 0, 1);
        }
        if (null == originAndDestDto.getId() && StringUtil.isEmpty(originAndDestDto.getUid())) {
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "保存数据失败：参数为空[uid]或[openId]", 0, 1);
        }
        int retInt = 0;
        try {
            retInt = iOriginAndDestSv.delete(originAndDestDto);
            if (retInt > 0) {
                return new ReturnObject(ReturnObject.SuccessEnum.success, "数据删除成功", 0, 1);
            }
        } catch (Exception e) {
            logger.error("删除失败：" + e.getMessage());
            return new ReturnObject(ReturnObject.SuccessEnum.fail, "删除失败：" + e.getMessage(), 0, 1);
        }
        return new ReturnObject(ReturnObject.SuccessEnum.fail, "删除失败", 0, 1);
    }
}
