package com.ruoyi.intelligent_explanation.controller;

import com.ruoyi.intelligent_explanation.api.BroadcastMaterialService;
import com.ruoyi.intelligent_explanation.controller.result.Result;
import com.ruoyi.intelligent_explanation.domian.BroadcastMaterial;
import com.ruoyi.intelligent_explanation.domian.MaterialDiy;
import com.ruoyi.intelligent_explanation.dto.BroadcastMaterialDto;
import com.ruoyi.intelligent_explanation.vo.BroadcastMaterialVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/broadcastMaterial")
public class BroadcastMaterialController {
    @Autowired
    private BroadcastMaterialService broadcastMaterialService;
    @RequestMapping("/add")
    public Result addBroadcastMaterial(@RequestBody BroadcastMaterial broadcastMaterial){
        Result result=Result.fail();
        if(broadcastMaterialService.insertBroadcastMaterial(broadcastMaterial)>0){
            result=Result.success();
        }
        return result;
    }
    @RequestMapping("/remove")
    public Result removeBroadcastMaterial(@RequestParam List<Long> ids){
        Result result=Result.fail();
        if(broadcastMaterialService.deleteBroadcastMaterial(ids)>0){
            result=Result.success();
        }
        return result;
    }


    @RequestMapping("/getList")
    public Result getBroadcastMaterial(@RequestBody BroadcastMaterialDto broadcastMaterialDto){
        List<BroadcastMaterial> broadcastMaterials = broadcastMaterialService.selectBroadcastMaterialList(broadcastMaterialDto.getBroadcastMaterial(), broadcastMaterialDto.getPageNum(), broadcastMaterialDto.getPageSize());
        BroadcastMaterialVo broadcastMaterialVo = new BroadcastMaterialVo();
        broadcastMaterialVo.setBroadcastMaterials(broadcastMaterials);
        broadcastMaterialVo.setTotal(broadcastMaterials.size());
     return Result.success(broadcastMaterialVo);
    }
    @RequestMapping("/edit")
    public Result editBroadcastMaterial(@RequestBody BroadcastMaterial broadcastMaterial){
        Result result=Result.fail();
        if( broadcastMaterialService.updateBroadcastMaterial(broadcastMaterial)>0){
            result= Result.success();
        }
        return result;
    }
}
