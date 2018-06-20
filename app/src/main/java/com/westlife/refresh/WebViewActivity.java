package com.westlife.refresh;

import android.accounts.AccountManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.chenzhi.refresh.PullToRefreshLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzhi on 2018/6/20 0020.
 */

public class WebViewActivity extends AppCompatActivity implements PullToRefreshLayout.OnRefreshListener{

    private WebView mWebView;
    private PullToRefreshLayout mRefreshView;

    Handler handler= new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        setTitle("WebViewActivity");

        mWebView = findViewById(R.id.web_view);
        mRefreshView = findViewById(R.id.refresh_view);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url == null) return false;
                try {
                    if (url.startsWith("weixin://") || url.startsWith("alipays://") || url.startsWith("taobao://") || url.startsWith("tel://")) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
                    return false;
                }

                //处理http和https开头的url
                view.loadUrl(url);
                return true;
            }
        });

        mWebView.loadUrl("http://www.baidu.com");


        //设置刷新加载监听
        mRefreshView.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(WebViewActivity.this, "刷新结束", Toast.LENGTH_SHORT).show();
            }
        },1000);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(WebViewActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        },1000);
    }
}
