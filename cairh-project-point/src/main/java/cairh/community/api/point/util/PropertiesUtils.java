package cairh.community.api.point.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class PropertiesUtils {
	private static Properties prop;

	private static List<String> fileList;
	public static String[] pwdNameList = {"pwd","password"};
	private static Logger logger = Logger.getLogger(PropertiesUtils.class);
	
	public static void clear() {
		prop = null;
	}

	public static Properties getProp() {
		if (prop == null) {
			prop = new Properties();

			if (fileList != null) {
				for (String filename: fileList) {
					InputStream configIs = null;
					try {
						configIs = PropertiesUtils.class.getClassLoader().getResourceAsStream(filename);
						prop.load(configIs);
					} catch (IOException e) {
						logger.error("读取配置文件错误"+e.toString(), e);
					}
					finally{
						if (configIs != null) {
							try {
								configIs.close();
							}
							catch(IOException e){
								logger.error("关闭文件流错!");
							}
						}
					}
				}
			}

		}
		return prop;
	}

	public static String get(String key) {
		String res = "";
		if (getProp().containsKey(key))
			res = getProp().getProperty(key);
		return res;
	}

	public static String get(String key, String defaultValue) {
		return getProp().getProperty(key, defaultValue);
	}
	
	public static int getInt(String key,  int defaultValue){
		return Integer.parseInt(get(key, String.valueOf(defaultValue)));
	}

	public static String getWithFormat(String key, String... vals) {

		String msg = "";
		String format = getProp().getProperty(key);
		if (!StringUtils.isBlank(format)) {
			MessageFormat mf = new MessageFormat(format);
			msg = mf.format(vals);
		}
		return msg;
	}

	public static Integer get(String key, Integer def) {
		try {
			Integer res = def;
			if (getProp().containsKey(key))
				res = Integer.parseInt(getProp().getProperty(key));
			return res;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return def;
		}

	}

	public static Long get(String key, Long def) {
		try {
			Long res = def;
			if (getProp().containsKey(key))
				res = Long.parseLong(getProp().getProperty(key));
			return res;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return def;
		}

	}

	public static void set(String key, String value) {
		getProp().put(key, value);
	}

	public void setFileList(List<String> fileList) {
		PropertiesUtils.fileList = fileList;
	}

	
	public static int getIntSend(String key, int defaultValue) {
		String value = get(key, String.valueOf(defaultValue));
		if(isPassword(key,value)&&value.matches("^[A-F0-9]+$") && value.length()%16==0){
			return Integer.parseInt(TripleDes.decode(value));
		}
		return Integer.parseInt(value);
	}
	
	public static boolean isPassword(String key , String value){
		boolean flag = false;
		boolean flag2 = false;
		if(key!=null&&value!=null&&!"null".equals(value)){
			key = key.replace(".","_");
			for(String str:pwdNameList){
				if(str.equals(key.trim())){
					flag = true;
				}
			}
			if(key.trim().contains("password")&&!"db_password".equals(key.trim())){
				flag2 = true;
			}
		}
		return flag || flag2;
	}
	
}
