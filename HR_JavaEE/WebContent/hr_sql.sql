------------------------------------------------------
-- Export file for user ICSSHR                      --
-- Created by Administrator on 2017/10/16, 14:15:16 --
------------------------------------------------------

spool hr_sql.log

prompt
prompt Creating table ADMIN
prompt ====================
prompt
create table ICSSHR.ADMIN
(
  ADMIN_NAME     VARCHAR2(30) not null,
  ADMIN_PASSWORD VARCHAR2(30) not null,
  STATUS         CHAR(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ICSSHR.ADMIN
  add primary key (ADMIN_NAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table DEPT
prompt ===================
prompt
create table ICSSHR.DEPT
(
  DEPT_ID   NUMBER(3) not null,
  DEPT_NAME VARCHAR2(30) default '' not null,
  DEPT_LOC  VARCHAR2(30) default '' not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ICSSHR.DEPT
  add primary key (DEPT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table DUTY
prompt ===================
prompt
create table ICSSHR.DUTY
(
  DUTY_ID         NUMBER(3) not null,
  DUTY_NAME       VARCHAR2(30) default '' not null,
  DUTY_MAX_SALARY NUMBER(9,2) default 0 not null,
  DUTY_MIN_SALARY NUMBER(9,2) default 0 not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ICSSHR.DUTY
  add primary key (DUTY_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table STAFF
prompt ====================
prompt
create table ICSSHR.STAFF
(
  STAFF_ID     NUMBER(10) not null,
  STAFF_NAME   VARCHAR2(30) default '' not null,
  STAFF_SEX    VARCHAR2(6) default 'ÄÐ' not null,
  STAFF_PHONE  VARCHAR2(11) default 0 not null,
  STAFF_SALARY NUMBER(9,2) default 0 not null,
  STAFF_DEPT   NUMBER(3),
  STAFF_DUTY   NUMBER(3)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ICSSHR.STAFF
  add primary key (STAFF_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ICSSHR.STAFF
  add foreign key (STAFF_DEPT)
  references ICSSHR.DEPT (DEPT_ID);
alter table ICSSHR.STAFF
  add foreign key (STAFF_DUTY)
  references ICSSHR.DUTY (DUTY_ID);


spool off
