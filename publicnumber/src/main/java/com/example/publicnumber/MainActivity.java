package com.example.publicnumber;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.publicnumber.Data.setData;

public class MainActivity extends AppCompatActivity {

    private List<Map<String, Object>> dataSource;
    private wechatAdapter wechatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EditText editText = findViewById(R.id.et);

        /*
        实现ListView
         */
        dataSource = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("avatar",R.drawable.weixin_1);
        map1.put("name","Java编程精选");
        map1.put("abstract","三张图彻底了解 Java中字符串的不...");
        map1.put("time","昨天");
        dataSource.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("avatar",R.drawable.weixin_2);
        map2.put("name","Android编程精选");
        map2.put("abstract","谷歌离职员工:谁能从谷歌手里偷走...");
        map2.put("time","昨天");
        dataSource.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("avatar",R.drawable.weixin_3);
        map3.put("name","源码共读");
        map3.put("abstract","虐哭无数人的烧脑刑侦科推理题,程...");
        map3.put("time","昨天");
        dataSource.add(map3);

        ListView listView = findViewById(R.id.lv);
        wechatAdapter = new wechatAdapter(this,
                R.layout.layout_wechat_item,
                dataSource);
        listView.setAdapter(wechatAdapter);

        /*
        设置ListView的监听器
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        WechatActivity.class);
                intent.putExtra("position", position);
                List<Map<String,Object>> list = setData();
                Map<String,Object> map = list.get(position);
                String time = map.get("time").toString();
                int img = (int) map.get("img");
                String tittle = map.get("tittle").toString();
                String context = map.get("context").toString();

                intent.putExtra("wechat_tittle",dataSource.get(position).get("name").toString());
                intent.putExtra("time",time);
                intent.putExtra("img",img);
                intent.putExtra("tittle",tittle);
                intent.putExtra("context",context);

                startActivityForResult(intent, 0);
            }
        });
        /*
        接收Intent
         */

    }
    /*
    创建adapter
     */
    private class wechatAdapter extends BaseAdapter {
        private Context context;    // 上下文环境
        private int item_layout_id;// item视图布局文件
        private List<Map<String, Object>> dataSource; // 数据

        public wechatAdapter(Context context,
                             int item_layout_id,
                             List<Map<String, Object>> dataSource) {
            this.context = context;
            this.item_layout_id = item_layout_id;
            this.dataSource = dataSource;
        }

        @Override
        public int getCount() {
            return dataSource.size();
        }

        @Override
        public Object getItem(int position) {
            return dataSource.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView,
                            ViewGroup parent) {
            if(null == convertView) {
                convertView = LayoutInflater.from(context)
                        .inflate(item_layout_id, null);
            }
            ImageView avatar = convertView.findViewById(R.id.wechat_avatar);
            TextView name = convertView.findViewById(R.id.wechat_name);
            TextView msg = convertView.findViewById(R.id.wechat_msg);
            TextView time = convertView.findViewById(R.id.wechat_time);

            Map<String, Object> itemData = dataSource.get(position);

            avatar.setImageResource((Integer) itemData.get("avatar"));
            name.setText(itemData.get("name").toString());
            msg.setText(itemData.get("abstract").toString());
            time.setText(itemData.get("time").toString());

            return convertView;
        }
    }

}
