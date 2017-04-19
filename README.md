# spring-mybatis
spring-boot实现mybatis分页

分页插件：pageHelper

表相关信息：
sql
```
create table MOT_ACTIVITY
(
  activity_id   NUMBER(20) not null,
  activity_name VARCHAR2(30),
  activity_desc VARCHAR2(200),
  activity_cost INTEGER,
  start_date    DATE,
  expired_date  DATE,
  activity_flow CLOB,
  creator       NUMBER(20),
  create_time   DATE,
  modify_time   DATE,
  status        INTEGER,
  event_list    VARCHAR2(400)
)
tablespace DATA1_TS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table MOT_ACTIVITY
  is 'mot营销活动管理';
-- Add comments to the columns 
comment on column MOT_ACTIVITY.activity_id
  is '营销活动的唯一ID，使用sequence生产';
comment on column MOT_ACTIVITY.activity_name
  is '营销活动名称';
comment on column MOT_ACTIVITY.activity_desc
  is '营销活动描述';
comment on column MOT_ACTIVITY.activity_cost
  is '营销活动的成本';
comment on column MOT_ACTIVITY.activity_flow
  is '营销活动的流程图，使用xml存储';
comment on column MOT_ACTIVITY.status
  is '营销活动的状态
0：运行中
1：未启动
2：暂停
3：未提交
4：审核中';
comment on column MOT_ACTIVITY.event_list
  is '营销活动关联的事件ID';
-- Create/Recreate primary, unique and foreign key constraints 
alter table MOT_ACTIVITY
  add constraint PK_MOT_ACTIVITY primary key (ACTIVITY_ID)
  using index 
  tablespace DATA1_TS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
```
