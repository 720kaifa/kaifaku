package cairh.community.api.game.kxian.util;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;


public class MiddleUtils {



	/**
	 * @param p_Str Base64编码的字符窜
	 * @return byte[]类型的照片信息
	 * @throws IOException
	 */
	public static byte[] fromBase64(String p_Str) throws IOException {
		byte[] byteBuffer = new BASE64Decoder().decodeBuffer(p_Str);
		return byteBuffer;
	}

	/**
	 * 过滤空指针
	 * @param value
	 * @return
	 */
	public static String setMiddleRespValue(String value) {
		if (StringUtils.isBlank(value)) {
			return "";
		}
		return value;
	}

	/**
	 * 获取前台Cookie中的user id
	 * @param req
	 * @return
	 */
	public static Long getMiddleCookieUserId(ServletRequest req) {
		HttpServletRequest request = (HttpServletRequest)req;

		long userId = 0L;
		Cookie[] reqCookies = request.getCookies();
		String cookieVal = "";
		if (reqCookies != null) {
			String name = "";
			for (Cookie cookie : reqCookies) {
				name = cookie.getName();
				if ("_client".equalsIgnoreCase(name) && StringUtils.isNotBlank(cookie.getValue())) { //MiddleConstants.MIDDLE_COOKIE_USER_ID
					cookieVal = decryptCookie(URLDecoder.decode(cookie.getValue()));
					if (StringUtils.isNotBlank(cookieVal)) {
						userId = Long.parseLong(cookieVal);
					}
				}
			}
		}
		return userId;
	}

	/**
	 * cookie 解析
	 * @param orgcookieString
	 * @return UserProfile null:解析失败或者密码错误
	 */
	public static String decryptCookie(String orgcookieString){
		try{
			String key = StringUtil.MD5(ConfigProperties.get("cookieKey"));
			String cookieStringDecode = AuthCodeUtil.authcodeDecode(orgcookieString, key);
			return cookieStringDecode;
		}catch(Exception e){
			return "";
		}

	}
	/**
	 * cookie 加密
	 * @param userProfile
	 */
	public static String encryptionCookie(String str){
		String key = StringUtil.MD5(ConfigProperties.get("cookieKey"));
		String cookieSteing = AuthCodeUtil.authcodeEncode(str, key);
		return cookieSteing;
	}

	private static Map<String, Integer> crhCookies;
	static {
		crhCookies = new HashMap<String, Integer>();
		String cookname = ConfigProperties.get("crh_cookie_name", "JSESSIONID#_client");
		for (String cookie : cookname.split("#")) {
			crhCookies.put(cookie, -1);
		}

	}

//	/**
//	 * cookie 设置
//	 * @param response
//	 * @param cookieValue
//	 */
//	public static void setAllCookie(HttpServletResponse response, UserProfile user){
//		try {
//			Set<Entry<String, Integer>> cookieSet = crhCookies.entrySet();
//			Iterator<Entry<String, Integer>> i = cookieSet.iterator();
//			String cookieVal = "";
//			for (String key : crhCookies.keySet()) {
//				if ("JSESSIONID".equalsIgnoreCase(key)) {
//					cookieVal = encryptionCookie(user.getMobile());
//				} else if ("_client".equalsIgnoreCase(key)) {
//					cookieVal = encryptionCookie(user.getUserId().toString());
//				}
//
//				if (StringUtils.isNotBlank(cookieVal)) {
//					StringBuffer cookieContent=new StringBuffer();
//				    //cookie Id
//				    cookieContent.append(key);
//				    cookieContent.append("=");
//				    cookieContent.append(URLEncoder.encode(cookieVal, "UTF-8"));
//				    cookieContent.append(";");
//				    //cookie path
//				    cookieContent.append("Path=/;");
//				    //cookie domain
//				    cookieContent.append("Domain=");
//				    cookieContent.append(ConfigProperties.get("domain"));
//				    cookieContent.append(";");
//				    //存活时间
////				    if(crhCookies.get(key) > 0 && isRemmeber){
////					    cookieContent.append("Max-Age=");
////					    cookieContent.append(crhCookies.get(key) * 24 * 3600);
////					    cookieContent.append(";");
////				    }
//
//				    //防止客户端js 读取cookie值
//				    cookieContent.append("HTTPOnly");
//				    response.addHeader("Set-Cookie",  cookieContent.toString());
//				}
//			}
//
//		} catch (Exception e) {
//			//logger.error("设置cookie", e);
//		}
//	}

}
