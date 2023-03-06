package com.ruoyi.intelligent_explanation.api;

import com.ruoyi.intelligent_explanation.domian.BroadcastMaterial;

import java.util.List;

public interface BroadcastMaterialService {

    int insertBroadcastMaterial(BroadcastMaterial broadcastMaterial);

    List<BroadcastMaterial> selectBroadcastMaterialList(BroadcastMaterial broadcastMaterial,int pageNum,int pageSize);

    int updateBroadcastMaterial(BroadcastMaterial broadcastMaterial);

    int deleteBroadcastMaterial(List<Long> ids);
}
