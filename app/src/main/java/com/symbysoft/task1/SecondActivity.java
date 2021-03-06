package com.symbysoft.task1;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class SecondActivity extends Activity implements RadioGroup.OnCheckedChangeListener
{

	public static final String TAG = ".SecondActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);

		RadioGroup rg = (RadioGroup) findViewById(R.id.layout_second_rg);
		for (ImageView.ScaleType t : ImageView.ScaleType.values())
		{
			RadioButton rb = new RadioButton(this);
			rb.setText(String.valueOf(t.ordinal()));
			rb.setTag(t);
			rg.addView(rb);
		}
		rg.check(((RadioButton) rg.getChildAt(0)).getId());

		rg.setOnCheckedChangeListener(this);

		Button btn_back = (Button) findViewById(R.id.btn_second_back_activity);
		btn_back.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				OnBtnBackClick(v);
			}
		});

	}

	public void OnBtnBackClick(View view)
	{
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId)
	{
		Log.e(TAG, "changed: " + String.valueOf(checkedId));

		ImageView img_view = (ImageView) findViewById(R.id.img_view_second);
		View rb = group.findViewById(checkedId);
		if (rb != null)
		{
			img_view.setScaleType((ImageView.ScaleType) rb.getTag());
		}
	}
}
