package com.ruoyi.intelligent_explanation.api;

import com.ruoyi.intelligent_explanation.domian.MaterialDiy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialDiyService  {

    /**
     * 插入素材diy接口
     * @param
     */
     int insertMaterialDiySelective(MaterialDiy materialDiy);

    /**
     * 可 素材id 查询 素材图文信息,分页
     * @param
     * @param broadcastMaterialId
     * @return
     */
    List<MaterialDiy> selectMaterialDiyListByMaterialIds(Long broadcastMaterialId, int startNum, int pageSize);

    /**
     * 可通过素材图文id或 素材id 删除 素材图文信息
     * @param ids
     * @param materialIds
     * @return
     */
     int deleteMaterialDiy(List<Long> ids,List<Long> materialIds);
}
