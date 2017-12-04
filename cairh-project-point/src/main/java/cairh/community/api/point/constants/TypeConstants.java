package cairh.community.api.point.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wanghh<br>
 * 开发时间: 2016年08月19日<br>
 */
public class TypeConstants {
	
	//大赛id
	public static Long VSTOCK_ZONE_TENCENT			= 3L;     //腾讯
	public static Long VSTOCK_ZONE_SIMU   			= 2L;     //私募
	public static Long VSTOCK_ZONE_CJIS				= 20010L; //中投实盘
	public static Long VSTOCK_ZONE_QQ_GROUP			= 20021L; //Q群争霸
	public static Long VSTOCK_ZONE_UNION_JRJ		= 20032L; //联盟牛人汇-金融界
	public static Long VSTOCK_ZONE_UNION_DZH		= 20033L; //联盟牛人汇-大智慧
	public static Long VSTOCK_ZONE_MASKED		    = 20034L; //模拟赛-蒙面牛人汇
	public static Long VSTOCK_ZONE_SIMU_FINAL 		= 1000002L;//私募决赛
	public static Long VSTOCK_ZONE_FINAL 			= 1000000L;//总决赛
	
	
	//大赛类型大赛类型 1 小实盘 2 实盘赛 3 伯乐赛 4 Q群争霸赛 5 模拟赛 6 半决赛 7 总决赛
	public static Integer VSTOCK_ZONE_TYPE_REAL_SMALL	= 1;
	public static Integer VSTOCK_ZONE_TYPE_REAL 		= 2;
	public static Integer VSTOCK_ZONE_TYPE_BOLE			= 3;
	public static Integer VSTOCK_ZONE_TYPE_QQGROUP		= 4;
	public static Integer VSTOCK_ZONE_TYPE_VIRTUAL		= 5;
	public static Integer VSTOCK_ZONE_TYPE_HALF         = 6;
	public static Integer VSTOCK_ZONE_TYPE_FINAL   		= 7;

	

	//成交类型
	public static final int SERVICE_TYPE_TRANSFER_NONE 		= -1;//总市值不变
	public static final int SERVICE_TYPE_TRANSFER_IN 		= 101;//资金转入（与999一致）
	public static final int SERVICE_TYPE_TRANSFER_OUT 		= 102;//资金转出（与998一致）
	public static final int SERVICE_TYPE_TRANSFER_BUY 		= 103;//普通买入（与-1一致）
	public static final int SERVICE_TYPE_TRANSFER_SELL 		= 104;//普通卖出（与-1一致）
	public static final int SERVICE_TYPE_TRANSFER_ZG 		= 105;//转股登记（与-1一致）
	public static final int SERVICE_TYPE_TRANSFER_SG 		= 106;//送股登记（与-1一致）
	public static final int SERVICE_TYPE_TRANSFER_PX 		= 107;//派息登记（与-1一致）
	public static final int SERVICE_TYPE_TRANSFER_KS 		= 108;//分红扣税（与-1一致）
	public static final int SERVICE_TYPE_TRANSFER_MSELL		= 109;//卖出的股票与收入的钱不等价
	public static final int SERVICE_TYPE_TRANSFER_MBUY 		= 110;//支出的钱与买入的股票不等价
	public static final int SERVICE_TYPE_TRANSFER_GPOUT 	= 996;//股票冲减转出
	public static final int SERVICE_TYPE_TRANSFER_GPIN 		= 997;//股票冲减转入
	public static final int SERVICE_TYPE_TRANSFER_CJOUT 	= 998;//资金冲减转出
	public static final int SERVICE_TYPE_TRANSFER_CJIN 		= 999;//资金冲减转入
	public static final int SERVICE_TYPE_TRANSFER_CLEAR 	= 995;//清算收益 有正负
	
	
	public static final int BUSINESS_CODE_TYPE_FUND 		= 1;//资金流水
	public static final int BUSINESS_CODE_TYPE_SEC          = 2;//股票流水
	public static final int BUSINESS_CODE_TYPE_DONE 		= 3;//成交
	
	public static final int BUSINESS_CODE_TYPE_FS			= 0;//资金和证券都相关的业务代码

	public static Map<String, String> serviceTypeMap;
	static{
		serviceTypeMap = new HashMap<String, String>();
		serviceTypeMap.put("101", "资金转入");
		serviceTypeMap.put("102", "资金转出");
		serviceTypeMap.put("103", "普通买入");
		serviceTypeMap.put("104", "普通卖出");
		serviceTypeMap.put("105", "转股登记");
		serviceTypeMap.put("106", "送股登记");
		serviceTypeMap.put("107", "派息登记");
		serviceTypeMap.put("108", "分红扣税");
		serviceTypeMap.put("996", "股票冲减转出");
		serviceTypeMap.put("997", "股票冲减转入");
		serviceTypeMap.put("998", "资金冲减转出");
		serviceTypeMap.put("999", "资金冲减转入");
	}

	//分红扩股service type
	public static final int DIVIDEND_SERVICE_TYPE_SG 		= 1;//送股
	public static final int DIVIDEND_SERVICE_TYPE_ZG 		= 2;//转股
	public static final int DIVIDEND_SERVICE_TYPE_PX 		= 3;//派现
	
	//产品类型：1：实物产品; 2:手机流量话费; 3：其他非实物产品；4：积分；5：活动
    public static final int PRODUCT_TYPE_PHYSICAL = 1;
    public static final int  PRODUCT_TYPE_MOBILE = 2;
    public static final int  PRODUCT_TYPE_NOT_PHYSICAL = 3;
    public static final int  PRODUCT_TYPE_POINT = 4;
    public static final int  PRODUCT_TYPE_ACTION = 5;

    // 积分商城产品展示类型
 	public static Integer VSE_PRODUCT_SHOW_TYPE_1 = 1; // 实物礼品
 	public static Integer VSE_PRODUCT_SHOW_TYPE_2 = 2; // 道具
 	public static Integer VSE_PRODUCT_SHOW_TYPE_3 = 3; // 增值服务
 	
 	// 积分商城产品来源类型
 	public static Integer VSE_USER_PRODUCT_ORIGIN_TYPE_1 = 1; // 兑换
 	public static Integer VSE_USER_PRODUCT_ORIGIN_TYPE_2 = 2; // 抽奖
 	public static Integer VSE_USER_PRODUCT_ORIGIN_TYPE_3 = 3; // 赠送
 	public static Integer VSE_USER_PRODUCT_ORIGIN_TYPE_4 = 4; // 活动
 	public static Integer VSE_USER_PRODUCT_ORIGIN_TYPE_41 = 41; // 口令活动
 	public static Integer VSE_USER_PRODUCT_ORIGIN_TYPE_42 = 42; // 打卡活动
 	public static Integer VSE_USER_PRODUCT_ORIGIN_TYPE_43 = 43; // 评论活动

 	//区间排行类型
 	public static final String PERIOD_TYPE_ALL     = "ALL";
 	public static final String PERIOD_TYPE_DAY     = "DAY";
 	public static final String PERIOD_TYPE_TOTAL   = "TOTAL";
 	public static final String PERIOD_TYPE_WEEK    = "WEEK";
 	public static final String PERIOD_TYPE_2WEEK   = "2WEEK";
 	public static final String PERIOD_TYPE_MONTH   = "MONTH";
 	
 	//work calendar类型
 	/*1:CLEAR*/ 
 	public static final Integer WORK_CALENDAR_CLEAR 	= 1;//清算

	public static final Integer POINT_DEFINE_TYPE_ACTIVITY = 4;//活动积分
	public static final Integer POINT_DEFINE_TYPE_BUY = 7;//积分购买
	public static final Integer POINT_DEFINE_TYPE_SHARE = 10;//分享活动获取积分
	public static final Integer POINT_DEFINE_TYPE_TOUJIAO = 11;//查看投教获取积分

	//SpecialTag
	public static final String SPECIAL_TAG_JIANHANG = "B";
	public static final String SPECIAL_TAG_OTHER = "A";
	public static final String TOP_LOCATION ="0001";
	
	//拉拽活动积分定义
	public static final String ACTIVITY_POINT_DEFINE_CODE_LOTTERY  = "0017";     //积分抽奖
	public static final String ACTIVITY_POINT_DEFINE_CODE_BRAND    = "0013";     //品牌口令
	public static final String ACTIVITY_POINT_DEFINE_CODE_SIGN     = "9000";     //天天打卡
	public static final String ACTIVITY_POINT_DEFINE_CODE_ROBOT    = "9001";     //群殴机器人
	public static final String ACTIVITY_POINT_DEFINE_CODE_BET      = "0016";     //高手押注
	public static final String ACTIVITY_POINT_DEFINE_CODE_COMMENT  = "0014";     //评论投顾
	
	//拉拽活动中奖积分定义
	public static final String ACTIVITY_WIN_CODE_LOTTERY   = "1003";     //积分抽奖中奖
	public static final String ACTIVITY_WIN_CODE_BRAND     = "0013";     //品牌口令
	public static final String ACTIVITY_WIN_CODE_SIGN      = "9000";     //天天打卡
	public static final String ACTIVITY_WIN_CODE_ROBOT     = "9002";     //群殴机器人成功
	public static final String ACTIVITY_WIN_CODE_BET       = "0007";     //押注成功
	public static final String ACTIVITY_WIN_CODE_COMMENT   = "0014";     //评论投顾
	
	
	//积分来源类型
	public static final Integer BASE_POINT_DEFINE_TYPE_1   = 1;//	1,经纪业务
	public static final Integer BASE_POINT_DEFINE_TYPE_2   = 2;//	2,社区活跃
	public static final Integer BASE_POINT_DEFINE_TYPE_3   = 3;//	3,游戏活跃
	public static final Integer BASE_POINT_DEFINE_TYPE_4   = 4;//	4,开户转化
	public static final Integer BASE_POINT_DEFINE_TYPE_5   = 5;//	5,入金转化
	public static final Integer BASE_POINT_DEFINE_TYPE_6   = 6;//	6,交易转化
	public static final Integer BASE_POINT_DEFINE_TYPE_7   = 7;//	7,关注转化
	
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
	
	//最多下注次数
	public static final Long MAX_TIME = 3L;
	
	//最多下注积分
	public static final Long MAX_POINT = 150L;
	
	//下注单位积分
	public static final Long POINT = 50L;
	
	//每一局最高纪录缓存
	public static final String GUESS_TOP_LIST = "guess_income_top_list";
	
	
	//历史总人数
	public static final String ALL_COUNT = "allCount";
	
	//奖励得分
	public static final String PRIZE_SCORE = "prizeScore";
		
	//首次奖励得分
	public static final String FIRST_SCORE = "55";	
	
	//参与奖励得分
	public static final String PLAY_SCORE = "5";	
	
	public static final String USER_UPPER_LIMIT_CACHE = "user_upper_limit_cache";	

	public static final String _VIEW_NOTAUDITED = "_view_notaudited";	
	public static final String STOCK_ = "common_stock_";	
	public static final String STOCK_TOP_VIEW = "common_stock_top_view";	
	public static final String USER_ = "personal_user_";	
	public static final String _VIEW = "_view";	
	public static final String _COMMENT = "_comment";	
	public static final String PERSONAL_TOUSER_ = "personal_touser_";	
	public static final String _THUMBSUP = "_thumbsup";	
}
