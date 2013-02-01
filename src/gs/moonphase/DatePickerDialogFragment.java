package gs.moonphase;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

/**
 * 
 * 
 */
public class DatePickerDialogFragment extends DialogFragment implements
		OnDateSetListener {

	public interface NoticeDialogListener {
		public void onDate(int year, int month, int day);
	}

	/**
	 * Use this instance of the interface to deliver action events
	 */
	private NoticeDialogListener mListener = null;

	/**
	 * Set listener
	 * 
	 * @param listener
	 */
	public void setNoticeDialogListener(NoticeDialogListener listener) {
		mListener = listener;
	}

    private int mYear;
    private int mMonth;
    private int mDay;

	public void setDate(int year, int month, int day) {
	    mYear = year;
	    mMonth = month;
	    mDay = day;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.DialogFragment#onCreateDialog(android.os.Bundle)
	 */
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, mYear, mMonth, mDay);
	}

	@Override
	public void onDateSet(DatePicker view, int year, int month, int day) {
		// Log.i(getTag(), "Data : " + year + "-" + month+1 + "-" + day);
		mListener.onDate(year, month, day); 
	}

}

