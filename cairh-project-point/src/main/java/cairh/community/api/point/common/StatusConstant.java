package cairh.community.api.point.common;
/***********************************************************************************
*1-->2013-05-24  quote by stevinzhu@cairenhui.com  业务相关状态常量    BugNo:--
*2-->
***********************************************************************************/
public class StatusConstant {
	
	
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
	
	
	/*************************** 户申请开户状态 end******************************/
	
	/*************************** 用户申请开户状态(用户角度) start******************************/
	/**注册成功*/
	public static  final long USER_STATUS_REGISTER		=0; 
	/**申请中*/
	public static  final long USER_STATUS_APPLY			=2; 
	/**审核中*/
	public static  final long USER_STATUS_APPROVE		=3;
	/**等待用户提交密码*/
	public static  final long USER_STATUS_TO_PWD 		=9;
	/**待提交crm*/
	public static  final long USER_STATUS_TO_SUBMIT		=10;
	/**开户成功*/
	public static  final long USER_STATUS_SUCCESS		=12;
	/**开户失败*/
	public static  final long USER_STATUS_FAIL			=13;
	/*************************** 户申请开户状态 end******************************/
	
	/*************************** 注册账号状态 start******************************/
	//用户注册状态
	public static final long USER_STATUS_NORMAL 			= 0;//正常
	public static final long USER_STATUS_NO_VALIDATE 		= 1;//未验证
	public static final long USER_STATUS_INVALID 			= -1;//作废
	/*************************** 用户申请开户状态(用户角度) start******************************/
	
	/*************************** 用户账户标志 start******************************/
	//用户账户注册状态
	public static final long USER_ACC_SUCCESSFLAG_C 		= 0;//创建成功
	public static final long USER_ACC_SUCCESSFLAG_S 		= 1;//开户成功
	public static final long USER_ACC_SUCCESSFLAG_F		= 2;//开户失败
	/*************************** 用户账户标志 end ******************************/
	
	//短信发送状态
	public static final long MESSAGE_STATUS_UNSEND			= 1;//未发送
	public static final long MESSAGE_STATUS_SENDING			= 2;//发送中
	public static final long MESSAGE_STATUS_FAIL			= -1;//发送失败
	public static final long MESSAGE_STATUS_SUCC			= 3;//发送成功
	
	//短信是否验证
	public static final int MESSAGE_VALIDATE_YES			= 1;//已验证
	public static final int MESSAGE_VALIDATE_NO				= 0;//未验证
	
	/*************************** 风险测评设置  start******************************/
	/** 风险测评完成 */
	public static  final long EXAM_SUCCESS=8; 
	
	/** 风险测评未完成 */
	public static  final long EXAM_FAIL=9; 
	
	/*************************** 银行设置 end******************************/
	
	

	/*************************** 三方存管  start******************************/
	/** 三方存管申请创建*/
	public static  final long DEPOSITY_REVIEW_APPLY=1; 
	/** 三方存管审核通过 */
	public static  final long DEPOSITY_REVIEW_SUCCESS=8;
	/** 三方存管审核未通过 */
	public static  final long DEPOSITY_REVIEW_FAIL=9; 
	
	/** 三方存管开户创建*/
	public static  final long DEPOSITY_APPLY=1; 
	
	public static  final long DEPOSITY_NEEDPASSWORD=7; //需要输入密码
	/** 三方存管开户通过 */
	public static  final long DEPOSITY_SUCCESS=8;
	/** 三方存管开户未通过 */
	public static  final long DEPOSITY_FAIL=9; 
	/*************************** 三方存管 end******************************/
	
	
	
	/*************************** 用户流程状态 progess  start******************************/
	/** 处理中 */
	public static  final long PROGRESS_DEALING=1; 
	/** 处理完成 */
	public static  final long PROGRESS_FINISHED=8; 
	/** 处理失败 */
	public static  final long PROGRESS_FAIL=9; 
	/*************************** 用户流程状态 progess end******************************/
	
	/*************************** 用户证件上传  start******************************/
	public static final long STATUS_ID_UPLOAD_SUCCESS = 8;
	public static final long STATUS_ID_UPLOAD_FAIL = 9;
	
	/*************************** 用户证件上传  end******************************/
	
	

	/*************************** 用户任务状态 start******************************/
	/** 任务未处理 */
	public static final long TASK_CREATE 	= 0;
	/** 任务已经接受处理 */
	public static final long TASK_DEALING 	= 2;
	/** 任务处理完成 */
	public static final long TASK_FINISH 		= 3;
	
	/*************************** 用户账户状态 end ******************************/
	
	/*************************** 数字证书审核状态 start******************************/
	/** 未审核 */
	public static final long CERT_CHECK_NO  	    = 0;
	/** 审核未通过 */
	public static final long CERT_CHECK_REJECT   = 1;
	/**审核通过**/
	public static final long CERT_CHECK_PASS   	= 2 ;

	
	/*************************** 数字证书审核状态 end ******************************/
	

	/*************************** 数字证书安装 start******************************/
	/** 未安装 */
	public static final long CERT_SETUP_NO  	    = -1;
	/** 已经安装 */
	public static final long CERT_SETUP_YES 		= 1;

	
	/*************************** 数字证书安装 end ******************************/
	
	 /*************************** 接口任务状态  start******************************/
	 /**接口任务状态：未提交 **/
	public static final Long HTINTERFACE_STATUS_0 			= 0L;
	/**接口任务状态：处理中 **/
	public static final Long HTINTERFACE_STATUS_1 			= 1L;
	/**接口任务状态：同步完成  **/
	public static final Long HTINTERFACE_STATUS_2 			= 2L;
	/**接口任务状态：同步失败 **/
	public static final Long HTINTERFACE_STATUS_3 			= 3L;
	/**接口任务状态：接口接收成功 **/
	public static final Long HTINTERFACE_STATUS_8 			= 8L;
	/**接口任务状态： 接口接收失败 **/
	public static final Long HTINTERFACE_STATUS_9 			= 9L;
	/*************************** 接口任务状态  end******************************/
	
	 /*************************** 字典状态 ******************************/
	/** 可显示状态 **/
	public static final Long DICTIONARY_STATUS_8 			= 8L;
	/** 可显示状态 **/
	public static final Long DICTIONARY_STATUS_9 			= 9L;
	
	//复核意见状态(UserAmendments)
	public static final long REVIEW_AMEND_STATUS_MODIFY		= 8L;
	public static final long REVIEW_AMEND_STATUS_NOT_MODIFY	= 9L;
	
	//基金公司显示状态
	public static final Long FUND_COMPANY_STATUS_8 			= 8L;//显示
	public static final Long FUND_COMPANY_STATUS_9 			= 9L;//隐藏
	
	//用户审核错误修改状态(UserProfileChange)
	public static final long USER_PROFILE_CHANGE_STATUS_0   = 0L;//未提交
	public static final long USER_PROFILE_CHANGE_STATUS_1   = 1L;//已提交
	public static final long USER_PROFILE_CHANGE_STATUS_8   = 8L;//修改成功
	public static final long USER_PROFILE_CHANGE_STATUS_9   = 9L;//修改失败
	
	//具体字段错误修改状态(UserChangeDetail)
	public static final long USER_CHANGE_DETAIL_STATUS_0   = 0L;//未修改
	public static final long USER_CHANGE_DETAIL_STATUS_8   = 8L;//修改成功
	public static final long USER_CHANGE_DETAIL_STATUS_9   = 9L;//修改失败
	
	public static final long ORG_STATUS_NORMAL=8L;
	public static final long ORG_TYPE_BRANCH=3L;
	
	/*********************基金公司 状态***************************/
	/**基金公司 正常状态**/
	public static final long FUNDCOMPANY_STATUS_8 = 8L;
	/**基金公司 隐藏状态**/
	public static final long FUNDCOMPANY_STATUS_9 = 9L;

	/*************************** 视频验证 start******************************/
	public static final long STATUS_VIDEO_VERIFY_SAVE = 1;
	public static final long STATUS_VIDEO_VERIFY_SUCCESS = 8;
	public static final long STATUS_VIDEO_VERIFY_FAIL = 9;
	/*************************** 视频验证  end******************************/
	
	public static final long USER_UNSIGNED_FLAG = 0;
	public static final long USER_SIGNED_FLAG = 1;
	
	//账户开户状态
	public static final String ACCOUNT_STATUS_0 			= "0";
	public static final String ACCOUNT_STATUS_1 			= "1";
	public static final String ACCOUNT_STATUS_2 			= "2";
	public static final String ACCOUNT_STATUS_3 			= "3";
	
	//证书状态
	public static final String CSDC_CERT_STATUS_0 			= "0"; //需重新安装的
	public static final String CSDC_CERT_STATUS_1 			= "1";
	public static final String CSDC_CERT_STATUS_2 			= "2";
	public static final String CSDC_CERT_STATUS_3 			= "3";
	public static final String CSDC_CERT_STATUS_4 			= "4";
	
	//
	public static final String FUN_FLAG_0 					= "0";
	public static final String FUN_FLAG_1 					= "1";
	
	
	/**************************  社区字段  **************************************/
	
	//消息提醒开关
	/** 0:消息提醒打开*/
	public static final String MSG_REMIND = "0";
	/** 1:消息提醒关闭*/
	public static final String MSG_NOT_REMIND = "1";
	
	//点赞提醒开关
	/**0:点赞提醒打开*/
	public static final String PRAISE_REMIND = "0";
	/**1:点赞提醒关闭*/
	public static final String PRAISE_NOT_REMIND = "1";
}
