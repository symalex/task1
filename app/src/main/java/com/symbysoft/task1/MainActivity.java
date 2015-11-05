package com.symbysoft.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

    public void OnBtnSecondClick(View view)
    {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void OnBtnThirdClick(View view) {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }
}
