/*k线英雄 所需表*/
/*======================MA_USER_REVENUE========================================*/
prompt PL/SQL Developer import file
prompt Created on 2017年3月27日 by admin
set feedback off
set define off
-- prompt Dropping MA_USER_REVENUE...
-- drop table MA_USER_REVENUE cascade constraints;
prompt Creating MA_USER_REVENUE...
create table MA_USER_REVENUE
(
  user_id            NUMBER not null,
  nike_name          VARCHAR2(45),
  total_revenue_rate NUMBER(38,4),
  ranking            NUMBER
)
;
comment on column MA_USER_REVENUE.user_id
  is '用户id';
comment on column MA_USER_REVENUE.nike_name
  is '昵称';
comment on column MA_USER_REVENUE.total_revenue_rate
  is '总收益率';
comment on column MA_USER_REVENUE.ranking
  is '名次';
alter table MA_USER_REVENUE
  add constraint PK_MA_USER_REVENUE primary key (USER_ID)
  using index 
;
create sequence USER_REVENUE_SEQ
minvalue 1
maxvalue 999999999999
start with 2000
increment by 1
cache 20;
prompt Disabling triggers for MA_USER_REVENUE...
alter table MA_USER_REVENUE disable all triggers;
prompt Loading MA_USER_REVENUE...
prompt Table is empty
prompt Enabling triggers for MA_USER_REVENUE...
alter table MA_USER_REVENUE enable all triggers;
set feedback on
set define on
prompt Done.


/*========================MA_REVENUE_LOG======================================*/
prompt PL/SQL Developer import file
prompt Created on 2017年3月27日 by admin
set feedback off
set define off
-- prompt Dropping MA_REVENUE_LOG...
-- drop table MA_REVENUE_LOG cascade constraints;
prompt Creating MA_REVENUE_LOG...
create table MA_REVENUE_LOG
(
  id           NUMBER not null,
  user_id      NUMBER,
  stock_code   VARCHAR2(20),
  stock_name   VARCHAR2(20),
  start_time   DATE,
  end_time     DATE,
  revenue_rate NUMBER(38,4),
  nav_ratio    NUMBER(38,4),
  create_time  DATE
)
;
comment on column MA_REVENUE_LOG.id
  is '序列';
comment on column MA_REVENUE_LOG.user_id
  is '用户id';
comment on column MA_REVENUE_LOG.stock_code
  is '股票代码';
comment on column MA_REVENUE_LOG.stock_name
  is '名称';
comment on column MA_REVENUE_LOG.start_time
  is '游戏起始时间';
comment on column MA_REVENUE_LOG.end_time
  is '游戏结束时间';
comment on column MA_REVENUE_LOG.revenue_rate
  is '收益率';
comment on column MA_REVENUE_LOG.nav_ratio
  is '涨跌率';
create index MA_REVENUE_LOG_INX1 on MA_REVENUE_LOG (user_id);
create index MA_REVENUE_LOG_INX2 on MA_REVENUE_LOG (stock_code); 
alter table MA_REVENUE_LOG
  add constraint PK_MA_REVENUE_LOG primary key (ID)
  using index 
 ;
 
 
create sequence REVENUE_LOG_SEQ
minvalue 1
maxvalue 999999999999
start with 2000
increment by 1
cache 20;

prompt Disabling triggers for MA_REVENUE_LOG...
alter table MA_REVENUE_LOG disable all triggers;
prompt Loading MA_REVENUE_LOG...
prompt Table is empty
prompt Enabling triggers for MA_REVENUE_LOG...
alter table MA_REVENUE_LOG enable all triggers;
set feedback on
set define on
prompt Done.


/*=====================MA_STOCK_POOL=========================================*/
prompt PL/SQL Developer import file
prompt Created on 2017年3月27日 by admin
set feedback off
set define off
-- prompt Dropping MA_STOCK_POOL...
-- drop table MA_STOCK_POOL cascade constraints;
prompt Creating MA_STOCK_POOL...
create table MA_STOCK_POOL
(
  stock_code  VARCHAR2(20) not null,
  stock_name  VARCHAR2(20) not null,
  market_code NUMBER not null,
  status      NUMBER
)
;
comment on table MA_STOCK_POOL
  is '股票池';
comment on column MA_STOCK_POOL.stock_code
  is '股票代码';
comment on column MA_STOCK_POOL.stock_name
  is '名称';
comment on column MA_STOCK_POOL.market_code
  is '市场标识';
comment on column MA_STOCK_POOL.status
  is '是否有效';
alter table MA_STOCK_POOL
  add constraint PK_MA_STOCK_POOL primary key (STOCK_CODE)
  using index 
;
create sequence STOCK_POOL_SEQ
minvalue 1
maxvalue 999999999999
start with 2000
increment by 1
cache 20;

prompt Disabling triggers for MA_STOCK_POOL...
alter table MA_STOCK_POOL disable all triggers;
prompt Loading MA_STOCK_POOL...
prompt Table is empty
prompt Enabling triggers for MA_STOCK_POOL...
alter table MA_STOCK_POOL enable all triggers;
set feedback on
set define on
prompt Done.


create table MA_History_ranking
(
  user_id number not null,
  rate    NUMBER(38,4),
  dateTime    number,
  rank    number,
  prize_point NUMBER
);
comment on table MA_History_ranking
  is 'K线历史排行表';
comment on column MA_History_ranking.user_id
  is '用户标识';
comment on column MA_History_ranking.rate
  is '收益率';
comment on column MA_History_ranking.dateTime
  is '时间精确到日';
comment on column MA_History_ranking.rank
  is '名次';
comment on column MA_HISTORY_RANKING.prize_point
  is '奖励分数';
create index MA_History_ranking_INX1 on MA_History_ranking (rank);
create index MA_History_ranking_INX2 on MA_History_ranking (dateTime);
create index MA_History_ranking_INX3 on MA_History_ranking (user_id);



create table MA_TODAY_ranking
(
  user_id number not null,
  rate    NUMBER(38,4),
  dateTime    number
);
comment on table MA_TODAY_ranking
  is 'K线今日排行表';
comment on column MA_TODAY_ranking.user_id
  is '用户标识';
comment on column MA_TODAY_ranking.rate
  is '收益率';
comment on column MA_TODAY_ranking.dateTime
  is '时间精确到日';
  
create index MA_TODAY_ranking_INX1 on MA_TODAY_ranking (dateTime);
create index MA_TODAY_ranking_INX2 on MA_TODAY_ranking (user_id);


-- Create table
create table MA_USERINFO
(
  user_id   NUMBER not null,
  mobile    VARCHAR2(64),
  image     VARCHAR2(50),
  nick_name VARCHAR2(45)
);
-- Add comments to the table 
comment on table MA_USERINFO
  is '游戏用户信息表';
-- Add comments to the columns 
comment on column MA_USERINFO.user_id
  is '用户标识';
comment on column MA_USERINFO.mobile
  is '手机号';
comment on column MA_USERINFO.image
  is '头像路径';
comment on column MA_USERINFO.nick_name
  is '昵称';
  
  
-- Create table
create table MA_USER_POINT_LOG
(
  id           NUMBER(14),
  user_id      NUMBER(14),
  mobile       VARCHAR2(64),
  occur_points NUMBER(14),
  type         CHAR(1),
  game_id      CHAR(1),
  remark       VARCHAR2(2000),
  code         VARCHAR2(32),
  create_time  date
);
-- Add comments to the table 
comment on table MA_USER_POINT_LOG
  is '积分记录表';
-- Add comments to the columns 
comment on column MA_USER_POINT_LOG.id
  is '流水id';
comment on column MA_USER_POINT_LOG.user_id
  is '用户id';
comment on column MA_USER_POINT_LOG.mobile
  is '手机号';
comment on column MA_USER_POINT_LOG.occur_points
  is '积分变化值';
comment on column MA_USER_POINT_LOG.type
  is '1消耗  2获取';
comment on column MA_USER_POINT_LOG.game_id
  is '游戏标示';
comment on column MA_USER_POINT_LOG.remark
  is '备注';
comment on column MA_USER_POINT_LOG.code
  is '积分配置信息ID';
comment on column MA_USER_POINT_LOG.create_time
  is '时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table MA_USER_POINT_LOG
  add constraint PK_MA_USER_POINT_LOG primary key (ID);
  
create sequence USER_POINT_LOG_SEQ
minvalue 1
maxvalue 999999999999
start with 2000
increment by 1
cache 20;


--游戏用户表MA_game_user
create table MA_GAME_USER
(
  id             NUMBER(14) not null,
  game_id      	 NUMBER(14),
  account_id     NUMBER(14),
  count          NUMBER(14),
  today_count          NUMBER(14),
  last_play_time DATE
)
;
comment on column MA_GAME_USER.count
  is '玩游戏的次数';
comment on column MA_GAME_USER.last_play_time
  is '最后一次游戏时间';
  comment on column MA_GAME_USER.today_count
  is '今日玩游戏的次数';
alter table MA_GAME_USER
  add constraint PK_MA_GAME_USER primary key (ID)
  using index 
;
-- Create sequence 
create sequence GAME_USER_SEQ
minvalue 1
maxvalue 999999999999
start with 2000
increment by 1
cache 20;

