package cairh.community.api.game.kxian.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
public class DateUtil {

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "HH:mm:ss";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	public static final String TIMESTAMP_FORMAT_T = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String DATE_FORMAT_MDHM = "MM/dd HH:mm";
	public static final String DATE_FORMAT_YMDHM = "YYYY/MM/dd HH:mm";
	public static final String DATE_PRECISE_TO_MINUTE = "yyyyMMddHHmm";
	public static final String DATE_FORMAT_NO_DELIMITER = "yyyyMMdd";
	public static final String DATE_FORMAT_NO_HHMMSS = "HHmmss";
	
	/**
	 * @Title: parse
	 * @Description: TODO(将字符串转换成Date类型)
	 * @param @param dateString
	 * @param @param dateFormat
	 * @param @return 设定文件
	 * @return Date 返回类型
	 * @throws
	 */
	public static Date parse(String dateString, String dateFormat) {
		if (StringUtils.isEmpty(dateString))
			return null;
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			return df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 在原有日期上增减指定天数
	 * 
	 * @param dateString
	 * @param dateFormat
	 * @param days
	 * @return
	 */
	public static Date parse(String dateString, String dateFormat, int days) {
		if (StringUtils.isEmpty(dateString))
			return null;
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			Date date = df.parse(dateString);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, days);
			return cal.getTime();
		} catch (ParseException e) {

			return null;
		}
	}
 
	/**
	 * @Title: format
	 * @Description: TODO(将Date类型转化成字符串)
	 * @param @param date
	 * @param @param dateFormat
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String format(Date date, String dateFormat) {
		if (date == null) {
			return "";
		} else {
			DateFormat df = new SimpleDateFormat(dateFormat);
			return df.format(date);
		}
	}

	/**
	 * @Title: date2Seconds
	 * @Description: TODO(将时间Date转化成秒数)
	 * @param @param date
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public static int date2Seconds(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		long millis = cal.getTimeInMillis();
		int seconds = (new Long(millis / 1000)).intValue();// 毫秒转换成秒
		return seconds;
	}

	/**
	 * @Title: date2Milliseconds
	 * @Description: TODO(将时间Date转化成毫秒数)
	 * @param @param date
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public static long date2Milliseconds(Date date) {
		return date.getTime();
	}

	/**
	* @Title: getSqlDate
	* @Description: TODO(将时间转化成 java.sql.Date)
	* @param @param dateString
	* @param @param dateFormat
	* @param @return    设定文件
	* @return java.sql.Date    返回类型
	* @throws
	*/
	public static java.sql.Date getSqlDate(String dateString, String dateFormat) {
		if (dateString == null || dateString.length() == 0)
			return null;
		Date date = parse(dateString, dateFormat);
		return new java.sql.Date(date.getTime());
	}

	/**
	* @Title: stringToTimestamp
	* @Description: TODO(将时间转化成Timestamp)
	* @param @param dateString
	* @param @param format
	* @param @return
	* @param @throws Exception    设定文件
	* @return Timestamp    返回类型
	* @throws
	*/
	public static Timestamp stringToTimestamp(String dateString, String format)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return new Timestamp(sdf.parse(dateString).getTime());
	}

	/**
	* @Title: addDay
	* @Description: TODO(增加日期)
	* @param @param date
	* @param @param n
	* @param @return    设定文件
	* @return Date    返回类型
	* @throws
	*/
	public static Date addDay(Date date, int n) {
		try {
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			cd.add(Calendar.DATE, n);
			return cd.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	
	public static Date addMonth(Date date, int n) {
		try {
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			cd.add(Calendar.MONTH, n);
			return cd.getTime();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Date addHour(Date date, int n) {
		try {
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			cd.add(Calendar.HOUR_OF_DAY, n);
			return cd.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	public static int getDateInt(Date date) {
		return Integer.parseInt(format(date, DATE_FORMAT_NO_DELIMITER));
	}
	
	
	public static int diffDate(Date date, Date date1) {
		return (int) ((date2Milliseconds(date) - date2Milliseconds(date1)) / (24 * 3600 * 1000));
    }
	
	/****
	 * 格式：2006年4月16日 星期六
	 * @param date
	 * @return
	 */
	public static String getDate(Date date){
		 String s = DateFormat.getDateInstance(DateFormat.FULL).format(date);
	     return s;
	}

	public static Date getSecInDate(Integer time) {
		if(null == time){
			return new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time.longValue() * 1000);
		Date date = cal.getTime();
		return date;
	}
	
	
	/**
	 * 获取两个日期之间间隔的天数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getIntervalDay(Date startDate, Date endDate){
		int day = 0;
		if(null != startDate && null != endDate){
			long end = endDate.getTime();
			long start = startDate.getTime();
			long betweenDate = (end-start)/(24*60*60*1000);
			day = Long.valueOf(betweenDate).intValue();
		}
		
		return day;
	}
	
	

	
	/**
	 * 获取两个日期之间间隔的年数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getIntervalYear(Date startDate, Date endDate){
		int startYear = 0;
		int endYear = 0;
		
		if(null != startDate){
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(startDate);
			startYear = cal1.get(Calendar.YEAR);
		}
		if(null != endDate){
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(endDate);
			endYear = cal2.get(Calendar.YEAR);
		}
		
		return endYear - startYear;
	}
	
	public static String getDiffTimeStr(Date start,Date end){
		String time = "";
		if(start!=null && end!=null){
			int t = (int)(end.getTime() - start.getTime())/1000;
			String h = "";
			String m = "";
			String s = "";
			h=(int)t/3600+"";
			m=(int)(t%3600)/60+"";
			s=t%60+"";
			if(h.length()<=1){
				h="0"+h;
			}
			if(m.length()<=1){
				m="0"+m;
			}
			if(s.length()<=1){
				s="0"+s;
			}
			time = h+":"+m+":"+s;
		}
		return time;
	}
	
	/**
	 * 获取相对于指定时间
	 * @param endDay
	 * @param month
	 * @param i
	 * @return
	 */
	public static Date getRelativeDate(Date date, int field, int add) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, add);
		return cal.getTime();
	}
	/** 
	* 判断当前日期是否在某一时间范围内<br> 
	* <br> 
	* @param time 需要判断的时间<br> 
	*/  
	public static boolean IsTimeIn(Date time,Date begin,Date end){
        return time.getTime()>=begin.getTime() && time.getTime()<=end.getTime();
    }
	
	/**
	 * 判断是否为交易日
	 * @param date
	 * @return
	 */
	public static boolean isWorkingDay(Date date){
		return com.cairenhui.vstock.commons.DateUtil.isWorkingTime(date);
	}
	
	/**
	 * 获取当前时间的下n个交易日的时间
	 * @param d 时间
	 * @param n 第n个工作日
	 * @return d 下n个工作日的时间
	 */
	public static Date addNTradingDay(Date d ,int n ){
		if(n < 0){
			for(int i = 0;i > n;i--){
				d = DateUtil.getRelativeDate(d, Calendar.DAY_OF_YEAR, -1);
				while(!com.cairenhui.vstock.commons.DateUtil.isWorkingTime(d)){
					d = DateUtil.getRelativeDate(d, Calendar.DAY_OF_YEAR, -1);
				}
			}
		}else{
			for(int i = 0;i < n;i++){
				d = DateUtil.getRelativeDate(d, Calendar.DAY_OF_YEAR, 1);
				while(!com.cairenhui.vstock.commons.DateUtil.isWorkingTime(d)){
					d = DateUtil.getRelativeDate(d, Calendar.DAY_OF_YEAR, 1);
				}
			}
		}
		
		return d;
	}
	
	/**
	 * 判断当前时间是否在当天的某一个时段内
	 * @param date 当前时间  
	 * @param begin 起始时间    如 "09:00:00"
	 * @param end   结束时间  如"16:00:00"
	 * @return 在区间内true  不在false
	 */
	public static boolean isInclude(Date date,String begin,String end){
		try {
		    String nowtime = DateUtil.format(date, DATE_TIME_FORMAT);
		    String nowtime_left = nowtime.substring(0, 10);
		    String begintime = nowtime_left + " " + begin;
		    String endtime = nowtime_left + " " + end;	
		
			SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date datebegin = sp.parse(begintime);
			Date dateend = sp.parse(endtime);
			Date datemetime = sp.parse(nowtime);
			if(datemetime.after(datebegin) && datemetime.before(dateend)){
				return true;
			}
		} catch (ParseException e) {
			return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		
//		System.out.println(DateUtil.isInclude(date, "00:00:00", "16:00:00"));
		System.out.println(DateUtil.addNTradingDay(date, 1));
//		System.out.println(DateUtil.addNTradingDay(date, 1));
//		System.out.println(DateUtil.isWorkingDay(date));
//		System.out.println(DateUtil.parse("08:00:00", DateUtil.TIME_FORMAT));
//		System.out.println(DateUtil.format(date, DATE_TIME_FORMAT));
//		String nowtime = DateUtil.format(date, DATE_TIME_FORMAT);
//		nowtime = nowtime.substring(0, 10);
//		String begintime = nowtime + " 00:00:00";
//		String endtime = nowtime + " 16:00:00";
//		try {
//			System.out.println(begintime+"---;----"+endtime);
//			SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
//			Date date1 = sp.parse(begintime);
//			Date date2 = sp.parse(endtime);
//			Date date3 = sp.parse("2016-05-25 00:00:00");
//			if(date3.after(date1) && date3.before(date2)){
//				System.out.println("在区间");
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		

//		System.out.println(DateUtil.IsTimeIn(date, begin, end));
		
		
//		System.out.println(DateUtil.format(new Date(), "yyyy-MM-dd")+"--------------"+DateUtil.parse("09:00", "HH:mm"));
//		System.out.println(DateUtil.IsTimeIn(new Date(), DateUtil.parse(s+" 09:00", "yyyy-MM-dd HH:mm"), DateUtil.parse(s+" 11:00", "yyyy-MM-dd HH:mm")));
	}
	
	public static Date getPreviousHalfHourBegin(Date date) {
		try{
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			cal.add(Calendar.MINUTE, -30);
			
			int minute = cal.get(Calendar.MINUTE);
			if(minute >=0 && minute < 30){
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				
				return cal.getTime();
			}else{
				cal.set(Calendar.MINUTE, 30);
				cal.set(Calendar.SECOND, 0);
				
				return cal.getTime();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return date;
	}

	public static Date getPreviousHalfHourEnd(Date date) {
		try{
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			cal.add(Calendar.MINUTE, -30);
			
			int minute = cal.get(Calendar.MINUTE);
			if(minute >=0 && minute < 30){
				cal.set(Calendar.MINUTE, 30);
				cal.set(Calendar.SECOND, 0);
				
				return cal.getTime();
			}else{
				cal.add(Calendar.HOUR_OF_DAY, 1);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				
				return cal.getTime();
			}
		}catch(Exception e){

		}
		return date;
	}

	/**
	 * 格式化时间
	 * @param time
	 * @return
	 */
	public static String formatDateTime(String time, String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		if(time==null ||"".equals(time)){
			return "";
		}
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatDateTime(date, dateFormat);

	}

	public static String formatDateTime(Date date, String dateFormat) {
		Calendar current = Calendar.getInstance();

		Calendar today = Calendar.getInstance();	//今天

		today.set(Calendar.YEAR, current.get(Calendar.YEAR));
		today.set(Calendar.MONTH, current.get(Calendar.MONTH));
		today.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
		//  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
		today.set( Calendar.HOUR_OF_DAY, 0);
		today.set( Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);

		Calendar yesterday = Calendar.getInstance();	//昨天

		yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
		yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
		yesterday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH)-1);
		yesterday.set( Calendar.HOUR_OF_DAY, 0);
		yesterday.set( Calendar.MINUTE, 0);
		yesterday.set(Calendar.SECOND, 0);

		//输入的日期
		current.setTime(date);
		if (current.get(Calendar.YEAR) == today.get(Calendar.YEAR)) {
			String time_ = format(date, DATE_FORMAT_MDHM);
			if (current.after(today)) {
				return "今天 " + time_.split(" ")[1];
			} else if (current.before(today) && current.after(yesterday)) {

				return "昨天 " + time_.split(" ")[1];
			} else {
				return time_;
			}
		} else {
			return format(date, DATE_FORMAT_YMDHM);
		}
	}
	
	/**
	 * 格式化行情时间
	 * @param commonTime
	 * @return
	 */
	public static String timeFormatting(Integer commonTime){
		int min = commonTime & 0x3f;
		int hour = (commonTime >> 6) & 0x1f;
		//int day = (commonTime >> 11) & 0x1f;
		String strMin = min <= 9 ? "0" + min : min + "";
		String strHour = hour <= 9 ? "0" + hour : hour + "";
		//String strDay = day < 9 ? "0" + day : day + "";
		return strHour+strMin;
	}

	
	/**
	 * 格式化日期 返回int
	 * @param date
	 * @return
	 */
	public static Integer getStringDate(Date date,String str){
		SimpleDateFormat formatter = new SimpleDateFormat(str);		
		String dateString = formatter.format(date);
		return Integer.parseInt(dateString);
	}
	
	
}
