package com.westlife.refresh.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chenzhi.refresh.PullableExpandableListView;
import com.westlife.refresh.utils.DataUtils;

import java.util.List;

/**
 * Created by chenzhi on 2018/6/20 0020.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context mContext;

    public ExpandableListViewAdapter(Context context) {
        this.mContext=context;
    }

    //  获得父项的数量
    @Override
    public int getGroupCount() {
        return DataUtils.groupStrings.length;
    }

    //  获得某个父项的子项数目
    @Override
    public int getChildrenCount(int groupPosition) {
        return DataUtils.childStrings[groupPosition].length;
    }

    //  获得某个父项
    @Override
    public Object getGroup(int groupPosition) {
        return DataUtils.groupStrings[groupPosition];
    }

    //  获得某个父项的某个子项
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return DataUtils.childStrings[groupPosition][childPosition];
    }

    //  获得某个父项的id
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //  获得某个父项的某个子项的id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //  按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
    @Override
    public boolean hasStableIds() {
        return false;
    }

    //  获得父项显示的view
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        textView.setHeight(90);
        textView.setTextSize(22);
        textView.setTextColor(Color.BLACK);
        textView.setGravity(Gravity.CENTER);
        textView.setText(DataUtils.groupStrings[groupPosition]);
        return textView;
    }

    //  获得子项显示的view
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        textView.setHeight(50);
        textView.setGravity(Gravity.CENTER);
        textView.setText(DataUtils.childStrings[groupPosition][childPosition]);
        return textView;
    }

    //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
