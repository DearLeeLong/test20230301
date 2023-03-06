package com.ruoyi.intelligent_explanation.vo;

import com.ruoyi.intelligent_explanation.domian.ExplainScene;
import lombok.Data;

import java.util.List;

@Data
public class ExplainSceneVo  {
    private int total;
    private List<ExplainScene> explainScenes;
}
