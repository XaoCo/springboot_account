-- Create table 用户表
create table A_USER
(
  U_ID            NUMBER not null,
  U_NAME          VARCHAR2(20) not null,
  U_AGE           NUMBER not null,
  U_JOB           VARCHAR2(20) not null,
  U_PASSWORD      VARCHAR2(20) not null,
  U_IDENTITY_CARD VARCHAR2(18) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column A_USER.U_ID
  is '用户编号';
comment on column A_USER.U_NAME
  is '用户姓名';
comment on column A_USER.U_AGE
  is '用户性别';
comment on column A_USER.U_JOB
  is '用户工作';
comment on column A_USER.U_PASSWORD
  is '用户密码';
comment on column A_USER.U_IDENTITY_CARD
  is '身份证';
-- Create/Recreate primary, unique and foreign key constraints 
alter table A_USER
  add constraint PK_1 primary key (U_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate indexes 
create unique index NO1 on A_USER (U_NAME, U_IDENTITY_CARD)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );





  
  
  
-- Create table  类别表
create table A_KIND
(
  K_ID   NUMBER not null,
  K_NAME VARCHAR2(20) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the columns 
comment on column A_KIND.K_ID
  is '花销或者入账的类别编号';
comment on column A_KIND.K_NAME
  is '花销或者入账的类别名称';
-- Create/Recreate indexes 
create unique index NO2 on A_KIND (K_ID, K_NAME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
  
-- Create table  收支总表
create table A_INOUT_ALL
(
  A_ID     NUMBER not null,
  A_U_NAME VARCHAR2(20) not null,
  A_K_NAME VARCHAR2(20) not null,
  A_FLAG   NUMBER not null,
  A_DESC   VARCHAR2(200),
  A_CHARGE NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the columns 
comment on column A_INOUT_ALL.A_ID
  is '账目编号';
comment on column A_INOUT_ALL.A_U_NAME
  is '用户';
comment on column A_INOUT_ALL.A_K_NAME
  is '花销类型';
comment on column A_INOUT_ALL.A_FLAG
  is '收支标志';
comment on column A_INOUT_ALL.A_DESC
  is '用途描述';
comment on column A_INOUT_ALL.A_CHARGE
  is '金额';
-- Create/Recreate primary, unique and foreign key constraints 
alter table A_INOUT_ALL
  add constraint PK primary key (A_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
  
  
  
-- Create sequence 
create sequence USER_SEQ
minvalue 1001
maxvalue 9999
start with 1061
increment by 1
cache 20
order;


-- Create sequence 
create sequence KIND_SEQ
minvalue 1001
maxvalue 9999
start with 1001
increment by 1
cache 20
order;

-- Create sequence 
create sequence RECORD_SEQ
minvalue 1001
maxvalue 9999
start with 1001
increment by 1
cache 20
order;

