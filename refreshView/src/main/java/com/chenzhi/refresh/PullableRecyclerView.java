package com.chenzhi.refresh;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 这世上有三样东西是别人抢不走的：
 * 一是吃进胃里的食物，
 * 二是藏在心中的梦想，
 * 三是读进大脑的书。
 * Created by chenzhi on 2017/3/24 0024.
 */

public class PullableRecyclerView extends RecyclerView implements Pullable {


    public PullableRecyclerView(Context context) {
        super(context);
    }

    public PullableRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) getLayoutManager();
        if (layoutManager.getItemCount() == 0) {
            return false;
        } else if (layoutManager.findLastVisibleItemPosition() == 0
                && getChildAt(0).getTop() >= 0) {
            // 滑到ListView的顶部了
            return true;
        } else
            return true;
    }

    @Override
    public boolean canPullUp() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) getLayoutManager();
        if (layoutManager.getItemCount() == 0) {
            // 没有item的时候也可以上拉加载
            return true;
        } else if (layoutManager.findLastVisibleItemPosition() == (layoutManager.getItemCount() - 1)) {
            // 滑到底部了
            if (getChildAt(layoutManager.findLastVisibleItemPosition() - layoutManager.findLastVisibleItemPosition()) != null
                    && getChildAt(
                    layoutManager.findLastVisibleItemPosition()
                            - layoutManager.findLastVisibleItemPosition()).getBottom() <= getMeasuredHeight())
                return true;
        }
        return false;
    }
}
