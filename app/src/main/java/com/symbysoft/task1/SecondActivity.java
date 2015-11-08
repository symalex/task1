package com.symbysoft.task1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class SecondActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    public static final String TAG = ".SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);

        RelativeLayout l = (RelativeLayout)findViewById(R.id.layout_second);
        final RadioButton[] rb = new RadioButton[ImageView.ScaleType.values().length];
        RadioGroup rg = new RadioGroup(this);
        rg.setGravity(Gravity.BOTTOM);
        rg.setOrientation(RadioGroup.HORIZONTAL);
        RelativeLayout.LayoutParams rg_params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );
        rg.setLayoutParams(rg_params);
        rg.setOnCheckedChangeListener(this);
        for(int i=0; i<ImageView.ScaleType.values().length; i++){
            rb[i]  = new RadioButton(this);
            rb[i].setText(String.valueOf(i));
            rb[i].setId(i+1);
            rg.addView(rb[i]);
        }
        rb[0].setChecked(true);
        l.addView(rg);
    }

    public void OnBtnBackClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.e(TAG, "changed: " + String.valueOf(checkedId));
        ImageView img_view = (ImageView)findViewById(R.id.img_view_second);
        img_view.setScaleType(ImageView.ScaleType.values()[checkedId-1]);
    }
}
