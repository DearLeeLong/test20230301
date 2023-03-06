package com.ruoyi.intelligent_explanation.domian;

import lombok.Data;

import java.util.Date;

@Data
public class ExplainScene {
    /**
     * 主键，场景id
     */
    private Long id;
    /**
     * 场景名称
     */
    private String sceneName;
    /**
     * 场景类型 01 讲解
     *             02 培训 培训时相当于课程表
     */
    private String sceneType;
    /**
     * 音频类型 01 问答收音
     *             02 流式收音
     */
    private String radioMode;
    /**
     * 场景欢迎语
     */
    private String sceneWelcome;
    /**
     * 素材名称
     */
    private String materialName;
    /**
     * 素材id
     */
    private Long broadcastMaterialId;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String updateBy;
    /**
     * 修改时间
     */
    private Date updateTime;
}
