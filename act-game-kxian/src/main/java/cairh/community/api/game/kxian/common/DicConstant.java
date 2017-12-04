package cairh.community.api.game.kxian.common;

/***********************************************************************************
 *1-->2013-05-24 create by stevinzhu@cairenhui.com 定义如分隔符,前缀符 BugNo:-- 2-->
 ***********************************************************************************/
public class DicConstant {

	/*************************** 字典表 start ******************************/
	/*
	 * 投资类型: 1001 资金账户 1002 股票账户 1003 基金账户 1004 信托账户 1005 理财账户 1006 其他账户
	 */
	public static final long ACCOUNT_TYPE 		= 1000;
	public static final long ACCOUNT_CAPITAL 	= 1001;
	public static final long ACCOUNT_STOCK 		= 1002;
	public static final long ACCOUNT_FUND 		= 1003;
	public static final long ACCOUNT_TRUST		= 1004;
	public static final long ACCOUNT_INVEST		= 1005;
	public static final long ACCOUNT_OTHER		= 1006;
	
	/**
	 * 账户类型: 1 上海A股 3 上海B股 2 深圳A股 4 深圳B股 5 转让A 6 转让B
	 */
	public static final long ACCOUNT_TYPE_SH_A = 1;
	public static final long ACCOUNT_TYPE_SH_B = 3;
	public static final long ACCOUNT_TYPE_SZ_A = 2;
	public static final long ACCOUNT_TYPE_SZ_B = 4;
	public static final long ACCOUNT_TYPE_ZH_A = 5;
	public static final long ACCOUNT_TYPE_ZH_B = 6;
	public static final long ACCOUNT_TYPE_FUND = 1003;
	public static final long ACCOUNT_TYPE_CAPITAL = 1001;
	public static final long ACCOUNT_TYPE_OTHER = 1006;
	public static final long ACCOUNT_TYPE_INVSET = 1005;
	public static final long ACCOUNT_TYPE_TRUST = 1004;

	/*************************** 字典表 end ******************************/
	
	public static final long  MESS_LEVEL= 2000;
	public static final long  CALLBACK_TIME= 1103;
	public static final long  CALLBACK_TYPE= 1102;
	public static final long  BUSINESS_TYPE= 1101;
	public static final long  USER_STATUS= 1100;
	public static final long  SERVICE_TYPE= 1017;
	public static final long  PROFESSION_CODE= 1015;//用户职业
	public static final long  DEGREE_CODE= 1014;//用户学历
	public static final long  NATION=1013;
	public static final long  GENDER=1012;//性别
	public static final long  IDENTITY_TYPE=1011;
	public static final long  UPLOAD_ASSIST_TYPE=2003;//上传辅助身份材料类型
	
	
	/*************************** 字典 accessLevel ******************************/
	/**可修改**/
	public static final long  ACCESSLEVEL_ABLE_EDIT=1;
	/**不可修改**/
	public static final long  ACCESSLEVEL_UNABLE_EDIT=2;
	
	public static final String  DEFUALT_NATION 		     = "CHN";
	public static final String  DEFUALT_IDENTITY_TYPE    = "0";
	
}
