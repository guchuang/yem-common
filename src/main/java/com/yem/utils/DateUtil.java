package com.yem.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

/**
 * 日期公共类
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2019年7月11日 上午11:17:15 <br/>
 *
 * @author <a href="mailto:hbszguchuang@163.com">guchuang</a>
 * @version 
 * @since JDK 1.8
 */
public final class DateUtil {

	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(DateUtil.class);

	public static final String STD_DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	public static final String STD_DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

	public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	
	public static final String DATE_FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	
	public static final String DATE_FORMAT_HH_MM = "HH:mm";

	/**
	 * 将日期格式的字符串转换为日期类型
	 * 
	 * @param dataString
	 * @param format
	 *            字符串的日期格式
	 * @return
	 */
	public static Date toDate(String dataString, String format) {
		if (StringUtils.isEmpty(dataString)) {
			return null;
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		try {
			return new Date(myFormat.parse(dataString).getTime());
		} catch (Exception e) {
			log.error("", e);
			return null;
		}
	}

	/**
	 * 将日期格式的字符串转换为日期类型。如果字符串的格式为"yyyy-MM-dd HH:mm:ss",则截取日期返回
	 * 
	 * @param dataString
	 * @return
	 */
	@Deprecated
	public static Date toDate(String dateString) {
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}
		if (dateString.length() > 10) {
			return toDate(dateString, STD_DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
		} else {
			return toDate(dateString, DATE_FORMAT_YYYYMMDD);
		}
	}

	/**
	 * 
	 * toDateHasTime:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author <a href="mailto:pengxue@chinaums.com">pengxue</a>
	 * @param dateString
	 * @return
	 * @since JDK 1.8
	 */
	public static Date toDateHasTime(String dateString) {
		return toDate(dateString, STD_DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 将时间格式的字符串转换为时间类型
	 * 
	 * @param timeString
	 * @param format
	 *            字符串的时间格式
	 * @return
	 */
	public static Timestamp toTime(String timeString, String format) {
		if (StringUtils.isEmpty(timeString)) {
			return null;
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		try {
			return new Timestamp(myFormat.parse(timeString).getTime());
		} catch (Exception e) {
			log.error("", e);
			return null;
		}
	}

	/**
	 * 将时间格式的字符串转换为时间类型。如果字符串的格式为"yyyy-MM-dd"，则返回当日0点0分0秒的时间。
	 * 
	 * @param timeString
	 * @return
	 */
	@Deprecated
	public static Timestamp toTime(String timeString) {
		if (StringUtils.isEmpty(timeString)) {
			return null;
		}
		if (timeString.length() > 10) {
			return toTime(timeString, STD_DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
		} else {
			return toTime(timeString, STD_DATE_FORMAT_YYYY_MM_DD);
		}
	}

	public static Timestamp toTimeHasDate(String timeString) {
		return toTime(timeString, STD_DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 如果字符串的格式是"yyyy-MM-dd"，则返回当日0点0分0秒的时间;如果格式是"yyyy-MM-dd HH:mm:ss"，直接返回该字符串表示的时间
	 * 
	 * @param dateString
	 * @return
	 */
	public static Timestamp getFirstTime(String dateString) {
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}
		if (dateString.length() > 10) {
			return toTime(dateString, "yyyy-MM-dd HH:mm:ss");
		} else {
			return toTime(dateString, "yyyy-MM-dd");
		}
	}

	/**
	 * 获取指定时间所在的日期
	 * 
	 * @param time
	 * @return
	 */
	public static Date getDate(Timestamp time) {
		if (time == null) {
			return null;
		}
		return new Date(time.getTime());
	}

	/**
	 * 获取系统当前日期
	 * 
	 * @return
	 */
	public static Date getDate() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String mystrdate = myFormat.format(calendar.getTime());
		return Date.valueOf(mystrdate);
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @return
	 */
	public static Timestamp getTime() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 获取14位系统当前时间
	 * 
	 */
	public static String getSysTime14() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar = Calendar.getInstance();
		return myFormat.format(calendar.getTime());
	}

	/**
	 * 判断是否闰年
	 * 
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取指定年指定月份的天数
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthDays(int year, int month) {
		switch (month) {
		case 0:
		case 2:
		case 4:
		case 6:
		case 7:
		case 9:
		case 11:
			return 31;
		case 1:
			if (isLeapYear(1900 + year)) {
				return 29;
			} else {
				return 28;
			}
		case 3:
		case 5:
		case 8:
		case 10:
			return 30;
		}
		throw new RuntimeException("错误的月份");
	}

	/**
	 * 获取两个日期之间间隔的天数
	 * 
	 * @param endDate
	 * @param beginDate
	 * @return
	 */
	public static long getDays(Date endDate, Date beginDate) {
		if (endDate == null || beginDate == null) {
			return 0;
		}
		long days = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		return days;
	}

	/**
	 * 获取两个时间点之间间隔的天数
	 * 
	 * @param endTime
	 * @param beginTime
	 * @return
	 */
	public static long getDays(Timestamp endTime, Timestamp beginTime) {
		if (endTime == null || beginTime == null) {
			return 0;
		}
		long days = (endTime.getTime() - beginTime.getTime()) / (24 * 60 * 60 * 1000);
		return days;
	}

	/**
	 * 获取指定月份的第一天的0点0分0秒的时间
	 * 
	 * @param month
	 * @return
	 */
	public static Timestamp getFirstTimeOfMonth(String month) {
		if (month == null || month.equals("")) {
			return null;
		}
		return toTime(month, "yyyyMM");
	}

	/**
	 * 判断一个时间是否在指定的月份
	 * 
	 * @param time
	 * @param month
	 * @return
	 */
	public static boolean inMonth(Timestamp time, String month) {
		if (time == null || month == null || month.equals("")) {
			return false;
		}
		String m = formatTime(time, "yyyyMM");
		return m.equals(month);
	}

	/**
	 * 获取当前月份，格式yyyyMM
	 * 
	 * @return
	 */
	public static String getMonth() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMM");
		return myFormat.format(getDate());
	}

	/**
	 * 获取距离现在间隔月份的时间
	 */
	public static String getPointMonth(int interval) {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, interval); // 得到某一个月

		return formatDate(calendar.getTime(), "yyyyMM");

	}

	/**
	 * 获取当前月份，格式MM
	 * 
	 * @return
	 */
	public static String getMMMonth() {
		SimpleDateFormat myFormat = new SimpleDateFormat("MM");
		return myFormat.format(getDate());
	}

	/**
	 * 获取当前年份，格式yyyy
	 * 
	 * @return
	 */
	public static String getYYYYYear() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy");
		return myFormat.format(getDate());
	}

	/**
	 * 获取当前年份，格式yy
	 * 
	 * @return
	 */
	public static String getYYYear() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yy");
		return myFormat.format(getDate());
	}

	/**
	 * 获取指定月份的第一天日期
	 * 
	 * @param month
	 * @return
	 */
	public static Date getFirstDateOfMonth(String month) {
		if (month == null || month.equals("")) {
			return null;
		}
		return toDate(month, "yyyyMM");
	}

	/**
	 * 判断指定日期是否在两个时间范围内
	 * 
	 * @param date
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean between(Date date, Timestamp beginTime, Timestamp endTime) {
		if (date.before(getDate(endTime)) && date.after(getDate(beginTime))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断指定时间是否在两个时间范围内
	 * 
	 * @param time
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean between(Timestamp time, Timestamp beginTime, Timestamp endTime) {
		if (time.before(endTime) && time.after(beginTime)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 将日期转换为yyyyMMdd格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMdd");
		return myFormat.format(date);
	}

	/**
	 * 将日期转换为指定格式的字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		return myFormat.format(date);
	}

	/**
	 * 将日期转换为指定格式的字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(java.util.Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(STD_DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
		return myFormat.format(date);
	}
	/**
	 * 将时间转换为yyyyMMdd HH:mm:ss格式的字符串
	 * 
	 * @param time
	 * @return
	 */
	public static String formatTime(Timestamp time) {
		if (time == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return myFormat.format(time);
	}

	/**
	 * 将时间转换为指定格式的字符串
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String formatTime(Timestamp time, String format) {
		if (time == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		return myFormat.format(time);
	}

	/**
	 * 将时间转换为长整型
	 * 
	 * @param time
	 * @return
	 */
	public static long toLong(Timestamp time) {
		return time.getTime();
	}

	public static String getDateString(Timestamp time) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		String mystrdate = myFormat.format(time);
		return mystrdate;
	}

	public static String getTimestampString(Timestamp time, String format) {
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		String mystrdate = myFormat.format(time);
		return mystrdate;
	}

	public static String getMonthByMMM(String MMM) {
		String[] monthList = { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" };
		String month = "01";
		for (int i = 0; i < 12; i++) {
			if (monthList[i].equalsIgnoreCase(MMM))
				month = "0" + (i + 1);
		}
		return month.substring(month.length() - 2);
	}

	/**
	 * @param createTime
	 * @param format
	 * @return
	 */
	public static String formatDate(java.util.Date createTime, String format) {
		// TODO Auto-generated method stub
		if (createTime == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		return myFormat.format(createTime);

	}

	public static String formatDate(Long curr, String format) {
		if (curr == 0)
			return "0";
		SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
		// sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
		sdf.applyPattern(format);
		return sdf.format(curr);
	}

	/**
	 * 将日期格式的字符串转换为日期类型
	 * 
	 * @param dataString
	 * @param format
	 *            字符串的日期格式
	 * @return
	 */
	public static java.util.Date toUtilDate(String dataString, String format) {
		return toUtilDate(dataString, format, null);
	}

	/**
	 * 将日期格式的字符串转换为日期类型
	 * 
	 * @param dataString
	 * @param format
	 *            字符串的日期格式
	 * @return
	 */
	public static java.util.Date toUtilDate(String dataString, String format, java.util.Date def) {
		if (dataString == null || dataString.equals("")) {
			return def;
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		try {
			return new java.util.Date(myFormat.parse(dataString).getTime());
		} catch (Exception e) {
			log.error("", e);
			return def;
		}
	}

	/**
	 * 功能: 将字符串转换为指定格式的日期返回
	 * 
	 * @param dateStr
	 *            要转换的字符串
	 * @param format
	 *            目标日期格式
	 * @return
	 */
	public static java.util.Date formatStrToDate(String dateStr, String format) {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat(format);
		java.util.Date date = null;
		try {
			date = sdf1.parse(dateStr);
		} catch (Exception e) {
			log.error("", e);
			return null;
		}
		return date;
	}

	/**
	 * 功能：字符串转换为Date
	 */
	public static java.util.Date formatStrToDate(String strdate) throws Exception {
		String str = strdate.replace("-", "");
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
		return formatter.parse(str);

	}

	/**
	 * 获取当前年份，格式format, 默认yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getStrDate() {
		return getStrDate("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取当前年份，格式format, 默认yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getStrDate(String format) {
		if (null == format || "".equals(format))
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		return myFormat.format(new java.util.Date());
	}

	/**
	 * 获取当前年份，格式format, 默认yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getStrDate(Timestamp date, String format) {
		if (null == format || "".equals(format))
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		return myFormat.format(date);
	}

	/**
	 * 比较两个字符串时间的大小 不取结果的绝对值
	 * 
	 * @param t1
	 *            时间1
	 * @param t2
	 *            时间2
	 * @param parrten
	 *            时间格式 :yyyy-MM-dd HH:mm:ss
	 * @return 返回long =0相等，>0 t1>t2，<0 t1<t2
	 */
	public static long compareStringTimeEx(String t1, String t2, String parrten) {
		SimpleDateFormat formatter = new SimpleDateFormat(parrten);
		long startT = 0;
		long endT = 0;
		try {
			startT = formatter.parse(t1).getTime();
			endT = formatter.parse(t2).getTime();

		} catch (ParseException e) {
			log.error("", e);
		}
		long ss = (startT - endT) / (1000); // 共计秒数
		return ss;
	}
	
	public static Date addDays(final Date date, final int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
        return new Date(calendar.getTimeInMillis());
    }
	
	/**
	 * 返回当前日期是礼拜几（0-6对应礼拜天-礼拜一...礼拜六）
	 * @param date
	 * @return
	 */
	public static String getDayOfWeek(final java.util.Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return String.valueOf(w);
	}
}
