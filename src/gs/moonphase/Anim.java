package gs.moonphase;

public class Anim {

	// RefDouble mageR = new RefDouble(); // Age of the Moon.
	// double age = mageR.val;
	final static double DURATION_PHASE = 29.5305882;
	final static double DURATION_IMAGE = DURATION_PHASE / 30; // phase/30images =
																// 1,054663864285714
	// int age = (int) mageR.val*10;

	public static void anim(double age) {
		if (age > DURATION_IMAGE * 30 - 0.5 || age < DURATION_IMAGE - 0.5) {
			MainActivity.iMoon.setImageResource(R.drawable.moon01);
		}
		else if(age > DURATION_IMAGE - 0.5 && age < DURATION_IMAGE*2 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon03);
		}
		else if(age > DURATION_IMAGE*2 - 0.5 && age < DURATION_IMAGE*3 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon05);
		}
		else if(age > DURATION_IMAGE*3 - 0.5 && age < DURATION_IMAGE*4 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon07);
		}		
		else if(age > DURATION_IMAGE*4 - 0.5 && age < DURATION_IMAGE*5 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon09);
		}
		else if(age > DURATION_IMAGE*5 - 0.5 && age < DURATION_IMAGE*6 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon11);
		}
		else if(age > DURATION_IMAGE*6 - 0.5 && age < DURATION_IMAGE*7 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon13);
		}
		else if(age > DURATION_IMAGE*7 - 0.5 && age < DURATION_IMAGE*8 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon15);
		}
		else if(age > DURATION_IMAGE*8 - 0.5 && age < DURATION_IMAGE*9 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon17);
		}
		else if(age > DURATION_IMAGE*9 - 0.5 && age < DURATION_IMAGE*10 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon19);
		}
		else if(age > DURATION_IMAGE*10 - 0.5 && age < DURATION_IMAGE*11 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon20);
		}
		else if(age > DURATION_IMAGE*11 - 0.5 && age < DURATION_IMAGE*12 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon21);
		}
		else if(age > DURATION_IMAGE*12 - 0.5 && age < DURATION_IMAGE*13 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon22);
		}
		else if(age > DURATION_IMAGE*13 - 0.5 && age < DURATION_IMAGE*14 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon23);
		}
		else if(age > DURATION_IMAGE*14 - 0.5 && age < DURATION_IMAGE*15 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon25);
		}
		else if(age > DURATION_IMAGE*15 - 0.5 && age < DURATION_IMAGE*16 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon27);
		}
		else if(age > DURATION_IMAGE*16 - 0.5 && age < DURATION_IMAGE*17 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon29);
		}
		else if(age > DURATION_IMAGE*17 - 0.5 && age < DURATION_IMAGE*18 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon31);
		}
		else if(age > DURATION_IMAGE*18 - 0.5 && age < DURATION_IMAGE*19 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon33);
		}
		else if(age > DURATION_IMAGE*19 - 0.5 && age < DURATION_IMAGE*20 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon35);
		}
		else if(age > DURATION_IMAGE*20 - 0.5 && age < DURATION_IMAGE*21 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon37);
		}
		else if(age > DURATION_IMAGE*21 - 0.5 && age < DURATION_IMAGE*22 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon39);
		}
		else if(age > DURATION_IMAGE*22 - 0.5 && age < DURATION_IMAGE*23 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon41);
		}
		else if(age > DURATION_IMAGE*23 - 0.5 && age < DURATION_IMAGE*24 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon43);
		}
		else if(age > DURATION_IMAGE*24 - 0.5 && age < DURATION_IMAGE*25 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon45);
		}
		else if(age > DURATION_IMAGE*25 - 0.5 && age < DURATION_IMAGE*26 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon47);
		}
		else if(age > DURATION_IMAGE*26 - 0.5 && age < DURATION_IMAGE*27 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon49);
		}
		else if(age > DURATION_IMAGE*27 - 0.5 && age < DURATION_IMAGE*28 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon51);			
		}
		else if(age > DURATION_IMAGE*28 - 0.5 && age < DURATION_IMAGE*28 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon53);			
		}
		else if(age > DURATION_IMAGE*29 - 0.5 && age < DURATION_IMAGE*28 - 0.5){
			MainActivity.iMoon.setImageResource(R.drawable.moon55);			
		}
	}
}
