package gs.moonphase;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

/**
 * 
 * 
 */
public class TimePickerDialogFragment extends DialogFragment implements
		TimePickerDialog.OnTimeSetListener {

	public interface NoticeDialogListener {
		public void onTime(int hourOfDay, int minute);
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

	private int mHour;
	private int mMinute;

	public void setDate(int hour, int minute) {
		mHour = hour;
		mMinute = minute;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.DialogFragment#onCreateDialog(android.os.Bundle)
	 */
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Create a new instance of TimePickerDialog and return it
		return new TimePickerDialog(getActivity(), this, mHour, mMinute,
				DateFormat.is24HourFormat(getActivity()));
	}

	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		// Log.i(getTag(), "Data : " + year + "-" + month+1 + "-" + day);
		mListener.onTime(hourOfDay, minute); 
	}
}
