package org.thankjava.toolkit.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 对java Date 进行的常规操作
* <p>Function: TimeHelper</p>
* <p>Description: </p>
* @author zhaoxy@thankjava.com
* @date 2014年12月10日 下午8:40:49
* @version 1.0
 */
public final class TimeHelper {
	
	private TimeHelper () {}

	public enum TimeType {
		DEFAULT("yyyy-MM-dd|HH:mm:ss"),
		yyyyMMddHH("yyyyMMddHH"),
		yyyyMMddHHmmss("yyyyMMddHHmmss"),
		yyyyMMdd("yyyyMMdd"),
		HHmmss("HHmmss"),
		;
		
		String type;
		private TimeType(String type){
			this.type = type;
		}
		public String getType(){
			return type;
		}
	}
	
	/**
	 * 将date Str 转换为 Date 类型
	* <p>Function: parseDate</p>
	* <p>Description: </p>
	* @author zhaoxy@thankjava.com
	* @date 2015年6月18日 上午9:59:42
	* @version 1.0
	* @param date
	* @param timeType
	* @return
	 */
	public static Date parseDate(String date,TimeType timeType){
		SimpleDateFormat sdf = getDateFormat(timeType);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取指定格式的SimpleDateFormat
	* <p>Function: getDateFormat</p>
	* <p>Description: </p>
	* @author zhaoxy@thankjava.com
	* @date 2015年6月18日 上午10:00:31
	* @version 1.0
	* @param timeType
	* @return
	 */
	public static SimpleDateFormat getDateFormat(TimeType timeType){
		if(timeType == null){
			timeType = TimeType.DEFAULT;
		}
		return new SimpleDateFormat(timeType.getType());
	}
	
	/**
	 * 格式化日期
	* <p>Function: formatDate</p>
	* <p>Description: </p>
	* @author zhaoxy@thankjava.com
	* @date 2015年6月18日 上午10:01:09
	* @version 1.0
	* @param timeType
	* @param date
	* @return
	 */
	public static String formatDate(TimeType timeType,Date date){
		return getDateFormat(timeType).format(date);
	}
	
	/**
	 * 将时间按照指定偏移单位和偏移量生成新的时间
	* <p>Function: offsetDate</p>
	* <p>Description: </p>
	* @author zhaoxy@thankjava.com
	* @date 2015年6月18日 上午10:01:26
	* @version 1.0
	* @param date
	* @param calendarUnit
	* @param dateOffset
	* @return
	 */
	public static Date offsetDate(Date date, int calendarUnit,int dateOffset) {
		if (date == null) {
			return date;
		}
		
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(calendarUnit, dateOffset);
		
		return ca.getTime();
	}
	
	/**
	 * 
	* <p>Function: dateOffset</p>
	* <p>Description: </p>
	* @author zhaoxy@thankjava.com
	* @date 2016年1月14日 下午7:18:48
	* @version 1.0
	* @param dateEarly
	* @param dateDfter
	* @return
	 */
	public static Long dateOffset(Date dateEarly,Date dateDfter){
		return dateDfter.getTime() - dateEarly.getTime();
	}
	
	/**
	 * 
	* <p>Function: dateOffsetSecond</p>
	* <p>Description: </p>
	* @author zhaoxy@thankjava.com
	* @date 2016年1月14日 下午7:21:01
	* @version 1.0
	* @param dateEarly
	* @param dateDfter
	* @return
	 */
	public static Integer dateOffsetSecond(Date dateEarly,Date dateDfter){
		Long ms = dateOffset(dateEarly, dateDfter);
		return (int) (ms / 1000);
	}
}
