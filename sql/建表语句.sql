prompt PL/SQL Developer import file
prompt Created on 2019年10月12日 by abc
set feedback off
set define off
prompt Creating A_GOAL...
create table A_GOAL
(
  GOALID      NUMBER not null,
  GOALNAME    VARCHAR2(50) not null,
  GOALDESC    VARCHAR2(60) not null,
  GOALTOTAL   VARCHAR2(60) not null,
  GOALPERCENT VARCHAR2(60),
  ENDDATE     VARCHAR2(10) not null,
  PROCESS     VARCHAR2(10),
  USERNAME    VARCHAR2(20) not null
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
alter table A_GOAL
  add constraint GOAL_PK primary key (GOALID)
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

prompt Creating A_INOUT_ALL...
create table A_INOUT_ALL
(
  A_ID     NUMBER not null,
  A_U_NAME VARCHAR2(20) not null,
  A_K_NAME VARCHAR2(20) not null,
  A_FLAG   NUMBER not null,
  A_DESC   VARCHAR2(200),
  A_CHARGE VARCHAR2(20) not null,
  A_DATE   VARCHAR2(10) not null
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
comment on column A_INOUT_ALL.A_DATE
  is '记录日期';
alter table A_INOUT_ALL
  add constraint PK primary key (A_ID)
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

prompt Creating A_KIND...
create table A_KIND
(
  K_ID   NUMBER not null,
  K_NAME VARCHAR2(20) not null,
  K_FLAG VARCHAR2(1) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column A_KIND.K_ID
  is '花销或者入账的类别编号';
comment on column A_KIND.K_NAME
  is '花销或者入账的类别名称';
create unique index NO2 on A_KIND (K_ID, K_NAME)
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

prompt Creating A_POSITION...
create table A_POSITION
(
  POSITION_ID   NUMBER not null,
  POSITION_NAME VARCHAR2(50) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table A_POSITION
  add constraint POSITION_PK primary key (POSITION_ID)
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

prompt Creating A_USER...
create table A_USER
(
  U_ID       NUMBER not null,
  U_NAME     VARCHAR2(20) default 'Family',
  U_PASSWORD VARCHAR2(32) default '000000',
  U_POSITION VARCHAR2(50) default '无名之辈',
  U_EMAIL    VARCHAR2(30) not null
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
comment on column A_USER.U_ID
  is '用户编号';
comment on column A_USER.U_NAME
  is '用户姓名';
comment on column A_USER.U_PASSWORD
  is '用户密码';
comment on column A_USER.U_POSITION
  is '家庭地位';
comment on column A_USER.U_EMAIL
  is '邮箱';
alter table A_USER
  add constraint PK_1 primary key (U_EMAIL)
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

prompt Disabling triggers for A_GOAL...
alter table A_GOAL disable all triggers;
prompt Disabling triggers for A_INOUT_ALL...
alter table A_INOUT_ALL disable all triggers;
prompt Disabling triggers for A_KIND...
alter table A_KIND disable all triggers;
prompt Disabling triggers for A_POSITION...
alter table A_POSITION disable all triggers;
prompt Disabling triggers for A_USER...
alter table A_USER disable all triggers;
prompt Loading A_GOAL...
insert into A_GOAL (GOALID, GOALNAME, GOALDESC, GOALTOTAL, GOALPERCENT, ENDDATE, PROCESS, USERNAME)
values (1132, '买房zi', '天津买房', '1234', null, '20191011', null, '333@qq.com');
commit;
prompt 1 records loaded
prompt Loading A_INOUT_ALL...
insert into A_INOUT_ALL (A_ID, A_U_NAME, A_K_NAME, A_FLAG, A_DESC, A_CHARGE, A_DATE)
values (1163, '333@qq.com', '预留买房', 3, '买房', '3000', '20191012');
insert into A_INOUT_ALL (A_ID, A_U_NAME, A_K_NAME, A_FLAG, A_DESC, A_CHARGE, A_DATE)
values (1164, '333@qq.com', '私活', 1, '打零工', '200', '20191012');
insert into A_INOUT_ALL (A_ID, A_U_NAME, A_K_NAME, A_FLAG, A_DESC, A_CHARGE, A_DATE)
values (1162, '333@qq.com', '公交打车', 0, '公交', '30', '20191012');
insert into A_INOUT_ALL (A_ID, A_U_NAME, A_K_NAME, A_FLAG, A_DESC, A_CHARGE, A_DATE)
values (1166, '333@qq.com', '外快', 1, '打零工', '3000', '20191012');
insert into A_INOUT_ALL (A_ID, A_U_NAME, A_K_NAME, A_FLAG, A_DESC, A_CHARGE, A_DATE)
values (1151, '333@qq.com', '工资', 1, '工资', '5090', '20190925');
insert into A_INOUT_ALL (A_ID, A_U_NAME, A_K_NAME, A_FLAG, A_DESC, A_CHARGE, A_DATE)
values (1152, '333@qq.com', '买菜', 0, '下班买新鲜蔬菜', '11.99', '20191011');
insert into A_INOUT_ALL (A_ID, A_U_NAME, A_K_NAME, A_FLAG, A_DESC, A_CHARGE, A_DATE)
values (1149, '333@qq.com', '预留房租', 3, '房租', '3000', '20190926');
commit;
prompt 7 records loaded
prompt Loading A_KIND...
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1001, '日常用品', '0');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1002, '人情+礼物', '0');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1003, '下馆子', '0');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1004, '买菜', '0');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1005, '公交打车', '0');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1006, '工资', '1');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1007, '外快', '1');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1008, '私活', '1');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1015, '预留买房', '3');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1009, '预留房租', '3');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1010, '预留保险', '3');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1011, '预留办公', '3');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1012, '其他', '3');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1013, '其他', '1');
insert into A_KIND (K_ID, K_NAME, K_FLAG)
values (1014, '其他', '0');
commit;
prompt 15 records loaded
prompt Loading A_POSITION...
insert into A_POSITION (POSITION_ID, POSITION_NAME)
values (1001, '说一不二的大大');
insert into A_POSITION (POSITION_ID, POSITION_NAME)
values (1002, '任劳任怨的伙计');
commit;
prompt 2 records loaded
prompt Loading A_USER...
insert into A_USER (U_ID, U_NAME, U_PASSWORD, U_POSITION, U_EMAIL)
values (1424, 'caopu', '96e79218965eb72c92a549dd5a330112', '说一不二的大大', '333@qq.com');
commit;
prompt 1 records loaded
prompt Enabling triggers for A_GOAL...
alter table A_GOAL enable all triggers;
prompt Enabling triggers for A_INOUT_ALL...
alter table A_INOUT_ALL enable all triggers;
prompt Enabling triggers for A_KIND...
alter table A_KIND enable all triggers;
prompt Enabling triggers for A_POSITION...
alter table A_POSITION enable all triggers;
prompt Enabling triggers for A_USER...
alter table A_USER enable all triggers;
set feedback on
set define on
prompt Done.



CREATE SEQUENCE  "SCOTT"."USER_SEQ"  MINVALUE 1001 MAXVALUE 9999 INCREMENT BY 1 START WITH 1021 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  "SCOTT"."RECORD_SEQ"  MINVALUE 10001 MAXVALUE 99999 INCREMENT BY 1 START WITH 10001 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  "SCOTT"."KIND_SEQ"  MINVALUE 1001 MAXVALUE 9999 INCREMENT BY 1 START WITH 1001 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  "SCOTT"."GOAL_SEQ"  MINVALUE 10001 MAXVALUE 99999 INCREMENT BY 1 START WITH 10001 CACHE 20 NOORDER  NOCYCLE ;
