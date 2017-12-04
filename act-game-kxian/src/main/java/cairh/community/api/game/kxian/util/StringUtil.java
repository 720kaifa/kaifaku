package cairh.community.api.game.kxian.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil extends StringUtils{
	public static String LINE_SEPARATOR =	(String) java.security.AccessController.doPrivileged(
            new sun.security.action.GetPropertyAction("line.separator"));
	private static DecimalFormat decimalFormat = new DecimalFormat("0.00");
	
	static Logger logger = LoggerFactory.getLogger(StringUtil.class);
	private static char[] DEFAULT_RANDOM = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k',  
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',  
            'x', 'y', 'z','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',  
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',  
            'X', 'Y', 'Z'};
	static{
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
	}
	/**
	 * 根据默认的char数组 生成随机字符串
	 * @param size
	 * @return
	 */
	public static String randomString(int size){
		return randomString(size,DEFAULT_RANDOM);
	}
	
	/**
	 * 根据指定的char数组 生成随机字符串
	 * @param size
	 * @param randomBase
	 * @return
	 */
	public static String randomString(int size, char[] randomBase){
		StringBuffer randomStr = new StringBuffer();
		SecureRandom random = new SecureRandom();
		for(int i=0; i<size; i++){
			randomStr.append(randomBase[Math.abs(random.nextInt(randomBase.length))]);
		}
		return randomStr.toString();
	}
	
	public static String getTxtContent(String content){
		if(content == null) return "";
		String str = content.replaceAll("<[^>]*?>", "").replaceAll("[ ]*", "").replaceAll("[　]*", "").replaceAll("&nbsp;", "").replaceAll("\\s*", "").trim();
		return  str;
	}
	
	/**
	 * MD5对字符串加密
	 * @param str
	 * @return
	 */
	public static String MD5(String str){
		StringBuffer strBuf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(str.getBytes());
			byte[] b = md.digest();
			for(int i = 0; i < b.length; i++){
				int temp = b[i] & 0xff;
				if(temp < 16)
					strBuf.append("0");
				strBuf.append(Integer.toHexString(temp));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return strBuf.toString();
	}
	
	/***
	 * 用正则表达式判断是不是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		if(str == null || "".equals(str)){
			return false;
		}
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	}
	
	/***
	 * 防止脚本注入，替换<>
	 * @param str
	 * @return
	 */
	public static String script2Txt(String str){
		if(str == null || "".equals(str)){
			return str;
		}
		str = str.trim();
		str = str.replaceAll("<","&lt;").replaceAll(">","&gt;");
		return str;
	}
	/***
	 * 替换成脚本
	 * @param str
	 * @return
	 */
	public static String txt2Script(String str){
		if(str == null || "".equals(str)){
			return str;
		}
		str = str.replaceAll("&lt;","<").replaceAll("&gt;",">");
		return str;
	}
	
	/***
	 * 计算字符数
	 * @param str
	 */
	public static int calculationBytes(String str){
		if(str == null){
			return 0;
		}
		str = str.trim();
		String after = str.replaceAll("[^\\x00-\\xff]", "11");
		return after.length();
	}
	
	/***
	 * 替换回车、换行
	 * @param s
	 * @return
	 */
	public static String replace( String s ){
		if(s == null){
			return "";
		}
//		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Pattern p = Pattern.compile("\\t|\r|\n");
		Matcher m = p.matcher(s);
		String after = m.replaceAll("");
		return after;
	}
	
	public static boolean isEmpty(String str){
		if(str == null || "".equalsIgnoreCase(str))
			return true;
		else
			return false;
	}
	public static boolean isNotEmpty(String str){
		if(str != null && !"".equalsIgnoreCase(str))
			return true;
		else
			return false;
	}
	
	/****
	 * 字符串截取，
	 * @param str
	 * @param length
	 * @param isExceed 是否超出
	 * @return
	 */
	public static String subString( String str , int length , Map<String, Object> map){
		if(map == null){
			map = new HashMap<String, Object>();
		}
		if( str == null || str.trim().length() <= length){
			map.put("isExceed", false);
			return str;
		}
		str = str.trim();
		if( length < 0 ){//内容大于了限制长度
			return str;
		}
		//UTF-8 汉字为3个字节
		if(length == 0){
			 length = str.length() * 2;
		}else{
			length = length * 2;
		}
		try {
			byte[] bt = str.getBytes("GBK");
			if(bt.length <= length){
				map.put("isExceed", false);
				return str;
			}
			map.put("isExceed", true);
			// 判断最后一个是否为负，如果是负的则丢掉该字节  
			if (bt[length] < 0) {  
			   return new String(bt, 0, --length, "GBK").replaceAll("�", "");
			} else {  
			   return new String(bt, 0, length, "GBK").replaceAll("�", "");
			}  
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}  
	}
	
	/**
	 * 英文算半个，汉子算一个---按照char截取，不会出现乱码
	 * @param str
	 * @param len
	 * @return
	 */
	public static String subString(String str, int len) {
		if(str == null) return "";
		str = str.trim();
		
		len = len * 2;
		StringBuffer sb = new StringBuffer();
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < 255) {
				counter++;
			} else {
				counter = counter + 2;
			}
			if (counter > len) {
				break;
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String numberFormat(String str){
		if(str == null) return "";
		return decimalFormat.format(Double.parseDouble(str));
	}
	
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6',
		'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	/**
	 * 对byte[]进行16进制编码
	 * @param data
	 * @return
	 */
	public static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];
		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}
		return out;
	}
	
	/**
	 * 将单个字符转成utf-8编码
	 * @param c  待转字符
	 * @return  utf-8字符串
	 * @author zhanggj
	 */
	public static String charToUTF8Hex(char c) {
		try {
			return new String(encodeHex(String.valueOf(c).getBytes("UTF-8"))).toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 将单个字符转成unicode
	 * @param c  待转字符
	 * @return  unicode字符串
	 * @author zhanggj
	 */
	public static String charToUnicode(char c) {
		String unicodeString = "\\u";
		int j = 0;
		String tmp;
		
		j = (c >>> 8); //取出高8位
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
			unicodeString += "0";
		unicodeString +=  tmp;
		j = (c & 0xFF); //取出低8位
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
			unicodeString += "0";
		unicodeString +=  tmp;
		
		return unicodeString;
	}
	
	/**
	 * 将单个unicode转成字符
	 * @param c  待转字符
	 * @return  unicode字符串
	 * @author zhanggj
	 */
	public static Character charToUnicode(String str) {
		return new Character((char) Integer.parseInt(str.replace("\\u", ""), 16));
	}
	
	/**
	 * 字符串传到页面时需要对特殊字符进行html转义
	 * @param str 待转字符
	 * @return  html字符串
	 * @author zhanggj
	 */
	public static String HtmlEncode(String str) {
		str = str.replace("&", "&amp;");
		str = str.replace(">", "&gt;");
		str = str.replace("<", "&lt;");
//		str = str.replace(" ", "&nbsp;");
		str = str.replace("\"", "&quot;");
		str = str.replace("\'", "&#39;");
		str = str.replace("\n", "<br/> ");
		str = str.replace("®", "&reg;");
		str = str.replace("©", "&copy;");
		str = str.replace("™", "&trade;");
		str = str.replace("[", "&#91;");
		str = str.replace("]", "&#93;");
		
		return str;
	}
	
	/**
	 * 字符串转成全角字符串
	 * 全角空格为12288，半角空格为32
	 * 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
	 * 
	 * @param input  任意字符串/全角字符串
	 * @return
	 * @author zhanggj
	 */
	public static String ToSBC(String input) {
		// 半角转全角：
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 32) {
				c[i] = (char) 12288;
				continue;
			}
			if (c[i] < 127)
				c[i] = (char) (c[i] + 65248);
		}
		return new String(c);
	}
	
	/**
	 * 字符串转成半角字符串
	 * 全角空格为12288，半角空格为32
	 * 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
	 * 
	 * @param input  任意字符串/全角字符串
	 * @return
	 * @author zhanggj
	 */
	public static String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i< c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	} 

	/**
	 * 将字符串转成unicode
	 * @param str 待转字符串
	 * @return unicode字符串
	 * @author zhanggj
	 */
	public static String StringToUnicode(String str)
	{
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++)
		{
			c = str.charAt(i);
			sb.append("\\u");
			j = (c >>> 8); //取出高8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
			j = (c & 0xFF); //取出低8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);

		}
		return (new String(sb));
	}

	/**
	 * unicode转成字符串
	 * @param str
	 * @return 普通字符串
	 * @author zhanggj
	 */
	public static String UnicodeToString(String str)
	{
		str = (str == null ? "" : str);
		//如果不是unicode码则原样返回
		if (str.indexOf("\\u") == -1)
			return str;

		StringBuffer sb = new StringBuffer(1000);

		for (int i = 0; i < str.length() - 6;)
		{
			String strTemp = str.substring(i, i + 6);
			String value = strTemp.substring(2);
			int c = 0;
			for (int j = 0; j < value.length(); j++)
			{
				char tempChar = value.charAt(j);
				int t = 0;
				switch (tempChar)
				{
				case 'a':
					t = 10;
					break;
				case 'b':
					t = 11;
					break;
				case 'c':
					t = 12;
					break;
				case 'd':
					t = 13;
					break;
				case 'e':
					t = 14;
					break;
				case 'f':
					t = 15;
					break;
				default:
					t = tempChar - 48;
				break;
				}

				c += t * ((int) Math.pow(16, (value.length() - j - 1)));
			}
			sb.append((char) c);
			i = i + 6;
		}
		return sb.toString();
	}
	
	public static String[] filterNull(String[] strArray){
		if(strArray == null || strArray.length < 1) return null;
		List<String> strList = new ArrayList<String>();
		for(String str : strArray){
			if(str != null)strList.add(str);
		}
		if(strList == null || strList.size() < 1) return null;
		String[] strs = new String[strList.size()];
		int i = 0;
		for(String str : strList){
			strs[i] = str;
			i++;
		}
		return strs;
	}
	
	public static String delHtmlTag(String html){
		Pattern pattern = Pattern.compile("<.*?>");
		Matcher matcher = pattern.matcher(html);
		List<String> replaceList = new ArrayList<String>();
		while (matcher.find()) {
			replaceList.add(html.substring(matcher.start(), matcher.end()));
		}
		for (String string : replaceList) {
			html = html.replace(string, "");
		}
		return html;
	}
	
	/***
	 * 用正则表达式判断是不是数字(包括小数)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPriceNum(String str){
		if(str == null || "".equals(str)){
			return false;
		}
	    return str.matches("^[\\d]+?\\.?[\\d]{0,2}$");
	}
	
	
	//oracle.sql.Clob类型转换成String类型
	public static String ClobToString(Clob clob) {
		String reString = "";
		Reader is = null;
		try {
			is = clob.getCharacterStream();
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} 
		// 得到流
		BufferedReader br = null;
		String s = null;
		try {
			br = new BufferedReader(is);
			s = br.readLine();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		StringBuffer sb = new StringBuffer();
		while (s != null) {
			//执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			try {
				s = br.readLine();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		//关闭流
		if(is != null){
				try {
					is.close();
					logger.debug("Reader流已关闭");
				} catch (IOException e) {
					logger.error("流关闭出错");
				}
		}	
		if (br != null){
			try {
				br.close();
				logger.debug("BufferedReader流已关闭");
			} catch (IOException e) {
				logger.error("流关闭出错");
			}
		}
		
		reString = sb.toString();
		return reString;
	}

	/**
	 * 方法isNumber判断输入的字符串是否是数字
	 *
	 * @param str
	 *            字符串类型
	 * @return 是数字返回true 反之返回false
	 */
	public static boolean isNumber(String obj) {
//		boolean t = false;
//		if (StringUtils.isNotEmpty(obj)) {
//			try {
//				if (Double.valueOf(obj) > 0D) {
//					t = true;
//				}
//			} catch (Exception e) {
//
//			}
//		}
		if(isEmpty(obj)) return false;
		return obj.matches("[\\d.]+");
	}

	/**
	 * 判断字符是否超过长度
	 *
	 * @param str
	 * @param num
	 * @return 超过规定字符返回true
	 */
	public static boolean isLen(String str, int num) {
		int forNum = 0;
		int alli = 0;//
		int strLen = 0;// 要循环的长度

		if (str.length() >= num) {
			strLen = num;
			return true;// 超过规定字符返回true
		} else {
			strLen = str.length();
		}
		for (int i = 0; i < strLen; i++) {
			if (num == Math.floor(forNum / 2f))
				break;
			if (str.substring(i, i + 1).getBytes().length > 1) {
				// 如果是字符
				alli = alli + 1;
			}
			alli = alli + 1;
		}
		if (alli > num) {
			return true;// 超过规定字符返回true
		}
		return false;// 不超过规定字符返回False
	}

	/**
	 * java按要求长度截取字段
	 *
	 * @param str
	 *            字符
	 * @param num
	 *            长度
	 * @return
	 */
	public static String getStrLen(String str, int num) {
		int forNum = 0;
		int alli = 0;//
		int strLen = 0;// 要循环的长度
		if (str.length() >= num) {
			strLen = num;
		} else {
			strLen = str.length();
		}
		for (int i = 0; i < strLen; i++) {
			if (num == Math.floor(forNum / 2f))
				break;
			if (str.substring(i, i + 1).getBytes().length > 1) {
				// 如果是字符
				alli = alli + 1;
			}
			alli = alli + 1;
			if (alli >= num) {
				return str.substring(0, i);
			}
		}
		return str.substring(0, strLen);
	}
	
	/**
	 * 格式化成百分数
	 * @param obj
	 * @return
	 */
	public static String  percent(Object obj) {
		 DecimalFormat df = new DecimalFormat("0.00%");
         String r = df.format(obj);
		 return r;
	}
}
