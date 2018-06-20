package com.westlife.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chenzhi.refresh.PullToRefreshLayout;
import com.chenzhi.refresh.PullableListView;
import com.chenzhi.refresh.PullableRecyclerView;
import com.westlife.refresh.adapter.RecyclerAdapter;
import com.westlife.refresh.utils.DataUtils;

/**
 * Created by chenzhi on 2018/6/20 0020.
 */

public class RecyclerViewActivity extends AppCompatActivity implements PullToRefreshLayout.OnRefreshListener{

    private PullToRefreshLayout mRefreshView;
    Handler handler= new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        setTitle("RecyclerViewActivity");

        mRefreshView = findViewById(R.id.refresh_view);
        mRefreshView.setOnRefreshListener(this);

        PullableRecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new RecyclerAdapter(this));
    }

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(RecyclerViewActivity.this, "刷新结束", Toast.LENGTH_SHORT).show();
            }
        },1000);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(RecyclerViewActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        },1000);
    }
}
