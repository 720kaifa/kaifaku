package cairh.community.api.game.kxian.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Service;

import cairh.community.api.game.kxian.service.IBaseService;
import cairh.community.api.game.kxian.util.ConfigProperties;
import cairh.community.api.game.kxian.util.HttpClientUtil;

import com.alibaba.fastjson.JSON;

@Service
public class BaseServiceImpl implements IBaseService{

	public static final String ctTempUrlPoint = ConfigProperties.get("caitong.server.url", "http://172.88.5.106:8066");
	public static final String ctTempUrlUser = ConfigProperties.get("caitong.server.url", "http://172.88.5.106:8383");
	
	public static final String pointProc = ConfigProperties.get("pointProc", "/point/pointProc");
	public static final String queryAvailablePoint = ConfigProperties.get("queryAvailablePoint", "/point/queryAvailablePoint");
	public static final String queryUserInfo = ConfigProperties.get("queryUserInfo", "/userCenter/queryUserInfo");
	
	public static final String Debug = ConfigProperties.get("Debug", "1");

	private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	public static final String CONTENT_TYPE = "Content-Type";
	//private static final String APPLICATION_JSON = "application/json";
	
	
	/**获取积分或消耗积分
	 * @author admin
	 * @param mobileNo
	 * @param from
	 * @param eventId
	 * @return
	 */
	public Map<String,Object> pointProc(String mobileNo,String from,String eventId){
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("error_no", "0");
		res.put("error_info", null);
		return res;
		
		/*Map<String,Object> param = new HashMap<String,Object>();
		param.put("mobileNo", mobileNo);
		param.put("from", from);
		param.put("eventId", eventId);

		try {
			String httpPost = HttpClientUtil.sendPost(ctTempUrlPoint+pointProc, new StringEntity(JSON.toJSONString(param)), CONTENT_TYPE_TEXT_JSON);
			
			JSONObject  jasonObject = JSONObject.fromObject(httpPost);
			Map<String,Object> map = (Map<String,Object>)jasonObject;		 
			//String httpPost =HttpClientUtil.sendPost(ctTempUrlPoint+pointProc, new StringEntity(JSON.toJSONString(param)), CONTENT_TYPE_TEXT_JSON);
		
		if(httpPost!=null){
			String error_no = map.get("error_no").toString();
			String error_info = map.get("error_info").toString();
			if(!("0").equals(error_no)){
				res.put("error_no", "-1");
				res.put("error_info", error_info);
				return res;
			}
		}
		res.put("error_no", "0");
		res.put("error_info", null);
		return res;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;*/
	}
	
	/**查询用户积分
	 * @author admin
	 * @param mobileNo
	 * @return
	 */
	public Map<String,Object> queryAvailablePoint(String mobileNo){
		Map<String,Object> res = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("mobileNo", mobileNo);

		//SisapResult httpPost =HttpClientUtils.httpPost(ctTempUrlPoint+queryAvailablePoint, param);
		String httpPost;
		try {
		httpPost = HttpClientUtil.sendPost(ctTempUrlPoint+queryAvailablePoint, new StringEntity(JSON.toJSONString(param)), CONTENT_TYPE_TEXT_JSON);
		
		JSONObject  jasonObject = JSONObject.fromObject(httpPost);
		Map<String,Object> map = (Map<String,Object>)jasonObject;		 
		
		if(httpPost!=null){
			String error_no = map.get("error_no").toString();
			String error_info = map.get("error_info").toString();
			if(!("0").equals(error_no)){
				res.put("error_no", "-1");
				res.put("error_info", error_info);
				return res;
			}
			String availablePoint = map.get("availablePoint").toString();
			String totalPoint = map.get("totalPoint").toString();
			res.put("error_no", "0");
			res.put("error_info", null);
			res.put("availablePoint", availablePoint);
			res.put("totalPoint", totalPoint);
			return res;
			
		}
		res.put("error_no", "0");
		res.put("error_info", null);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	/**查询用户基本信息
	 * @author admin
	 * @param mobileNo
	 * @return
	 * @throws Exception 
	 */
	public Map<String,Object> queryUserInfo(String mobileNo){
		Map<String,Object> res = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("mobileNo", mobileNo);

		if(Debug.equals("1")){
			res.put("error_no", "0");
			res.put("error_info", null);
			res.put("mobileNo", mobileNo);
			res.put("name", "测试用户"+mobileNo);
			res.put("iconId", 5555);
			res.put("id", mobileNo);
			return res;
		}else{
			try {//{"mobileNo": "18058783501"}
				//http://172.88.5.106:8383/userCenter/queryUserInfo
			String httpPost =HttpClientUtil.sendPost(ctTempUrlUser+queryUserInfo, new StringEntity(JSON.toJSONString(param)), CONTENT_TYPE_TEXT_JSON);
			JSONObject  jasonObject = JSONObject.fromObject(httpPost);
			Map<String,Object> map = (Map<String,Object>)jasonObject;		 
			if(httpPost!=null){
				String error_no = map.get("error_no").toString();
				String error_info = map.get("error_info").toString();
				if(!("0").equals(error_no)){
					res.put("error_no", "-1");
					res.put("error_info", error_info);
					return res;
				}
			}
			String iconId = map.get("iconId").toString();
			String name = map.get("name").toString();
			String id = map.get("id").toString();
			
			res.put("error_no", "0");
			res.put("error_info", null);
			res.put("mobileNo", mobileNo);
			res.put("name", name);
			res.put("iconId", iconId);
			res.put("id", id);
			return res;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return res;
		}
	}
	
	/**
	 * 使用 POST 方式提交数据
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 *//*
	private HttpPost getPostMethod(String url, String postParam) throws UnsupportedEncodingException {
		HttpPost post = new HttpPost(url);
		post.addHeader(CONTENT_TYPE, APPLICATION_JSON);
		StringEntity se = new StringEntity(postParam, "UTF-8");
		se.setContentType(CONTENT_TYPE_TEXT_JSON);
		// se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
		// APPLICATION_JSON));
		post.setEntity(se);
		return post;
	}
	
	
	public String sendHttpPost(HttpPost httpPost) throws Exception {  
        CloseableHttpClient httpClient = null;  
        CloseableHttpResponse response = null;  
        HttpEntity entity = null;  
        String responseContent = null;  
        try {  
            // 创建默认的httpClient实例.  
            httpClient = HttpClientBuilder.create().build();
//            httpPost.setConfig(requestConfig);  
            // 执行请求  
            response = httpClient.execute(httpPost);  
            entity = response.getEntity();  
            responseContent = EntityUtils.toString(entity, "UTF-8");  
        } finally {  
            try {  
                // 关闭连接,释放资源  
                if (response != null) {  
                    response.close();  
                }  
                if (httpPost != null) {  
                	httpPost.releaseConnection();
                }  
            } catch (IOException e) {  
//            	log.error(e.getMessage(),e);
            }  
        }  
        return responseContent;  
    }
	
	*/
}
