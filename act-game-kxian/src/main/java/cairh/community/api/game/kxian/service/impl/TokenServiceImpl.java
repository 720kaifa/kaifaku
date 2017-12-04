package cairh.community.api.game.kxian.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cairh.community.api.game.kxian.service.ITokenService;
import cairh.community.api.game.kxian.util.ConfigProperties;
import cairh.community.api.game.kxian.util.FastJsonUtil;

import com.htsec.security.SecurityUtil;

@Service
public class TokenServiceImpl implements ITokenService{

	private static String zhzxKey = ConfigProperties.get("token_key", "httradeinterface");
	private static Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);
	
	public String anlyToken(String token){
		if(null != token){
			String tokenKey = SecurityUtil.decodeMessage(token, zhzxKey).trim();
			return tokenKey;
		}
		return null;
	}

	public Map<String, Object> getUserInfoByToken(String token) {
		String userInfoJsonStr = anlyToken(token);
		if (userInfoJsonStr == null) {
			logger.info("token解析失败，token:{}", token);
			return null;
		}
		try {
			return FastJsonUtil.parseObject(userInfoJsonStr, HashMap.class);
		} catch (Exception e) {
			logger.warn("token信息异常，token:"+ userInfoJsonStr, e);
			return null;
		}
	}

	public static void main(String[] args) {
//		String before = "8d8959f165ed1b48ac1df7bcdbbf2d7b5ef9e553643f69770e009736d257974afc568b244556af4ebf4dce2794a380f804c218cdd649cc6e7c38993b4133228dc6fd0f00cd98302dc53c30e0fcec7c3e57ffdd9bb4d961bb2377bdb8a9b2812589d6b728a4b0290237501c679893c223";
//		String after = "{\"accountId\":\"2\",\"phoneNumber\":\"44baba2ae47ab2bd611d5f57d69dad54\",\"channelId\":\"stock-mock\",\"time\":1482807485518}";
//		String tokenKey = SecurityUtil.decodeMessage(before, "httradeinterface");
//		System.out.println(tokenKey);
//		System.out.println(after.equals(tokenKey));
//		String decode = SecurityUtil.encodeMessage(after, "httradeinterface");
//		System.out.println(decode);
//		System.out.println(before.equals(decode));

		String testStr = "{\"accountId\":\"1\",\"phoneNumber\":\"44baba2ae47ab2bd611d5f57d69dad54\",\"channelId\":\"stock-mock\",\"time\":1482807485518}";
		String key = "httradeinterface";
		System.out.println(SecurityUtil.encodeMessage(testStr, key));
		System.out.println(SecurityUtil.decodeMessage(SecurityUtil.encodeMessage(testStr, key), key));
		System.out.println(testStr.equals(SecurityUtil.decodeMessage(SecurityUtil.encodeMessage(testStr, key), key)));



	}

}
