package com.ruoyi.intelligent_explanation.service;

import com.ruoyi.intelligent_explanation.api.BroadcastMaterialService;
import com.ruoyi.intelligent_explanation.api.MaterialDiyService;
import com.ruoyi.intelligent_explanation.domian.BroadcastMaterial;
import com.ruoyi.intelligent_explanation.mapper.BroadcastMaterialMapper;
import com.ruoyi.intelligent_explanation.mapper.MaterialDiyMapper;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BroadcastMaterialServiceImpl implements BroadcastMaterialService {
    @Resource
    public BroadcastMaterialMapper broadcastMaterialMapper;
    @Resource
    public MaterialDiyService materialDiyService;

    @Override
    public int insertBroadcastMaterial(BroadcastMaterial broadcastMaterial) {
        return  broadcastMaterialMapper.insertBroadcastMaterialSelective(broadcastMaterial);

    }

    @Override
    public List<BroadcastMaterial> selectBroadcastMaterialList(BroadcastMaterial broadcastMaterial, int pageNum, int pageSize) {
        int startNum=(pageNum-1)*pageSize;
        return broadcastMaterialMapper.selectBroadcastMaterialBySelective(broadcastMaterial,startNum,pageSize);
    }


    @Override
    public int updateBroadcastMaterial(BroadcastMaterial broadcastMaterial) {
        return broadcastMaterialMapper.updateBroadcastMaterial(broadcastMaterial);
    }

    @Override
    public int deleteBroadcastMaterial(List<Long> ids) {
        materialDiyService.deleteMaterialDiy(null,ids);
        return broadcastMaterialMapper.deleteBroadcastMaterialByIdsList(ids);
    }

}
