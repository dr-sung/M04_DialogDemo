package edu.uco.hsung.m04_dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class FireMissilesDialogFragment extends DialogFragment {
	
	/* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
	public interface FireMissilesListener {
        void onFireMissilesDialogPositiveClick(DialogFragment dialog);
        void onFireMissilesDialogNegativeClick(DialogFragment dialog);
	}
	
	// Use this instance of the interface to deliver action events
	FireMissilesListener listener;
	
	// to instantiate the NoticeDialogListener
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (FireMissilesListener) getActivity();
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(getActivity().toString()
                    + " must implement FireMissilesListener");
        }
    }
	
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_fire_missiles)
               .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       listener.onFireMissilesDialogPositiveClick(FireMissilesDialogFragment.this);
                   }
               })
               .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       listener.onFireMissilesDialogNegativeClick(FireMissilesDialogFragment.this);
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
