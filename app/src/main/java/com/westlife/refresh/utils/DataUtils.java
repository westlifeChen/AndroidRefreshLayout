package com.westlife.refresh.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenzhi on 2018/6/20 0020.
 */

public class DataUtils {
    private static List<String> mList;

    public static String[] groupStrings = {"西游记", "水浒传", "三国演义", "红楼梦"};
    public static String[][] childStrings = {
            {"唐三藏", "孙悟空", "猪八戒", "沙和尚"},
            {"宋江", "林冲", "李逵", "鲁智深"},
            {"曹操", "刘备", "孙权", "诸葛亮", "周瑜"},
            {"贾宝玉", "林黛玉", "薛宝钗", "王熙凤"}
    };

    public static List<String> getList() {
        if (mList == null) {
            mList = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                mList.add("测试数据Item" + i);
            }
        }
        return mList;
    }
}
