package gs.moonphase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.viewpagerindicator.TitlePageIndicator;

public class MainActivity extends FragmentActivity implements DatePickerDialogFragment.NoticeDialogListener,
TimePickerDialogFragment.NoticeDialogListener{

	final String LOG_TAG = "myLogs";
	
	final int MENU_ABOUT_ID = 1;
	final int MENU_QUIT_ID = 2;

	final int DIALOG_DATE = 1;
	final int DIALOG_TIME = 2; 

	final String CAUNT_YEAR = "caunt_year";
	final String CAUNT_MONTH = "caunt_month";
	final String CAUNT_DAY = "caunt_day";
	final String CAUNT_HOUR = "caunt_hour";
	final String CAUNT_MINUTE = "caunt_minute";
	final String CAUNT_POSITION = "caunt_position";
	final String VISIBILITY_VIEWPAGER = "visibility_viewpager";
	
	int year, month, day, h, m, s;

	double hour, jDate, iEtDay, iEtHour, iEtMinute, iEtSecond;

	int position;

	EditText etDate, etTime;
	Button btn;
	boolean isVisibleViewpager;
	
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
	Animation animScale; 
	
	List<View> views;
	
	String test;///////////////

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

		if (year == 0){
			
			// get the current date
			final Calendar c = Calendar.getInstance();
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH);
			day = c.get(Calendar.DAY_OF_MONTH);
			h = c.get(Calendar.HOUR_OF_DAY);
			m = c.get(Calendar.MINUTE);			
		} 
		
		// display the current date
		updateDisplay();
				
		animScale = AnimationUtils.loadAnimation(this, R.anim.anim_combo);
		iMoon.startAnimation(animScale);
		
		if (isVisibleViewpager){
			calulate();
		}
		Log.d(LOG_TAG, "savedInstanceState" + savedInstanceState 
				+ "\nyear = " + year + "\nisVisibleViewpager" 
				+ isVisibleViewpager + "\ntest = " + test);

		
		test = "testing"; ////////////////////
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, MENU_ABOUT_ID, 0, "About");
		menu.add(0, MENU_QUIT_ID, 0, "Exit");		
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case MENU_ABOUT_ID:
			AboutDialogFragment dlg = new AboutDialogFragment();			
			dlg.show(getSupportFragmentManager(),
					"AboutPickerDialogFragment");
			break;
		case MENU_QUIT_ID:
			// exit
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void clickDate(View v) {
		DatePickerDialogFragment dlg = new DatePickerDialogFragment();
		dlg.setNoticeDialogListener(MainActivity.this);
		dlg.setDate(year, month, day);
		dlg.show(getSupportFragmentManager(),
				"DatePickerDialogFragment");
	}
	
	public void clickTime(View v) {
		TimePickerDialogFragment dlg = new TimePickerDialogFragment();
		dlg.setNoticeDialogListener(MainActivity.this);
		dlg.setDate(h, m);
		dlg.show(getSupportFragmentManager(),
				"TimePickerDialogFragment");
	}
	
	public void clickRes(View v) {
		calulate();
	}

	private void calulate(){
		LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        
        View page1 = inflater.inflate(R.layout.one, null);
        views.add(page1);
        
        View page2 = inflater.inflate(R.layout.two, null);
        views.add(page2);
        
        View page3 = inflater.inflate(R.layout.three, null);
        views.add(page3);
        
        MyPageAdapter adapter = new MyPageAdapter(this, views);
        ViewPager pager = (ViewPager)findViewById( R.id.viewpager );
        TitlePageIndicator indicator = (TitlePageIndicator)findViewById( R.id.indicator );
        pager.setAdapter( adapter );        
        indicator.setViewPager( pager );
        
        indicator.onPageSelected(position);  
        pager.setCurrentItem(position);
        
      //We set this on the indicator, NOT the pager
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            	MainActivity.this.position = position;
//                Toast.makeText(MainActivity.this, "Changed to page " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        
        
        pager.setVisibility(1);
        isVisibleViewpager = true;
		
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
		
		LinearLayout llbg =(LinearLayout) findViewById(R.id.llupBG);
		llbg.setVisibility(1);
		anim.stop();
		iMoon.setBackgroundResource(R.drawable.moon01);
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

	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	  super.onSaveInstanceState(savedInstanceState);
	  // Save UI state changes to the savedInstanceState.
	  // This bundle will be passed to onCreate if the process is
	  // killed and restarted.
	  savedInstanceState.putInt(CAUNT_YEAR, year);
	  savedInstanceState.putInt(CAUNT_MONTH, month);
	  savedInstanceState.putInt(CAUNT_DAY, day);
	  savedInstanceState.putInt(CAUNT_HOUR, h);
	  savedInstanceState.putInt(CAUNT_MINUTE, m);
	  savedInstanceState.putInt(CAUNT_POSITION, position);
	  savedInstanceState.putBoolean(VISIBILITY_VIEWPAGER, isVisibleViewpager);
	  savedInstanceState.putString("test", test);
	  // etc.
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
	  super.onRestoreInstanceState(savedInstanceState);
	  // Restore UI state from the savedInstanceState.
	  // This bundle has also been passed to onCreate.
	  year = savedInstanceState.getInt(CAUNT_YEAR);
	  month = savedInstanceState.getInt(CAUNT_MONTH);
	  day = savedInstanceState.getInt(CAUNT_DAY);
	  h = savedInstanceState.getInt(CAUNT_HOUR);
	  m = savedInstanceState.getInt(CAUNT_MINUTE);
	  position = savedInstanceState.getInt(CAUNT_POSITION);
	  isVisibleViewpager = savedInstanceState.getBoolean(VISIBILITY_VIEWPAGER);
	  test = savedInstanceState.getString("test");
	}
}
