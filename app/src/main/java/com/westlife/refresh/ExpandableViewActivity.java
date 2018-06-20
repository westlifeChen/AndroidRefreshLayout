package com.westlife.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.chenzhi.refresh.PullToRefreshLayout;
import com.chenzhi.refresh.PullableExpandableListView;
import com.westlife.refresh.adapter.ExpandableListViewAdapter;

/**
 * Created by chenzhi on 2018/6/20 0020.
 */

public class ExpandableViewActivity extends AppCompatActivity implements PullToRefreshLayout.OnRefreshListener{

    private PullToRefreshLayout mRefreshView;
    Handler handler= new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_view);
        setTitle("ExpandableViewActivity");

        mRefreshView = findViewById(R.id.refresh_view);
        mRefreshView.setOnRefreshListener(this);

        PullableExpandableListView expandableView = findViewById(R.id.expandable_view);

        expandableView.setAdapter(new ExpandableListViewAdapter(this));
    }

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(ExpandableViewActivity.this, "刷新结束", Toast.LENGTH_SHORT).show();
            }
        },1000);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(ExpandableViewActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        },1000);
    }

}
