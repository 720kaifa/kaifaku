/* 猜大盘清算 */

create or replace package pkg_guess is
   procedure guess_clear(p_term_no in number,p_result out  integer);


   procedure delivery_prize(p_term_no in number,v_term_result in varchar2,p_attend_count out integer,p_total_stake out integer,p_total_prize out integer, p_result out integer);

   -- 积分记录
  function chg_point(p_user_id number,p_point_chg integer,p_biz_code varchar2,p_note varchar2) return number ;
   
end pkg_guess;

/
create or replace package body pkg_guess is

   procedure guess_clear(p_term_no in number,p_result out  integer)
   is
     v_sql_str varchar2(1000);
     v_guess_term_rec  t_sq_guess_term%rowtype;
     v_term_result varchar2(10);
     v_delivery_status  integer;
     v_total_attend integer:=0;
     v_total_stake integer:=0;
     v_total_prize integer:=0;
     v_result integer;
  begin

     begin
       select t.* into  v_guess_term_rec from t_sq_guess_term t where  t.term_no = p_term_no;
     exception
       when others then
           p_result:=-1;
           return ;
     end ;


     v_term_result:= v_guess_term_rec.term_result;
     v_delivery_status:= v_guess_term_rec.delivery_control;

     -- 赛期状态不正常
     if  v_delivery_status <> 0  then
         p_result:=-2;
         return ;
     end if;

     -- 指数没有结果信息
     if v_term_result is null then
         p_result:=-3;
         return ;
     end if;

     -- 比赛未结束
     if  sysdate - v_guess_term_rec.match_end_date<=0 then
         p_result:=-4;
         return ;
     end if;


     update t_sq_guess_term t set t.delivery_control = '3' where t.term_no = p_term_no;
     commit;

     delivery_prize(p_term_no,v_term_result,v_total_attend,v_total_stake,v_total_prize,v_result);
     if  v_result =0  then
         p_result:=v_result;
         update  t_sq_guess_term t  set t.delivery_control ='4',t.attend_count=v_total_attend , t.total_stake_points =v_total_stake ,t.total_prize_points =v_total_prize   where  t.term_no = p_term_no;
         commit;
     else
         p_result:=v_result;
         update t_sq_guess_term t  set t.delivery_control = '9' where  t.term_no = p_term_no;
         commit;
     end if;
  end guess_clear;

  procedure delivery_prize(p_term_no in number,v_term_result in varchar2, p_attend_count out integer,p_total_stake out integer,p_total_prize out integer,p_result out integer) is

    v_stake_rec  t_sq_guess_stake%rowtype;
    v_stake_id number;
    v_stake_result varchar2(10);
    v_price_point  integer:=0;
    v_total_attend integer:=0;
    v_total_stake integer:=0;
    v_total_prize integer:=0;
    v_guess_point_biz  constant varchar2(6):='0009';
    v_call_result number;
    cursor stake_cur  is select  * from t_sq_guess_stake where term_no = p_term_no;
  begin

      open stake_cur;
      loop
         fetch stake_cur into v_stake_rec;
         exit when stake_cur%notfound;

              v_total_attend :=v_total_attend+1;
              v_total_stake :=  v_total_stake + v_stake_rec.stake_points;

              v_stake_result :=v_stake_rec.stake_win_lose;
              v_stake_id :=v_stake_rec.stake_id;
              if v_term_result = v_stake_result then
                   v_price_point := 2*v_stake_rec.stake_points;
                   v_total_prize :=  v_total_prize + v_price_point;

                   v_call_result:=chg_point(v_stake_rec.user_id,v_price_point,v_guess_point_biz,'猜大盘');
                   if  v_call_result >=0  then
                     update t_sq_guess_stake  t  set t.prize_flag = 1 ,t.prize_points=v_price_point,t.delivery_flag=1,t.delivery_time=sysdate where t.stake_id =v_stake_id;
                     commit;
                   else
                      update t_sq_guess_stake  t  set t.prize_flag = 1 ,t.prize_points=v_price_point,t.delivery_flag=9,t.delivery_time=sysdate where t.stake_id =v_stake_id;
                      commit;
                   end if;

              else
                   update t_sq_guess_stake  t  set t.prize_flag = 0 ,t.prize_points=0,t.delivery_flag=1,t.delivery_time=sysdate where t.stake_id =v_stake_id;
                   commit;
              end if;
      end loop;
    close stake_cur;

    p_attend_count:=v_total_attend;
    p_total_stake:=v_total_stake;
    p_total_prize :=v_total_prize;
    p_result:=0;
    return ;
end delivery_prize;


function  chg_point(p_user_id number,p_point_chg integer,p_biz_code varchar2,p_note varchar2) return number is
    v_point_rec t_sq_user_point%rowtype;
    v_biz_rec  t_sq_base_point_define%rowtype;
    v_sql_str varchar2(1000);
    v_total_points number;
    v_available_points  number;

    v_occur_points  integer;
    v_used_points integer:=0;
  begin
       -- 积分定义判断
       begin
        select *
          into v_biz_rec
          from t_sq_base_point_define t
         where t.code = p_biz_code;
        if (v_biz_rec.status <> 1) then
          return - 1; -- 积分定义不存在
        end if;

        if (v_biz_rec.points = 0) then
           v_occur_points := p_point_chg ;
        else
           v_occur_points := v_biz_rec.points;
        end if;

        if (v_occur_points < 0) then
          v_used_points := abs(v_occur_points);
        else
          v_used_points := 0;
        end if;
    exception
        when others then
           return -9; -- 系统错误
     end;

     --  积分账户判断
     begin
            select * into  v_point_rec from  t_sq_user_point t where t.user_id = p_user_id ;
            v_total_points  :=v_point_rec.total_points + v_occur_points;
            v_available_points := v_point_rec.available_points + v_occur_points;
            if(v_available_points< 0) then
                return -2; -- 积分不足
             end if;
     exception
        when others then
           return -9; -- 系统错误
     end;

     begin
          -- 积分流水
          insert into t_sq_user_point_log
                     (id,
                      user_id,
                      occur_points,
                      after_points,
                      point_define_code,
                      remark,
                      create_time
                      )
               select user_point_log_seq.nextval,p_user_id,
                      v_occur_points,
                      v_available_points,
                      p_biz_code,
                      p_note,
                      sysdate
               from dual;

                update t_sq_user_point t set t.total_points = v_total_points ,t.available_points =v_available_points,t.used_points = t.used_points + v_used_points  where t.user_id =  p_user_id;
                commit;

                return   v_available_points;
     exception when others then
         return -9;
     end ;
  end chg_point;



end pkg_guess;
/
