package com.ruoyi.intelligent_explanation.domian;


import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 素材实体
 */
@Data
public class BroadcastMaterial {
    /**
     * 素材id
     */
    private Long id;
    /**
     * 素材名称
     */
    private String materialName;
    /**
     * 场景类型      01 预设材料，适用于PPT 及视频
     *             02 DIY材料，适用于宣讲及培训
     *             03 系统演示，适用于讲解场景
     */
    private String sceneType;
    /**
     *   业务类型    01 公司讲解
     *             02 系统讲解
     *             03 业务讲解
     *             04 业务培训
     *             05 其它培训
     */
    private String businessType;
    /**
     * 文件类型
     *             01 PPT
     *             02 视频
     *             03 音频
     *             04 图文
     *             05 其它
     */
    private String fileType;
    /**
     *音频文件
     */
    private String audioFile;
    /**
     *音频文本
     */
    private String audioText;
    /**
     * 素材文件存储路径
     */
    private String materialFile;
    /**
     * 素材文件文本说明
     */
    private String materialDesc;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;

    private String createTimeStr;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    private String updateTimeStr;



}
