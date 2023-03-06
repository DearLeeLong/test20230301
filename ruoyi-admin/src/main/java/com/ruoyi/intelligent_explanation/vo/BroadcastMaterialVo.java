package com.ruoyi.intelligent_explanation.vo;

import com.ruoyi.intelligent_explanation.domian.BroadcastMaterial;
import com.ruoyi.intelligent_explanation.domian.MaterialDiy;
import lombok.Data;

import java.util.List;
@Data
public class BroadcastMaterialVo  {

    private List<BroadcastMaterial> broadcastMaterials;
    private int total;
}
