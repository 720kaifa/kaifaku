package cairh.community.api.game.kxian.common;
public class ProgressNodes {

	//虚拟节点
	public static String ENTITY_VERIFY_V="11001"; //身份验证
	public static String OPEN_APPLY_V="21005";//开户申请
	public static String ID_VERIFY_V="11002";//实名验证
	public static String BANK_VERIFY_V="11003";//银行验证
	public static String VIDEO_VERIFY_V="11004";//视频验证
	
	//实际功能 用户只在该步骤成功时候调用
	public static String REGISTER				= "12100";//注册/短信验证
	public static String CONTROL_SETUP			= "12101";//下载安全控件
	public static String VERIFY_TYPE			= "12102";//实名验证选择
	public static String BANK_VERIFY			= "12103";//银行验证
	public static String VIDEO_VERIFY			= "12104";//视频验证
	public static String CA						= "12105";//安装CA证书
	public static String SUBSCRIBE				= "22106";//完善用户资料
	public static String ID_UPLOAD				= "22107";//上传身份证
	public static String INVEST_TYPE			= "22108";//选择投资品种
	public static String AGREEMENT_SIGN			= "22109";//协议签署
	public static String RISK_EXAM				= "22110";//风险评测
	public static String BRANCH					= "22111";//选择营业部
	public static String PWD_SETTING			= "22112";//设置密码
	public static String DEPOSITY				= "22113";//指定存管银行
	public static String APPLY_SUBMIT			= "22114";//提交开户申请
	public static String CALLBACK				= "23115";//回访
	
	public static String USER_IMPROVE           ="33200"; //用户递交整改
	
	public static String RECEIVE_VIDEO_REQUEST  ="33201";//	接收视频请求任务
	public static String POLICE_SYSTEM_QUERY	="33202";//	公安系统查询
	public static String VIDEO_VALIDATE_SUCCESS ="33203";//	完成视频验证任务(成功)
	public static String VIDEO_VALIDATE_FAIL    ="33221";//	完成视频验证任务(失败)
	public static String CD_QUERY               ="33204";//	中登查询
	
	public static String APPROVE_REJECT         ="33205";//	审核开户（驳回）
	public static String APPROVE_SUCCESS        ="33206";//	审核开户（通过）
	public static String REVIEW_REJECT          ="33207";//	复核开户（驳回）
	public static String REVIEW_SUCCESS         ="33208";//	复核开户（通过）
	public static String REVIEW_AUTO_SUCCESS    ="33226";//	复核 通过自动进柜台
	
	
	public static String COUNTER_RECEIVE        ="33209";// 柜台开户
	public static String COUNTER_PREOPEN_SUCCESS="33210";//	预开户成功
	public static String COUNTER_PREOPEN_FAIL   ="33211";//	预开户失败
	public static String CALL_BACK              ="33212";//	回访中
	public static String OPEN_SUCCESS           ="33213";//	开户成功
	public static String OPEN_FAIL	            ="33213";// 开户失败
	public static String BANK_VALIDATE_SUCCESS	="33215";//	银行验证成功
	public static String BANK_VALIDATE_FAIL  	="33222";//	银行验证失败
	public static String REVIDEO_VERIFY	        ="33216";//	重新采集视频请求（用户） 
	public static String RECEIVE_REVIDEO_VERIFY ="33217";//	接收重采视频请求任务
	public static String SUCCESS_REVIDEO_VERIFY ="33218";// 完成重采视频成功
	public static String FAIL_REVIDEO_VERIFY    ="33300";// 完成重采视频失败
	public static String CA_DELIVERY_SUCCESS    ="33219";// 证书发放审核（成功）
	public static String CA_DELIVERY_FAIL       ="33220";// 证书发放审核（失败）
	public static String COUNTER_FAIL_SUCCESS   ="33223";//复核通过（柜台预开户失败）
	public static String COUNTER_FAIL_REJECT    ="33224";//复核驳回（柜台预开户失败） 进入审批中流程
	public static String COUNTER_AUTO_SUCCESS   ="33225";//复核通过（柜台预开户成功） 系统自动完成 到回访中
	
	
	public static String SYS_USER_MANAGER       ="43018";//系统账户维护
	public static String SYS_BRANCH_BANK        ="43017";//营业部存管银行
	public static String ACCOUNT_CREATE         ="33900";//业务人员登录
	public static String ACCOUNT_CREATE_SUCCESS ="33901";//账户开立成功
	public static String ACCOUNT_CREATE_FAIL    ="33902";//账户开立失败
 
	
	/*******************   简易开户流程节点     ********************************/
	// 填写用户资料	
	public static String SIMPLE_BASIC_INFO		="302001";
	// 网银实名验证	
	public static String SIMPLE_BANK_VERIFY		="303001";
	// 安装CA证书	
	public static String SIMPLE_SETUP_CERT		="304001";
	// 密码和协议	
	public static String SIMPLE_PWD_AGRMT		="305001";
	// 短信回访
	public static String SIMPLE_SMS_CALLBACK	="306001";
	// 绑定三方存管
	public static String SIMPLE_BIND_SPECIFY	="307001";
	// 开户成功
	public static String SIMPLE_OPEN_SUCCESS	="309001";
	// 回访
	public static String SIMPLE_CALLBACK		="311001";
	// 风险评测
	public static String SIMPLE_RISK_EXAM		="313001";
	// 投资品种
	public static String SIMPLE_INVEST_TYPE		="315001";
	// 上传照片
	public static String SIMPLE_ID_UPLOAD		="317001";
	// 视频验证
	public static String SIMPLE_VIDEO_VERIFY	="319001";
	 
}
