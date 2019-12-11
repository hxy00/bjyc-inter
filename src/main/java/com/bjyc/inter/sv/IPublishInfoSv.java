package com.bjyc.inter.sv;

import com.bjyc.inter.pojo.dto.PublishInfoDto;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IPublishInfoSv {

    PageInfo<?> getPublishInfoPage(PublishInfoDto publishInfoDto) throws Exception;

    List<Map<String, Object>> getPublishInfoList(PublishInfoDto publishInfoDto) throws Exception;

    Map<String, Object> getPublishInfo(PublishInfoDto publishInfoDto) throws Exception;

    Integer save(PublishInfoDto publishInfoDto) throws Exception;

    Integer delete(PublishInfoDto publishInfoDto) throws Exception;

    Integer update(PublishInfoDto publishInfoDto) throws Exception;
}
