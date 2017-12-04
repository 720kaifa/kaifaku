package cairh.community.api.point.util;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class UploaderClient {
	private static HttpClient httpClient = new DefaultHttpClient();
	private static String uploaderUrl = ConfigProperties.get("uploadAddr","http://192.168.1.103:8081/upload!uploadFile.action");
    static {
        ThreadSafeClientConnManager ccm = new ThreadSafeClientConnManager();
        ccm.setMaxTotal(20);
        ccm.setDefaultMaxPerRoute(20);
        
        HttpParams params = new BasicHttpParams();
        params.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10 * 1000);
        params.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 60 * 1000);
        
        httpClient = new DefaultHttpClient(ccm, params);
    }
    
	public static String upload(File[] files, Map<String, String> map)
			throws ClientProtocolException, IOException {
		return upload(URLDecoder.decode(uploaderUrl, "UTF-8"), files, map);
	}

	public static String upload(String url, File[] files,
			Map<String, String> map) throws ClientProtocolException,
			IOException {
		if (files == null) {
			return null;
		}

		MultipartEntity reqEntity = new MultipartEntity();
		int len = files.length;
		for (int i = 0; i < len; i++) {
			File file = files[i];
			if (file != null)
				reqEntity.addPart("myFiles", new FileBody(file));
		}
		if (null != map && map.size() > 0) {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();

				reqEntity.addPart(key, new StringBody(value));
			}
		}

		HttpPost httppost = new HttpPost(url);

		httppost.setEntity(reqEntity);

		String rst = null;
		HttpEntity entity = null;
		try{
		    HttpResponse response = httpClient.execute(httppost);
			if (200 == response.getStatusLine().getStatusCode()) {
				entity = response.getEntity();
	
				if (entity != null) {
					rst = EntityUtils.toString(entity);
					rst = (new String(rst.getBytes("iso-8859-1"),"UTF-8"));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (null != httppost) {
                httppost.abort();
            }
			if (null != entity) {
                EntityUtils.consume(entity);
            }
		}
		return rst;
	}

	public static void main(String[] a) throws ClientProtocolException,
			IOException {
//		File file = new File("H:\\5.jpg");
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("userId", String.valueOf(1));
//		map.put("picType", "front");
//
//		System.out.println(upload(new File[] { file }, map));
	}
}