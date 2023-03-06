package com.ruoyi.intelligent_explanation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface CommonMapper {
   List<Map>  getConstByType(@Param("dictType") String dictType);
}
