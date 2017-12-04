package cairh.community.api.game.kxian.common;

import java.util.HashMap;
import java.util.Map;

public class ErrorInfoConstant {
	public static final Map<Integer,String> ERROR_INFO_MAP =new HashMap<Integer,String>();
   static
   {
	   ERROR_INFO_MAP.put(1, "用户未登录或已超时，请重新<a href=\"/\">登录</a>") ;
	   ERROR_INFO_MAP.put(-1, "系统出错，请联系客服");
	   ERROR_INFO_MAP.put(-2, "系统出错，请联系客服");
	   ERROR_INFO_MAP.put(-3, "提交出错，请重试") ;
	   ERROR_INFO_MAP.put(-4, "系统出错，请联系客服");
	   ERROR_INFO_MAP.put(-1001, "不存在该银行，请重新选择");
	   ERROR_INFO_MAP.put(-1002,"请输入银行卡号");
	   ERROR_INFO_MAP.put(-1003,"不需要输入银行卡号和银行密码");
	   ERROR_INFO_MAP.put(-1004,"用户未登录或已超时，请重新登录");
	   ERROR_INFO_MAP.put(-1005,"用户未登录或已超时，请重新登录");
	   ERROR_INFO_MAP.put(-1006,"用户未登录或已超时，请重新登录");
	   ERROR_INFO_MAP.put(-1007,"请重新获取手机验证码");
	   ERROR_INFO_MAP.put(-1008,"请重新获取手机验证码");
	   ERROR_INFO_MAP.put(-1009,"手机验证码错误，请重试");
	   ERROR_INFO_MAP.put(-1010,"该客户已存在，请重新输入");
	   ERROR_INFO_MAP.put(-1011,"获取客户预约信息失败");
	   ERROR_INFO_MAP.put(-1012,"风险评测出错，请重试");
	   ERROR_INFO_MAP.put(-1013,"客户模版记录不存在");
	   ERROR_INFO_MAP.put(-1014,"客户记录不存在");
//	   ERROR_INFO_MAP.put(-1015,"客户记录已存在");
	   ERROR_INFO_MAP.put(-1016,"您的身份证不符合要求，请重试");
	   ERROR_INFO_MAP.put(-1017,"您上传的图片不符合要求，请重新上传");
	   ERROR_INFO_MAP.put(-1018,"您上传的图片不符合要求，请重新上传");
	   ERROR_INFO_MAP.put(-1019,"您上传的图片不符合要求，请重新上传");
	   ERROR_INFO_MAP.put(-1020,"您上传的图片不符合要求，请重新上传");
	   ERROR_INFO_MAP.put(-1021,"您的身份证不符合要求，请重试");
	   ERROR_INFO_MAP.put(-1022,"密码安全等级较弱，请重新设置");
	   ERROR_INFO_MAP.put(-1023,"协议文本不存在");
	   ERROR_INFO_MAP.put(-1024,"无法获取签署的电子协议");
	   ERROR_INFO_MAP.put(-1025,"签署开户协议失败，请重试");
	   ERROR_INFO_MAP.put(-1026,"图片上传失败，请重试");
	   ERROR_INFO_MAP.put(-1027,"图片上传失败，请重试");
	   ERROR_INFO_MAP.put(-1028,"回访问卷失败，请重试");
	   ERROR_INFO_MAP.put(-1029,"证书安装失败，请重试");
	   ERROR_INFO_MAP.put(-1031,"系统出错，请联系客服");
	   ERROR_INFO_MAP.put(-200,"视频连接失败，请重试");
   }
}
