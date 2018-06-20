package com.westlife.refresh.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chenzhi on 2018/6/20 0020.
 */

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList;

    public MyAdapter(Context context, List<String> list) {
        this.mContext=context;
        this.mList=list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        textView.setHeight(120);
        textView.setGravity(Gravity.CENTER);
        textView.setText(mList.get(position));
        return textView;
    }
}
