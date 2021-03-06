package date;

import java.util.Calendar;
import java.util.Date;

import org.thankjava.toolkit.utils.date.TimeHelper;
import org.thankjava.toolkit.utils.date.TimeHelper.TimeType;

public class TimeHelperTest {

	
	public static void main(String[] args) {
		System.out.println(TimeHelper.formatDate(TimeType.yyyyMMddHHmmss,new Date()));
		
		Date dateNow = TimeHelper.offsetDate(new Date(), Calendar.DAY_OF_YEAR, -32);
		System.out.println(dateNow.getTime());
		System.out.println(new Date().getTime());
	}
}