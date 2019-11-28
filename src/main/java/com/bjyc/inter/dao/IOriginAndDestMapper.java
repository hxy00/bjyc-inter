package com.bjyc.inter.dao;

import com.bjyc.inter.pojo.dto.OriginAndDestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface IOriginAndDestMapper {

    List<Map<String, Object>> getListMap(@Param("originAndDestDto") OriginAndDestDto originAndDestDto);

    Integer save(@Param("originAndDestDto") OriginAndDestDto originAndDestDto);

    Integer delete(@Param("originAndDestDto") OriginAndDestDto originAndDestDto);
}
