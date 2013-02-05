package gs.moonphase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;


/**
 * 
 * 
 */
public class AboutDialogFragment extends DialogFragment {

//	public interface NoticeDialogListener {
//		public void onTime(int hourOfDay, int minute);
//	}
//
//	/**
//	 * Use this instance of the interface to deliver action events
//	 */
//	private NoticeDialogListener mListener = null;
//
//	/**
//	 * Set listener
//	 * 
//	 * @param listener
//	 */
//	public void setNoticeDialogListener(NoticeDialogListener listener) {
//		mListener = listener;
//	}
//
//	private int mHour;
//	private int mMinute;
//
//	public void setDate(int hour, int minute) {
//		mHour = hour;
//		mMinute = minute;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * android.support.v4.app.DialogFragment#onCreateDialog(android.os.Bundle)
//	 */
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.AboutTitle)
        .setIcon(R.drawable.ic_launcher)
        .setMessage(R.string.About)
               .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {

                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}