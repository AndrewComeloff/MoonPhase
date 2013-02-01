package gs.moonphase;

import java.util.Formatter;

public class Calc {
	
	private String newMoon;
	private String firstQuarter;
	private String fullMoon;
	private String thirdQuarter;
	private String nextNewMoon;
	private String julianDate;
	private String phase;
	private String age;
	
	private double ageDay;
	
	public Calc(int Y, int M, int D, double H) {
		double[] phases = new double[5];
		Formatter fmtr = new Formatter();

		RefDouble pphaseR = new RefDouble();
		RefDouble mageR = new RefDouble();
		RefDouble distR = new RefDouble();
		RefDouble angdiaR = new RefDouble();
		RefDouble sudistR = new RefDouble();
		RefDouble suangdiaR = new RefDouble();

		double jd = Jgdates.jDay(Y, M, D, H);

		Phase.phase(jd, pphaseR, mageR, distR, angdiaR, sudistR, suangdiaR);
		ageDay = (double) mageR.val;
		int aom_d = (int) mageR.val;
//		Log.d("myLogs", "mageR" + mageR);
		int aom_h = (int) (24 * (mageR.val - Math.floor(mageR.val)));
//		Log.d("myLogs", "Math.floor(mageR.val)-" + Math.floor(mageR.val) + "   mageR.val-" + mageR.val);
		int aom_m = (int) (1440 * (mageR.val - Math.floor(mageR.val))) % 60;

		julianDate = jd + "";

		phase = (int) (pphaseR.val * 100) + "%";

		fmtr.format("%02d дн, %02d час, %02d мин", aom_d, aom_h, aom_m);
		age = fmtr.out().toString();

		Phase.phasehunt5(jd, phases);

		newMoon = Jgdates.strGdate(phases[0], 0);
		firstQuarter = Jgdates.strGdate(phases[1], 0);
		fullMoon = Jgdates.strGdate(phases[2], 0);
		thirdQuarter = Jgdates.strGdate(phases[3], 0);
		nextNewMoon = Jgdates.strGdate(phases[4], 0);	
		
	}

	/**
	 * @return new Moon
	 */
	public String getNewMoon() {
		return newMoon;
	}
	
	/**
	 * @return first quarter of the Moon
	 */
	public String getFirstQuarter() {
		return firstQuarter;
	}

	/**
	 * @return full the Moon
	 */
	public String getFullMoon() {
		return fullMoon;
	}

	/**
	 * @return third quarter of the Moon
	 */
	public String getThirdQuarter() {
		return thirdQuarter;
	}
	
	/**
	 * @return next new Moon
	 */
	public String getNextNewMoon() {
		return nextNewMoon;
	}
	
	/**
	 * @return the Julian date
	 */
	public String getJulianDate() {
		return julianDate;
	}
	
	/**
	 * @return phases
	 */
	public String getPhase() {
		return phase;
	}
	
	/**
	 * @return age of the Moon
	 */
	public String getAge() {
		return age;
	}
	
	/**
	 * @return age of the Moon in days
	 */
	public double getAgeJul() {
		return ageDay;
	}
}

	
	
	
	
	
	
	
	
//	public static void CalcPhases(int Y, int M, int D, double H) {
//		double[] phases = new double[5];
//		Formatter fmtr = new Formatter();
//
//		RefDouble pphaseR = new RefDouble();
//		RefDouble mageR = new RefDouble();
//		RefDouble distR = new RefDouble();
//		RefDouble angdiaR = new RefDouble();
//		RefDouble sudistR = new RefDouble();
//		RefDouble suangdiaR = new RefDouble();
//
//		double jd = jgdates.jDay(Y, M, D, H);
//
//		Phase.phase(jd, pphaseR, mageR, distR, angdiaR, sudistR, suangdiaR);
//		age = (double) mageR.val;
//		int aom_d = (int) mageR.val;
//		Log.d("myLogs", "mageR" + mageR);
//		int aom_h = (int) (24 * (mageR.val - Math.floor(mageR.val)));
//		Log.d("myLogs", "Math.floor(mageR.val)-" + Math.floor(mageR.val) + "   mageR.val-" + mageR.val);
//		int aom_m = (int) (1440 * (mageR.val - Math.floor(mageR.val))) % 60;
//
//		MainActivity.tvJdateRes.setText(jd + "");
//
//		MainActivity.tvPhaseRes.setText((int) (pphaseR.val * 100) + "%");
//
//		fmtr.format("%02d дн, %02d час, %02d мин", aom_d, aom_h, aom_m);
//		MainActivity.tvAgeRes.setText(fmtr.out().toString());
//
//		Phase.phasehunt5(jd, phases);
//
//		MainActivity.tvNewMoonRes.setText(jgdates.strGdate(phases[0], 0));
//		MainActivity.tv1QuarterRes.setText(jgdates.strGdate(phases[1], 0));
//		MainActivity.tvFullMoonRes.setText(jgdates.strGdate(phases[2], 0));
//		MainActivity.tv3QuarterRes.setText(jgdates.strGdate(phases[3], 0));
//		MainActivity.tvNewMoon2Res.setText(jgdates.strGdate(phases[4], 0));
//	}
//
//}
