/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/3/2 14:32:58                            */
/*==============================================================*/


drop table if exists alarm_broadcast_log;

drop table if exists alarm_event;

drop table if exists alarm_event_push;

drop table if exists broadcast_material;

drop table if exists business_risk_task;

drop table if exists control_alarm_log;

drop table if exists explain_scene;

drop table if exists indicator;

drop table if exists knowledge_lib;

drop table if exists material_diy;

drop table if exists sys_config;

drop table if exists sys_dept;

drop table if exists sys_dict_data;

drop table if exists sys_dict_type;

drop table if exists sys_menu;

drop table if exists sys_oper_log;

drop table if exists sys_role;

drop table if exists sys_role_menu;

drop table if exists sys_user;

drop table if exists sys_user_online;

drop table if exists task;

drop table if exists task_attachment;

drop table if exists task_corre_mailAndphone;

drop table if exists task_log;

drop table if exists task_mail;

drop table if exists task_mail_config;

drop table if exists task_message;

drop table if exists task_message_config;

drop table if exists task_template;

drop table if exists task_template_corre_mailAndphone;

drop table if exists voice_control_command;

drop table if exists voice_control_log;

drop table if exists 告警业务配置表;

drop table if exists 告警事件联系表;

drop table if exists 虚拟值班定时任务;

drop table if exists 领导短信称呼配置;

/*==============================================================*/
/* Table: alarm_broadcast_log                                   */
/*==============================================================*/
create table alarm_broadcast_log
(
   id                   varchar(14),
   alarm_event_id       varchar(14),
   broadcast_time       datetime,
   alarm_time           datetime,
   alarm_source         char(4) comment '01 大屏
            02 PC告警模块
            03 督办任务
            04 重复播报',
   alarm_type           char(4) comment '01 设备告警
            02 安全告警
            03 运营告警
            04 环保告警
            05 自然灾害告警
            06 其它告警',
   indicator_id         varchar(14),
   indicator_name       varchar(20),
   indicator_grade      char(4) comment '01  一级告警
            02  二级告警
            03  三级告警',
   broadcast_content    varchar(200)
);

alter table alarm_broadcast_log comment '告警播报日志表
问题：播报是广播还是点对点？';

/*==============================================================*/
/* Table: alarm_event                                           */
/*==============================================================*/
create table alarm_event
(
   id                   varchar(14),
   alarm_time           datetime,
   alarm_source         char(4) comment '01 大屏
            02 督办任务
            03 重复播报',
   alarm_type           char(4) comment '01 设备告警
            02 安全告警
            03 运营告警
            04 环保告警
            05 自然灾害告警
            06 其它告警',
   indicator_id         varchar(14),
   alarm_indicator_name varchar(20),
   indicator_grade      char(4) comment '01  一级告警
            02  二级告警
            03  三级告警',
   broadcast_content    varchar(200),
   recommend_indicator  varchar(50),
   broadcast_broadcast_content int(10) comment '0  待播报
            非0 已播报次数',
   is_pre               char(2) comment '即：是否发消息、电话等。'
);

alter table alarm_event comment '告警事件表';

/*==============================================================*/
/* Table: alarm_event_push                                      */
/*==============================================================*/
create table alarm_event_push
(
   id                   varchar(14),
   alarm_event_id       varchar(14),
   push_type            char(4) comment '01 短信
            02 邮件
            03 电话
            04 APP消息
            05 OA站内信',
   push_by              varchar(10),
   push_by_name         varchar(10),
   recipient            varchar(10),
   recipient_mail       varchar(20),
   recipient_phone      varchar(20),
   send_content         varchar(200),
   send_time            datetime,
   send_state           char(2) comment '01 发送成功
            02 发送失败'
);

/*==============================================================*/
/* Table: broadcast_material                                    */
/*==============================================================*/
create table broadcast_material
(
   id                   bigint,
   material_name        varchar(100),
   scene_type           char(4) comment '01 预设材料，适用于PPT 及视频
            02 DIY材料，适用于宣讲及培训
            03 系统演示，适用于讲解场景',
   business_type        char(4) comment '01 公司讲解
            02 系统讲解
            03 业务讲解
            04 业务培训
            05 其它培训',
   file_type            char(4) comment '01 PPT
            02 视频
            03 音频
            04 图文
            05 其它',
   audio_file           varchar(50) comment '文件存储路径，音频文件优化',
   audio_text           varchar(2000),
   material_file        varchar(50) comment '文件存储路径，如果是图文，则没有此内容',
   material_desc        varchar(200),
   create_by            varchar(10),
   create_time          datetime,
   update_by            varchar(10),
   update_time          datetime
);

alter table broadcast_material comment '播报素材表，含宣传、介绍、操作、培训材料管理';

/*==============================================================*/
/* Table: business_risk_task                                    */
/*==============================================================*/
create table business_risk_task
(
   id                   varchar(14),
   task_name            varchar(200),
   risk_type            char(4) comment '01:火电
            02:水电
            03:新能源
            04:矿山',
   risk_theme           char(4) comment '01：安全管理分析
            02：生产经营分析
            03：设备状态分析
            04：生产能效分析
            05：专项专题分析
            06：安全管理分析
            07：经济运行分析
            08：检修管理分析
            09：运行指标分析
            10：经济运行分析
            11：设备状态分析
            12：专项专题分析
            13：集中功率预测分析
            14：生产指标分析
            15：矿井灾害分析
            ',
   risk_indi            varchar(14),
   risk_url             varchar(50),
   remark               varchar(200)
);

alter table business_risk_task comment '经营风险任务详情表';

/*==============================================================*/
/* Table: control_alarm_log                                     */
/*==============================================================*/
create table control_alarm_log
(
   id                   varchar(14),
   log_time             date,
   overview_contrlo_statistics int(10),
   drill_control_statistics int(10),
   data_control_statistics int(10),
   env_alarm_statistics int(10),
   equipment_alarm_statistics int(10),
   safety_alarm_statistics int(10),
   operation_alarm_statistics int(10),
   disaster_alarm_statistics int(10)
);

alter table control_alarm_log comment '调度告警统计表，对应实时数据更新';

/*==============================================================*/
/* Table: explain_scene                                         */
/*==============================================================*/
create table explain_scene
(
   id                   bigint,
   scene_name           varchar(100),
   scene_type           char(4) comment '01 讲解
            02 培训 培训时相当于课程表',
   radio_mode           char(4) comment '01 问答收音
            02 流式收音',
   scene_welcome        varchar(1000),
   material_name        varchar(100),
   broadcast_material_id bigint,
   create_by            varchar(10),
   create_time          datetime,
   update_by            varchar(10),
   update_time          datetime
);

alter table explain_scene comment '设计典型讲解场景，默认配置参数
打开领导参观模式 、打开系统讲解模式、打开宣传模式

                                  -&#&';

/*==============================================================*/
/* Table: indicator                                             */
/*==============================================================*/
create table indicator
(
   id                   varchar(14),
   indicator_code       varchar(10),
   indicator_name       varchar(20),
   data_type            char(4) comment '01 字符
            02 数值
            03 逻辑
            04 日期
            05 时间
            06 其它',
   indicator_unit       char(4) comment '01：kWh
            02：kW
            03：吨
            04：米/秒
            05：兆焦/平方米
            06：%
            07：项
            08：台
            随着指标确定，将根据指标继续完善单位
            ',
   is_alarm_indicator   char(2),
   is_alarm_broadcast   char(2),
   alarm_grade          char(4),
   broadcast_template   varchar(200),
   recommend_indicator  varchar(20),
   remark               varchar(200),
   create_time          datetime,
   create_by            varchar(10),
   update_time          datetime,
   update_by            varchar(10)
);

alter table indicator comment '指标库表';

/*==============================================================*/
/* Table: knowledge_lib                                         */
/*==============================================================*/
create table knowledge_lib
(
   id                   varchar(14),
   question             varchar(200),
   question_type        char(4) comment '01 问答
            02 语音指令，如果是语音指令，答案是指令编码ID',
   answer               varchar(500),
   `explain`           varchar(500),
   create_by            varchar(14),
   create_time          datetime,
   update_by            varchar(14),
   update_time          datetime
);

/*==============================================================*/
/* Table: material_diy                                          */
/*==============================================================*/
create table material_diy
(
   id                   bigint,
   broadcast_material_id bigint,
   serial_number        int(2),
   audio_type           char(4) comment '01 上传音频
            02 文本合成',
   audio_content        varchar(1000) comment '如果是上传，则对应的是URL',
   diy_content          varchar(1000),
   broadcast_duration   int(10) comment '按秒设计',
   remak                varchar(1000)
);

alter table material_diy comment '素材图文表，适用于DIY图文,通过序号将素材连接在一起；';

/*==============================================================*/
/* Table: sys_config                                            */
/*==============================================================*/
create table sys_config
(
   config_id            int,
   config_name          varchar(1),
   config_key           varchar(1),
   config_value         varchar(1),
   config_type          char(1),
   create_by            varchar(1),
   create_time          datetime,
   update_by            varchar(1),
   update_time          datetime,
   remark               varchar(1)
);

alter table sys_config comment '系统配置表
1、';

/*==============================================================*/
/* Table: sys_dept                                              */
/*==============================================================*/
create table sys_dept
(
   dept_id              bigint not null,
   parent_id            bigint,
   ancestors            varchar(1),
   dept_name            varchar(1),
   order_num            int,
   leader               varchar(1),
   phone                varchar(1),
   email                varchar(1),
   status               char(1),
   del_flag             char(1),
   create_by            varchar(1),
   create_time          datetime,
   update_by            varchar(1),
   update_time          datetime,
   dept_code            varchar(1),
   primary key (dept_id)
);

/*==============================================================*/
/* Table: sys_dict_data                                         */
/*==============================================================*/
create table sys_dict_data
(
   dict_code            bigint,
   dict_sort            int,
   dict_label           varchar(1),
   dict_value           varchar(1),
   dict_type            varchar(1),
   css_class            varchar(1),
   list_class           varchar(1),
   is_default           char(1),
   status               char(1),
   create_by            varchar(1),
   create_time          datetime,
   update_by            varchar(1),
   update_time          datetime,
   remark               varchar(1)
);

/*==============================================================*/
/* Table: sys_dict_type                                         */
/*==============================================================*/
create table sys_dict_type
(
   dict_id              bigint,
   dict_name            varchar(1),
   dict_type            varchar(1),
   status               char(1),
   create_by            varchar(1),
   create_time          datetime,
   update_by            varchar(1),
   update_time          datetime,
   remark               varchar(1)
);

alter table sys_dict_type comment 'sys_dict_type';

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   menu_id              bigint,
   menu_name            varchar(1),
   parent_id            bigint,
   order_num            int,
   path                 varchar(1),
   component            varchar(1),
   is_frame             int,
   menu_type            char(1),
   visible              char(1),
   perms                varchar(1),
   icon                 varchar(1),
   create_by            varchar(1),
   create_time          datetime,
   update_by            varchar(1),
   update_time          datetime,
   remark               varchar(1)
);

/*==============================================================*/
/* Table: sys_oper_log                                          */
/*==============================================================*/
create table sys_oper_log
(
   oper_id              bigint,
   title                varchar(1),
   business_type        int,
   method               varchar(1),
   request_method       varchar(1),
   operator_type        int,
   oper_name            varchar(1),
   dept_name            varchar(1),
   oper_url             varchar(1),
   oper_ip              varchar(1),
   oper_location        varchar(1),
   oper_param           varchar(1),
   json_result          varchar(1),
   status               char(1),
   error_msg            varchar(1),
   oper_time            datetime
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   role_id              bigint,
   role_name            varchar(1),
   role_key             varchar(1),
   role_sort            int,
   data_scope           char(1),
   status               char(1),
   del_flag             char(1),
   create_by            varchar(1),
   create_time          datetime,
   update_by            varchar(1),
   update_time          datetime,
   remark               varchar(1)
);

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu
(
   role_id              bigint,
   menu_id              bigint
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   user_id              bigint,
   dept_id              bigint,
   user_name            varchar(1),
   nick_name            varchar(1),
   user_type            varchar(1),
   email                varchar(1),
   phonenumber          varchar(1),
   sex                  char(1),
   avatar               varchar(1),
   password             varchar(1),
   status               char(1),
   del_flag             char(1),
   login_ip             varchar(1),
   login_date           datetime,
   create_by            varchar(1),
   create_time          datetime,
   update_by            varchar(1),
   update_time          datetime,
   remark               varchar(1)
);

/*==============================================================*/
/* Table: sys_user_online                                       */
/*==============================================================*/
create table sys_user_online
(
   sessionId            bigint,
   user_name            varchar(1),
   dept_name            varchar(1),
   ipaddr               varchar(1),
   login_location       varchar(1),
   browser              varchar(1),
   os                   varchar(1),
   start_timestamp      varchar(1),
   last_access_time     datetime,
   status               char(1),
   expire_time          datetime
);

/*==============================================================*/
/* Table: task                                                  */
/*==============================================================*/
create table task
(
   id                   varchar(14),
   task_name            varchar(100),
   task_start_time      datetime,
   task_end_time        datetime,
   业务类型                 char(10) comment '01 常规值守
            02 流程自动批报
            03 报表自动报送
            04 经营风险管控
            05 值守驱优
            06 其它',
   task_period          char(4) comment '01：每天
            02：每周
            03：每月',
   task_type            char(4) comment '01 定时任务，后台任务名称
            02 RPA任务，RPA任务编码
            03 辅助任务，链接
            04 其它

            按照任务类型进行修改。',
   task_order           varchar(100) comment '常规任务，无
            定时任务，执行定时任务名称
            辅助任务，操作URL链接',
   task_desc            varchar(100),
   task_state           char(2) comment '01 待执行
            02 已完成',
   remind_duration      int comment '30min
            60min
            ',
   remind_duration_unit char(4) comment '01 分
            02 时',
   create_by            varchar(10),
   create_time          datetime,
   update_by            varchar(10),
   update_time          datetime
);

alter table task comment '值班任务表，注：任务对应的RPA任务通过RPA任务编码关联';

/*==============================================================*/
/* Table: task_attachment                                       */
/*==============================================================*/
create table task_attachment
(
   id                   varchar(14),
   task_id              varchar(14),
   attachment_name      varchar(100),
   attachment_url       varchar(100),
   remark               varchar(1000),
   文件类型                 char(10) comment '01 集团调度日报表
            02 国电电力生产监控日报
            03 国家能源集团电力电力生产日报
            04 其它',
   文件状态                 char(10) comment '01 已下载
            02 已发送',
   文件日期                 char(10),
   创建日期                 char(10)
);

alter table task_attachment comment '如有定时任务抓取 文件，
则作为任务附件加载，主要用于存储各日报表已抓取及处理状态';

/*==============================================================*/
/* Table: task_corre_mailAndphone                               */
/*==============================================================*/
create table task_corre_mailAndphone
(
   id                   varchar(14),
   task_id              varchar(14),
   push_type            char(4) comment '01 短信
            02 邮件
            03 电话
            04 APP消息
            05 OA站内信',
   mail_or_phone_id     varchar(10)
);

/*==============================================================*/
/* Table: task_log                                              */
/*==============================================================*/
create table task_log
(
   id                   varchar(14),
   task_id              varchar(14),
   task_name            varchar(100),
   task_oper_desc       varchar(200) comment '01 模拟登陆、02 下载、03 发送 等操作描述',
   oper_type            char(4) comment '01 手动操作
            02 自动操作',
   oper_by              varchar(10),
   oper_by_time         datetime
);

alter table task_log comment '值班任务日志表，记录值班任务操作，如果是RPA 需要提供相应接口调用';

/*==============================================================*/
/* Table: task_mail                                             */
/*==============================================================*/
create table task_mail
(
   id                   varchar(14),
   mail_theme           varchar(100),
   mail_addressee       varchar(1000),
   mail_cc              varchar(1100),
   mail_content         varchar(1000) comment '01：每天
            02：每周
            03：每月',
   attachment_name      varchar(100) comment '01 日常待办
            02 定时任务，URL
            03 辅助任务，链接',
   create_by            varchar(10),
   create_time          datetime,
   update_by            varchar(10),
   update_time          datetime
);

alter table task_mail comment '任务发送邮件模板库,方便引用';

/*==============================================================*/
/* Table: task_mail_config                                      */
/*==============================================================*/
create table task_mail_config
(
   id                   varchar(14),
   mail_template_name   varchar(100),
   mail_theme           varchar(100),
   mail_addressee       varchar(1000),
   mail_cc              varchar(1000),
   mail_content         varchar(1000) comment '01：每天
            02：每周
            03：每月',
   attachment_name      varchar(100) comment '01 日常待办
            02 定时任务，URL
            03 辅助任务，链接',
   mail_template_desc   varchar(1000),
   create_by            varchar(10),
   create_time          datetime,
   update_by            varchar(10),
   update_time          datetime
);

alter table task_mail_config comment '任务发送邮件模板库,方便引用';

/*==============================================================*/
/* Table: task_message                                          */
/*==============================================================*/
create table task_message
(
   id                   varchar(14),
   recipient_name       varchar(1000),
   recipient_phone      varchar(200),
   message_content      varchar(1000) comment '01：每天
            02：每周
            03：每月',
   create_by            varchar(10),
   create_time          datetime,
   update_by            varchar(10),
   update_time          datetime
);

alter table task_message comment '发送短信模板库,方便引用';

/*==============================================================*/
/* Table: task_message_config                                   */
/*==============================================================*/
create table task_message_config
(
   id                   varchar(14),
   message_template_name varchar(100),
   recipient_name       varchar(1000),
   recipient_phone      varchar(200),
   message_content      varchar(1000) comment '01：每天
            02：每周
            03：每月',
   message_template_desc varchar(1000),
   create_by            varchar(10),
   create_time          datetime,
   update_by            varchar(10),
   update_time          datetime
);

alter table task_message_config comment '发送短信模板库,方便引用';

/*==============================================================*/
/* Table: task_template                                         */
/*==============================================================*/
create table task_template
(
   id                   varchar(14),
   task_name            varchar(100),
   task_start_time      datetime,
   task_end_time        datetime,
   task_period          char(4) comment '01：每天
            02：每周
            03：每月',
   业务类型                 char(10) comment '01 常规值守
            02 流程自动批报
            03 报表自动报送
            04 经营风险管控
            05 值守驱优
            06 其它',
   task_type            char(4) comment '01 定时任务，后台任务名称
            02 RPA任务，RPA任务编码
            03 辅助任务，链接
            04 其它

            按照任务类型进行修改。',
   task_order           varchar(200) comment '01 日常待办
            02 定时任务，后台任务名称
            03 辅助任务，链接
            04 RPA任务，RPA任务编码',
   task_desc            varchar(200),
   remind_duration      int,
   remind_duration_unit char(4),
   template_desc        varchar(200),
   create_by            varchar(10),
   create_time          datetime,
   update_by            varchar(10),
   update_time          datetime
);

alter table task_template comment '值班任务模板库，自定义日常操作任务，方便引用';

/*==============================================================*/
/* Table: task_template_corre_mailAndphone                      */
/*==============================================================*/
create table task_template_corre_mailAndphone
(
   id                   varchar(14),
   task_template_id     varchar(14),
   push_type            char(4) comment '01 短信
            02 邮件
            03 电话
            04 APP消息
            05 OA站内信',
   mail_or_phone_id     varchar(10)
);

/*==============================================================*/
/* Table: voice_control_command                                 */
/*==============================================================*/
create table voice_control_command
(
   id                   varchar(14),
   command_name         varchar(50),
   command_code         varchar(10) comment '与FAQ结果编码一致',
   command_url          varchar(50),
   business_category    char(4) comment '01 调度
            0101 总览调度
            0102 钻取调度
            0103 数据调度
            02 告警
            0201 重复播报
            03 值守
            0301 风险管控
            04 讲解
            05 培训
            06 其它',
   command_desc         varchar(200),
   is_use               char(2) comment '0：启用
            1：未启用',
   create_time          datetime,
   create_by            varchar(10) comment '创建人工号',
   update_time          datetime,
   update_by            varchar(10) comment '修改人员工号'
);

alter table voice_control_command comment '语音调度指令表：打开、查询、下钻、重复

指令表与 科大讯飞 提供服务集成，集成方式需要后续 进';

/*==============================================================*/
/* Table: voice_control_log                                     */
/*==============================================================*/
create table voice_control_log
(
   id                   varchar(14),
   call_time            datetime,
   call_by              varchar(10),
   call_by_name         varchar(10),
   voice_control_command_id varchar(14),
   command_name         varchar(50),
   command_url          varchar(50),
   business_category    char(4),
   command_execute_state char(2) comment '调用指令执行状态
            01 成功
            02 失败',
   command_execute_desc varchar(200) comment '调用执行状态说明，如：失败时原因'
);

alter table voice_control_log comment '语音调度日志表';

/*==============================================================*/
/* Table: 告警业务配置表                                               */
/*==============================================================*/
create table 告警业务配置表
(
   id                   varchar(14),
   `interval`           int(10),
   repeat_alarm_num     int(10),
   is_del_onelevel      char(2),
   is_del_twolevel      char(2),
   is_del_threelevel    char(2),
   onelevel_sound       blob,
   twolevel_sound       blob,
   threelevel_sound     blob,
   sms_template         varchar(200),
   mail_template        varchar(200)
);

/*==============================================================*/
/* Table: 告警事件联系表                                               */
/*==============================================================*/
create table 告警事件联系表
(
   ID                   char(10),
   单位名称                 char(10),
   单位简称                 char(10),
   单位编码                 char(10),
   单位责任人                char(10),
   办公电话                 char(10),
   手机号                  char(10),
   邮箱                   char(10),
   备注                   char(10)
);

alter table 告警事件联系表 comment '配置告警事件联系单位';

/*==============================================================*/
/* Table: 虚拟值班定时任务                                              */
/*==============================================================*/
create table 虚拟值班定时任务
(
   id                   varchar(14),
   task_name            varchar(100),
   task_order           varchar(200),
   task_exe_args        varchar(100),
   task_state           char(2),
   create_time          datetime,
   create_by            varchar(14)
);

alter table 虚拟值班定时任务 comment '定时任务';

/*==============================================================*/
/* Table: 领导短信称呼配置                                              */
/*==============================================================*/
create table 领导短信称呼配置
(
   id                   char(10),
   值班领导姓名               char(10),
   值班领导职务（含姓）           char(10),
   电话                   char(10),
   邮箱                   char(10)
);

alter table 领导短信称呼配置 comment '主要用于处理短信尊称配置，目前按姓名匹配，存在重名问题。
如果发现重名，统一用”总“。';



