package cairh.community.api.game.kxian.service;

import java.util.Map;


/**
 * 财通积分和账户系统
 * @author cql
 *
 */
public interface IBaseService {

	public abstract  Map<String,Object> pointProc(String mobileNo,String from,String eventId);
	public abstract  Map<String,Object> queryAvailablePoint(String mobileNo);
	public abstract  Map<String,Object> queryUserInfo(String mobileNo);
	
	
}
