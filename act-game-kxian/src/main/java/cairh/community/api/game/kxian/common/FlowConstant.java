package cairh.community.api.game.kxian.common;

import java.util.HashMap;
import java.util.Map;

public class FlowConstant {
	public static Map<Integer, String> stepUrlMap1;
	public static Map<Integer, String> stepUrlMap5;
	
	static {
		// 目前只用于可允许退回的阶段
		if (stepUrlMap1 == null) {
			stepUrlMap1 = new HashMap<Integer, String>();
			stepUrlMap1.put(1, "/user/invest/");
			stepUrlMap1.put(2, "/department/");
			stepUrlMap1.put(3, "/auth/upload/");
			stepUrlMap1.put(4, "/auth/profile/");
			stepUrlMap1.put(5, "/auth/video/");
			
		}
		if (stepUrlMap5 == null) {
			stepUrlMap5 = new HashMap<Integer, String>();
			stepUrlMap5.put(1, "/simple/invest/");
			stepUrlMap5.put(2, "/simple/department/");
			stepUrlMap5.put(3, "/simple/upload/");
			stepUrlMap5.put(4, "/simple/profile/");
			stepUrlMap5.put(5, "/simple/cert/");
		}
	}
}
