package cairh.community.api.point.constants;


public class TypeConstant {
	/** 用户状态-正常 */
	public static final String USER_STATUS_NORMAL = "0";
	/** 用户状态-禁言 */
	public static final String USER_STATUS_GAG = "1";
	/** 用户状态-删除 */
	public static final String USER_STATUS_DELETE = "2";
	/** 个人资料修改无提示 */
	public static final String INFO_PROMPT_NO = "0";
	/** 个人资料修改提示 */
	public static final String INFO_PROMPT_YES = "1";
	
	/** 用户状态-正常 */
	public static final String USER_STATUS_NORMAL_NAME = "正常";
	/** 用户状态-禁言 */
	public static final String USER_STATUS_GAG_NAME = "禁言";
	/** 用户状态-删除 */
	public static final String USER_STATUS_DELETE_NAME = "删除";

	/** 点赞评论提醒 */
	public static final String REMIND_SET_YES = "0";
	/** 点赞评论不提醒 */
	public static final String REMIND_SET_NO = "1";

	/** 观点状态-正常 */
	public static final String VIEWPOINT_STATUS_NORMAL = "0";
	/** 观点状态-待审核 */
	public static final String VIEWPOINT_STATUS_PENDING = "1";
	/** 观点状态-已删除 */
	public static final String VIEWPOINT_STATUS_DELETE = "2";
	/** 观点状态-审核不通过 */
	public static final String VIEWPOINT_STATUS_NOPASS = "3";

	/** 评论状态-正常 */
	public static final String COMMENT_STATUS_NORMAL = "0";
	/** 评论状态-待审核 */
	public static final String COMMENT_STATUS_PENDING = "1";
	/** 评论状态-已删除 */
	public static final String COMMENT_STATUS_DELETE = "2";
	/** 评论状态-审核不通过 */
	public static final String COMMENT_STATUS_NOPASS = "3";

	/** 忽略标志-正常 */
	public static final String IS_IGNORE_NO = "0";
	/** 忽略标志-忽略 */
	public static final String IS_IGNORE_YES = "1";

	/** 是否置顶-正常 */
	public static final String IS_TOP_NO = "0";
	/** 是否置顶-置顶 */
	public static final String IS_TOP_YES = "1";

	/** 针对对象-观点 */
	public static final String FOR_WHAT_VIEWPOINT = "1";
	/** 针对对象-评论 */
	public static final String FOR_WHAT_COMMENT = "2";
	/** 针对对象-用户 */
	public static final String FOR_WHAT_USER = "3";
	/** 针对对象-敏感词 */
	public static final String FOR_WHAT_SENSITIVE_WORDS = "4";

	/** 举报类型-1：段子或无意义的评论 */
	public static final String REPORT_TYPE_1 = "1";
	/** 举报类型-2：恶意攻击谩骂 */
	public static final String REPORT_TYPE_2 = "2";
	/** 举报类型-3：营销广告 */
	public static final String REPORT_TYPE_3 = "3";
	/** 举报类型-4：淫秽色情 */
	public static final String REPORT_TYPE_4 = "4";
	/** 举报类型-5：政治反动 */
	public static final String REPORT_TYPE_5 = "5";
	/** 举报类型-9：其他 */
	public static final String REPORT_TYPE_9 = "9";

	/** 举报状态-未处理 */
	public static final String REPORT_STATUS_NO = "0";
	/** 举报状态-已删除 */  //2：禁言                      3：忽略
	public static final String REPORT_STATUS_DEL = "1";
	/** 举报状态-已禁言  */
	public static final String REPORT_STATUS_GAG = "2";
	/** 举报状态-忽略 */
	public static final String REPORT_STATUS_IGN = "3";

	/** 敏感词状态-有效 */
	public static final String SENSITIVE_WORDS_STATUS_VALID = "0";
	/** 敏感词状态-无效 */
	public static final String SENSITIVE_WORDS_STATUS_INVALID = "1";

	/** 审核类型-昵称 */
	public static final String VERIFY_TYPE_NCIK_NAME = "1";
	/** 审核类型-头像 */
	public static final String VERIFY_TYPE_IMAGE = "2";
	/** 审核类型-签名 */
	public static final String VERIFY_TYPE_SIGN = "3";

	/** 审核状态-未审核 */
	public static final String VERIFY_STATUS_NO_AUDIT = "0";
	/** 审核状态-通过 */
	public static final String VERIFY_STATUS_PASS = "1";
	/** 审核状态-未通过 */
	public static final String VERIFY_STATUS_NO_PASS = "2";
	
	/** 审核状态-全部 */
	public static final String VERIFY_STATUS_ALL_NAME = "全部";
	/** 审核状态-未审核 */
	public static final String VERIFY_STATUS_NO_AUDIT_NAME = "未审核";
	/** 审核状态-通过 */
	public static final String VERIFY_STATUS_PASS_NAME = "通过";
	/** 审核状态-未通过 */
	public static final String VERIFY_STATUS_NO_PASS_NAME = "未通过";
	
	/** 审核不通过原因类型-1：审核不通过 */
	public static final String VERIFY_NO_PASS_TYPE_1 = "1";
	/** 审核不通过原因类型-2：包含敏感词 */
	public static final String VERIFY_NO_PASS_TYPE_2 = "2";
	/** 审核不通过原因类型-9：其他 */
	public static final String VERIFY_NO_PASS_TYPE_9 = "9";
	
	/** 操作留痕类型-1：用户审核 */
	public static final String OPERATE_TYPE_1 = "1";
	/** 操作留痕类型-2：内容管理 */
	public static final String OPERATE_TYPE_2 = "2";
	/** 操作留痕类型-3：内容审核 */
	public static final String OPERATE_TYPE_3 = "3";
	/** 操作留痕类型-4：举报管理 */
	public static final String OPERATE_TYPE_4 = "4";
	/** 操作留痕类型-5：敏感词管理 */
	public static final String OPERATE_TYPE_5 = "5";
	
	/** 操作留痕描述-昵称*/
	public static final String OPERATE_DES_NCIK_NAME = "昵称";
	/** 操作留痕描述-头像*/
	public static final String OPERATE_DES_IMAGE = "头像";
	/** 操作留痕描述-签名*/
	public static final String OPERATE_DES_SIGN = "签名";

	
	/** 账户中心类型-审核通过 */
	public static final String AUDIT_RESULT_PASS = "S";
	/** 账户中心类型-审核不通过 */
	public static final String AUDIT_RESULT_NOPASS = "F";
	/** 账户中心类型-修改头像 */
	public static final String MODIFY_TYPE_IMAGE = "A";
	/** 账户中心类型-修改个人说明 */
	public static final String MODIFY_TYPE_SIGN = "P";
	/** 账户中心类型-修改昵称 */
	public static final String MODIFY_TYPE_NICK_NAME = "N";
	/** 账户中心类型-处理审核结果成功 */
	public static final String TRAIL_RESULT_SUCCESS = "S";
	/** 账户中心类型-处理审核结果失败 */
	public static final String TRAIL_RESULT_FAIL = "F";
	/** 账户中心类型-此次审核已失效 */
	public static final String TRAIL_RESULT_EXPIRE= "O";
	/** 账户中心类型-审核端审核结果不符合约定状态 */
	public static final String TRAIL_RESULT_WRONG = "E";

	/** 账户中心类型-同步成功*/
	public static final String ZHZX_SYNC_SUCCESS = "1";
	/** 账户中心类型-同步失败*/
	public static final String ZHZX_SYNC_FAIL = "2";
	
	/** 用户动态信息-个人资料修改无提示*/
	public static final String USER_PRESENCE_NO_PROMOT = "0";
	/**用户动态信息-个人资料修改提示*/
	public static final String USER_PRESENCE_PROMOT = "1";
	
	/**猜涨跌用户押注结果 未中奖 */
	public static final Integer GUESS_STAKE_PRIZE_NO = 0;
	/**猜涨跌用户押注结果 中奖*/
	public static final Integer GUESS_STAKE_PRIZE_WIN = 1;

	/**用户积分消耗类型-商品消耗*/
	public static final String PRODUCT_USED = "1";
	/**用户积分消耗类型-非商品消耗*/
	public static final String NOT_PRODUCT_USED = "2";
	/**用户积分消耗类型-获取积分*/
	public static final String GET_POINTS = "3";
	/**用户积分消耗类型-其他*/
	public static final String OTHER = "4";
	
	
	
	/*************************** 渠道信息  start******************************/
	
	/**叶子节点*/
	public static final String LEAF_NODE = "1";
	
	/**非叶子节点*/
	public static final String NOT_LEAF_NODE = "0";	
	
	/**展示*/
	public static final String SHOW = "1";
	/**不展示*/
	public static final String NOT_SHOW = "2";
	
	/**1级渠道*/
	public static final String CHANNEL_RANK1 = "1";
	
	/**2级渠道*/
	public static final String CHANNEL_RANK2 = "2";
	
	/**3级渠道*/
	public static final String CHANNEL_RANK3 = "3";
	
	/**4级渠道*/
	public static final String CHANNEL_RANK4 = "4";
	
		
	/*************************** 渠道信息  end******************************/
	
	
	/*************************** 用户积分状态  start******************************/
	/**有效用户*/
	public static final Integer USER_POINT_VALID = 1;
	/**无效用户*/
	public static final Integer USER_POINT_INVALID = -1;
	/**自营用户*/
	public static final Integer USER_POINT_SELF = 2;
	/*************************** 用户积分状态  end******************************/
	
	

	/*************************** 营业部信息  start******************************/
	/**总部*/
	public static final long  OGR_HEAD=1;
	/**分公司*/
	public static final long  OGR_COPORATION=2;
	/**分支机构*/
	public static final long  OGR_BRANCH=3;

	/*************************** 营业部信息  end ******************************/

	/*************************** 系统消息等级  start******************************/
	public static final long  MESS_LEVEL_1=1; //1  普通
	public static final long  MESS_LEVEL_2=2; //  2 中级
	public static final long  MESS_LEVEL_3=3; // 3  紧急
	public static final long  MESS_LEVEL_9=9;//9 最紧急
	/*************************** 系统消息等级  end ******************************/

	/*************************** 系统消息类型  start******************************/
	public static final long  MESS_TYPE_1=1; //	1前台通知
	public static final long  MESS_TYPE_2=2; // 2后台通知
	/*************************** 系统消息类型  end ******************************/

	/***************************  字典表  start******************************/
	/** 正常 */
	public static  final long DIC_STATUS_NORMAL				= 8;
	/** 隐藏 */
	public static  final long DIC_STATUS_HIDDEN				= 9;
	/** 可以修改 */
	public static final long  DIC_ACCESS_LEVEL_1			= 1;
	/** 不能修改 */
	public static final long  DIC_ACCESS_LEVEL_2			= 2;
	/*************************** 字典表   end******************************/

	/*************************** 用户任务状态 start******************************/
	/** 任务未处理 */
	public static final long TASK_CREATE 		= 0;
	/** 任务已经接受处理 */
	public static final long TASK_DEALING 		= 2;
	/** 任务处理完成 */
	public static final long TASK_FINISH 		= 3;
	/*************************** 用户任务状态 end ******************************/
	
	//登录密码 1交易密码 2资金密码
	public static final String PWD_TRANSACTION			="1";
	public static final String PWD_CAPITAL				="2";
	
	
	/*********************用户绑定状态start*************************/
	/**1:绑定*/
	public static final String BINDING_STATUS = "1";
	/**2:未绑定*/
	public static final String NOT_BINDING_STATUS = "2";
	/*********************用户绑定状态end*************************/
	
	
	/*********************用户绑定状态start*************************/
	/**1:激活*/
	public static final String ACTIVE_STATUS = "1";
	/**2:未激活*/
	public static final String NOT_ACTIVE_STATUS = "2";
	/*********************用户绑定状态end*************************/
}
