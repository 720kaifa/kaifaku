package cairh.community.api.game.kxian.common;

import java.util.ArrayList;
import java.util.List;

import com.cairenhui.filter.util.ConfigProperties;

/***********************************************************************************
*1-->2013-05-24  quote by stevinzhu@cairenhui.com  类型常量,不包括业务相关状态信息    BugNo:--
*2-->
***********************************************************************************/
public class TypeConstant {
	
	
	/*************************** 题库类型 start******************************/
	/** 个人用户题库 */
	public static final long PAPER_TYPE_PERSON=1;

    /** 机构用户题库 */
	public static final long PAPER_TYPE_ORG=2;
	
	/** 该选择项被选中 */
	public static final long OPTION_SELECTED=1;
	
	/** 该选择项未被选中 */
	public static final long OPTION_UNSELECTED=0;
	/*************************** 题库类型 end******************************/
	
	//审核修改类型
	public static final long AUDIT_CHANGE_TYPE_SELF		= 1;//用户整改
	public static final long AUDIT_CHANGE_TYPE_AUDIT	= 2;//审核整改
	
	/*************************** 协议签署  start******************************/
	/** 协议已经阅读 */
	public static final long  AGREEMENT_READED=1;
	
	/** 协议未阅读 */
	public static final long  AGREEMENT_UNREADED=0;
	/*************************** 协议签署  end ******************************/
	

	
	//修改人员类型-UserPresence表
	public static final long OU_TYPE_SELF 				= 1;//用户自己
	public static final long OU_TYPE_OTHER 				= 2;//其他管理人员
	
	//营业部类型
	public static final int ORG_TYPE_HEAD				= 1;//总部
	public static final int ORG_TYPE_BRANCH				= 2;//分公司
	public static final int ORG_TYPE_DEPARTMENT			= 3;//营业部
	
	//证件到期时间类型
	public static final long FOREVER_FLAG_NO			= 0;//阶段有效
	public static final long FOREVER_FLAG_YES			= 1;//永久有效
	
	/*************************** 证件类型  start******************************/
	public static final String IDENTITY_TYPE_ID 		= "0";//身份证
	/*************************** 证件类型  start******************************/
	

	//dic = 1101
	/*************************** 任务类型  start******************************/
	public static final String  TASK_VIDEO_VERIFY="1"; //视频验证
	public static final String  TASK_CHECK="2"; // 开户审核(用户递交)
	public static final String  TASK_REVIEW="3"; // 开户复核（用户递交）
	public static final String  TASK_VIDEO_PICK="4";//重采视频
	public static final String  TASK_CA_DELIVERY="5";//颁发证书
	public static final String  TASK_IMPROVE_CHECK="6";//整改审批（用户递交）
	public static final String  TASK_REVIEW_APPROVE="7";//复核未通过
	public static final String  TASK_REVIEW_COUNTER_SUCCESS="8";//复核人员复核柜台预开户成功
	public static final String  TASK_REVIEW_COUNTER_FAIL="9";//复核人员复核柜台预开户失败
	/*************************** 任务类型  end ******************************/
	
	
	public static final long IDENTITY_0=0L; //身份证
	
	
	
	//业务类型(businessType)，发送短信时用到
	public static final int BUSINESS_TYPE_REGISTER 		= 1;//注册
	public static final int BUSINESS_TYPE_LOGIN 		= 2;//登录
	public static final int BUSINESS_TYPE_IMPROVE 		= 3;//审核失败
	public static final int BUSINESS_TYPE_CA_SUCCESS 	= 4;//CA成功
	public static final int BUSINESS_TYPE_CA_FAIL		= 5;//CA失败
	public static final int BUSINESS_TYPE_OPEN_SUCCESS	= 6;//开户成功
	public static final int BUSINESS_TYPE_OPEN_FAIL		= 7;//开户失败
	
	/*************************** 新意图片类型  start******************************/
	public static final long XY_PIC_FRONT_BACK 		= 1;	//身份证正反面
	public static final long XY_PIC_FRONT 			= 2;	//身份证正面
	public static final long XY_PIC_BACK 			= 3;	//身份证反面
	public static final long XY_PIC_FACE 			= 4;	//头部正面照
	/*************************** 新意图片类型  start******************************/
	
	//恒生cookie
	public static String hs_cookie_name = ConfigProperties.get("hs_cookie_name", "");
	public static String hs_cookie_path = ConfigProperties.get("hs_cookie_path", "");
	public static String hs_cookie_domain = ConfigProperties.get("hs_cookie_domain", "");
	
	public static List<String> cookieNameList = new ArrayList<String>();
	static{
		String[] items = hs_cookie_name.split("#");
		if(null != items){
			for(String item : items){
				cookieNameList.add(item);
			}
		}
	}
	
	//三方存管开通方式
	public static final int THIRD_DEPOSITY_11 			= 11;//一站式、需要密码
	public static final int THIRD_DEPOSITY_12 			= 12;//一站式、不需要密码
	public static final int THIRD_DEPOSITY_21 			= 21;//两站式、需要账号
	public static final int THIRD_DEPOSITY_22 			= 22;//两站式、不需要账号(默认)

	//请求类型
	public static final int REQUEST_TYPE_SUBMIT		= 1;//提交请求
	public static final int REQUEST_TYPE_QUERY			= 2;//查询请求
	
	//能否返回上一步
	public static final long BACK_TO_YES					= 1;//能返回
	public static final long BACK_TO_NO					= 0;//不能返回
	
	//身份证正反面代码
	public static final String IDENTITY_FRONT			= "6A";//身份证正面
	public static final String IDENTITY_BACK			= "6B";//身份证反面
	public static final String IDENTITY_FACE				= "80";//正面照
	public static final String IDENTITY_FZCL				= "90";//辅助身份材料照
	
	//1 资金密码 2 交易密码 3 通讯密码
	public static final int PWD_TYPE_CAPITAL			= 1;//资金密码
	public static final int PWD_TYPE_TRADE				= 2;//交易密码
	public static final int PWD_TYPE_COMMUNICATION	= 3;//通讯密码
	
	//默认资金密码、交易密码
	public static final String PWD_CAPITAL_DEFAULT		= "1";//资金密码
	public static final String PWD_TRADE_DEFAULT		= "2";//交易密码
	public static final String PWD_COMMUNICATION_DEFAULT		= "3";//通讯密码
	
	//股东账号交易类别
	public static final String ACCOUNT_STOCK_SH			= "1";//上海A股
	public static final String ACCOUNT_STOCK_SZ			= "2";//深圳A股
	public static final String ACCOUNT_FUND_HS			= "011";//沪市基金
	public static final String ACCOUNT_FUND_SS			= "022";//深市基金
	public static final String ACCOUNT_FUND_OTC			= "9";//OTC
	//public static final String ACCOUNT_FUND_ZG			= "OTC";//资管
	public static final String ACCOUNT_FUND_FG			= "008";//富国基金
	public static final String ACCOUNT_CUST_PAYMENT 		= "1";//消费支付
	
	//开户类型
	public static final int OPEN_TYPE_1					= 1;//开户
	public static final int OPEN_TYPE_3					= 3;//转户
	public static final int OPEN_TYPE_5					= 5;//简易开户
	public static final int OPEN_TYPE_7					= 7;//H5开户
	
	public static final String OP_STATION_DEFAULT		= "";
	
	//中登开户标志
	public static final String ZD_OPEN_FLAG_YES			= "1";
	public static final String ZD_OPEN_FLAG_NO			= "0";
	
	//协议类型
	public static final String PROTOCAL_TYPE_BANK		= "0";//存管协议
	public static final String PROTOCAL_TYPE_ACCOUNT	= "1";//开户协议
	public static final String PROTOCAL_TYPE_CA			= "2";//数字证书协议
	
	// 协议批量签署标志
	public static final String PROTOCAL_SIGN_GROUP_KH		= "开户协议";
	public static final String PROTOCAL_SIGN_GROUP_BANK	= "存管协议";
	
	public static final String DEPOSITY_BANK_BIZ = ConfigProperties.get("deposity.bank.biz.unit.id", "1601");//1604
	public static final String OTHER_DEPOSITY_BANK_BIZ = "1604";//存管外部协议
	
	//建行、农行、平安银行、交通银行、北京银行
	public static final String BANK_NO_JS				= "6";//建行
	public static final String BANK_NO_NY				= "A";//农行
	public static final String BANK_NO_PA				= "K";//平安
	public static final String BANK_NO_JT				= "C";//交行
	public static final String BANK_NO_BJ				= "H";//北京
	
	//数字签名的算法
	public static final String CA_ALGORITHM				= "Detached";
	
	//渠道类型 1营业部渠道 2个人渠道
	public static final int SOURCE_TYPE_ORG				= 1;
	public static final int SOURCE_TYPE_USER			= 2;
	
	//用户注册来源区分：1网上开户；2手机开户
	public static final String REGISTER_WAY_MOBILE		= "2";
	
	//接入方式
	public static class APP {
		public static final  String PC = "100";  //网上开户
		public static final  String MOBILE = "200";  //手机开户
		public static final  String PAD = "300";  //pad开户
	}
	
}
