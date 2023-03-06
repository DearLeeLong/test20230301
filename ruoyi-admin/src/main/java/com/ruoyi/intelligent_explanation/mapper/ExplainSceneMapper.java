package com.ruoyi.intelligent_explanation.mapper;

import com.ruoyi.intelligent_explanation.domian.ExplainScene;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExplainSceneMapper {
    int insertExplainSceneSelective(ExplainScene explainScene);
    List<ExplainScene> selectExplainSceneList(@Param("explainScene")ExplainScene explainScene,@Param("startNum") int startNum,@Param("pageSize")int pageSize);
    int deleteExplainSceneByIds(@Param("idsList")List<Long> ids);
    int updateExplainScene(ExplainScene explainScene);

}
