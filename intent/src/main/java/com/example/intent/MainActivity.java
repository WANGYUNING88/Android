package com.example.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        启动内部activity
         */
        Button button = findViewById(R.id.btn_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                三种方法
                 */
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName(MainActivity.this,Activity1.class);
                intent.setComponent(componentName);


//                Intent intent = new Intent(MainActivity.this,Activity1.class);


//                Intent intent1 = new Intent();
//                intent1.setClass(MainActivity.this,
//                        Activity1.class);
                startActivity(intent);

                /*
                获取Intent
                 */
                Log.e("text",intent.getComponent().getClassName());
                Log.e("text",intent.getComponent().getPackageName());

            }
        });
        /*
        打开外部应用(taobao)
         */
        Button button1 = findViewById(R.id.btn_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.taobao",
                        "com.example.taobao.MainActivity");
                startActivity(intent);
            }
        });
        /*
        隐性INTENT
         */
        Button button2 = findViewById(R.id.btn_3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("cool");
                intent.addCategory("shuai");
                startActivity(intent);
            }
        });
        /*
        data
         */
        Button button3 = findViewById(R.id.btn_4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("huabei://paowang:8888/wangyuning"));
                startActivity(intent);
            }
        });
    }
}
