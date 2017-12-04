package cairh.community.api.point.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cairh.community.api.point.exception.BizException;



/**
 * 功能说明: HttpClient工具类<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author kongdy<br>
 * 开发时间: 2015年1月20日<br>
 */
public class HttpClientUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

//	private static final ContentType DEFAULT_TEXT_UTF8 = ContentType.DEFAULT_TEXT.withCharset(StandardCharsets.UTF_8);

	private PoolingHttpClientConnectionManager connManager;


	private static HttpClientUtil util;

	private HttpClientUtil() {
	}

	public static HttpClientUtil getInstance() {
		if (util != null) {
			return util;
		}
		util = new HttpClientUtil();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		connManager.setMaxTotal(400);
		connManager.setDefaultMaxPerRoute(200);
		util.connManager = connManager;
		return util;
	}

	private HttpEntity buildFormEntry(Map<String, Object> map) {
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			for (Map.Entry<String, Object> entity : map.entrySet()) {
				params.add(new BasicNameValuePair(entity.getKey(), String.valueOf(entity.getValue())));
			}
			HttpEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
			return entity;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 构建http请求实体，支持字符串及文件
	 *
	 * @param params
	 * @return
	 *//*
	private HttpEntity buildHttpEntry(Map<String, Object> params) {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setCharset(StandardCharsets.UTF_8);
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				String pname = entry.getKey();
				Object pvalue = entry.getValue();
				// 如果pvalue为null，就可以不放到http请求的参数中。这样接请求接收方获取到的是null对象，避免接收请求方得到“null”字符串
				if (pvalue == null) {
					continue;
				}
				if (pvalue instanceof String) {
					builder.addTextBody(pname, String.valueOf(pvalue), DEFAULT_TEXT_UTF8);
				} else if (pvalue instanceof File) {
					builder.addBinaryBody(pname, (File) pvalue);
				} else if (pvalue instanceof InputStream) {
					builder.addBinaryBody(pname, (InputStream) pvalue);
				} else if (pvalue instanceof List) {
					for (Object obj : (List) pvalue) {
						builder.addTextBody(pname, String.valueOf(obj), DEFAULT_TEXT_UTF8);
					}
				} else if (pvalue.getClass().isArray()) {
					Object[] array = (Object[]) pvalue;
					for (int i = 0; i < array.length; i++) {
						builder.addTextBody(pname, String.valueOf(array[i]), DEFAULT_TEXT_UTF8);
					}
				} else {// 兼容处理，long、int等基本类型
					builder.addTextBody(pname, String.valueOf(pvalue), DEFAULT_TEXT_UTF8);
				}
			}
		}
		return builder.build();
	}*/

	/**
	 * POST方式请求，支持提交字符串/文件
	 *
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 * @throws IOException
	 */
/*	public byte[] httpPost(String url, Map<String, Object> params, List<Header> headers) throws IOException {
		HttpPost httppost = new HttpPost(url);
		HttpEntity reqEntity = buildFormEntry(params);
		httppost.setEntity(reqEntity);
		return execute(httppost, headers);
	}*/

	public String httpPost(String url, Map<String, Object> params) {
		HttpPost httppost = new HttpPost(url);
		HttpEntity reqEntity = buildFormEntry(params);
		httppost.setEntity(reqEntity);
		String response = null;
		try {
			response = new String(execute(httppost, null), "utf-8");
		} catch (IOException e) {
			logger.error("http request POST error, url：" + url + ", param:" + params, e);
		}

		return response;
	}

	/**
	 * POST方式请求，支持提交xml
	 *
	 * @param url
	 * @param xml
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	/*public byte[] httpPost(String url, String xml, List<Header> headers) throws IOException {
		HttpPost httppost = new HttpPost(url);
		HttpEntity reqEntity = buildXmlHttpEntry(xml);
		httppost.setEntity(reqEntity);
		return execute(httppost, headers);
	}

	*//**
	 * 构建xml-http请求实体
	 *
	 * @param params
	 * @return
	 *//*
	private HttpEntity buildXmlHttpEntry(String xml) {
		EntityBuilder builder = EntityBuilder.create();
		builder.setContentEncoding(StandardCharsets.UTF_8.name());
		builder.setContentType(ContentType.APPLICATION_XML);
		builder.setText(xml);
		return builder.build();
	}

	*//**
	 * POST方式请求，支持提交bytes类型
	 *
	 * @param url
	 * @param binary
	 * @param headers
	 * @return
	 * @throws IOException
	 *//*
	public byte[] httpPost(String url, byte[] binary, List<Header> headers) throws IOException {
		HttpPost httppost = new HttpPost(url);
		HttpEntity reqEntity = buildBinaryHttpEntry(binary);
		httppost.setEntity(reqEntity);
		return execute(httppost, headers);
	}

	*//**
	 * 构建bytes-http请求实体
	 *
	 * @param params
	 * @return
	 *//*
	private HttpEntity buildBinaryHttpEntry(byte[] binary) {
		EntityBuilder builder = EntityBuilder.create();
		builder.setContentEncoding(StandardCharsets.UTF_8.name());
		builder.setBinary(binary);
		return builder.build();
	}

	*//**
	 * GET方式请求
	 *
	 * @param url
	 * @param headers
	 * @return
	 * @throws IOException
	 *//*
	public byte[] httpGet(String url, List<Header> headers) throws IOException {
		HttpGet httpget = new HttpGet(url);
		return execute(httpget, headers);
	}

	public String httpGet(String url, Map<String, Object> params) {
		return httpGet(url, params, null);
	}

	public String httpGet(String url, Map<String, Object> param, List<Header> headers) {
		try {
			if (param != null && param.size() > 0) {
				if (url.indexOf("?") == -1) {
					url = url + "?";
				}
				StringBuilder sb = new StringBuilder();

				for (String key : param.keySet()) {
					sb.append(key);
					sb.append("=");
					sb.append(param.get(key).toString());
					sb.append("&");
				}
				url = url + sb.substring(0, sb.length() - 1);
			}

			HttpGet httpget = new HttpGet(url);
			return new String(execute(httpget, headers), "utf-8");
		} catch (Exception e) {
			logger.error("http request GET error, url：" + url + ", param:" + param, e);
		}

		return null;
	}

	*//**
	 * Post方式请求
	 *
	 * @param url
	 * @param headers
	 * @return
	 * @throws IOException
	 *//*
	public byte[] httpPost(String url, List<Header> headers) throws IOException {
		HttpPost httpPost = new HttpPost(url);
		return execute(httpPost, headers);
	}

	*//**
	 * 执行http请求，解析输出流为字节
	 *
	 * @param request
	 * @param headers    不能为null，否则不能把执行post请求得到的header放进去
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	private byte[] execute(HttpRequestBase request, List<Header> headers) throws IOException {
		if (headers != null && headers.size() > 0) {
			// 添加请求头
			for (Header header : headers) {
				request.addHeader(header);
			}
		} else if (headers == null) {
			// 如果入参的headers为null,后面headers.add(header)是返回不出去的。这一句只是为了避免空指针异常
			headers = new ArrayList<Header>();
		}
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(10000).setConnectionRequestTimeout(10000)
				.setSocketTimeout(10000).build();
		request.setConfig(requestConfig);
		HttpClientBuilder httpBuilder = HttpClients.custom();
		httpBuilder.setConnectionManager(connManager);
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		try { 
			httpclient = httpBuilder.build();
			request.getParams().setParameter("Connection", "close");
			response = httpclient.execute(request);
			for (Header header : response.getAllHeaders()) {
				if ("Set-Cookie".equalsIgnoreCase(header.getName())) {
					// 回写返回的cookie
					headers.add(header);
				}
			}
			if (response.getStatusLine().getStatusCode() == HttpServletResponse.SC_OK) {
				HttpEntity entity = response.getEntity();
				byte[] data = EntityUtils.toByteArray(entity);
				return data;
			} else {
				throw new BizException(String.valueOf(response.getStatusLine().getStatusCode()), "网络请求发生异常:" + response.getStatusLine());
			}
		} finally {
			if (request != null) {
				try {
					request.completed();
					request.abort();
				} catch (Exception e) {
					logger.warn("关闭request发生错误", e);
				}
			}
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					logger.warn("关闭response发生错误", e);
				}
			}
			// 使用连接池，不能关闭httpclient
			if (httpclient != null) {
				try {
					httpclient.close();
				} catch (Exception e) {
					logger.warn("关闭httpclient发生错误", e);
				}
			}
		}
	}
	/*
	*//**
	 * 垃圾回收时关闭
	 *//*
	@Override
	public void finalize() {
		connManager.close();
	}*/
}
