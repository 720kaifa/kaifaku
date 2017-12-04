package cairh.community.api.point.constants;


import cairh.community.api.point.util.ConfigProperties;

/***********************************************************************************
*1-->2013-05-24  create by stevinzhu@cairenhui.com  定义如分隔符,前缀符    BugNo:--
*2-->
***********************************************************************************/
public class Constant {

    public static final String GLOBAL_NO_PERMISSION ="对不起，您没有此操作权限！";
    public static final String ILLEGAL_REQUEST="非法请求";
    public static final String PARAM_NOT_CORRECT="请求参数错误";
    public static final String OP_SUCCESS="保存成功";
    public static final String LOGIN_WRONG= "用户名或密码不正确";
    public static final String TIME_OUT= "登录超时";

    public static final String LOGIN_BRANCH_WRONG = "无此营业部";

    public static final String ORG_EXISTS                   = "该营业部已经存在";
    public static final String ORG_NAME_NOT_EMPTY           = "营业部名称不能为空";
    /** 字典编号为整数 */
    public static final String DICT_ENTRY_ERROR= "请填写正确字典编号";
    /** 字典选择项不能为空 */
    public static final String DICT_SUBENTRY_NOEMPTY= "字典选择项不能为空";
    /** 字典显示项不能为空 */
    public static final String DICT_PROMOT_NOEMPTY= "字典显示项不能为空";
    /** 字典选择项已经存在 */
    public static final String DICT_SUBENTRY_EXISTS= "字典选择项已经存在";
    /** 该字典项目不能被修改  */
    public static final String DICT_UNABLE_MODIFY= "该字典项目不能被修改";
    /** 字典维护出现异常 */
    public static final String DICT_EXCEPTION= "字典维护出现异常";
    //角色管理
    public static final String VALIDATE_ROLE_ID_NULL		= "角色ID不能为空";
    public static final String VALIDATE_ROLE_CODE_NULL		= "角色代码不能为空";
    public static final String VALIDATE_ROLE_CODE_EXIST		= "角色代码已经存在";
    public static final String VALIDATE_ROLE_NAME_NULL		= "角色名称不能为空";
    public static final String VALIDATE_ROLE_NAME_EXIST		= "角色名称已经存在";
    public static final String VALIDATE_RESOURCE_LIST_NULL	= "权限列表不能为空";
    public static final String VALIDATE_RESOURCE_LIST_ERROR	= "权限列表有误";
    public static final String SAVE_RESOURCE_LIST_ERROR		= "新增角色出错";
    public static final String EDIT_ROLE_ERROR				= "修改角色出错";
    public static final String EDIT_RESOURCE_LIST_ERROR		= "修改角色出错";
    public static final String DEL_ROLE_ERROR				= "删除角色出错";
    //获取权限列表
    public static final String GET_RESOURCE_LIST_NULL 	= "权限列表为空";
    public static final String GET_RESOURCE_LIST_FAIL 	= "获取权限列表出错";

    /**  公告标题不能为空  */
    public static final String  MESS_TITLE_NOEMPTY= "公告标题不能为空";
    /**  公告内容不能为空  */
    public static final String  MESS_CONTENT_NOEMPTY= "公告内容不能为空";
    /**  公告内容不能为空  */
    public static final String  MESS_TYPE_NOEMPTY= "公告类型不能为空";
    /**  请填写有效日期  */
    public static final String  MESS_TIME_ERROR= "请填写有效日期";

    public static final String 	SYSTEM_EXCEPTION="当前服务不可用，请稍后尝试！";

    public final static String RESOURCE_CODE_VIDEO						= "001";  //视频
    public final static String RESOURCE_CODE_CERT						= "003";  //证书

     /**主站地址*/
    public static String WEB_ADDR = ConfigProperties.get("webAddr", "http://wskh.htsec.com");

    public static String HIS_WEB_ADDR = ConfigProperties.get("hisWebAddr", "");
    /**静态资源路径*/
    public static String STATIC_RESOURCES_ADDR = ConfigProperties.get("staticResourcesAddr", "http://wskh.htsec.com");
    /**域名*/
    public static String DOMAIN = ConfigProperties.get("domain", "cairenhui.com");

    public static final String SERVER_MAC = ConfigProperties.get("station", "A820660D0E18");
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
    public static final long  DEFAULT_WEIGHT=1;
    
    public static final String  COMMA_SPLIT=",";
    
    public static final int QUERY_PAGE_SIZE  = 20;
    public static final int QUERY_PAGE_SIZE_15  = 15;
    public static final int QUERY_PAGE_SIZE_10  = 10;
    
    public static final  long  DEFAULT_ORDER_NUM=1000;
    
    public static final String  DIC_SPLIT="/";
    
    //分页大小
    public static final int PAGE_SIZE_ROLE_MANAGE 			= 20;//角色管理
    public static final int PAGE_SIZE_VERIFY_BANK 			= 20;//身份验证银行
    public static final int PAGE_SIZE_THIRD_BANK 			= 20;//第三方存管银行
    public static final int PAGE_SIZE_BUSINESS_KIND 		= 20;//业务品种
    public static final int PAGE_SIZE_PROTOCOLS 			= 20;//开户协议
    public static final int PAGE_SIZE_RISK_CHECK 			= 20;//风险测评
    
    public static final String PIC_MIS="miscellaneous";
    
    public static final String XY_BUSS_TYPE = "ZZ39";
    
    //身份认证此步骤约耗时?分钟的Key
    public static final String KEY_USER_VERIFY_TIME = "user_verify_time";
    //开户申请此步骤约耗时?分钟的Key
    public static final String KEY_OPEN_APPLY_TIME = "open_apply_time";
    //系统运行状态的Key
    public static final String KEY_SYSTEM_RUN_STATUS = "system_run_status";
    
    public static final  String GENERAL_ORG="0000";
    
    public static final String HTTPSTR = "http";
    
    public static final String DIGEST_FORMAT = "yyyy年MM月dd日HH时mm分ss秒";

    public static final String EXPORT_USER_REGISTER = "exportUserRegister";
	
	//导出excel分页大小，即一个sheet的数据
	public static final int PAGE_SIZE = 50000;  //一个sheet数量
	public static final int ONE_TIME = 5000; //单次查询数量
	public static final int SELECT_TIMES = 10; //查询次数

    /**公告内容截取的字符长度**/
    public static final int NOTICCONTENLEN		= 40;
    
    public static final String GUESS_GET = "猜涨跌猜中得分";
    
    public static final String GUESS_GET1 = "猜涨跌返回得分";
    
    //后台角色 role_code
    /**超级管理员*/
    public static final String ROLE_CODE_SYS="001";
    /**社区操作员*/
    public static final String ROLE_CODE_OP="002";
    /**社区审核员*/
    public static final String ROLE_CODE_CHECK="003";
    /**直播系统管理员*/
    public static final String ROLE_CODE_LV="004";
    
    /**超级管理员 员工号*/
    public static final String SUP_SYS_USER="000000";
    
    
    
    
    //权限code RESOURCE_CODE
    /**审核权限*/
    public static final String RESOURCE_CODE_CHECK="002";
    /**直播系统权限*/
    public static final String RESOURCE_CODE_LV="003";
    
    
    
} 
