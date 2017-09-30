package edu.uco.hsung.m04_dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class PickColorDialogFragment extends DialogFragment {
	
	/* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
	public interface PickColorListener {
        void onPickColorClick(int colorIndex, DialogFragment dialog);
	}
	
	// Use this instance of the interface to deliver action events
	PickColorListener listener;
	
	// to instantiate the NoticeDialogListener
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (PickColorListener) getActivity();
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(getActivity().toString()
                    + " must implement PickColorListener");
        }
    }
	
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pick_color)
               .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                   // The 'which' argument contains the index position
                   // of the selected item
                	   listener.onPickColorClick(which, PickColorDialogFragment.this);
               }
        });
        return builder.create();
    }
}
