package cairh.community.api.point.util.upload;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StringUtil {

	private static final String SPACE_MARK_STR = ",";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(new File("/uploader/filesys/temp/130404859385100000.jpg").isAbsolute());
		getURLPath("/uploader/filesys/temp/130404859385100000.jpg");
		/*List<Integer> list = split2List("11,22");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}*/
	}

	public static String[] split2Array(String str){
		String[] rst = null;
		if(str != null){
			rst = str.split(SPACE_MARK_STR);
		}
		return rst;
	}

	public static List split2List(String str){
		List list = null;
		if(str != null){
			list = Arrays.asList(str.split(SPACE_MARK_STR));
		}
		return list;
	}

	public static <T> List<T> array2List(T[] array){
		List<T> list = Arrays.asList(array);
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] list2Array(List<T> list){
		T[] arr = null;
		if(list != null){
			arr = (T[]) list.toArray(new Object[list.size()]);
		}
		return arr;
	}

	/**
	 * 解析整型数字
	 * @param value
	 * @return
	 */
	public static int parseInt(String value){
		int intValue = 0;
		try{
			intValue = Integer.parseInt(value);
		}catch(Exception e){
			e.printStackTrace();
		}
		return intValue;
	}
	/**
	 * 解析Long型数字
	 * @param value
	 * @return
	 */
	public static long parseLong(String value, long defValue){
		long longValue = defValue;
		try{
			longValue = Long.parseLong(value);
		}catch(Exception e){
			e.printStackTrace();
		}
		return longValue;
	}

	public static String getYearStamp(){
		String pattern = "yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}

	public static String getDateStamp(){
		String pattern = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}

	public static String getURLPath(String url){
		String path = null;
		URL urlObj = null;
		try {
			urlObj = new URL(url);
			path = urlObj.getPath();
		} catch (MalformedURLException e) {
//			e.printStackTrace();
			path = url;
		}
		if(path != null && path.startsWith("/")){
			path = path.substring(1);
		}
//		System.out.println(path);
		return path;
	}
}
