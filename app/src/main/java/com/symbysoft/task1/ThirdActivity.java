package com.symbysoft.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class ThirdActivity extends Activity implements AdapterView.OnItemSelectedListener {
    public static final String TAG = ".ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_third);

        Spinner spinner = (Spinner)findViewById(R.id.third_spinner);

        SampleSpinnerAdapter spinnerArrayAdapter = new SampleSpinnerAdapter(this);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void OnBtnBackClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.e(TAG, "changed: " + String.valueOf(id));
        ImageView img_view = (ImageView)findViewById(R.id.img_view_third);
        img_view.setScaleType(ImageView.ScaleType.values()[(int)id]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.e(TAG, "onNothingSelected");
    }
}
