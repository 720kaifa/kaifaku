package cairh.community.api.game.kxian.constants;

import cairh.community.api.game.kxian.util.ConfigProperties;

/**
 * 功能说明: 字段常量类<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author dell<br>
 * 开发时间: 2016年11月10日<br>
 */

public class Fields {
	
	public static final String ERROR_NO_KEY = "error_no";//错误号
	public static final String ERROR_INFO_KEY = "error_info";//错误信息
	public static final String RESULT_LIST = "resultList";//返回列表
	public static final String RESULT_MAP = "resultMap";//返回对象

	/******************接口出入参*****************************/

	public static final String ERIAL_NO = "erial_no";//操作流水
	public static final String OPERATE_TIME = "operate_time";//操作时间
	public static final String OPERATE_TYPE = "operate_type";//操作类型
	public static final String OPERATE_DES = "operate_des";//操作描述
	public static final String CONTENT_ID = "content_id";//观点、评论、审核、敏感词或者用户的ID


	public static final String VERIFY_ID = "verify_id";//任务ID
	public static final String VERIFY_TYPE = "verify_type";//审核类型
	public static final String VERIFY_CONTENT	 = "verify_content";//审核内容

	public static final String WORDS_ID = "words_id";//敏感词ID
	public static final String WORDS_CONTENT = "words_content";//敏感词

	public static final String REPORT_ID = "report_id";//举报id
	public static final String REPORT_DATE = "report_date";//举报时间
	public static final String REPORT_TYPE = "report_type";//举报类型
	public static final String OPERATOR_ID = "operator_id";//操作员ID
	public static final String OP_TIME = "op_time";//操作时间


	public static final String SHARE_ID = "share_id";//分享ID
	public static final String SHARE_DATE = "share_date";//分享时间

	public static final String PRAISE_ID = "praise_id";//点赞ID
	public static final String TO_USER_ID = "to_user_id";//被赞用户ID
	public static final String FOR_ID = "for_id";//赞的观点ID或评论的ID
	public static final String PRAISE_DATE = "praise_date";//点赞时间

	public static final String COMMENT_ID = "comment_id";//评论ID
	public static final String VIEW_USER_ID = "view_user_id";//观点用户ID
	public static final String UP_COMMENT_ID = "up_comment_id";//被评论ID
	public static final String UP_USER_ID = "up_user_id";//被评论用户ID
	public static final String COMMENT_DATE = "comment_date";//评论日期
	public static final String IS_UP_IGNORE = "is_up_ignore";//被评论者忽略标志
	public static final String FOR_WHAT = "for_what";//针对观点的评论还是针对评论的评论

	public static final String VIEW_ID = "view_id";//观点ID
	public static final String PUB_DATE = "pub_date";//发布时间
	public static final String VERIFY_DATE = "verify_date";//审核时间
	public static final String DEL_DATE = "del_date";//删除时间
	public static final String AUDITOR_ID = "auditor_id";//操作员ID
	public static final String IS_IGNORE = "is_ignore";//忽略标志
	public static final String SHARE_COUNT = "share_count";//分享数
	public static final String CONTENT = "content";//内容
	public static final String IS_TOP = "is_top";//是否置顶

	public static final String ARTICLE_ID	 = "article_id";//资讯ID
	public static final String ORG_ART_ID = "org_art_id";//原资讯ID
	public static final String TITLE = "title";//标题
	public static final String CONTEXT = "context";//内容
	public static final String VIEW_COUNT = "view_count";//观点数
	public static final String COMMENT_COUNT = "comment_count";//评论数
	public static final String VIEW_URL = "view_url";//显示用URL
	public static final String SOURCE = "source";//来源：有个股、资讯、视频、音频
	
	public static final String SEND_LIKE_COUNT = "send_like_count";//我发出的赞
	public static final String PRAISE_COUNT = "praise_count";//我收到的赞
	public static final String UNREAD_PRAISE_COUNT = "unread_praise_count";//未读的赞的数量
	public static final String UNREAD_COMMENT_COUNT = "unread_comment_count";//未读的评论的数量
	public static final String USER_INFO_PROMPT = "user_info_prompt";//个人资料修改提示
	public static final String PRAISE_REMIND = "praise_remind";//点赞提醒
	public static final String MSG_REMIND = "msg_remind";//评论提醒
	public static final String LAST_OPT_TIME = "last_opt_time";//最后操作时间

	public static final String USER_ID = "user_id";//用户ID
	public static final String ACCOUNT_ID = "account_id";//账户ID
	public static final String USER_NAME = "user_name";//用户名（系统默认）
	public static final String MOBILE = "mobile";//手机号码
	public static final String NICK_NAME = "nice_name";//昵称
	public static final String IMAGE = "image";//头像路径
	public static final String SIGN = "sign";//个性签名
	public static final String RANK = "rank";//用户等级
	public static final String STATUS = "status";//状态
	public static final String REG_TIME = "reg_time";//注册时间
	public static final String UPD_TIME = "upd_time";//更新时间



	public static final String  COMMA_SPLIT=",";

	public static final int QUERY_PAGE_SIZE  = 20;

	public static final String  DIC_SPLIT="/";

	/*********************登录错误相关提示**************************/
	public final static String HTTP_POST_WRONG1 			= "返回结果为空";
	public final static String HTTP_POST_WRONG2 			= "解析返回数据出错";

	//请求类型
	public static final int REQUEST_TYPE_SUBMIT		= 1;//提交请求
	public static final int REQUEST_TYPE_QUERY		= 2;//查询请求

	//积分渠道等级
	public static final String CHANNEL_RANK1 = "1";  //1级渠道
	public static final String CHANNEL_RANK2 = "2";  //2级渠道
	public static final String CHANNEL_RANK3 = "3";  //3级渠道
	public static final String CHANNEL_RANK4 = "4";  //4级渠道



	//之后删除相关代码中的引用

	//身份验证方式
	public static final long VERIFY_TYPE_BANK					= 1;//银行验证
	public static final long VERIFY_TYPE_VIDEO					= 2;//视频验证

	//业务类型(businessType)，发送短信时用到
	public static final int BUSINESS_TYPE_REGISTER 		    	= 1;//注册
	public static final int BUSINESS_TYPE_LOGIN 		        = 2;//登录
	public static final int BUSINESS_TYPE_IMPROVE 		    	= 3;//审核失败
	public static final int BUSINESS_TYPE_CA_SUCCESS 			= 4;//CA成功
	public static final int BUSINESS_TYPE_CA_FAIL		    	= 5;//CA失败
	public static final int BUSINESS_TYPE_OPEN_SUCCESS			= 6;//开户成功
	public static final int BUSINESS_TYPE_OPEN_FAIL		    	= 7;//开户失败
	public static final int BUSINESS_TYPE_PASSWORD		    	= 8;//一步式输入密码
	public static final int BUSINESS_TYPE_QGM		    	    = 9;//抢购码
	public static final int BUSINESS_TYPE_ZYYC                  = 99;//账户异常

	/*************接口编号常量定义*****************/
	//视频见证队列资源获取
	public static final String VIDEO_NO3		= "WA2001";
	//视频见证资源释放
	public static final String VIDEO_NO4		= "WA2002";
	//视频见证资源更新
	public static final String VIDEO_NO5		= "WA2003";
	//档案图片下载
	public static final String USER_INFO_NO9	= "WA0032";

	/*************************** 用户申请开户状态 start******************************/
	/**注册成功*/
	public static  final long ACCOUNT_REGISTER			= 0;
	/**实名验证成功*/
	public static  final long ACCOUNT_VALIDATED			= 1;
	/**开户申请中*/
	public static  final long ACCOUNT_APPLY				= 2;
	/**审核中（用户递交）*/
	public static  final long ACCOUNT_CHECKS			= 3;
	/**用户整改*/
	public static  final long ACCOUNT_IMPROVE			= 4;
	/**复核中*/
	public static  final long ACCOUNT_REVIEW			= 5;
	/**复核通过*/
	public static  final long ACCOUNT_REVIEW_SUCCESS	= 6;
	/**复核未通过*/
	public static  final long ACCOUNT_REVIEW_FAIL		= 7;
	/**柜台预开户*/
	public static  final long ACCOUNT_AT_CUNTER			= 8;
	/**柜台预开户成功*/
	public static  final long ACCOUNT_PRE_SUCCESS		= 9;
	/**柜台预开户失败*/
	public static  final long ACCOUNT_PRE_FAIL			= 10;
	/**回访中*/
	public static  final long ACCOUNT_CALLBACK			= 11;
	/**开户成功*/
	public static  final long ACCOUNT_SUCCESS			= 12;
	/**开户失败*/
	public static  final long ACCOUNT_FAIL				= 13;
	/**视频验证失败*/
	public static  final long ACCOUNT_VALIDATED_FAIL	= 14;
	/** 证书发放审批未通过通过*/
	public static  final long CA_DELIVERY_REJECT		= 15;
	// 角色名称
	public static final String ROLE_NAME = "role_name";

	//视频验证状态
	public static final long VIDEO_VERIFY_STATUS_NOT_VERIFY	= 1L;
	public static final long VIDEO_VERIFY_STATUS_SUCC		= 8L;
	public static final long VIDEO_VERIFY_STATUS_FAIL		= 9L;


	/**文件上传地址*/
	public static String UPLOAD_SERVICE_ADDR = "";

	/**静态资源路径*/
	public static String STATIC_RESOURCES_ADDR = ConfigProperties.get("staticResourcesAddr", "http://wskh.htsec.com");

	/**主站地址*/
	public static String WEB_ADDR = ConfigProperties.get("webAddr", "http://wskh.htsec.com");

	public static String HIS_WEB_ADDR = ConfigProperties.get("hisWebAddr", "");

	/**域名*/
	public static String DOMAIN = ConfigProperties.get("domain", "cairenhui.com");

	/**视频服务IP*/
	public static String VIDEO_SERVER_IP = ConfigProperties.get("videoServerIp", "192.168.1.210");

	/**视频服务IP*/
	public static String VIDEO_SERVER_IP_INNER = ConfigProperties.get("videoServerIp_inner", "192.168.1.210");

	/**视频服务地址*/
	public static String VIDEO_SERVER_ADDR = ConfigProperties.get("videoServerAddr", "http://192.168.1.210:8080");

	/**视频服务内网地址*/
	public static String VIDEO_SERVER_ADDR_INNER = ConfigProperties.get("videoServerAddr_inner", "http://192.168.1.210:8080");

	/**百度查询地址*/
	public static String BAIDU_MAP_API_URL = ConfigProperties.get("baiduMapApiAddress", "http://api.map.baidu.com/api?v=1.5&ak=9E05511e6595aaabef732fe1b6e2e58e");

	/**新意地址*/
	public static String XY_ADDR = ConfigProperties.get("XYAddr", "http://188.188.113.196:8080/ECIMC/jsp/service/uploadimage/scanimage.do");

	/**新意图片目录*/
	public static String XY_DIR = ConfigProperties.get("XYDir", "C:\\xy");

	/**videoBussinessServer*/
	public static String VIDEO_BUSSINESS_SERVER_WEB_ADDR = ConfigProperties.get("videoBussinessServerWebAddr", "http://video.cairenhui.com:8080");

	/**videoBussinessServeInnerr*/
	public static String VIDEO_BUSSINESS_SERVER_WEB_ADDR_INNER = ConfigProperties.get("videoBussinessServerWebAddrInner", "http://video.cairenhui.com:8080");

	/**QUEUE*/
	public static String QUEUE_SWITCH_WEB_ADDR = ConfigProperties.get("queueSwitchWebAddr", "http://middle.httest.com:8080");

	/**ANYCHAT视频服务IP*/
	public static String ANY_CHAT_STREAM_IP_ADDR = ConfigProperties.get("anyChatStreamIpAddr", "video.cairenhui.com");

	/**ANYCHAT端口*/
	public static String ANY_CHAT_STREAM_PORT = ConfigProperties.get("anyChatStreamPort", "8906");

	/**协议前缀域名*/
	public static String PROTOCAL_WEB_ADDR = ConfigProperties.get("protocal_web_addr", "");
	
	/**商品状态---1已上架*/
	public static final Long PRODUCT_STATUS_UP=1l;
	/**商品状态---0已下架*/
	public static final Long PRODUCT_STATUS_DOWN=0l;
	/**商品状态--- -1未生效*/
	public static final Long PRODUCT_STATUS_INVALID=-1l;
	/**活动状态---0未生效*/
	public static final String  ACTION_STATUS_NO="0";
	/**活动状态---1已生效*/
	public static final String  ACTION_STATUS_YES="1";
	/**活动状态---2已失效*/
	public static final String  ACTION_STATUS_DOWN="2";
	
	/**调账管理增删状态---1增加*/
	public static final String  ADJUST_STATUS_ADD="1";
	/**调账管理增删状态---2减少*/
	public static final String  ADJUST_STATUS_DEL="2";
	/**调账管理数据状态---1正常*/
	public static final String  ADJUST_DATA_STATUS_NORMAL="1";
	/**调账管理数据状态---2异常*/
	public static final String  ADJUST_DATA_STATUS_ABNORMAL="2";
	
	/**用户账号激活状态---1已激活*/
	public static final String  USER_IS_ACTIVE_YES="1";
	/**用户账号激活状态---2未激活*/
	public static final String  USER_IS_ACTIVE_NO="2";
	
	/**审核状态---0未审核*/
	public static final String  CHECK_STATUS_NO="0";
	/**审核状态---1审核通过*/
	public static final String  CHECK_STATUS_PASS="1";
	/**审核状态---2审核不通过*/
	public static final String  CHECK_STATUS_NO_PASS="2";
	/**物流状态：待发货*/
	public static final String EXPRESS_STATUS1 = "0";
	/**物流状态：已发货*/
	public static final String EXPRESS_STATUS2 = "1";
	/**物流状态：已签收*/
	public static final String EXPRESS_STATUS3 = "2";
	/**物流状态：发货失败*/
	public static final String EXPRESS_STATUS4 = "9";	
}
