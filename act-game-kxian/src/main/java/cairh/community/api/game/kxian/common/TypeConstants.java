package cairh.community.api.game.kxian.common;


public class TypeConstants{
	
	//网上开户的公告类型为1
	public static final int WSKH_NOTICE_TYPE=1;
	
	//手机开户的公告类型为4
	public static final int SJKH_NOTICE_TYPE=4;
	
	/**
	 * 加解密key
	 */
	public static final String AES_SECRYPT_KEY = "cairenhui";
	
	//猜涨总人数
	public static final String UP_PEOPLE = "putPeopleCount";
	
	//猜涨总积分
	public static final String UP_POINT = "putTotalPoint";
	
	//猜涨的第一位下注最高积分的userid
	public static final String UP_MAX_USERID = "putMaxUserId";
	
	//猜涨的第一位下注最高积分
	public static final String UP_MAX_POINT = "putMaxPoint";
	
	//猜跌总人数
	public static final String DOWN_PEOPLE = "downPeopleCount";
	
	//猜跌总积分
	public static final String DOWN_POINT = "downTotalPoint";
	
	//猜跌的第一位下注最高积分的userid
	public static final String DOWN_MAX_USERID = "downMaxUserId";

	//猜跌的第一位下注最高积分
	public static final String DOWN_MAX_POINT = "DownMaxPoint";
	
	//用户ID
	public static final String USER_ID = "userId";
		
	//押注积分
	public static final String DO_POINT = "doPoint";
	
	//押注次数
	public static final String TIMES = "times";
	
	//得分
	public static final String SCORE = "score";
	
	//猜涨还是跌
	public static final String UP_OR_DOWN = "upOrDown";
	
	//押注时间
	public static final String STAKE_TIME = "stakeTime";
	
	//最多下注次数
	public static final Long MAX_TIME = 1L;
	
	//最多下注积分
	public static final Long MAX_POINT = 150L;
	
	//下注单位积分
	public static final Long POINT = 50L;
	
	//历史总人数
	public static final String ALL_COUNT = "allCount";
	
	//每一局最高纪录缓存
	public static final String GUESS_TOP_LIST = "guess_income_top_list";
	
	//奖励得分
	public static final String PRIZE_SCORE = "prizeScore";
		
	//首次奖励得分
	public static final String FIRST_SCORE = "55";	
	
	//参与奖励得分
	public static final String PLAY_SCORE = "5";
}