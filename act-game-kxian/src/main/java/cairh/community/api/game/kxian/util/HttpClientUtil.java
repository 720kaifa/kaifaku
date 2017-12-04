package cairh.community.api.game.kxian.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cairh.community.api.game.kxian.bean.SisapResult;
import cairh.community.api.game.kxian.common.FuncEnum;
import cairh.community.api.game.kxian.exception.BizException;

/**
 * 
 */
public class HttpClientUtil {

    private static String ENCODING = "UTF-8";

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * 请求中台
     */
    public static SisapResult httpPost(FuncEnum func, Map<String, Object> param) {
        logger.info(String.format("请求中台接口%s[%s]:%s", func.getFuncNo(), func.getFuncDesc(), param.toString()));
        String sisapUrl = ConfigProperties.get("sisap.webservice.url", "");
        if (!sisapUrl.endsWith("/")) {

            sisapUrl += "/";
        }
        String url = sisapUrl + func.getFuncNo() + ".action";
        //设置参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        StringEntity entity = null;
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            if (entry.getValue() != null) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
        }
        if (list.size() > 0) {
            try {
                entity = new UrlEncodedFormEntity(list, ENCODING);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        SisapResult sisapResult = new SisapResult(sendPost(url, entity, "application/x-www-form-urlencoded"));
        logger.info("请求成功[{}]", loggerfilter(sisapResult));
        if (!sisapResult.isSuccess()) {
            throw new BizException(sisapResult.getError_no(), sisapResult.getError_info());
        }
        return sisapResult;
    }

   /* *//**
     *  请求账户中心
     * @param url
     * @param param
     *//*
    public static AccountResult httpPostToAccount(String url, Map<String, Object> param) {
        logger.info("请求账户中心{} 参数：{}", url, param.toString());
        String accountUrl = ConfigProperties.get("htsec.account.service", "");
        url = accountUrl + url + ".json";
        //设置参数
        JSONObject jsonParam = new JSONObject();
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            jsonParam.put(entry.getKey(), entry.getValue());
        }
        AccountResult accountResult = null;
        try {
            accountResult = new AccountResult(sendPost(url, new StringEntity(jsonParam.toString(), ENCODING), "application/json;charset=utf-8"));
        } catch (Exception e) {
        	logger.error("请求账户中心失败{}，参数{}", url, param.toString());
        }
        logger.info("请求成功[{}]", loggerfilter(accountResult));
        if (!accountResult.isSuccess()) {
            throw new BizException(accountResult.getError_no(), accountResult.getError_info());
        }
        return accountResult;
    }*/


    /**
     * 发送请求
     * @param url
     * @param entity
     * @param contentType
     * @return
     */
    public static String sendPost(String url, StringEntity entity, String contentType) {

    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        DefaultHttpClient httpClient = new DefaultHttpClient();
        
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", StringUtils.isEmpty(contentType) ? "application/x-www-form-urlencoded" : contentType);
        CloseableHttpResponse response = null;
        try {
            httpPost.setEntity(entity);
//            httpPost.getParams().setParameter("Connection", "close");
//            httpPost.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, ConfigProperties.get("sisap.webservice.connection.timeout", 60) * 1000);
//            httpPost.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,ConfigProperties.get("sisap.webservice.submit.timeout", 60) * 1000);
            
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(ConfigProperties.get("sisap.webservice.submit.timeout", 60) * 1000)
            		.setConnectTimeout(ConfigProperties.get("sisap.webservice.connection.timeout", 60) * 1000).build();//设置请求和传输超时时间
            httpPost.setConfig(requestConfig);
            
            response = httpClient.execute(httpPost);
            url = URLDecoder.decode(url, ENCODING);
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                return EntityUtils.toString(response.getEntity());
            } else {
            	httpPost.completed();
            	httpPost.abort();
                String warn = "请求失败:" + response.getStatusLine().getStatusCode();
                logger.warn(warn);
                throw new BizException("-1", warn);
            }
        } catch (Exception e) {
        	httpPost.completed();
        	httpPost.abort();
            logger.warn("请求超时:" + url, e);
            throw new BizException("-1", "请求超时");
        } finally{
        	if(null != response){
        		try {
					response.close();
				} catch (Exception e) {
					logger.warn("关闭response发生错误", e);
				}
        	}
        	if(null != httpPost){
        		httpPost.releaseConnection();
        	}
        	
        	if(null != httpClient){
        		try {
					httpClient.close();
				} catch (Exception e) {
					logger.warn("关闭httpClient发生错误", e);
				}
        	}
        }
    }

    /**
     * 发送get请求
     *
     * @param url 路径
     * @return
     */
    public static SisapResult httpGet(String url) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
//        DefaultHttpClient client = new DefaultHttpClient();
        //发送get请求
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
//        	request.getParams().setParameter("Connection", "close");
//        	request.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, ConfigProperties.get("sisap.webservice.connection.timeout", 60) * 1000);
//        	request.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,ConfigProperties.get("sisap.webservice.submit.timeout", 60) * 1000);
           
        	RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(ConfigProperties.get("sisap.webservice.submit.timeout", 60) * 1000)
            		.setConnectTimeout(ConfigProperties.get("sisap.webservice.connection.timeout", 60) * 1000).build();//设置请求和传输超时时间
        	request.setConfig(requestConfig);
            
            url = URLDecoder.decode(url, ENCODING);
            response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
                return new SisapResult(strResult);
            } else {
            	request.completed();
            	request.abort();
                logger.warn("请求失败:" + url);
                return new SisapResult(response.getStatusLine().getStatusCode()+"", "请求失败");
            }
        } catch (Exception e) {
        	request.completed();
        	request.abort();
            logger.warn("程序异常:" + url, e);
            return new SisapResult("-1", "程序异常");
        } finally {
        	if(null != response){
        		try {
					response.close();
				} catch (Exception e) {
					logger.warn("关闭response发生错误", e);
				}
        	}
        	if(null != request){
        		request.releaseConnection();
        	}
        	
        	if(null != client){
        		try {
        			client.close();
				} catch (Exception e) {
					logger.warn("关闭httpClient发生错误", e);
				}
        	}
        }
    }

    /**
     * 过滤resultList
     * @param sisapResult
     * @return
     */
    private static String loggerfilter(SisapResult sisapResult) {
        Map<String, Object> res = MapUtil.beanToMap(sisapResult);
        if (sisapResult.getResultList().size() > 0) {
            res.put("resultList", "resultList");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("user_id", 2);
        SisapResult ob = HttpClientUtil.httpPost(FuncEnum.CRH_CM1001, map);
        if (ob != null) {
            System.out.println(ob.getResultMap());
        }
    }
}
