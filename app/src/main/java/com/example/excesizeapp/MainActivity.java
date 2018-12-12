package com.example.excesizeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.excesizeapp.LoginActivity;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //Bmob第一：默认初始化
        Bmob.initialize(this, "b00f73fcffa14e8dc6dd43989bd82e8c");

        setContentView(R.layout.activity_main);

        //添加按钮的点击事件
        Button button=(Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建intent实例
                Intent intent=new Intent(MainActivity.this,totalfgmt.class);
                startActivity(intent);
            }
        });

    }



}
