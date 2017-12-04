package cairh.community.api.point.util;


public class TextConstant {
	//登录错误相关提示
	public final static String LOGIN_SUBMIT_ERROR				= "提交信息错误";
	public final static String LOGIN_SUBMIT_ERROR1				= "错误的用户名或密码";
	public final static String LOGIN_SUBMIT_ERROR2				= "您的账户被锁定，请稍后重试";
	public final static String LOGIN_WRONG1 					= "系统繁忙，请稍后重试";
	public final static String LOGIN_WRONG2 					= "资金账号状态非正常";
	public final static String LOGIN_WRONG3 					= "辅资金账号查询异常";
	public final static String LOGIN_WRONG4 					= "辅资金账号不允许登录";
	public final static String SYSTEM_ERROR 					= "系统繁忙，请稍后重试";
	public final static String ILLEGAL_PARAMETER 			    = "参数错误";
	public final static String ACCOUNT_NO_WRONG1 				= "资金账号格式错误";
	public final static String ACCOUNT_NO_WRONG2 				= "资金账号为空";
	public final static String ACCOUNT_NO_WRONG3 				= "资金账户状态异常，请联系开户营业部";
	public final static String PWD_WRONG1 						= "请输入交易密码";
	public static final String VERIFYCODE_WRONG1				= "验证码错误";
	public static final String VERIFYCODE_WRONG2				= "图片验证码错误";
	public static final String USER_NOT_LOGIN					= "用户未登录，请您重新登录";
	public static final String USER_NOT_EXIST					= "用户不存在";
	public static final String FUND_COMPANY_NOT_EXIST			= "基金公司不存在";
	public static final String FUND_COMPANY_OPEN_YET			= "您已开通该基金公司账户";
	public static final String FUND_OPEN_WRONG_TIME				= "请在交易日9：30——15：00时间段内开通基金账户";
	
	//三方存管银行错误提示
	public static final String DEPOSITY_BANK_SELECT				= "请指定三方存管银行";
	public static final String DEPOSITY_BANK_ACCOUNT			= "请填写三方存管银行账户";
	public static final String DEPOSITY_BANK_ACCOUNT_PWD		= "请填写三方存管银行账户密码";
	public static final String DEPOSITY_ERROR_00000 			= "三方存管绑定提交信息不全";
	public static final String DEPOSITY_ERROR_00001 			= "请填写三方存管银行账户";
	public static final String DEPOSITY_ERROR_00002 			= "请填写三方存管银行账户密码";
	public static final String DEPOSITY_ERROR_00003 			= "三方存管绑定异常";
	public static final String DEPOSITY_ERROR_00020 			= "变更操作时需要撤销的信息不全";
	public static final String DEPOSITY_ERROR_00021 			= "解除操作时需要撤销的信息不全";
	public static final String DEPOSITY_ERROR_00031 			= "银行信息错误";
	public static final String DEPOSITY_ERROR_00041             = "三方存管补签异常";
	
	//业务开通/未开通提示
	public static final String BIZ_CLOSE_TIPS					= "您还未开通";
	public static final String BIZ_OPEN_TIPS					= "已开通";
	
	//密码设置错误提示
	public static final String SETTING_CASH_NOEMPTY				= "资金密码为6位数字";
	public static final String SETTING_TRANS_NOEMPTY			= "交易密码为6位数字";
	public static final String SETTING_CONNECT_NOEMPTY			= "通信密码为6位数字";
	public static final String SETTING_CONNECT_NOTEQUAL			= "两次通信密码不一致";
	public static final String SETTING_CASH_NOTEQUAL			= "两次资金密码不一致";
	public static final String SETTING_TRANS_NOTEQUAL			= "两次交易密码不一致 ";

	/****************************基本资料校验**********************************/
	public static final String SUCCESS 					= "success";
	public static final String VALIDATE_INVALID 		= "含有非法字符";
	//校验姓名
	public static final String VALIDATE_NAME_NULL 		= "姓名不能为空";
	public static final String VALIDATE_NAME_ERROR1		= "姓名不符合规范";
	//校验手机
	public static final String VALIDATE_MOBILE_NULL 	= "手机号码不能为空";
	public static final String VALIDATE_MOBILE_EXIST 	= "手机号码已被使用";
	public static final String VALIDATE_MOBILE_ERROR 	= "手机号码填写错误";
	//校验身份证号
	public static final String VALIDATE_CID_NULL 		= "身份证号码不能为空";
	public static final String VALIDATE_CID_EXIST 		= "身份证号码已被使用";
	public static final String VALIDATE_CID_ERROR1 		= "身份证号码填写错误";//身份证号码长度有误
	public static final String VALIDATE_CID_ERROR2 		= "身份证号码填写错误";//除最后一位外都应为数字
	public static final String VALIDATE_CID_ERROR3 		= "身份证号码填写错误";//生日格式无效
	public static final String VALIDATE_CID_ERROR4 		= "身份证号码填写错误";//生日不在有效范围
	public static final String VALIDATE_CID_ERROR5 		= "身份证号码填写错误";//身份证月份无效
	public static final String VALIDATE_CID_ERROR6 		= "身份证号码填写错误";//身份证日期无效
	public static final String VALIDATE_CID_ERROR7 		= "身份证号码填写错误";//地区编码错误
	public static final String VALIDATE_CID_ERROR8		= "身份证号码填写错误";//身份证校验码有误
	public static final String VALIDATE_CID_ERROR9		= "未满18周岁不能开户";
	//校验身份证和姓名
	public static final String VALIDATE_CIDNAME_EXIST	= "身份证号码已被使用";
	//校验身份证发证机关
	public static final String VALIDATE_CIDFROM_NULL	= "发证机关不能为空";
	public static final String VALIDATE_CIDFROM_ERROR	= "发证机关填写错误";
	//校验证件地址
	public static final String VALIDATE_CIDADDR_NULL	= "地址不能为空";
	public static final String VALIDATE_CIDADDR_ERROR	= "证件地址错误";
	//校验身份证有效期限
	public static final String VALIDATE_CIDABLE_NULL	= "有效期限不能为空";
	public static final String VALIDATE_CIDABLE2_NULL	= "有效期限和长期有效必须填一个";
	public static final String VALIDATE_CIDABLE_ERROR	= "有效期限填写错误";
	//校验联系地址：省份、城市、地区
	public static final String VALIDATE_PROVI_NULL		= "请选择省份";
	public static final String VALIDATE_CITY_NULL		= "请选择城市";
	public static final String VALIDATE_AREA_NULL		= "请选择地区";
	//校验联系地址详细信息
	public static final String VALIDATE_ADDRESS_NULL	= "联系地址不能为空";
	public static final String VALIDATE_ADDRESS_ERROR	= "联系地址填写错误";
	public static final String VALIDATE_ADDRESS_ERROR2	= "请填写详细的联系地址,格式:XX省XX市+详细地址";
	//校验邮政编码
	public static final String VALIDATE_POSTCODE_NULL	= "邮政编码不能为空";
	public static final String VALIDATE_POSTCODE_ERROR 	= "邮政编码填写错误";
	//校验固定电话
	public static final String VALIDATE_TEL_NULL		= "固定电话不能为空";
	public static final String VALIDATE_TEL_ERROR		= "固定电话填写错误";
	//校验电子邮件
	public static final String VALIDATE_EMAIL_NULL		= "电子邮件不能为空";
	public static final String VALIDATE_EMAIL_ERROR		= "电子邮件填写错误";
	//校验职业
	public static final String VALIDATE_JOB_NULL		= "职业不能为空";
	public static final String VALIDATE_JOB_ERROR		= "职业选择错误";
	//校验学历
	public static final String VALIDATE_EDU_NULL		= "学历不能为空";
	public static final String VALIDATE_EDU_ERROR		= "学历选择错误";
	//营业部选择出错
	public static final String VALIDATE_ORG_NULL		= "请选择开户营业部";
	public static final String VALIDATE_ORG_ERROR		= "开户营业部选择错误";
	//营业部选择
	public static final String NO_RECOMMEND_ORG			= "没有推荐的营业部";
	public static final String VALIDATE_SUCCESS			= "验证通过";
	public static final String SAVE_CID_INFO_ERROR		= "保存身份信息有异常";
	public static final String SAVE_COM_INFO_ERROR		= "保存常用信息有异常";
	public static final String SAVE_ORG_INFO_ERROR		= "保存开户营业部信息有异常";

	/*****************************注册相关错误提示************************************/
	public static final String MPHONE_EMPTY				= "手机号码不能为空";
	public static final String MPHONE_INVALID			= "手机号码格式错误";
	public static final String MPHONE_USED_YET			= "此手机号码已经注册，请点击登录按钮";
	public static final String MPHONE_NOT_LOGIN			= "手机号码未被注册";
	public static final String GEN_VALID_CODE_WRONG		= "生成手机验证码出错，请重新获取";
	public static final String MESS_CONTENT_EMPTY		= "短信内容为空";
	public static final String VALIDATE_CODE_EMPTY		= "验证码为空";
	public static final String VALIDATE_CODE_WRONG1		= "验证码格式错误";
	public static final String VALIDATE_CODE_WRONG2		= "验证码错误";
	public static final String VALIDATE_CODE_WRONG3		= "验证码已被使用";
	public static final String VALIDATE_CODE_WRONG4		= "修改手机验证码错误";
	public static final String VALIDATE_CODE_WRONG5		= "新手机验证码错误";
	
	public static final String 	ILLEGAL_REQUEST			= "非法请求";
	public static final String 	REQUEST_FAIL			= "系统繁忙,请稍后再试!";
	public static final String 	DEPOSITY_BANK			= "请选择存管银行";
	public static final String 	DEPOSITY_ACCOUNT_NOEMPTY= "存管银行账户不能为空";
	public static final String 	SIGN_INVALID			= "无效数字签名";
	public static final String 	AGREEMENT_SIGN			= "您已经签署相关协议";
	public static final String 	PWD_VALIDATE_FAIL		= "密码过于简单,请重新设置!";
	public static final String  SIGN_REVOCATION			= "您的数字证书已被注销,请重新申请！";   
	
	//短信内容
	public static final String MESS_NEED_IMPROVE		= "尊敬的客户，您在海通网站提交的开户信息部分有误，请登录我公司网站修改后重新提交，如有疑问请拨打客服热线95553";
	public static final String MESS_OPEN_SUCCESS		= "尊敬的客户，恭喜您网上开户成功！请登录我公司网站下载交易客户端，了解最新业务。欢迎拨打客服热线95553，祝您投资顺利！";
	public static final String MESS_OPEN_FAIL			= "尊敬的客户，您在海通证券网上开户的申请未能通过，如有疑问请拨打客服热线95553";
	public static final String MESS_CA_SUCCESS		    = "尊敬的客户，您申请的数字证书已获批准，请尽快登录网上开户页面，按照提示完成开户的其他步骤";
	public static final String MESS_CA_FAIL		        = "尊敬的客户，您的数字证书申请失败，请登录海通网站查询详情，如有疑问请拨打客服热线95553";
	public static final String MESS_REGISTER	        = "欢迎使用海通证券网上开户，您的短信验证码是xxxxxx，请确保由您本人完成开户操作，如有疑问请拨打客服热线95553";
	public static final String MESS_LOGIN	            = "欢迎使用海通证券网上开户，您的短信验证码是xxxxxx，请确保由您本人完成开户操作，如有疑问请拨打客服热线95553";
	public static final String MESS_KRB	           	 	= "欢迎使用海通证券网上开户，您的短信验证码是xxxxxx，请确保由您本人完成“快融宝”业务申请，如有疑问请拨打客服热线95553";
	public static final String MESS_PAY					= "欢迎开通海通证券保证金支付服务，您的验证码是xxxxxx，请确保由您本人完成申请，如有疑问请拨打客服热线95553";
	public static final String MESS_GQJL           	 	= "欢迎使用海通证券网上营业厅，您的短信验证码是xxxxxx，请确保由您本人完成“行权融资”业务申请，如有疑问请拨打客服热线95553";
	public static final String MESS_MARGIN	           	= "欢迎使用海通证券网上开户，您的短信验证码是xxxxxx，请确保由您本人完成“融资融券”业务申请，如有疑问请拨打客服热线95553";
	public static final String MESS_USERPROFILE	        = "欢迎使用海通证券网上营业厅密码重置，您的短信验证码是xxxxxx，如有疑问请拨打客服热线95553";
	public static final String DIGITAL_SIGN				= "欢迎使用海通证券金融产品代销业务电子签名约定书服务，您的短信验证码是xxxxxx，请确保由您本人完成，如有疑问请拨打客服热线95553";
	public static final String MESS_CYB					= "欢迎使用海通证券网上开户，您的短信验证码是xxxxxx，请确保由您本人完成“创业板”业务申请，如有疑问请拨打客服热线95553";
	public static final String MESS_CYB_SYNC			= "尊敬的客户，恭喜您创业板转签成功，如有疑问请拨打客服热线95553，祝您投资顺利！";

	public static final String MESS_PAY_CZMM			= "重置支付密码验证码为：xxxxxx，确认重置后会短信发送新的支付密码，请稍后查收，如需修改，请进行密码修改操作";
	public static final String USER_PROFILE_OLD_MOBILE  = "您修改绑定手机号的验证码为：xxxxxx，如非本人操作，请致电95553或4008888001";
	public static final String USER_PROFILE_NEW_MOBILE  = "您新绑定手机号的验证码为：xxxxxx，如非本人操作，请致电95553或4008888001";
	public static final String MESS_ANONY_RISK	        = "欢迎使用海通证券网上营业厅风险承受能力测评，您的短信验证码是xxxxxx，如有疑问请拨打客服热线95553";

	public static final String MESS_GJS	           		= "欢迎使用海通证券网上开户，您的短信验证码是xxxxxx，请确保由您本人完成“贵金属”业务申请，如有疑问请拨打客服热线95553";
	public static final String MESS_WEALTH	           	= "欢迎使用海通证券财富视图，您的短信验证码是xxxxxx，请确保由您本人完成“财富视图”业务解绑，如有疑问请拨打客服热线95553";
	public static final String MESS_PORT_STAT	        = "尊敬的客户，xx业务接口异常次数已达到##次，请及时关注！";
	
	/*************************************业务错误提示*****************************************/
	//金仕达查询无记录错误提示
	public static final String KSD_NO_RECORD					= "查询失败：查询无记录";
	//机构用户错误提示
	public static final String ORG_USER_WRONG 					= "机构客户暂不支持此项业务，请到附近营业部办理";
	//用户证件信息错误提示
	public static final String USER_IDENTITY_WRONG1 			= "暂不支持第一代身份证用户办理此业务";
	public static final String USER_IDENTITY_WRONG2 			= "您的证件已过期，请更新证件信息";
	
	//申请证书错误提示
	public static final String CERT_WRONG2 						= "开始视频出错，请重试";
	public static final String CERT_WRONG3 						= "查询用户视频信息出错";
	public static final String CERT_WRONG4 						= "机构客户暂不支持证书申请";
	public static final String CERT_WRONG5 						= "页面已过期，请刷新页面";
	public static final String CERT_WRONG6 						= "证书申请密码字符串为空";
	public static final String CERT_WRONG7 						= "MAC地址为空";
	public static final String CERT_WRONG8 						= "无法获取用户证书申请信息";
	public static final String CERT_WRONG9 						= "用户证书颁发未通过";
	public static final String CERT_WRONG10 					= "通信链路繁忙";
	public static final String CERT_WRONG11 					= "证书生成错误";
	public static final String CERT_WRONG12 					= "申请证书类型错误";
	public static final String CERT_WRONG13						= "请选择预约时间";
	public static final String CERT_WRONG14						= "预约时间格式错误";
	
	//上传图片错误提示
	public static final String UPLOAD_FILE_WRONG1				= "上传文件格式不正确";
	public static final String UPLOAD_FILE_WRONG2 				= "上传文件失败";
	public static final String UPLOAD_FILE_WRONG3 				= "无法获取上传图片内容";
	public static final String UPLOAD_FILE_WRONG4 				= "客户公安信息[图像解码出错]";
	public static final String UPLOAD_FILE_WRONG5 				= "身份证有效期解析失败，请重新上传";
	public static final String UPLOAD_FILE_WRONG6				= "签发机关解析失败，请重新上传";
	public static final String UPLOAD_FILE_WRONG7				= "身份证号解析失败，请重新上传";
	public static final String UPLOAD_FILE_WRONG8				= "身份证姓名解析失败，请重新上传";
	public static final String UPLOAD_FILE_WRONG9				= "身份证号错误，请重新上传";
	public static final String UPLOAD_FILE_WRONG10				= "姓名错误，请重新上传";
	public static final String UPLOAD_FILE_WRONG11				= "上传身份证免冠照异常";
	public static final String UPLOAD_FILE_WRONG12				= "证件地址解析为空";
	
	//OTC业务相关错误
	public static final String OTC_WRONG1 						= "OTC业务开通出错";
	public static final String OTC_WRONG3 						= "查询用户OTC信息出错";
	public static final String OTC_WRONG4 						= "查询OTC基金公司信息出错";
	public static final String OTC_WRONG5 						= "您已开通过OTC";
	public static final String OTC_WRONG6 						= "您已经申请过开通OTC";
	
	//债券逆回购业务相关错误
	public static final String NATIONNAL_DEBT_WRONG1 			= "债券质押式逆回购业务开通出错";
	public static final String NATIONNAL_DEBT_WRONG3 			= "您尚未签署金融产品代销业务电子签名约定书";
	public static final String NATIONNAL_DEBT_WRONG4 			= "不存在该种股票账户类型";
	public static final String NATIONNAL_DEBT_WRONG5 			= "获取股东账户信息出错";
	public static final String NATIONNAL_DEBT_WRONG6 			= "您尚未开通深圳A股股东账户";
	public static final String NATIONNAL_DEBT_WRONG7 			= "您尚未开通上海A股股东账户";
	public static final String NATIONNAL_DEBT_WRONG8 			= "您已开通债券质押式逆回购业务";
	
	//风险评测相关错误
	public static final String RISK_PAPER_WRONG2 				= "获取用户风险承受能力测评信息出错";
	public static final String RISK_PAPER_WRONG3 				= "您未做风险承受能力测评";
	public static final String RISK_PAPER_WRONG4 				= "风险承受能力测评已过期";
	public static final String RISK_PAPER_WRONG5 				= "评测失败,请重试";
	public static final String RISK_PAPER_WRONG6 				= "您未做风险承受能力测评，请进行评测";
	public static final String RISK_PAPER_WRONG7 				= "您的风险承受能力测评结果已过期，请重新进行评测";
	
	//报价回购相关错误
	public static final String BJHG_WRONG1 						= "报价回购开通失败，请重试";
	public static final String BJHG_WRONG2 						= "查询用户报价回购信息出错";
	public static final String BJHG_WRONG3 						= "您尚未开通上海A股股东账户";
	public static final String BJHG_WRONG4 						= "您的账户状态为未指定，暂时无法开通";
	public static final String BJHG_WRONG5 						= "您的账户状态为新指定，请于下一个工作日再提交申请";
	
	//证券账户相关错误
	public static final String STOCK_ACCOUNT_WRONG1 			= "查询用户证券账户信息出错";
	public static final String STOCK_ACCOUNT_WRONG2 			= "证券账户开通出错";
	public static final String STOCK_ACCOUNT_WRONG3 			= "您的沪A证券账户状态非正常";
	public static final String STOCK_ACCOUNT_WRONG4 			= "您尚未开通沪A证券账户";
	
	//电子签名约定书错误
	public static final String DIGITAL_SIGN_WRONG1 				= "签署金融产品代销业务电子签名约定书出错";
	
	//开放式基金相关错误
	public static final String OPEN_FUND_WRONG1 				= "注销的基金公司不存在";
	public static final String OPEN_FUND_WRONG2 				= "您未开通该基金公司账号";
	public static final String OPEN_FUND_WRONG3 				= "基金账号为未连通状态，不能销户";
	public static final String OPEN_FUND_WRONG4 				= "您已申请过开通该基金，不能重复申请";
	
	//三方存管相关错误
	public static final String THIRD_WRONG1 					= "查询用户信息出错";
	public static final String THIRD_WRONG2 					= "非身份证开户用户不能绑定三方存管";
	public static final String THIRD_WRONG3 					= "查询中登信息出错";
	public static final String THIRD_WRONG4 					= "纯B用户不能绑定三方存管";
	
	//协议签订错误提示
	public static final String USER_APPLY_WRONG1 				= "未找到用户申请信息";
	public static final String USER_APPLY_WRONG2				= "未找到快融宝合同信息";
	public static final String USER_APPLY_WRONG3				= "内容格式错误";
	
	//快融宝错误提示
	public static final String KRB_WRONG0    					= "开通快融宝业务时，提交征信因子失败！";
	public static final String KRB_WRONG5						= "快融宝开通失败";
	public static final String KRB_WRONG6						= "您的快融宝申请已提交，不能重新开通";
	public static final String KRB_WRONG7						= "您的快融宝申请已成功，不能重新开通";
	public static final String KRB_WRONG8						= "提交签署协议异常";
	public static final String KRB_WRONG9						= "提交确认条款信息异常";
	public static final String KRB_WRONG10						= "无法获取用户手机号码";
	public static final String KRB_WRONG11						= "修改用户应急联系人信息出错";
	
	//行权融资错误提示
	public static final String GQJL_WRONG0    					= "开通行权融资业务时，提交征信因子失败！";
	public static final String GQJL_WRONG5						= "行权融资开通失败";
	public static final String GQJL_WRONG6						= "您的行权融资申请已提交，不能重新开通";
	public static final String GQJL_WRONG7						= "您的行权融资申请已成功，不能重新开通";
	public static final String GQJL_WRONG8						= "提交签署协议异常";
	public static final String GQJL_WRONG9						= "提交确认条款信息异常";
	public static final String GQJL_WRONG10					= "无法获取用户手机号码";
	public static final String GQJL_WRONG11					= "修改用户应急联系人信息出错";
	
	//保证金支付错误提示
	public static final String PAY_WRONG1						= "无法获取用户手机号码";
	public static final String PAY_WRONG2						= "昵称不能为空";
	public static final String PAY_WRONG3						= "支付密码不能为空";
	public static final String PAY_WRONG4						= "单笔支付限额必须大于0小于等于100000的整数";
	public static final String PAY_WRONG5						= "单日支付限额必须大于0小于等于100000的整数";
	public static final String PAY_WRONG6						= "支付密码必须为六位数字";
	public static final String PAY_WRONG7						= "您还未开通三方存管，请先开通三方存管服务";
	public static final String PAY_WRONG8						= "没有可以开通的消费支付业务功能,请确认系统状态";
	
	//国富基金(天天涨)错误提示
	public static final String TTZ_WRONG2						= "查询用户富国基金开通状态失败";
	public static final String TTZ_WRONG3						= "开通富国基金失败";
	public static final String TTZ_WRONG4						= "签署协议失败";
	
	//融资融券错误提示
	public static final String MARGIN_WRONG1					= "您的融资融券申请已提交，不能重新开通";
	public static final String MARGIN_WRONG2					= "您的融资融券申请已成功，不能重新开通";
	public static final String MARGIN_WRONG3					= "提交签署协议异常";
	public static final String MARGIN_WRONG4					= "修改用户应急联系人信息出错";
	public static final String MARGIN_WRONG5					= "提交征信信息出错";
	public static final String MARGIN_WRONG6					= "征信重要信息（客户信息）申报出错";
	public static final String MARGIN_WRONG7					= "征信合同签署出错";
	public static final String MARGIN_WRONG8					= "征信授信申请出错";
	public static final String MARGIN_WRONG9					= "征信重要信息（股票信息）申报出错";
	public static final String MARGIN_WRONG10					= "征信资金账号录入出错";
	public static final String MARGIN_WRONG11					= "您已列入黑名单客户，不允许开通融资融券业务";
	public static final String MARGIN_WRONG12					= "征信客户其他信息录入出错";
	public static final String MARGIN_WRONG13					= "用户融资融券申请状态有误，请刷新页面";
	public static final String MARGIN_WRONG14					= "融资融券跳转页面有误";
	
	//修改用户信息错误提示
	public static final String USER_MODIFY_WRONG1				= "新邮箱与已绑定邮箱相同";
	public static final String USER_MODIFY_WRONG2				= "验证的邮箱与您绑定的邮箱不同";
	
	//沪港通开通错误提示
	public static final String HK_STOCK_WRONG1					= "您已提交港股通开通请求，请刷新页面查看开通状态";
	public static final String HK_STOCK_WRONG2					= "您的净资产不足50万，暂不能开通港股通业务";
	public static final String HK_STOCK_WRONG3					= "当天无法再次申请，请于第二天继续申请开通港股通业务";
	public static final String HK_STOCK_WRONG4					= "开通港股通业务出错";
	public static final String HK_STOCK_WRONG5					= "无法获取港股通测试题库";
	public static final String HK_STOCK_WRONG6					= "无法获取用户港股通测试答案";
	public static final String HK_STOCK_WRONG7					= "您的测试结果不符合要求，请重新进行测试";
	public static final String HK_STOCK_WRONG8					= "您的登录密码已过期，请重新登录网厅";
	public static final String HK_STOCK_WRONG9					= "您的沪港通申请已提交，不能重新开通";
	public static final String HK_STOCK_WRONG10					= "您的沪港通请已成功，不能重新开通";
	
	//消费支付错误提示
	public static final String XFZF_WRONG1						= "查询用户保证金支付开通状态错误";
	public static final String XFZF_WRONG2						= "请至少选择开通一种保证金支付服务";
	public static final String XFZF_WRONG3						= "保证金支付服务开通失败";
	public static final String XFZF_WRONG4						= "您已开通保证金支付服务，不能重复开通";
	public static final String XFZF_WRONG5						= "请选择需要开通的保证金支付业务";
	public static final String XFZF_WRONG6						= "您尚未开通保证金支付服务";
	public static final String XFZF_WRONG7						= "您已开通该保证金支付业务，不能重复开通";
	public static final String XFZF_WRONG8						= "查询消费支付客户基础数据信息错误";
	public static final String XFZF_WRONG9						= "查询消费支付客户绑定银行卡信息出错";
	public static final String XFZF_WRONG10						= "消费支付手机验证功能暂未开启，请稍后重试";
	public static final String XFZF_WRONG11						= "发送手机验证码失败，请稍后重试";
	public static final String XFZF_WRONG12						= "保证金支付转账转入已提交，请注意查收";
	public static final String XFZF_WRONG13						= "手机号码充值失败";
	public static final String XFZF_WRONG14						= "信用卡还款失败";
	public static final String XFZF_WRONG15						= "信用卡设置失败";
	public static final String XFZF_WRONG16						= "信用卡添加失败";
	public static final String XFZF_WRONG17						= "保证金支付额度设置失败";
	public static final String XFZF_WRONG18						= "转账转入添加银行卡失败";
	public static final String XFZF_WRONG19						= "转账转入删除银行卡失败";
	public static final String XFZF_WRONG20						= "支付密码加密失败，请重试";
	public static final String XFZF_WRONG21						= "支付密码错误，若密码连续三次输入错误，则账户当日会被锁定";
	public static final String XFZF_WRONG22						= "手机充值申请已提交，请注意查收";
	public static final String XFZF_WRONG23						= "重置密码失败";
	
	//创业板错误提示
	public static final String CYB_WRONG1						= "目前只支持首次交易日在2年及以上的用户开通";
	public static final String CYB_WRONG2						= "查询用户首次交易日出错";
	public static final String CYB_WRONG3						= "创业板签署查询出错";
	public static final String CYB_WRONG4						= "尚未开通深圳A股账户或账户状态非正常";
	public static final String CYB_WRONG5						= "创业板开通出错";
	public static final String CYB_WRONG6						= "您不符合转签条件，请前往开户营业部柜台办理创业板权限";
	
	//重要资料错误提示
	public static final String IMPORTANT_ERROR1					= "没有查询到您的申请记录";
	public static final String IMPORTANT_ERROR2					= "您的身份证正面还没有上传";
	public static final String IMPORTANT_ERROR3					= "您的身份证背面还没有上传";
	
	//密码重置错误提示
	public static final String PWDRESET_INFOWRONG				= "您所填写的信息不符,请核对您的资金帐号，姓名，身份证号码";
	public static final String PWDRESET_PHONEWRONG				= "请输入开户时预留的手机号码，如需要修改，请前往附近营业部或者致电95553";
	
	//贵金属错误提示
	public static final String GJS_WRONG1						="提交用户资料异常";
	public static final String GJS_WRONG2						="设置交易密码异常";
	
	//财富视图错误提示
	public static final String WEALTH_WRONG1					="财富视图权限开通出错";
	public static final String WEALTH_WRONG2					="财富视图绑定出错";
	public static final String WEALTH_WRONG3					="财富视图解绑出错";
}
