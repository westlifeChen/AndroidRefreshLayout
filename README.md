# AndroidRefreshLayout
Android万能刷新加载框架，适用于所有View，可根据自己需求定制！<br>
本Demo演示如何使用通用的下拉刷新上拉加载控件，demo中已经实现了常见的需要上下拉功能的控件，其他控件如果需要加入这两个功能可自行扩展，实现Pullable接口即可

# 应用截图
<table>
    <tr>
        <td><img src="/screenshots/demo1.png"></td>
        <td><img src="/screenshots/expandable.gif"></td>
        <td><img src="/screenshots/grid.gif"></td>
    </tr>
</table>
<table>
    <tr>
        <td><img src="/screenshots/3image.gif"></td>
        <td><img src="/screenshots/web.gif"></td>
    </tr>
</table>

## 使用方法
具体使用方法以ListView为例，用法基本上都一样，很简单！

#### 布局文件声明
    <com.chenzhi.refresh.PullToRefreshLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/refresh_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <include layout="@layout/refresh_head" />
        <!-- 支持所有实现Pullable接口的View -->

        <com.chenzhi.refresh.PullableListView
            android:id="@+id/list_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

        </com.chenzhi.refresh.PullableListView>

        <include layout="@layout/load_more" />

    </com.chenzhi.refresh.PullToRefreshLayout>
    
#### 代码使用
 查找刷新控件
    mRefreshView = findViewById(R.id.refresh_view);
 设置监听
    mRefreshView.setOnRefreshListener(this);
    
 实现接口
    public class ListViewActivity extends AppCompatActivity implements PullToRefreshLayout.OnRefreshListener{
    
 覆写回调方法
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
 
