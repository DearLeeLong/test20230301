package com.ruoyi.intelligent_explanation.service;

import com.ruoyi.intelligent_explanation.api.ExplainSceneService;
import com.ruoyi.intelligent_explanation.domian.ExplainScene;
import com.ruoyi.intelligent_explanation.mapper.ExplainSceneMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ExplainSceneServiceImpl implements ExplainSceneService {
    @Resource
    private ExplainSceneMapper explainSceneMapper;
    @Override
    public int insertExplainScene(ExplainScene explainScene) {
        return explainSceneMapper.insertExplainSceneSelective(explainScene);
    }

    @Override
    public List<ExplainScene> selectExplainSceneList(ExplainScene explainScene, int pageNum, int pageSize) {
        int startNum=(pageNum-1)*pageSize;
         return explainSceneMapper.selectExplainSceneList(explainScene,startNum,pageSize);
    }


    @Override
    public int deleteExplainSceneByIds(List<Long> ids) {
        return explainSceneMapper.deleteExplainSceneByIds(ids);
    }

    @Override
    public int updateExplainScene(ExplainScene explainScene) {
        return explainSceneMapper.updateExplainScene(explainScene);
    }
}
