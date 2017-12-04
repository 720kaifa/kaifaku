package cairh.community.api.game.kxian.common;


/**
 * Created by luyj on 2016/9/16.
 */
public class RedisKeyConstants {
    public static final String FOLLOWED_ACCOUNT_ID = "_followed_account_id_";
   
    
    public static final String FOLLOWED_IMPORT_TIME = "_fimport_time_";
    
    
    public static final String MSG_LIST = "_msg_list_";

    public static final String RT_LOTTERY_LIST = "rt_lottery_list";
    public static final String PRODUCTS_LIST = "_products_list_";

    public static final String TXNRH_VALIDATE_CODE_TIME = "txnrh_validate_code_time";
    public static final String POINT_ACTION_PASSPHRASE = "point_action_passphrase";
    public static final String POINT_ACTION_PASSPHRASE_LUCK_MEMBERS = "point_action_passphrase_luck_members";

    public static final String LOGIN_ACCOUNT_COUNT = "login_account_count";

    public static final String ELITE_POOL = "elite_pool";
    
    public static final String ALL_BET_USERS = "all_bet";
    
    //登录失败 记录次数
    public static final String LOGIN_FAILED_TIMES = "login_failed_times_";
    //发短信次数
    public static final String SEND_TIMES = "send_times_";

    //location信息
    public static final String LOCATION_ID_KEY = "location_";

    public static String getFollowedAccountId(Long accountId) {
        return FOLLOWED_ACCOUNT_ID + accountId;
    }
    
    public static final String HT_QUOTE_1A0001 = "ht_quote_1a0001";
    
    public static String getIsOpen(Integer isOpen){
    	String  isOpenStr =   ( isOpen ==null ||isOpen ==0 )?"00000000":String.valueOf(isOpen);
    	return  isOpenStr;
    }
}
