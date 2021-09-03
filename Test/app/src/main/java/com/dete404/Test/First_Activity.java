package com.dete404.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class First_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        //取出Main活动传递来的对应name的数据
        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.d("First_Activity",data);
    }
}