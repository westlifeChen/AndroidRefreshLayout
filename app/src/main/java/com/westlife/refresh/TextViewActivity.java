package com.westlife.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

import com.chenzhi.refresh.PullToRefreshLayout;
import com.chenzhi.refresh.PullableImageView;
import com.chenzhi.refresh.PullableTextView;

/**
 * Created by chenzhi on 2018/6/20 0020.
 */

public class TextViewActivity extends AppCompatActivity implements PullToRefreshLayout.OnRefreshListener {

    private PullToRefreshLayout mRefreshView;
    Handler handler = new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        setTitle("TextViewActivity");

        mRefreshView = findViewById(R.id.refresh_view);
        PullableTextView textView = findViewById(R.id.text_view);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(36);

        textView.setText("我是文字，支持刷新加载");

        mRefreshView.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(TextViewActivity.this, "刷新结束", Toast.LENGTH_SHORT).show();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(TextViewActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        }, 1000);
    }
}
