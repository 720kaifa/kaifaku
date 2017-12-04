--游戏用户表t_sq_game_user
create table T_SQ_GAME_USER
(
  id             NUMBER(14) not null,
  game_id      	 NUMBER(14),
  account_id     NUMBER(14),
  count          NUMBER(14),
  today_count          NUMBER(14),
  last_play_time DATE
)
;
comment on column T_SQ_GAME_USER.count
  is '玩游戏的次数';
comment on column T_SQ_GAME_USER.last_play_time
  is '最后一次游戏时间';
  comment on column T_SQ_GAME_USER.today_count
  is '今日玩游戏的次数';
alter table T_SQ_GAME_USER
  add constraint PK_T_SQ_GAME_USER primary key (ID)
  using index 
;
-- Create sequence 
create sequence GAME_USER_SEQ
minvalue 1
maxvalue 999999999999
start with 2000
increment by 1
cache 20;

prompt Done.


/*=====================T_SQ_GUESS_COUNT=========================================*/

-- drop table T_SQ_GUESS_COUNT cascade constraints;
prompt
prompt Creating table T_SQ_GUESS_COUNT
prompt ===============================
prompt
create table T_SQ_GUESS_COUNT
(
  count_id              NUMBER(18) not null,
  user_id               NUMBER(14) not null,
  user_name             VARCHAR2(64) not null,
  success_rate          NUMBER(14,4) default 0 not null,
  total_revenue         INTEGER default 0 not null,
  win_time     			INTEGER default 0 not null,
  failure_time  		INTEGER default 0 not null,
  max_win_time 			INTEGER default 0 not null,
  create_time           DATE,
  update_time           DATE
)
;
comment on table T_SQ_GUESS_COUNT
  is '猜涨跌财富统计';
comment on column T_SQ_GUESS_COUNT.count_id
  is 'ID';
comment on column T_SQ_GUESS_COUNT.user_id
  is '用户ID';
comment on column T_SQ_GUESS_COUNT.user_name
  is '用户昵称';
comment on column T_SQ_GUESS_COUNT.success_rate
  is '成功率';
comment on column T_SQ_GUESS_COUNT.total_revenue
  is '总收益';
comment on column T_SQ_GUESS_COUNT.win_time
  is '猜赢次数';
comment on column T_SQ_GUESS_COUNT.failure_time
  is '猜败次数';
comment on column T_SQ_GUESS_COUNT.max_win_time
  is '单日最大命中次数';
comment on column T_SQ_GUESS_COUNT.create_time
  is '创建时间';
comment on column T_SQ_GUESS_COUNT.update_time
  is '更新时间';
create unique index T_SQ_GUESS_COUNT_INX1 on T_SQ_GUESS_COUNT (USER_ID)
;
alter table T_SQ_GUESS_COUNT
  add constraint PK_T_SQ_GUESS_COUNT primary key (COUNT_ID)
;

create sequence GUESS_COUNT_SEQ
minvalue 1
maxvalue 999999999999
start with 2000
increment by 1
cache 20;

prompt
prompt Creating table T_SQ_GUESS_STAKE
prompt ===============================
prompt  
create table T_SQ_GUESS_STAKE
(
  stake_id       NUMBER(18) not null,
  user_id        NUMBER(14),
  user_name      VARCHAR2(64),
  term_no        NUMBER(14),
  stake_time     DATE,
  stake_points   INTEGER,
  stake_win_lose VARCHAR2(10),
  prize_flag     INTEGER default 0,
  prize_points   INTEGER,
  delivery_flag  INTEGER,
  delivery_time  DATE,
  back_points    INTEGER
)
;
comment on table T_SQ_GUESS_STAKE
  is '猜大盘押注';
comment on column T_SQ_GUESS_STAKE.stake_id
  is '押注ID';
comment on column T_SQ_GUESS_STAKE.user_id
  is '押注用户ID';
comment on column T_SQ_GUESS_STAKE.user_name
  is '押注人名称';
comment on column T_SQ_GUESS_STAKE.term_no
  is '开奖的周期';
comment on column T_SQ_GUESS_STAKE.stake_time
  is '押注时间';
comment on column T_SQ_GUESS_STAKE.stake_points
  is '押注分数   >0';
comment on column T_SQ_GUESS_STAKE.stake_win_lose
  is '押注内容 目前指猜大盘  -1  跌  0  平  1 涨';
comment on column T_SQ_GUESS_STAKE.prize_flag
  is '是否中间 0   表示未中奖  1 表示中奖 ';
comment on column T_SQ_GUESS_STAKE.prize_points
  is '中奖积分数';
comment on column T_SQ_GUESS_STAKE.delivery_flag
  is '是否已经发奖';
comment on column T_SQ_GUESS_STAKE.back_points
  is '返回分数';
create index T_SQ_GUESS_STAKE_INX1 on T_SQ_GUESS_STAKE (USER_ID);
create index T_SQ_GUESS_STAKE_INX2 on T_SQ_GUESS_STAKE (TERM_NO);
alter table T_SQ_GUESS_STAKE
  add constraint PK_GUESS_STAKE primary key (STAKE_ID);

create sequence GUESS_STAKE_SEQ
minvalue 1
maxvalue 999999999999
start with 2000
increment by 1
cache 20;


---------------------------------------------
prompt
prompt Creating table T_SQ_GUESS_TERM
prompt =========================
prompt
create table T_SQ_GUESS_TERM
(
  term_id            NUMBER(14) not null,
  term_no            NUMBER(14),
  term_name          VARCHAR2(50),
  sign_begin_date    DATE,
  sign_end_date      DATE,
  match_begin_date   DATE,
  match_end_date     DATE,
  limit_stake_points INTEGER,
  attend_count       INTEGER,
  total_stake_points INTEGER,
  total_prize_points INTEGER,
  term_result        VARCHAR2(50),
  delivery_control   INTEGER,
  create_datetime    DATE,
  create_by          NUMBER(14),
  guess_zhang_points INTEGER,
  guess_die_points   INTEGER,
  term_describe           VARCHAR2(50)
)
;
comment on table T_SQ_GUESS_TERM
  is '猜大盘期数';
comment on column T_SQ_GUESS_TERM.term_id
  is '改期ID';
comment on column T_SQ_GUESS_TERM.term_no
  is '改期编号';
comment on column T_SQ_GUESS_TERM.term_name
  is '改期名字';
comment on column T_SQ_GUESS_TERM.sign_begin_date
  is '押注开始时间';
comment on column T_SQ_GUESS_TERM.sign_end_date
  is '押注截止时间';
comment on column T_SQ_GUESS_TERM.match_begin_date
  is '改期开始时间';
comment on column T_SQ_GUESS_TERM.match_end_date
  is '改期截止时间';
comment on column T_SQ_GUESS_TERM.limit_stake_points
  is '没人押注限制 ';
comment on column T_SQ_GUESS_TERM.attend_count
  is '参与人数';
comment on column T_SQ_GUESS_TERM.total_stake_points
  is '总押注多少积分';
comment on column T_SQ_GUESS_TERM.total_prize_points
  is '总共发多少积分';
comment on column T_SQ_GUESS_TERM.term_result
  is '开奖结果    目前 -1  表示跌 0  平  1 涨';
comment on column T_SQ_GUESS_TERM.delivery_control
  is '发奖控制    0  创建      3  发放point中   4  完成    9 异常 ';
comment on column T_SQ_GUESS_TERM.create_datetime
  is '该期创建时间';
comment on column T_SQ_GUESS_TERM.create_by
  is '创建人';
comment on column T_SQ_GUESS_TERM.guess_zhang_points
  is '押涨总积分';
comment on column T_SQ_GUESS_TERM.guess_die_points
  is '押跌总积分';
comment on column T_SQ_GUESS_TERM.term_describe
  is '描述';
create unique index T_SQ_GUESS_TERM_INX1 on T_SQ_GUESS_TERM (TERM_NO)
;
alter table T_SQ_GUESS_TERM
  add constraint PK_GUESS_TERM primary key (TERM_ID)
  using index 
;

create sequence GUESS_TERM_SEQ
minvalue 1
maxvalue 999999999999
start with 2000
increment by 1
cache 20;