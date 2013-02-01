package gs.moonphase;

public class Season {

	private String spring;
	private String summer;
	private String autumn;
	private String winter;
	
	public Season(int year) {
		double m1, m2, m3, m4, dSpring, dSummer, dAutumn, dWinter;
		
//		double jd = jgdates.jDay(year, month, day, hour);

		m1 = ((double) year - 2000.) / 1000.;
		m2 = m1 * m1;
		m3 = m2 * m1;
		m4 = m3 * m1;

		dSpring = 2451623.80984 + 365242.37404 * m1 + 0.05169 * m2 - 0.00411 * m3
				- 0.00057 * m4;
		dSummer = 2451716.56767 + 365241.62603 * m1 + 0.00325 * m2 + 0.00888 * m3
				- 0.00030 * m4;
		dAutumn = 2451810.21715 + 365242.01767 * m1 - 0.11575 * m2 + 0.00337 * m3
				+ 0.00078 * m4;
		dWinter = 2451900.05952 + 365242.74049 * m1 - 0.06223 * m2 - 0.00823 * m3
				+ 0.00032 * m4;

		spring = Jgdates.strGdate(dSpring, 0);
		summer = Jgdates.strGdate(dSummer, 0);
		autumn = Jgdates.strGdate(dAutumn, 0);
		winter = Jgdates.strGdate(dWinter, 0);
	}


	/**
	 * @return the vernal equinox
	 */
	public String getSpring() {
		return spring;
	}

	/**
	 * @return the summer solstice
	 */
	public String getSummer() {
		return summer;
	}

	/**
	 * @return the autumnal equinox
	 */
	public String getAutumn() {
		return autumn;
	}

	/**
	 * @return the winter solstice
	 */
	public String getWinter() {
		return winter;
	}
}

