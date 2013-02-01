package gs.moonphase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.viewpagerindicator.TitlePageIndicator;

public class MainActivity extends FragmentActivity implements DatePickerDialogFragment.NoticeDialogListener,
TimePickerDialogFragment.NoticeDialogListener{

	final String LOG_TAG = "myLogs";

	final int DIALOG_DATE = 1;
	final int DIALOG_TIME = 2; 
	int year, month, day, h, m, s;

	double hour, jDate, iEtDay, iEtHour, iEtMinute, iEtSecond;
	String date;

	Date d;

	EditText etDate, etTime;
	Button btn;
	
	private TextView tvJdateRes;
	private TextView tvPhaseRes;
	private TextView tvAgeRes;
	private TextView tvNewMoonRes;
	private TextView tv1QuarterRes;
	private TextView tvFullMoonRes;
	private TextView tv3QuarterRes;
	private TextView tvNextNewMoonRes;
	private TextView tvEasterOrthodoxRes;
	private TextView tvEasterCatholicRes;
	
	private TextView tvSpring;
	private TextView tvSummer;
	private TextView tvAutumn;
	private TextView tvWinter;
	
	TableLayout tlInfoPhase, tlInfoSeason;
	
	public static ImageView iMoon;
	
	AnimationDrawable anim;
	
	List<View> views;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		etDate = (EditText) findViewById(R.id.etDate);
		etTime = (EditText) findViewById(R.id.etTime);
		btn = (Button) findViewById(R.id.btn);

		iMoon = (ImageView)findViewById(R.id.iMoon);
		
		iMoon.setBackgroundResource(R.drawable.moon);
		
		anim = (AnimationDrawable)iMoon.getBackground(); 
		anim.start();

		
		// get the current date
				final Calendar c = Calendar.getInstance();
				year = c.get(Calendar.YEAR);
				month = c.get(Calendar.MONTH);
				day = c.get(Calendar.DAY_OF_MONTH);
				h = c.get(Calendar.HOUR_OF_DAY);
				m = c.get(Calendar.MINUTE);
				

				// display the current date
				updateDisplay();

//		d = new Date();
//		String format = "yyyy-MM-dd";
//		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
//		etDate.setText(sdf.format(d));
//		
//		d = new Date();
//		format = "HH:mm";
//		sdf = new SimpleDateFormat(format, Locale.getDefault());
//		etTime.setText(sdf.format(d));
//
//		sdf = new SimpleDateFormat("y");
//		date = sdf.format(d);
//		year = Integer.parseInt(date);
//		Log.d(LOG_TAG, "Year = " + year);
//
//		sdf = new SimpleDateFormat("M");
//		date = sdf.format(d);
//		month = Integer.parseInt(date);
//		Log.d(LOG_TAG, "Month = " + month);
//
//		sdf = new SimpleDateFormat("d");
//		date = sdf.format(d);
//		day = Integer.parseInt(date);
//		Log.d(LOG_TAG, "Day = " + day);
//
//		sdf = new SimpleDateFormat("H");
//		date = sdf.format(d);
//		h = Integer.parseInt(date);
//		Log.d(LOG_TAG, "Hour = " + h);
//
//		sdf = new SimpleDateFormat("m");
//		date = sdf.format(d);
//		m = Integer.parseInt(date);
//		Log.d(LOG_TAG, "Minutes = " + m);
//
//		sdf = new SimpleDateFormat("s");
//		date = sdf.format(d);
//		s = Integer.parseInt(date);
//		Log.d(LOG_TAG, "Second = " + s);  
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void clickDate(View v) {
		DatePickerDialogFragment dlg = new DatePickerDialogFragment();
		dlg.setNoticeDialogListener(MainActivity.this);
		dlg.setDate(year, month, day);
		dlg.show(getSupportFragmentManager(),
				"DatePickerDialogFragment");
//		showDialog(DIALOG_DATE);
	}
	
	public void clickTime(View v) {
		TimePickerDialogFragment dlg = new TimePickerDialogFragment();
		dlg.setNoticeDialogListener(MainActivity.this);
		dlg.setDate(h, m);
		dlg.show(getSupportFragmentManager(),
				"DatePickerDialogFragment");
//		showDialog(DIALOG_TIME);
	}
	
	public void clickRes(View v) {
		
		LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        
        View page1 = inflater.inflate(R.layout.one, null);
        views.add(page1);
        
        View page2 = inflater.inflate(R.layout.two, null);
        views.add(page2);
        
        View page3 = inflater.inflate(R.layout.three, null);
        views.add(page3);
        
        MyPageAdapter adapter = new MyPageAdapter(views);
        ViewPager pager = (ViewPager)findViewById( R.id.viewpager );
        TitlePageIndicator indicator = (TitlePageIndicator)findViewById( R.id.indicator );
        pager.setAdapter( adapter );
        indicator.setViewPager( pager );
        
        pager.setVisibility(1);
		
		tvJdateRes = (TextView) page1.findViewById(R.id.tvJDateRes);
		tvPhaseRes = (TextView) page1.findViewById(R.id.tvPhaseRes);
		tvAgeRes = (TextView) page1.findViewById(R.id.tvAgeRes);
		tvNewMoonRes = (TextView) page1.findViewById(R.id.tvNewMoonRes);
		tv1QuarterRes = (TextView) page1.findViewById(R.id.tv1quarterRes);
		tvFullMoonRes = (TextView) page1.findViewById(R.id.tvFullMoonRes);
		tv3QuarterRes = (TextView) page1.findViewById(R.id.tv3quarterRes);
		tvNextNewMoonRes = (TextView) page1.findViewById(R.id.tvNextNewMoonRes);
		tvEasterOrthodoxRes = (TextView) page3.findViewById(R.id.tvEasterOrthodoxRes);
		tvEasterCatholicRes = (TextView) page3.findViewById(R.id.tvEasterCatholicRes);
		tvSpring = (TextView) page2.findViewById(R.id.tvSpringRes);
		tvSummer = (TextView) page2.findViewById(R.id.tvSummerRes);
		tvAutumn = (TextView) page2.findViewById(R.id.tvAutumnRes);
		tvWinter = (TextView) page2.findViewById(R.id.tvWinterRes);
		
		hour = Jgdates.hhh(h, m, s);		
		
		Calc calc = new Calc(year, month, day, hour);
		tvJdateRes.setText(calc.getJulianDate());
		tvPhaseRes.setText(calc.getPhase());
		tvAgeRes.setText(calc.getAge());
		tvNewMoonRes.setText(calc.getNewMoon());
		tv1QuarterRes.setText(calc.getFirstQuarter());
		tvFullMoonRes.setText(calc.getFullMoon());
		tv3QuarterRes.setText(calc.getThirdQuarter());
		tvNextNewMoonRes.setText(calc.getNextNewMoon());		
		
		Season season = new Season(year);		
		tvSpring.setText(season.getSpring());
		tvSummer.setText(season.getSummer());
		tvAutumn.setText(season.getAutumn());
		tvWinter.setText(season.getWinter());
		
		tvEasterOrthodoxRes.setText(Easter.easterOrthodox(year));
		tvEasterCatholicRes.setText(Easter.easterCatholic(year));
		
//		anim.stop();
//		iMoon.setBackgroundResource(R.drawable.moon01);
		Anim.anim(calc.getAgeJul());
	}

	@Override
	public void onDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		updateDisplay();
	}
	
	@Override
	public void onTime(int hourOfDay, int minute) {
		h = hourOfDay;
		m = minute;
		updateDisplay();
	}

	private void updateDisplay() {
		etDate.setText(new StringBuilder()
		// Month is 0 based so add 1
		.append(pad(day)).append(".").append(pad(month + 1)).append(".")
		.append(year));
		etTime.setText(new StringBuilder().append(pad(h)).append(":")
				.append(pad(m)));
	}
	
	private static String pad(int c) {
		if (c >= 10)
			return String.valueOf(c);
		else
			return "0" + String.valueOf(c);
	}



//	protected Dialog onCreateDialog(int id) {
//		switch (id) {
//		case DIALOG_DATE:
//			DatePickerDialog dpd = new DatePickerDialog(this, callBackDate, year,
//					month-1, day);
//			
//			return dpd;
//		case DIALOG_TIME:
//			TimePickerDialog tpd = new TimePickerDialog(this, callBackTime, h, m, true);
//			return tpd;			
//		}
//
//		return super.onCreateDialog(id);
//	}
//
//	OnDateSetListener callBackDate = new OnDateSetListener() {
//
//		public void onDateSet(DatePicker view, int thisYear, int monthOfYear,
//				int dayOfMonth) {
//			
//			year = thisYear;
//			month = monthOfYear + 1 ;
//			day = dayOfMonth;
//			etDate.setText(year + "-" + month + "-" + day);
//		}
//	};
//	
//	OnTimeSetListener callBackTime = new OnTimeSetListener() {
//		
//		@Override
//		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//			h = hourOfDay;
//			m = minute;
//			etTime.setText(hourOfDay + ":" + minute);
//			
//		}
//	};
}
