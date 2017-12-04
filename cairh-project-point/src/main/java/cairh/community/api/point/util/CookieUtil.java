package cairh.community.api.point.util;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class CookieUtil {
	private static Logger logger = Logger.getLogger(CookieUtil.class);
	
	/**
	 * cookie 读取 
	 * @param req
	 * @return
	 */
	public static String getCookie(HttpServletRequest req,String name){
		try{
			Cookie[] reqCookies = req.getCookies();
			if (reqCookies != null) {
				for (Cookie cookie : reqCookies) {
					if(name.equals(cookie.getName())){
						return URLDecoder.decode(cookie.getValue(),"UTF-8");
					}
				}
			}else{
				return null;
			}
		}catch(Exception e){
			logger.error("解析cookie出现异常:"+e);
			return null;
		}
		return null;
	}
	
	/**
	 * cookie 加密
	 * @param userProfile
	 */
	public static String encryptionCookie(String str){
		String key =  StringUtil.MD5(ConfigProperties.get("cookieKey"));
		String cookieSteing = AuthCodeUtil.authcodeEncode(str, key);
		return cookieSteing;
	}

	/**
	 * cookie 解析
	 * @param orgcookieString
	 * @return UserProfile null:解析失败或者密码错误
	 */
	public static String decryptCookie(String orgcookieString){
		try{
			String key = StringUtil.MD5(ConfigProperties.get("cookieKey"));
			String 	cookieStringDecode = AuthCodeUtil.authcodeDecode(orgcookieString, key);
			return cookieStringDecode;
		}catch(Exception e){
			logger.error("解析失败"+e);
			return null;
		}
		
	}
}
