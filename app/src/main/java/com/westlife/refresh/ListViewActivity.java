package com.westlife.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.chenzhi.refresh.PullToRefreshLayout;
import com.chenzhi.refresh.PullableListView;
import com.westlife.refresh.adapter.MyAdapter;
import com.westlife.refresh.utils.DataUtils;

/**
 * Created by chenzhi on 2018/6/20 0020.
 */

public class ListViewActivity extends AppCompatActivity implements PullToRefreshLayout.OnRefreshListener{

    private PullToRefreshLayout mRefreshView;
    Handler handler= new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        setTitle("ListViewActivity");

        mRefreshView = findViewById(R.id.refresh_view);
        PullableListView listView = findViewById(R.id.list_view);

        listView.setAdapter(new MyAdapter(this, DataUtils.getList()));

        mRefreshView.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(ListViewActivity.this, "刷新结束", Toast.LENGTH_SHORT).show();
            }
        },1000);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(ListViewActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        },1000);
    }
}
