package cairh.community.api.point.common;
/***********************************************************************************
*1-->2013-05-24  quote by stevinzhu@cairenhui.com  系统提示信息    BugNo:--
*2-->
***********************************************************************************/
public class TextConstant {
	
	public static final String LOGIN_WRONG= "用户名或密码不正确";
	
	/**三方存管银行指定*/
	public static final String DEPOSITY_BANK_SELECT= "请指定三方存管银行";
	/**三方存管银行账户填写*/
	public static final String DEPOSITY_BANK_ACCOUNT= "请填写三方存管银行账户";
	
	/**密码设置不能为空*/
	public static final String SETTING_CASH_NOEMPTY= "资金密码为6位数字";
	public static final String SETTING_TRANS_NOEMPTY= "交易密码为6位数字";
	public static final String SETTING_CONNECT_NOEMPTY= "通信密码为6位数字";
	
	public static final String SETTING_CONNECT_NOTEQUAL= "两次通信密码不一致";
	public static final String SETTING_CASH_NOTEQUAL= "两次资金密码不一致";
	public static final String SETTING_TRANS_NOTEQUAL= "两次交易密码不一致 ";

	/**
	 * 基本资料校验
	 * @auther zhanggj
	 */
	public static final String VERIFYCODE_WRONG1				= "图片验证码错误";
	public static final String SUCCESS 					= "success";			//校验通过返回值
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
	public static final String VALIDATE_EMAIL_NOT_EXISTS = "电子邮件不存在";

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
	
	/****************************审核相关错误提示************************************/
	public static final String AUDIT_USER_NOT_EXIST				= "被修改用户不存在";
	public static final String AUDIT_USER_NOT_LOGIN				= "用户未登录";
	public static final String AUDIT_NOT_NEED_MODIFY			= "您没有待修改项";
	public static final String AUDIT_FIELD_NOT_NEED_MODIFY		= "该项不需要修改";
	public static final String AUDIT_FIELD_NOT_MODIFY			= "您还有待修改项";
	public static final String AUDIT_FIELD_EMPTY				= "修改字段为空";
	public static final String AUDIT_CONTENT_EMPTY				= "修改内容为空";
	public static final String VALIDATE_FIELD_ERROR				= "该字段不需验证";
	public static final String AUDIT_DICT_EMPTY					= "字典表中不存在此种类型的数据";
	public static final String AUDIT_FUND_COMPANY_EMPTY			= "基金公司列表为空";
	public static final String AUDIT_STOCK_ACCOUNT_EMPTY		= "不存在该类型的股票账户";
	public static final String AUDIT_FUND_ACCOUNT_EMPTY			= "不存在该类型的基金账户";
	public static final String AUDIT_FUND_COMPANY_EMPTY2		= "请选择基金公司";
	public static final String AUDIT_FUND_COMPANY_EMPTY3		= "不存在该基金公司";
	public static final String AUDIT_SERVICE_TYPE_WRONG1		= "委托方式不能为空";
	public static final String AUDIT_SERVICE_TYPE_WRONG2		= "委托方式不存在";
	public static final String AUDIT_SERVICE_TYPE_WRONG3		= "委托方式不合法";
	public static final String AUDIT_DEPOSITY_BANK_WRONG1		= "存管银行为空";
	public static final String AUDIT_DEPOSITY_BANK_WRONG2		= "存管银行或银行卡号为空";
	public static final String AUDIT_DEPOSITY_BANK_WRONG3		= "存管银行或银行卡号为空不存在";
	public static final String AUDIT_DEPOSITY_BANK_WRONG4		= "银行卡号格式错误";
	public static final String AUDIT_DEPOSITY_BANK_WRONG5		= "数据库中没有银行列表";
	public static final String AUDIT_DEPOSITY_BANK_WRONG6		= "没有该银行的三方存管协议";
	public static final String AUDIT_DEPOSITY_BANK_WRONG7		= "三方存管签名为空";
	public static final String AUDIT_ID_PIC_WRONG1				= "图片地址为空";
	public static final String AUDIT_ORG_WRONG2					= "不存在该营业部";
	public static final String AUDIT_ORG_WRONG1					= "数据库中没有营业部列表";
	public static final String AUDIT_IMG_URL_WRONG1				= "图片地址为空";
	public static final String AUDIT_IMG_URL_WRONG2				= "图片地址格式不正确";
	
	
	public static final String USER_NOT_LOGIN				    = "用户未登录";
	
	/** */
	public static final String 	ILLEGAL_REQUEST="非法请求";
	public static final String 	REQUEST_FAIL="系统繁忙,请稍后再试!";
	public static final String 	DEPOSITY_BANK="请选择存管银行";
	public static final String 	DEPOSITY_ACCOUNT_NOEMPTY="存管银行账户不能为空";
	public static final String 	SIGN_INVALID="无效数字签名";
	public static final String 	AGREEMENT_SIGN="您已经签署相关协议";
	public static final String 	PWD_VALIDATE_FAIL="密码过于简单,请重新设置!";
	public static final String  SIGN_REVOCATION= "您的数字证书已被注销,请重新申请！";   
	
	/*********************登录错误相关提示**************************/
	public final static String HTTP_POST_WRONG1 			= "返回结果为空";
	public final static String HTTP_POST_WRONG2 			= "解析返回数据出错";
	
	//短信内容
	public static final String MESS_NEED_IMPROVE		= "尊敬的客户，您在海通网站提交的开户信息部分有误，请登录我公司网站修改后重新提交，如有疑问请拨打客服热线95553";
	public static final String MESS_OPEN_SUCCESS		= "尊敬的客户，恭喜您网上开户成功！请登录我公司网站下载交易客户端，了解最新业务。欢迎拨打客服热线95553，祝您投资顺利！";
	public static final String MESS_OPEN_FAIL			= "尊敬的客户，您在海通证券网上开户的申请未能通过，如有疑问请拨打客服热线95553";
	public static final String MESS_CA_SUCCESS		    = "尊敬的客户，您申请的数字证书已获批准，请尽快登录网上开户页面，按照提示完成开户的其他步骤";
	public static final String MESS_CA_FAIL		        = "尊敬的客户，您的数字证书申请失败，请登录海通网站查询详情，如有疑问请拨打客服热线95553";
	public static final String MESS_REGISTER	        = "欢迎使用海通证券网上开户，您的短信验证码是xxxxxx，请确保由您本人完成开户操作，如有疑问请拨打客服热线95553";
	public static final String MESS_LOGIN	            = "欢迎使用海通证券网上开户，您的短信验证码是xxxxxx，请确保由您本人完成开户操作，如有疑问请拨打客服热线95553";
	
	//注册错误
	public static final String REGISTER_WRONG1 			= "营业部不存在";
	public static final String REGISTER_WRONG2 			= "发送验证码失败，请重试";
	public static final String REGISTER_WRONG3 			= "短信验证码验证失败";
	public static final String REGISTER_WRONG4 			= "您尚未开通海通证券账户";
	//上传图片错误
	public static final String TXT_UPLOAD_FAILED 		= "上传文件失败";
	public static final String ID_UPLOAD_WRONG1 		= "您还未上传照片";
	public static final String ID_UPLOAD_WRONG2 		= "上传照片失败，请重新上传";
	public static final String ID_UPLOAD_WRONG3 		= "身份证正面照识别出错，请重新上传";
	public static final String ID_UPLOAD_WRONG4 		= "身份证反面照识别出错，请重新上传";
	public static final String ID_UPLOAD_WRONG5 		= "您上传的图片不符合要求，请重新上传";
	public static final String ID_UPLOAD_WRONG6 		= "您尚未登录或已超时，请重新<a href=\"/\">登录</a>";
	//基本资料错误
	public static final String BASIC_INFO_WRONG1 		= "提交资料出错，请稍后重试";
	public static final String BASIC_INFO_WRONG2 		= "您尚未登录或已超时，请重新<a href=\"/\">登录</a>";
	public static final String BASIC_INFO_WRONG3 		= "该客户已存在，请重新输入";
	public static final String BASIC_INFO_WRONG4 		= "身份证件信息不存在";
	//视频验证出错
	public static final String VIDEO_VERIFY_WRONG1 		= "视频验证失败，请重试";
	public static final String VIDEO_VERIFY_WRONG2 		= "您已在待见证队列中,不能重复申请";
	public static final String VIDEO_VERIFY_WRONG3 		= "当前待见证队列已满，请稍后再试";
	public static final String VIDEO_VERIFY_WRONG4 		= "视频验证未通过";
	public static final String VIDEO_VERIFY_WRONG5		= "您尚未登录或已超时，请重新<a href=\"/\">登录</a>";
	//单向视频上传出错
	public static final String VIDEO_VERIFY_WRONG6 		= "图片或视频上传出错，请重新上传";
	//证书申请出错
	public static final String CA_WRONG1 				= "无法获取证书内容，请重试";
	public static final String CA_WRONG2 				= "您尚未登录或已超时，请重新<a href=\"/\">登录</a>";
	//选择账户出错
	public static final String ACCOUNT_TYPE_WRONG1		= "您尚未登录或已超时，请重新<a href=\"/\">登录</a>";
	public static final String ACCOUNT_TYPE_WRONG2		= "请选择您要开设的账户";
	public static final String ACCOUNT_TYPE_WRONG3		= "您选择的账户不存在";
	public static final String ACCOUNT_TYPE_WRONG4		= "开户协议签名出错，请确认是否正确安装数字证书";
	//密码设置出错
	public static final String PWD_SET_WRONG1			= "您尚未登录或已超时，请重新<a href=\"/\">登录</a>";
	public static final String PWD_SET_WRONG2			= "密码不能为空";
	public static final String PWD_SET_WRONG3			= "密码类型错误";
	public static final String PWD_SET_WRONG4			= "密码格式错误";
	//绑定三方存管出错
	public static final String THIRD_DEPOSITY_WRONG1	= "您尚未登录或已超时，请重新<a href=\"/\">登录</a>";
	public static final String THIRD_DEPOSITY_WRONG2	= "银行卡号格式错误";
	public static final String THIRD_DEPOSITY_WRONG3	= "银行卡密码格式错误";
	public static final String THIRD_DEPOSITY_WRONG4	= "银行卡类型错误";
	public static final String THIRD_DEPOSITY_WRONG5	= "不存在该银行";
	public static final String THIRD_DEPOSITY_WRONG6	= "绑定三方存管出错";
	public static final String THIRD_DEPOSITY_WRONG7	= "不存在该银行三方存管协议";
	public static final String THIRD_DEPOSITY_WRONG8	= "无法获取三方存管协议电子签名";
	//提交风险出错
	public static final String RISK_WRONG1				= "您尚未登录或已超时，请重新<a href=\"/\">登录</a>";
	public static final String RISK_WRONG2				= "填写答案有误";
	//提交风险出错
	public static final String CALLBACK_WRONG1			= "您尚未登录或已超时，请重新<a href=\"/\">登录</a>";
	//签署协议出错
	public static final String SIGN_WRONG1				= "该协议不存在";
	public static final String SIGN_WRONG2				= "签署电子协议出错";
	public static final String SIGN_WRONG3				= "三方存管协议不存在";
	public static final String SIGN_WRONG4				= "三方存管银行不存在";
	//开户出错
	public static final String OPEN_ACCOUNT_WRONG1		= "开股票账户出错";
	//预约视频出错
	public static final String ORDER_VIDEO_WRONG1		= "qq号格式错误";
	public static final String ORDER_VIDEO_WRONG2		= "请选择预约时间";
	public static final String ORDER_VIDEO_WRONG3		= "预约时间格式错误";
	public static final String ORDER_VIDEO_WRONG4		= "预约视频错误";
	public static final String ORDER_VIDEO_WRONG5		= "该QQ号已存在，请重新输入";
	//委托方式
	public static final String OPEN_SERVICE_TYPE_WRONG  = "开设委托方式出错";
	
	public static final String BASIC_INFO_WRONG8 		= "请选择开户统一受理中心";
	//营业部选择错误提示
	public static final String DEPARTMENT_WRONG1 		= "请选择营业部";
	public static final String DEPARTMENT_WRONG2 		= "提交营业部信息出错";
	
	public static final String BROKER_NOT_FOUND			= "经纪人信息不存在";
	
	//民生银行错误提示
	public static final String AUDIT_BANK_WRONG1                = "银行卡号不能为空";

}
