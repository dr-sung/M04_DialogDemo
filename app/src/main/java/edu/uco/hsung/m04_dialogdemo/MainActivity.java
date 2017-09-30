package edu.uco.hsung.m04_dialogdemo;


import android.app.Activity;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements
        FireMissilesDialogFragment.FireMissilesListener,
        PickColorDialogFragment.PickColorListener,
        PickToppingsDialogFragment.PickToppingsListener,
        CustomLayoutDialogFragment.CustomLayoutListener {

    private TextView textview;
    private static final String TAG = "UIDialogDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.textview);

        Button buttonFire = (Button) findViewById(R.id.fire_button);
        buttonFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FireMissilesDialogFragment d = new FireMissilesDialogFragment();
                d.show(getFragmentManager(), "missiles");
            }
        });

        Button buttonColor = (Button) findViewById(R.id.color_button);
        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickColorDialogFragment d = new PickColorDialogFragment();
                d.show(getFragmentManager(), "colors");
            }
        });

        Button buttonToppings = (Button) findViewById(R.id.topping_button);
        buttonToppings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickToppingsDialogFragment d = new PickToppingsDialogFragment();
                d.show(getFragmentManager(), "toppings");
            }
        });

        Button buttonCustom = (Button) findViewById(R.id.custom_button);
        buttonCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomLayoutDialogFragment d = new CustomLayoutDialogFragment();
                d.show(getFragmentManager(), "custom");
            }
        });
    }

    @Override
    public void onFireMissilesDialogPositiveClick(DialogFragment dialog) {
        textview.setText(R.string.fire_message);
    }

    @Override
    public void onFireMissilesDialogNegativeClick(DialogFragment dialog) {
        textview.setText(R.string.cancel_fire_message);
    }

    @Override
    public void onPickColorClick(int colorIndex, DialogFragment dialog) {
        Resources res = getResources();
        String color = res.getStringArray(R.array.colors_array)[colorIndex];
        String text = String.format(res.getString(R.string.color_pick_message), color);
        textview.setText(text);
    }

    @Override
    public void onPickToppingsDialogPositiveClick(ArrayList<Integer> items,
                                                  DialogFragment dialog) {
        Resources res = getResources();
        String[] toppings = res.getStringArray(R.array.toppings);

        String selectedItems = "";
        for (int i = 0; i < items.size(); i++) {
            selectedItems += toppings[items.get(i)] + " ";
        }

        String text = String.format(res.getString(R.string.topping_pick_message), selectedItems);
        textview.setText(text);
    }

    @Override
    public void onPickToppingsDialogNegativeClick(DialogFragment dialog) {
        textview.setText(R.string.cancel_pick_message);
    }

    @Override
    public void onCustomLayoutDialogPositiveClick(String username,
                                                  String password, DialogFragment dialog) {
        String text = String.format(getResources().getString(R.string.user_info),
                                username, password);
        textview.setText(text);
    }

    @Override
    public void onCustomLayoutDialogNegativeClick(DialogFragment dialog) {
        textview.setText(R.string.cancel_signin);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

}