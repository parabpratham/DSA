package CalenderEx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class CalenderSet {


	public static void main(String[] args) throws ParseException {
		

//		SimpleDateFormat sdf = new SimpleDateFormat("dd' 'mmm' 'yyyy");
//		Date d =sdf.parse("21 jan 2009");
//		System.out.println(sdf.format(d));
		
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
		System.out.println(System.currentTimeMillis());
		
		Calendar cal = Calendar.getInstance();
		cal.set(cal.YEAR,2010);
		cal.set(cal.MONTH,8);
		cal.set(cal.DATE, 26);
		
		Date dt = new Date(cal.getTimeInMillis());
		System.out.print(dt);
		
	}
	private static void display(Date bthDate2) {
		// TODO Auto-generated method stub
		System.out.println("The Birthday is:");
		System.out.println(bthDate2.getDate() + "-" + bthDate2.getMonth() +"-" + bthDate2.getYear());
		
	}
	private static void display(Calendar cal) {
		
		System.out.println("New Date is:");
		System.out.print(cal.get(5)+"-"+cal.get(2)+"-"+cal.get(1));
		
	}
//	private static void addMonths() {
//		
//		int year = bthDate.getYear();
//		int date = bthDate.getDate();
//		int month = bthDate.getMonth() + 6;
//		if(month>12)
//		{
//			year++;
//			month = month - 12;
//		}
//		
//	
//	}

}
