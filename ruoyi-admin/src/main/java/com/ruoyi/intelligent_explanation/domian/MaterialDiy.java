package com.ruoyi.intelligent_explanation.domian;

import lombok.Data;

/**
 * 素材图文DIY实体
 */
@Data
public class MaterialDiy {
    /**
     * 素材图文id
     */
    private Long id;
    /**
     * 素材id
     */
    private  Long broadcastMaterialId;
    /**
     * 序号
     */
    private int serialNumber;
    /**
     * 音频类型，01 上传音频
     *             02 文本合成
     */
    private String audioType;
    /**
     * 音频内容，文件路径
     */
    private String audioContent;
    /**
     * 图文内容，图片路径
     */
    private String diyContent;
    /**
     * 播放时长
     */
    private int broadcastDuration;
    /**
     * 说明
     */
    private String remak;
}

