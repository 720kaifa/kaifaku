package cairh.community.api.point.constants;

/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wanghh<br>
 * 开发时间: 2016年07月12日<br>
 */
public class StatusConstants {

	// 用户状态
	public static final int USER_STATUS_ENABLE = 1;
	public static final int USER_STATUS_DISABLE = 0;

	// 用户账户状态
	public static final int USER_ACCOUNT_STATUS_ENABLE = 1;
	public static final int USER_ACCOUNT_STATUS_DISABLE = 0;

	public static final int FOLLOW_STATUS_ENABLE = 1;
	public static final int FOLLOW_STATUS_DISABLE = 0;

	public static final int FOLLOW_LOG_FOLLOWED = 1;//订阅
	public static final int FOLLOW_LOG_UNFOLLOW = 2;//取消订阅
	/**
	 * 短信发送状态
	 * -1.发送失败
	 * 1.未发送
	 * 2.发送成功
	 * 3.已验证
	 */
	public static final int VALIDATE_CODE_STATUS_fail = -1;
	public static final int VALIDATE_CODE_STATUS_1 = 1;
	public static final int VALIDATE_CODE_STATUS_2 = 2;
	public static final int VALIDATE_CODE_STATUS_3 = 3;

	public static final int VALIDATE_CODE_TYPE_REGISTER = 1;
	public static final int VALIDATE_CODE_TYPE_LOGIN = 2;

	/**
	 * 待推送消息状态
	 * 0 创建   1 审核通过  2 审核不通过   3 发送中 4 已完成 5 失败  9  取消
	 */
	public static final short MSG_PUSH_STATUS_CREATE = 0;
	public static final short MSG_PUSH_STATUS_APPROVE= 1;
	public static final short MSG_PUSH_STATUS_UNAPPROVE = 2;
	public static final short MSG_PUSH_STATUS_SENDING = 3;
	public static final short MSG_PUSH_STATUS_SENDED = 4;
	public static final short MSG_PUSH_STATUS_FAIL = 5;
	public static final short MSG_PUSH_STATUS_CANCEL = 9;


	//用户积分状态
	public static final int POINT_STATUS_ENABLE = 1;
	public static final int POINT_STATUS_DISABLE = 0;

	//分红状态 1 已登记 2 已发放
	public static final int DIVIDEND_STATUS_REGISTERED		= 1;//已登记
	public static final int DIVIDEND_STATUS_DILIDEND		= 2;//已发放
	
	
	//追踪状态
	public static int TRACK_STATUS_FOLLOW = 1;
	public static int TRACK_STATUS_CANCEL = 0;
	
	//大赛状态 1:正常 0:非正常
	public static Integer VSTOCK_ZONE_STATUS_NORMAL 		= 1;
	public static Integer VSTOCK_ZONE_STATUS_UNNORMAL 		= 0;

	public static final int TOP_LIST_VISIBLE 		= 0;//参与排名
	public static final int TOP_LIST_UNVISIBLE 		= 1;//不参与排名
	
	//vstock_zone状态
	public static final int VSTOCK_ZONE_NOT_OPEN			= 1;//未开赛
	public static final int VSTOCK_ZONE_OPEN				= 2;//进行中
	public static final int VSTOCK_ZONE_END					= 3;//已结束
	
	//qq群状态
	public static int QQ_ACTIVE = 0;
	public static int QQ_NOT_ACTIVE = -1;


	//是否清算
	public static final int NOT_CLEAR		= 0;
	public static final String HAS_CLEAR 		= "FINISHED";
	public static final int CLEARING        = 2;
	public static final int READY_CONFIRM   = 3;
	
	//用户押注状态
	public static final int USER_BET_STATUS_ON = 1;
	public static final int USER_BET_STATUS_OFF = 0; 
}
