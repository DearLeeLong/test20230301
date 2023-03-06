package com.ruoyi.intelligent_explanation.controller;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.intelligent_explanation.controller.result.Result;
import com.ruoyi.intelligent_explanation.mapper.CommonMapper;
import com.ruoyi.intelligent_explanation.utils.ServersConfig;
import com.ruoyi.intelligent_explanation.utils.SnowFlakeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonsController {
    @Autowired
    public SnowFlakeUtils snowFlakeUtils;
    @Resource
    public CommonMapper commonMapper;
    @Autowired
    private ServersConfig serverConfig;
    @RequestMapping("/getId")
    public Result getId(){
        return Result.success(snowFlakeUtils.nextId());
    }

    @RequestMapping("/getConstByType")
    public Result getConstByType(@RequestBody Map map){
        return Result.success(commonMapper.getConstByType(String.valueOf(map.get("type"))));
    }
    @RequestMapping("/upload")
    public Result upload(MultipartFile file){
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            Map<String,String> map=new HashMap<String,String>();
            map.put("url", url);
            map.put("fileName", fileName);
            map.put("newFileName", FileUtils.getName(fileName));
            map.put("originalFilename", file.getOriginalFilename());
           return Result.success(map);
        }
        catch (Exception e)
        {
            return Result.fail(e.getMessage());
        }
    }

}
