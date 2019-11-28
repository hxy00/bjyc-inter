package com.bjyc.inter.sv;

import com.bjyc.inter.pojo.dto.OriginAndDestDto;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IOriginAndDestSv {

    PageInfo<?> getOriginAndDestPage(OriginAndDestDto originAndDestDto) throws Exception ;

    List<Map<String, Object>> getOriginAndDestList(OriginAndDestDto originAndDestDto) throws Exception ;

    Map<String, Object> getOriginAndDest(OriginAndDestDto originAndDestDto) throws Exception ;

    Integer save(OriginAndDestDto originAndDestDto) throws Exception ;;

    Integer delete(OriginAndDestDto originAndDestDto) throws Exception ;;
}
