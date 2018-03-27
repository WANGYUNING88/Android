package com.example.publicnumber;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2018/3/24.
 */

public class Data {
    public static List<Map<String,Object>> setData(){
        List<Map<String, Object>> dataSource = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("img",R.drawable.java);
        map1.put("tittle","三张图彻底了解Java中字符的不变性");
        map1.put("context","一针见血");
        map1.put("time","昨天18:40");
        dataSource.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("img",R.drawable.android);
        map2.put("tittle","谷歌离职员工:谁能从谷歌手里偷走Android");
        map2.put("context","Steve Yegge 写下了这篇《Who will steal Android from Google》");
        map2.put("time","昨天00:00");
        dataSource.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("img",R.drawable.gongdu);
        map3.put("tittle","程序员面对烧脑刑侦科推理题一秒解");
        map3.put("context","程序员在恐慌什么");
        map3.put("time","昨天12:30");
        dataSource.add(map3);
        return dataSource;
    }

}
