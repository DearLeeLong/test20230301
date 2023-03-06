package com.ruoyi.intelligent_explanation.api;

import com.ruoyi.intelligent_explanation.domian.ExplainScene;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExplainSceneService {

    int insertExplainScene(ExplainScene explainScene);
    List<ExplainScene> selectExplainSceneList(ExplainScene explainScene,int pageNum,int pageSize);
    int deleteExplainSceneByIds(List<Long> ids);
    int updateExplainScene(ExplainScene explainScene);
}
