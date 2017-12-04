package cairh.community.api.game.kxian.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cairh.community.api.game.kxian.bean.SisapResult;
import cairh.community.api.game.kxian.exception.BizException;



public class HttpClientUtils {
	  private static String ENCODING = "UTF-8";
	  private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	
	
	/**
     * 请求接口 url
     */
    public static SisapResult httpPost(String url, Map<String, Object> param) {
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
        /*if (!sisapResult.isSuccess()) {
            throw new BizException(sisapResult.getError_no(), sisapResult.getError_info());
        }*/
        return sisapResult;
    }
    /**
     * 发送请求
     * @param url
     * @param entity
     * @param contentType
     * @return
     */
    public static String sendPost(String url, StringEntity entity, String contentType) {


        DefaultHttpClient httpClient = new DefaultHttpClient();
        
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", StringUtils.isEmpty(contentType) ? "application/x-www-form-urlencoded" : contentType);
        try {
            httpPost.setEntity(entity);
            httpPost.getParams().setParameter("Connection", "close");
            httpPost.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, ConfigProperties.get("sisap.webservice.connection.timeout", 60) * 1000);
            httpPost.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,ConfigProperties.get("sisap.webservice.submit.timeout", 60) * 1000);
            HttpResponse result = httpClient.execute(httpPost);
            url = URLDecoder.decode(url, ENCODING);
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                return EntityUtils.toString(result.getEntity());
            } else {
            	httpPost.abort();
                String warn = "请求失败:" + result.getStatusLine().getStatusCode();
                logger.warn(warn);
                throw new BizException("-1", warn);
            }
        } catch (IOException e) {
        	httpPost.abort();
            logger.warn("请求超时:" + url, e);
            throw new BizException("-1", "请求超时");
        } finally{
        	if(null != httpPost){
        		httpPost.releaseConnection();
        	}
        	
        	if(null != httpClient){
        		httpClient.close();
        	}
        	
        }
        
    }
	
    /**
     * 请求接口 带request
     */
    public static SisapResult httpPost(String url, Map<String, Object> param,HttpServletRequest request) {
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
    	SisapResult sisapResult = new SisapResult(sendPost(url, entity, "application/x-www-form-urlencoded",request));
    	logger.info("请求成功[{}]", loggerfilter(sisapResult));
    	if (!sisapResult.isSuccess()) {
    		throw new BizException(sisapResult.getError_no(), sisapResult.getError_info());
    	}
    	return sisapResult;
    }
    /**
     * 发送请求  带request
     * @param url
     * @param entity
     * @param contentType
     * @return
     */
    public static String sendPost(String url, StringEntity entity, String contentType,HttpServletRequest request) {
    	
    	String CRH_SESSION_ID = CookieUtil.getCookie(request, "CRH_SESSION_ID");
    	DefaultHttpClient httpClient = new DefaultHttpClient();
    	HttpPost httpPost = new HttpPost(url);
    	
    	httpPost.setHeader("Content-Type", StringUtils.isEmpty(contentType) ? "application/x-www-form-urlencoded" : contentType);
    	httpPost.setHeader("Cookie", "CRH_SESSION_ID="+CRH_SESSION_ID);
    	try {
    		httpPost.setEntity(entity);
    		httpPost.getParams().setParameter("Connection", "close");
    		httpPost.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, ConfigProperties.get("sisap.webservice.connection.timeout", 60) * 1000);
    		httpPost.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,ConfigProperties.get("sisap.webservice.submit.timeout", 60) * 1000);
    		HttpResponse result = httpClient.execute(httpPost);
    		url = URLDecoder.decode(url, ENCODING);
    		/**请求发送成功，并得到响应**/
    		if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
    			/**读取服务器返回过来的json字符串数据**/
    			return EntityUtils.toString(result.getEntity());
    		} else {
    			httpPost.abort();
    			String warn = "请求失败:" + result.getStatusLine().getStatusCode();
    			logger.warn(warn);
    			throw new BizException("-1", warn);
    		}
    	} catch (IOException e) {
    		httpPost.abort();
    		logger.warn("请求超时:" + url, e);
    		throw new BizException("-1", "请求超时");
    	}  finally{
        	if(null != httpPost){
        		httpPost.releaseConnection();
        	}
        	
        	if(null != httpClient){
        		httpClient.close();
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

}
