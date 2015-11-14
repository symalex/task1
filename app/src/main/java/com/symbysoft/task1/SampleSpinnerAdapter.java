package com.symbysoft.task1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SampleSpinnerAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater inflater;

    static class Holder{
        TextView view;
        Holder(View v){
            this.view = (TextView)v.findViewById(R.id.spinner_item);
        }
    }

    public SampleSpinnerAdapter(Context ctx) {
        this.ctx = ctx;
        this.inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return ScaleType.values().length;
    }

    @Override
    public ImageView.ScaleType getItem(int position) {
        return ScaleType.values()[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder h;
        if( convertView == null ){
            convertView = inflater.inflate(R.layout.layout_spinner, null, false);
            h = new Holder(convertView);
            h.view.setText(String.valueOf(getItem(position)));
            convertView.setTag(h);
        }
        h = (Holder)convertView.getTag();
        h.view.setText(String.valueOf(getItem(position)));
        return convertView;
    }
}
