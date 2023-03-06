package com.ruoyi.intelligent_explanation.controller;

import com.ruoyi.intelligent_explanation.api.MaterialDiyService;
import com.ruoyi.intelligent_explanation.controller.result.Result;
import com.ruoyi.intelligent_explanation.domian.MaterialDiy;
import com.ruoyi.intelligent_explanation.vo.MaterialDiyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialDiyService materialDiyService;
    @RequestMapping("/add")
    public Result addMaterialDiy(@RequestBody  MaterialDiy materialDiy){
        Result result=Result.fail();
       if(materialDiyService.insertMaterialDiySelective(materialDiy)>0){
           result=Result.success();
       }
    return result;
    }

    @RequestMapping("/remove")
    public Result removeMaterialDiy(@RequestParam List<Long> ids){
        Result result=Result.fail();
        if(materialDiyService.deleteMaterialDiy(ids,null)>0){
            result=Result.success();
        }
        return result;
    }


    @RequestMapping("/getList")
    public Result getMaterialDiy(Long broadcastMaterialId,Integer pageNum, Integer pageSize){
        List<MaterialDiy> materialDiys = materialDiyService.selectMaterialDiyListByMaterialIds(broadcastMaterialId, pageNum, pageSize);
        MaterialDiyVo materialDiyVo=new MaterialDiyVo();
        materialDiyVo.setMaterialDiyList(materialDiys);
        materialDiyVo.setTotal(materialDiys.size());
        return Result.success(materialDiyVo);
    }
}
