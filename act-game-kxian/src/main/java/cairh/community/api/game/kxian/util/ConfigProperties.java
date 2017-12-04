package cairh.community.api.game.kxian.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigProperties {
	private static Properties prop;
	
	static Logger logger = LoggerFactory.getLogger(ConfigProperties.class);
	
	public static Properties getProp() {
		if(prop == null){
			prop=new Properties();
			InputStream configIs = null;
			try {
				//有效加载上传文件配置 避免覆盖config.properties
				configIs = ConfigProperties.class.getClassLoader().getResourceAsStream("/uploader-config.properties");
				if(configIs!=null){
					prop.load(configIs);
					propertiesPasswordDecode(prop);
				}
				
				configIs = ConfigProperties.class.getClassLoader().getResourceAsStream("conf/sms.properties");
				if(configIs!=null){
					prop.load(configIs);
					propertiesPasswordDecode(prop);
				}
				configIs = ConfigProperties.class.getClassLoader().getResourceAsStream("conf/config.properties");
				if(configIs!=null){
					prop.load(configIs);
					propertiesPasswordDecode(prop);
				}
                configIs = ConfigProperties.class.getClassLoader().getResourceAsStream("/conf/mail.properties");
                if(configIs!=null){
                    prop.load(configIs);
                    propertiesPasswordDecode(prop);
                }
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(configIs != null){
						configIs.close();
					}
				} catch (IOException e2) {

				}
			}

		}
		return prop;
	}
	
	
	public static boolean reload(String configFileName){
		if(prop == null){
			prop=new Properties();
		}
		InputStream configIs = null;
		try {
			if(!configFileName.startsWith("/"))  configFileName = "/"+configFileName;
			configIs = ConfigProperties.class.getClassLoader().getResourceAsStream(configFileName);
			if(configIs!=null){
				prop.load(configIs);
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
			return false;
		}finally {
			try {
				if(configIs != null){
					configIs.close();
				}
			} catch (IOException e2) {
				logger.error(e2.getMessage());
			}
		}
		return true;
	}
	
	public static String get(String key){
		String res = "";
		if(getProp().containsKey(key))
			res = getProp().getProperty(key);
		return res;
	}
	
	public static String get(String key,String defaultValue){
		return getProp().getProperty(key, defaultValue);
	}
	public static Integer get(String key,Integer def){
		try {
			Integer res = def;
			if(getProp().containsKey(key))
				res = Integer.parseInt(getProp().getProperty(key));
			return res;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return def;
		}
		
	}
	
	public static Long get(String key,Long def){
		try {
			Long res = def;
			if(getProp().containsKey(key))
				res = Long.parseLong(getProp().getProperty(key));
			return res;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return def;
		}
		
	}
	public static void set(String key , String value){
		getProp().put(key, value);
	}
	
	/**
	 * 取静态文件服务地址
	 * @return		ip:port
	 */
	public static String getStaticFileServer(){
		String DN = "";
		String server = get("server.staticfile.cdn", "http://htsec.cairenhui.com");
		String port = ConfigProperties.get("serverport.staticfile.cdn", "");
		if(port == null || "".equals(port)){
			if(server.endsWith("/")){
				DN = server;
			}else{
				DN = server + "/";
			}
		}else{
			if(server.endsWith("/")){
				short len = (short) server.length();
				server = server.substring(0, len-1);
			}
			DN = server + ":" + port + "/";
		}
		return DN;
	}
	
	/**
	 * 取静态文件服务替换地址
	 * @return		ip:port
	 */
	public static String getReplaceAddrRex(){
		String DN = "http(s)?://(.+?/)+?";
		String keyword = get("imgurl.split.keyword", "files");
		if(keyword.endsWith("/")){
			short len = (short) keyword.length();
			keyword = keyword.substring(0, len-1);
		}
		DN = DN+keyword+"/";
		return DN;
	}
	
	public static void main(String[] args) {
		String str = "ttdd.properites";
		System.out.println(reload(str));
	}
	
	/**
	 * 对配置文件中 的password进行解密
	 */
	private static void propertiesPasswordDecode(Properties prop){
		 Enumeration<?> keys = prop.propertyNames();
 		while(keys.hasMoreElements()){
 			String key = (String)keys.nextElement();
             String value = prop.getProperty(key);
             if (key.contains("password") && null != value) {
            	 value = TriDES.decode(value.trim());
                 prop.setProperty(key, value);
             }
 		}
	}
	
	public static String getProperty(String key){
		return prop.getProperty(key);
	}
}
