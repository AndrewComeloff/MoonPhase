package gs.moonphase;

import java.util.*;
import java.lang.String;

public class Jgdates {

	// ==+== ѕреобразование часов, минут, секунд в градусы с дол€ми ====
	public static double hhh(int h, int m, int s) {
		return h + m / 60. + s / 3600.;
	}
	
	// ==+== ёлианска€ дата дл€ любой даты с 4713 г. до новой эры =========
	public static double jDay(int year, int month, int day, double hour) {
		int b;
		long a = 10000L * year + 100L * month + day;

		if (month <= 2) {
			month += 12;
			--year;
		}
		if (a <= 15821004L)
			b = -2 + (year + 4716) / 4 - 1179;
		else
			b = year / 400 - year / 100 + year / 4;

		return 365. * year - 679004. + 2400000.5 + b
				+ Math.floor(30.6001 * (month + 1)) + day + hour / 24.;
	}
	
	public static void hms(double x, RefInt h, RefInt m, RefInt s) {
		x += 0.5/3600;
		h.val = (int) x;

		x -= h.val;
		x *= 60;
		m.val = (int) x;

		x -= m.val;
		x *= 60;
		s.val = (int) x;
	}
	
	public static void gDate(double jd, RefInt year, RefInt month, RefInt day,
			RefDouble hour) {
		int b, d, f;
		double c, e, jd0 = Math.floor(jd + .5);

		if (jd0 < 2299161.) { // юлианский календарь
			b = 0;
			c = jd0 + 1524.;
		} else { // григориаский календарь
			b = (int) ((jd0 - 1867216.25) / 36524.25);
			c = jd0 + (b - (int) (b / 4)) + 1525.;
		}

		d = (int) ((c - 122.1) / 365.25);
		e = 365. * d + Math.floor(d / 4.);
		f = (int) ((c - e) / 30.6001);

		day.val = (int) (Math.floor(c - e + .5) - Math.floor(30.6001 * f));
		month.val = f - 1 - 12 * (int) (f / 14);
		year.val = d - 4715 - (7 + month.val) / 10;
		hour.val = 24. * (jd + 0.5 - jd0);
	}

	public static String strGdate (double jd, int flag)
	{
    	RefInt yea = new RefInt();
    	RefInt mon = new RefInt();
    	RefInt day = new RefInt();
    	RefDouble hour = new RefDouble();
    	RefInt hou = new RefInt();
    	RefInt mnt = new RefInt();
    	RefInt sec = new RefInt();
    	
    	gDate (jd, yea, mon, day, hour);
    	hms (hour.val, hou, mnt, sec);
    	
    	Formatter fmtr = new Formatter();
    	//String fmtr;

		  switch (flag)
		  {
		  case 0: // date + time [yyyy.mm.dd hh:mm:ss]
		    //hms(time(), 1, h, m, s, c);//BIT_ROUND_SEC
	    	fmtr.format("%4d-%02d-%02d   %02d:%02d:%02d", yea.val, mon.val, day.val, hou.val, mnt.val, sec.val);
		    //sprintf(date, "%04d.%02d.%02d %02d:%02d:%02d", yy, mm, dd, h,m,s);
		    break;
		  case 1: // date + time [yyyy.mm.dd hh:mm:ss.ccc]
		    //hms(time(), 0, h, m, s, c);
		    //sprintf(date, "%04d.%02d.%02d %02d:%02d:%02d.%d", yy, mm, dd, h,m,s,c);
	    	//fmtr.format("%02d-%02d-%4d %02d:%02d", day, mon, yea, hou, mnt);
		    break;
		  case 2: // date + time [dd.mm.yyyy hh:mm:ss]
		    //hms(time(), 1, h, m, s, c);//BIT_ROUND_SEC
		    //sprintf(date, "%02d.%02d.%04d %02d:%02d:%02d", dd,mm,yy, h,m,s);
		    break;
		  case 3: // date + time [dd.mm.yyyy hh:mm]
		    //hms(time(), 2, h, m, s, c);//BIT_ROUND_MIN
		    //sprintf(date, "%04d.%02d.%02d %02d:%02d", yy, mm, dd, h,m);
	    	fmtr.format("%02d.%02d.%04d %02d:%02d", day.val, mon.val, yea.val, hou.val, mnt.val);
		    break;
		  case 4: // date [dd.mm.yyyy]
		    //sprintf(date, "%02d.%02d.%04d",dd,mm,yy);
		    break;
		  case 5: // date [yyyy.mm.dd]
		    //sprintf(date, "%04d.%02d.%02d", yy, mm, dd);
		    break;
		  case 6: // time [hh.mm.ss]
		    //hms(time(), 1, h, m, s, c);//BIT_ROUND_SEC
		    //sprintf(date, "%02d:%02d:%02d",h,m,s);
		    break;

		  }
	  
	  return fmtr.out().toString();
	}



}