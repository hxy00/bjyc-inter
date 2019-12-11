package com.bjyc.inter.dao;

import com.bjyc.inter.pojo.dto.PublishInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface IPublishInfoMapper {

    List<Map<String, Object>> getListMap(@Param("publishInfoDto") PublishInfoDto publishInfoDto);

    Integer save(@Param("publishInfoDto") PublishInfoDto publishInfoDto);

    Integer delete(@Param("publishInfoDto") PublishInfoDto publishInfoDto);

    Integer update(@Param("publishInfoDto") PublishInfoDto publishInfoDto);
}
