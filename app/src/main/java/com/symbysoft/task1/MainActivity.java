package com.symbysoft.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        Button btn_second = (Button)findViewById(R.id.btn_second_activity);
        btn_second.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OnBtnSecondClick(v);
            }
        });

        Button btn_third = (Button)findViewById(R.id.btn_third_activity);
        btn_third.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OnBtnThirdClick(v);
            }
        });

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
