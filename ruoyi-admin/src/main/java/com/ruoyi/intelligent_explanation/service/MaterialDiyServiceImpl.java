package com.ruoyi.intelligent_explanation.service;

import com.ruoyi.intelligent_explanation.api.MaterialDiyService;
import com.ruoyi.intelligent_explanation.domian.MaterialDiy;
import com.ruoyi.intelligent_explanation.mapper.MaterialDiyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 素材DIY服务
 */
@Service
public class MaterialDiyServiceImpl implements MaterialDiyService {
    @Resource
    private MaterialDiyMapper materialDiyMapper;
    @Override
    public int insertMaterialDiySelective(MaterialDiy materialDiy) {
    return materialDiyMapper.insertMaterialDiySelective(materialDiy);
    }

    @Override
    public List<MaterialDiy> selectMaterialDiyListByMaterialIds(Long materialId,int pageNum,int pageSize) {
        List<Long> materialIds = new ArrayList<Long>();
        int startNum=(pageNum-1)*pageSize;
        materialIds.add(materialId);
        List<MaterialDiy> materialDiys = materialDiyMapper.selectMaterialDiyListByMaterialIds(materialIds,startNum,pageSize);
        return materialDiys;
    }

    @Override
    public int deleteMaterialDiy(List<Long> ids, List<Long> materialIds) {
        int i=0;
        if(ids!=null &&ids.size()!=0){
            int d1 = materialDiyMapper.deleteMaterialDiyByIds(ids);
          if(d1>0){
              i=d1;
          }
        }
        if(materialIds!=null &&materialIds.size()>0){
            int d2= materialDiyMapper.deleteMaterialDiyByMaterialIds(materialIds);
            if(d2>0){
                i=d2;
            }
        }
        return i;
    }

}

