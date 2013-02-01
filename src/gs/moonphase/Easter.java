package gs.moonphase;

import java.util.Calendar;

public class Easter {	

	public static String easterOrthodox(int year) {		
		Calendar calendar = Calendar.getInstance();
		String easter;		
		int a = year % 19;
		int b = year % 4;
		int c = year % 7;
		int d = (19 * a + 15) % 30;
		int e = (2 * b + 4 * c + 6 * d + 6) % 7;
		if (d + e <= 10) {
			calendar.set(year, 3 + 1, 22 + d + e + 13);
		} else {
			calendar.set(year, 4 + 1, d + e - 9 + 13);
		}
		int day = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH) - 1;
		year = calendar.get(Calendar.YEAR);
		easter = year + "-" + month + "-" + day;
		return easter;
	}
	
	
	static int day = 0;
	static int month = 0;
	static double hour = 0;
	public static String easterCatholic(int year) {
		
		
		Season season = new Season(year);		
		String spring = season.getSpring(); // Получаем весенее равноденствие		
		parseDate(spring);
		
		Calc calc = new Calc(year, month, day, hour);
		String fullMoon = calc.getFullMoon(); // Получаем полнолуние
		parseDate(fullMoon);
		
		double jDateEquinox = Double.parseDouble(calc.getJulianDate());
		calc = new Calc(year, month, day, hour);
		double jDateFullMoon = Double.parseDouble(calc.getJulianDate());
		
		while (jDateFullMoon <= jDateEquinox) {
			String fullMoon2 = fullMoon;
			while (fullMoon.equals(fullMoon2)) {
				day++;
				calc = new Calc(year, month, day, hour);
				fullMoon2 = calc.getFullMoon();				
			}
			parseDate(fullMoon2);
			jDateFullMoon = Jgdates.jDay(year, month, day, hour);
						
		}
		

	Calendar cal = Calendar.getInstance();  
	cal.setTime(cal.getTime());
	cal.set(year, month - 1, day);	
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

	while (dayOfWeek < 9){
		cal.set(year, month - 1, day++);
		dayOfWeek++;
	}
	day = cal.get(Calendar.DAY_OF_MONTH);
	month = cal.get(Calendar.MONTH);
		
		return year + "-" + (month + 1) + "-" + day;
	}

	private static void parseDate(String date) {
//		year = Integer.parseInt(date.substring(0, 4));
		month = Integer.parseInt(date.substring(5, 7));
		day = Integer.parseInt(date.substring(8, 10));
		
	}
}
