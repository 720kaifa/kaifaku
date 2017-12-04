package cairh.community.api.point.util;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class ConfigUtil {
	private static Logger logger = Logger.getLogger(ConfigUtil.class);
	/**
	 * 配置的web地址
	 */
	public static String configWebAddr = ConfigProperties.get("webAddr");
	//过滤路径
	private static Map<String,String> needLoginMap = null;
	//css js 文件最后一次更新时间(精确到小时)
	private static Map<String,String> jcTimeMap = null;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
	
	static{//在spring配置文件里面配置了改类，生成bean时会执行这里
		//初始化 needLoginMap
		getNeedLoginMap();
	    //初始化 jcTimeMap
		updateJcMap();
	}
	
	/**
	 * 得到css js 文件最后一次更新时间
	 * @return
	 */
	public static Map<String,String> getJcTimeMap (){
		return getJcTimeMap(false);
	}
	
	public static Map<String,String> getJcTimeMap (boolean updateFlag){
		if(jcTimeMap==null||updateFlag){
			if(jcTimeMap==null)
				jcTimeMap = new HashMap<String, String>();
			try {
				File fileBase = new File(ConfigUtil.class.getResource("/").getPath());
				String basePath = fileBase.getParentFile().getParentFile().getAbsolutePath();
				File jsFile = new File(basePath+"/js");
				if (jsFile.exists()) {
					File[] jsFiles = jsFile.listFiles();
					for (File file : jsFiles) {
						putJcFileNameAndTime(jcTimeMap, file);
					}
				}
				File cssFile = new File(basePath+"/css");
				if (cssFile.exists()) {
					File[] cssFiles = cssFile.listFiles();
					for (File file : cssFiles) {
						putJcFileNameAndTime(jcTimeMap, file);
					}
				}
				File imagesFile = new File(basePath+"/images");
				if (imagesFile.exists()) {
					File[] imagesFiles = imagesFile.listFiles();
					for (File file : imagesFiles) {
						putJcFileNameAndTime(jcTimeMap, file);
					}
				}
				File loadSwf = new File(basePath+"/swf/sns/loading.swf");
				if(loadSwf.exists()){
					jcTimeMap.put("loading.swf", sdf.format(loadSwf.lastModified()));
				}
				File avatarSwf = new File(basePath+"/swf/sns/avatar4crh.swf");
				if(avatarSwf.exists()){
					jcTimeMap.put("avatar4crh.swf", sdf.format(avatarSwf.lastModified()));
				}
			} catch (Exception e) {
				logger.warn("jc配置", e);
			}
		}
		return jcTimeMap;
	}
	
	public static void putJcFileNameAndTime(Map<String,String> jcTimeMap,File file){
		if(file.isDirectory()){
			File [] files = file.listFiles();
			for (File file2 : files) {
				putJcFileNameAndTime(jcTimeMap,file2);
			}
		}else{
			jcTimeMap.put(file.getName(), sdf.format(file.lastModified()));
		}
	}
	
	/**
	 * 得到过滤路径
	 * @return
	 */
	public static Map<String,String> getNeedLoginMap(){
		try {
			if(needLoginMap==null){
				needLoginMap = new HashMap<String,String>();
				SAXReader reader = new SAXReader();
				InputStream is = ConfigUtil.class.getResourceAsStream("/filterUrls.xml");
				if (is!=null) {
					Document doc = reader.read(is);
					Element root = doc.getRootElement();
					for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
						Element e = (Element) i.next();
						if ("url".equals(e.getName())) {
							needLoginMap.put(e.attributeValue("value"), e
									.attributeValue("type"));
						}
					}
				}
			}
		} catch (Exception e) {
			logger.warn("得到过滤路径", e);
		}
		return needLoginMap;
			
	}
	
	/**
	 * 更新Javascript Css版本
	 */
	private static void updateJcMap(){
		getJcTimeMap(true);
	} 
	
	/**
	 * 给Javascript Css加版本
	 * @param jcName
	 * @return
	 */
	public static String getVersionJc(String jcName){
		String a=jcName;
		return jcName+"?v="+jcTimeMap.get(jcName);
	}
	
	public static void main(String[] args) {
		long start = new Date().getTime();
		for(int i=0 ; i <100000 ; i++ ){
			String jsPath = ConfigUtil.class.getResource("../util").getPath();
			File file = new File(jsPath);
			file.lastModified();
		}
		long end = new Date().getTime();
		System.out.println("直接读 耗费时间:"+(end-start)+"毫秒");
		
		Map<String ,String> map = new HashMap<String, String>();
		map.put("aa", "10000000");
		map.put("aa2", "10000000");
		map.put("aa3", "10000000");
		map.put("aa4", "10000000");
		map.put("aa5", "10000000");
		map.put("aa6", "10000000");
		map.put("aa7", "10000000");
		map.put("aa8", "10000000");
		long start1 = new Date().getTime();
		for(int i=0 ; i <100000 ; i++ ){
			map.get("aa2");
		}
		long end1 = new Date().getTime();
		System.out.println("内存hash后读 耗费时间:"+(end1-start1)+"毫秒");
		
	}

}
