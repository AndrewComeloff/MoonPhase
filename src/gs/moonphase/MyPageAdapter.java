package gs.moonphase;

import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.viewpagerindicator.TitleProvider;


public class MyPageAdapter extends PagerAdapter implements TitleProvider{
	
	List<View> views = null;
 
//	static String phase, equinox, easter;
//	public void some_method(Context context) {
//		   context.getResources();
//		   phase = context.getString(R.string.phase_moon);
//		   equinox = context.getString(R.string.equinox);
//		   easter = context.getString(R.string.easter);
//		}
//	Activity context;	
//	Resources res = context.getResources();
	
//	Resources.getSystem().getStringArray(R.array.strArrayTabs);
//	String[] strArrayTabs = res.getStringArray(R.array.strArrayTabs);
	
	private static String[] titles = new String[]
		    {
				"Фазы",
				"Равноденствие",
				"Пасха"
		    };
		 
		    public MyPageAdapter(Context ctx, List<View> inViews )
		    {
		    	Resources res = ctx.getResources();
		    	titles = res.getStringArray(R.array.strArrayTabs);
		    	views = inViews;
		    }
		 
		    public String getTitle( int position )
		    {
		        return titles[ position ];
		    }
		 
		    @Override
		    public int getCount()
		    {
		        return titles.length;
		    }
		 
		    @Override
		    public Object instantiateItem( View pager, int position )
		    {
		        View v = views.get(position );
		        ((ViewPager)pager).addView( v, 0);
		        return v;
		    }
		 
		    @Override
		    public void destroyItem( View pager, int position, Object view )
		    {
		        ((ViewPager)pager).removeView( (View)view );
		    }
		 
		    @Override
		    public boolean isViewFromObject( View view, Object object )
		    {
		        return view.equals( object );
		    }
		 
		    @Override
		    public void finishUpdate( View view ) {}
		 
		    @Override
		    public void restoreState( Parcelable p, ClassLoader c ) {}
		 
		    @Override
		    public Parcelable saveState() {
		        return null;
		    }
		 
		    @Override
		    public void startUpdate( View view ) {}
    
}