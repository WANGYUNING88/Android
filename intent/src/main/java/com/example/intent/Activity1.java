package com.example.intent;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by wang on 2018/3/22.
 */

public class Activity1 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity);

        TextView textView = findViewById(R.id.activity_text);
        textView.setText("我是Activity1");
    }
}
