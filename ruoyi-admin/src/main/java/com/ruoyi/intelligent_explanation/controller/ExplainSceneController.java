package com.ruoyi.intelligent_explanation.controller;

import com.ruoyi.intelligent_explanation.api.BroadcastMaterialService;
import com.ruoyi.intelligent_explanation.api.ExplainSceneService;
import com.ruoyi.intelligent_explanation.controller.result.Result;
import com.ruoyi.intelligent_explanation.domian.BroadcastMaterial;
import com.ruoyi.intelligent_explanation.domian.ExplainScene;
import com.ruoyi.intelligent_explanation.dto.ExplainSceneDto;
import com.ruoyi.intelligent_explanation.vo.BroadcastMaterialVo;
import com.ruoyi.intelligent_explanation.vo.ExplainSceneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("explainScene")
public class ExplainSceneController {
    @Autowired
    private ExplainSceneService explainSceneService;
    @RequestMapping("/add")
    public Result add(@RequestBody ExplainScene explainScene){
        Result result=Result.fail();
        if(explainSceneService.insertExplainScene(explainScene)>0){
            result=Result.success();
        }
        return result;
    }
    @RequestMapping("/remove")
    public Result removeExplainScene(@RequestParam List<Long> ids){
        Result result=Result.fail();
        if(explainSceneService.deleteExplainSceneByIds(ids)>0){
            result=Result.success();
        }
        return result;
    }


    @RequestMapping("/getList")
    public Result getExplainScene(@RequestBody ExplainSceneDto explainSceneDto){
        List<ExplainScene> explainSceneList = explainSceneService.selectExplainSceneList(explainSceneDto.getExplainScene(),explainSceneDto.getPageNum(),explainSceneDto.getPageSize());
        ExplainSceneVo explainSceneVo = new ExplainSceneVo();
        explainSceneVo.setExplainScenes(explainSceneList);
        explainSceneVo.setTotal(explainSceneList.size());
        return Result.success(explainSceneVo);
    }
    @RequestMapping("/edit")
    public Result editExplainScene(@RequestBody ExplainScene explainScene){
        Result result=Result.fail();
        if( explainSceneService.updateExplainScene(explainScene)>0){
            result= Result.success();
        }
        return result;
    }
}
