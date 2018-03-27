package com.example.publicnumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import static com.example.publicnumber.Data.setData;

/**
 * Created by wang on 2018/3/24.
 */

public class WechatActivity extends Activity {
    private Map<String,Object> map;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wechat);
        /*
        得到传到的值
         */
        Intent intent = getIntent();
        final int position = intent.getIntExtra("position",
                0);
        TextView time = findViewById(R.id.context_time);
        TextView tittle = findViewById(R.id.context_tittle);
        TextView context = findViewById(R.id.context_context);
        Log.e("context",intent.getStringExtra("context"));
        ImageView img = findViewById(R.id.context_img);
        TextView wechat_tittle = findViewById(R.id.wechat_tittle);
//        List<Map<String,Object>> list = setData();
//        map = list.get(position);
        wechat_tittle.setText(intent.getStringExtra("wechat_tittle"));
        time.setText(intent.getStringExtra("time"));
        tittle.setText(intent.getStringExtra("tittle"));
        context.setText(intent.getStringExtra("context"));
        img.setImageResource(intent.getIntExtra("img",0));
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
//                intent.getIntExtra("img",
//                0));
//        img.setImageBitmap(imgNew);
        /*
        返回按钮
         */
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
        /*
        菜单
         */
        TextView t1 = findViewById(R.id.btn_1);
        TextView t2 = findViewById(R.id.btn_2);
        TextView t3 = findViewById(R.id.btn_3);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View popupView = getLayoutInflater().inflate(R.layout.popupmenu,null);
                PopupWindow popupWindow;
                popupWindow = new PopupWindow(popupView,dip2px(getApplicationContext(),100),
                        dip2px(getApplicationContext(),160),true);
                popupWindow.showAsDropDown(v);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View popupView = getLayoutInflater().inflate(R.layout.popupmenu,null);
                PopupWindow popupWindow;
                popupWindow = new PopupWindow(popupView,dip2px(getApplicationContext(),100),
                        dip2px(getApplicationContext(),160),true);
                popupWindow.showAsDropDown(v);

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View popupView = getLayoutInflater().inflate(R.layout.popupmenu,null);
                PopupWindow popupWindow;
                popupWindow = new PopupWindow(popupView,dip2px(getApplicationContext(),100),
                        dip2px(getApplicationContext(),160),true);
                popupWindow.showAsDropDown(v);
            }
        });

    }
    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources()
                .getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5f);
    }
}
