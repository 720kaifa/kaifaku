 /* 初始化t_sq_guess_term 猜大盘周期表数据  */

create or replace package guessTerm is

procedure test1(p_result out integer);

end guessTerm;
/
create or replace package body guessTerm is

 procedure test1(p_result out integer) is
     v_sql_str varchar2(1000);

     v_num integer;
     v_num2 integer;
     v_num3 integer;
     v_date integer;
     v_inc_date date;
     v_temp date;
     v_term_no number;
  begin
	
     select to_char(sysdate-1,'yyyyMMdd') into v_date  from dual;
     for tradingdays in (select t.trade_date from T_SQ_TRADING_CALENDAR t 
		WHERE t.trade_date > v_date AND t.trade_flag =1 ORDER BY trade_date)
		loop
		
           select  to_date(tradingdays.trade_date,'yyyyMMdd')+ 9.5/24  into v_inc_date from dual;
           for v_num2 in 1..120 loop
                v_temp:=v_inc_date + v_num2/24/60;
                v_term_no :=to_char(v_temp,'yyyyMMddHH24mi');

            insert into t_sq_guess_term(term_id,
                  term_no,
                  term_name,
                  sign_begin_date,
                  sign_end_date,
                  match_begin_date,
                  match_end_date,
                  limit_stake_points,
                  attend_count,
                  total_stake_points,
                  total_prize_points,
                  term_result,
                  delivery_control,
                  create_datetime)
           select guess_term_seq.nextval,
                  v_term_no,
                  v_term_no || 'name',
                  v_temp - 2/24/60,
                  v_temp - 1/24/60,
                  v_temp - 1/24/60,
                  v_temp,
                  100,
                  0,
                  0,
                  0,
                  0,
                  0,
                  sysdate
             from dual;
           end loop;
           commit;

           select    to_date(tradingdays.trade_date,'yyyyMMdd') + 13/24 into v_inc_date from dual;
           for v_num3 in 1..120 loop

                v_temp:= v_inc_date + v_num3/24/60;
                v_term_no :=to_char(v_temp,'yyyyMMddHH24mi');

                insert into t_sq_guess_term(term_id,
                  term_no,
                  term_name,
                  sign_begin_date,
                  sign_end_date,
                  match_begin_date,
                  match_end_date,
                  limit_stake_points,
                  attend_count,
                  total_stake_points,
                  total_prize_points,
                  term_result,
                  delivery_control,
                  create_datetime)
           select guess_term_seq.nextval,
                  v_term_no,
                  v_term_no || 'name',
                  v_temp - 2/24/60,
                  v_temp - 1/24/60,
                  v_temp - 1/24/60,
                  v_temp,
                  100,
                  0,
                  0,
                  0,
                  0,
                  0,
                  sysdate
             from dual;
           end loop;
           commit;
          
     end loop;

  end test1;
end guessTerm;
/