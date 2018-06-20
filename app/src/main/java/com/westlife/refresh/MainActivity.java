package com.westlife.refresh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startExpandable(View view) {
        startActivity(new Intent(this, ExpandableViewActivity.class));
    }

    public void startGird(View view) {
        startActivity(new Intent(this, GridActivity.class));
    }

    public void startImage(View view) {
        startActivity(new Intent(this, ImageActivity.class));
    }

    public void startList(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void startRecycler(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void startScroll(View view) {
        startActivity(new Intent(this, ScrollViewActivity.class));
    }

    public void startText(View view) {
        startActivity(new Intent(this, TextViewActivity.class));
    }

    public void startWeb(View view) {
        startActivity(new Intent(this, WebViewActivity.class));
    }
}
