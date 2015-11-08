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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_third);

        RelativeLayout l = (RelativeLayout)findViewById(R.id.layout_third);

        Spinner spinner = new Spinner(this);

        ArrayList<String> spinnerArray = new ArrayList<String>();
        for(int i=0; i< ImageView.ScaleType.values().length; i++) {
            spinnerArray.add(String.valueOf(ImageView.ScaleType.values()[i]));
        }

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(this);

        l.addView(spinner);
    }

    public void OnBtnBackClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.e("TAG", "changed: " + String.valueOf(id));
        ImageView img_view = (ImageView)findViewById(R.id.img_view_third);
        img_view.setScaleType(ImageView.ScaleType.values()[(int)id]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Log.e("TAG", "changed: " + String.valueOf(id));
    }
}
