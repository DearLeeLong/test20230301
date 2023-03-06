package com.ruoyi.intelligent_explanation.mapper;

import com.ruoyi.intelligent_explanation.domian.MaterialDiy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MaterialDiyMapper {
    int insertMaterialDiySelective(MaterialDiy materialDiy);
    List<MaterialDiy> selectMaterialDiyListByIds(@Param("idsList") List<Long> ids);
    List<MaterialDiy> selectMaterialDiyListByMaterialIds(@Param("materialIdsList")List<Long> materialIds,@Param("startNum")int startNum,@Param("pageSize")int pageSize);
    int deleteMaterialDiyByIds(@Param("idsList")List<Long> ids);
    int deleteMaterialDiyByMaterialIds(@Param("materialIdsList")List<Long> materialIds);


}
