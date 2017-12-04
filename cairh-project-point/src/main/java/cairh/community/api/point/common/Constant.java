package cairh.community.api.point.common;

import com.cairenhui.filter.util.ConfigProperties;

/***********************************************************************************
*1-->2013-05-24  create by stevinzhu@cairenhui.com  定义如分隔符,前缀符    BugNo:--
*2-->
***********************************************************************************/
public class Constant {
	//项目地址
	public static final String WEB_ADDR = ConfigProperties.get("webAddr");
	//静态资源地址
	public static final String STATIC_RESOURCES_ADDR = ConfigProperties.get("staticResourcesAddr");
    //视频验证呼叫号
	public static final String DELAULT_QUEUE_ID = ConfigProperties.get("default_queue_id", "1000");
	//视频服务器地址
	public static final String VIDEO_SERVER_IP = ConfigProperties.get("videoServerIp","");
	public static final String VIDEO_SERVER_PORT = ConfigProperties.get("videoServerPort","");
	public static final String VIDEO_REC_LEASTTIME = ConfigProperties.get("videoRecordLeastTime","10");
	public static final String VIDEO_REC_MAXTIME = ConfigProperties.get("videoRecordMaxTime","3");
	public static final String VIDEO_CON_MAXTIME = ConfigProperties.get("videoConnectingMaxTime","300000");
	//金仕达密码加密算法SN串
	public static  final  String PWD_ENCRYPT="000000";
	
	public static  final  String BANK_PWD_ENCRYPT="9999999999";
	
	public static final String FUND_ACCOUNT_BIZ = "1101";
	
	public static final String STOCK_COMP_COOKIE = "scp";
	
	public static final String ERROR_INFO = "errorInfo";

	public static final String ERROR_NO = "errorNo";
} 
