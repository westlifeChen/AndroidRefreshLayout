package com.westlife.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.chenzhi.refresh.PullToRefreshLayout;
import com.chenzhi.refresh.PullableGridView;
import com.westlife.refresh.adapter.MyAdapter;
import com.westlife.refresh.utils.DataUtils;

/**
 * Created by chenzhi on 2018/6/20 0020.
 */

public class GridActivity extends AppCompatActivity implements PullToRefreshLayout.OnRefreshListener{

    private PullToRefreshLayout mRefreshView;
    Handler handler= new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        setTitle("GridActivity");

        mRefreshView = findViewById(R.id.refresh_view);
        PullableGridView gridView = findViewById(R.id.grid_view);
        gridView.setNumColumns(2);

        gridView.setAdapter(new MyAdapter(this, DataUtils.getList()));

        mRefreshView.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(GridActivity.this, "刷新结束", Toast.LENGTH_SHORT).show();
            }
        },1000);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(GridActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        },1000);
    }
}
