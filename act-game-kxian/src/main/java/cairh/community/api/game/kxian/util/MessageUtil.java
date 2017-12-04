package cairh.community.api.game.kxian.util;

public class MessageUtil {
  
	private  static String  getMessage(String message,String ...params){
		if(StringUtil.isEmpty(message)){
			message="";
		}
		if(params!=null  && params.length>0){
    		for(int i=0;i<params.length;i++){
    			message  = message.replace("${"+i+"}", params[i]);
    		}
    	}
		return message;
	}
	
	/**根据sms.properties配置获取短信内容
	 * @param messageKey
	 * @param params
	 * @return
	 */
	public static String  getMessageByKey(String messageKey,String ...params){
		String   messText =  ConfigProperties.get(messageKey);
		return   getMessage(messText, params);
	}
	
}
