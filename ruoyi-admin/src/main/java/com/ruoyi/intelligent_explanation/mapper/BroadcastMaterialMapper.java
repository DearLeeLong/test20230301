package com.ruoyi.intelligent_explanation.mapper;

import com.ruoyi.intelligent_explanation.domian.BroadcastMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BroadcastMaterialMapper {

    int insertBroadcastMaterialSelective(BroadcastMaterial broadcastMaterial);
    List<BroadcastMaterial> selectBroadcastMaterialBySelective(@Param("broadcastMaterial") BroadcastMaterial broadcastMaterial,@Param("startNum") int startNum,@Param("pageSize")int pageSize);
    int updateBroadcastMaterial(BroadcastMaterial broadcastMaterial);
    int deleteBroadcastMaterialById(@Param("id")Long id);
    int deleteBroadcastMaterialByIdsList(@Param("idsList") List<Long> idsList);
}
