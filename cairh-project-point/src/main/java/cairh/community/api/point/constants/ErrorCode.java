package cairh.community.api.point.constants;

public class ErrorCode {

	
	/** 一切正常 */
	public static final String OK = "0";
	/** 通用错误号-1  */
	public static final String ERROR_NO_NEGATIVE_1 = "-1";

	/**
	 * 弱密码
	 */
	public static final String WEAK_PASSWORD = "-42";
	/**
	 * 错误的交易密码
	 */
	public static final String WRONG_TRANSACTION_PWD = "-61";
	
	/**
	 * 用户已存在，重复的
	 */
	public static final String USER_REPETITIVE = "10000";
		/**
	 * 账户已存在，重复的
	 */
	public static final String ACCOUNT_REPETITIVE = "10001";

	/**
	 * 暂不支持的登录方式
	 */
	public static final String NOT_SUPPORTED_LOGIN_WAY = "10002";
	/**
	 * 用户信息不存在
	 */
	public static final String USER_NOT_EXIST = "10003";
	/**
	 * 验证码错误
	 */
	public static final String VERIFY_CODE_ERROR = "10004";
	/**
	 * 用户名或者密码错误
	 */
	public static final String WRONG_ID_OR_PASSWORD = "10005";
	
	/**
	 * 参数错误
	 */
	public static final String ILLEAGE_PARAM = "10006";
	
	/**
	 * 参数为空
	 */
	public static final String PARAM_EMPTY = "10007";
	/**
	 * 实盘报名，需要选小赛区
	 */
	public static final String REGISTER_SELECT_ZONE = "10008";
	public static final String REGISTER_SELECT_ZONE_ERROR = "10009";
	/**
	 * 未开户用户的订阅数量达到上线
	 */
	public static final String FOLLOW_UNOPEN_OUT = "20001";
	/**
	 * 开户用户的订阅数量达到上线
	 */
	public static final String FOLLOW_OPEN_OUT = "20002";
	/**
	 * 积分不足
	 */
	public static final String PRODUCT_LACK = "20010";
	//兑换上限
	public static final String PRODUCT_COUNT_LIMIT = "20011";
	//充值卡库存不足
	public static final String CARD_COUNT_LIMIT = "20028";
	//需要开户
	public static final String PRODUCT_NEED_OPEN = "20012";
	
	public static final String CHECK_IN_SECTION_ERROR = "20013";
	//未参加腾讯模拟赛
	public static final String NOT_JOIN_TENCENT = "20014";
	//未开户不能查看机器人流水
	public static final String QUERY_TRADE_UNOPEN_OUT = "20016";
	//未报名
	public static final String NO_SIGN_ROBOT = "20017";
	//重复报名
	public static final String REPEAT_JOIN_ROBOT = "20018";
	//积分定义异常
	public static final String POINT_DEFINE_ERROR= "20015";
	//口令错误
	public static final String PASSPHRASE_ERROR = "20020";
	public static final String PASSPHRASE_NOT_OPEN = "20021";
	public static final String PASSPHRASE_ERROR_TIME = "20022";
	public static final String PASSPHRASE_NOT_LIUCK = "20025";

	//投教积分不可重复获得
	public static final String POINT_TOUJIAO_REPETITIVE = "20030";

	public static final String PRIOR_CHAMPION_NONE = "20040";
}
