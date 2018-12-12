package com.example.excesizeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class accoutSign extends AppCompatActivity {

    EditText login_email,login_password;
    Button button,button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accout_sign);



        button=(Button)findViewById(R.id.r);
        button1=(Button)findViewById(R.id.r1) ;

        login_email=(EditText)findViewById(R.id.login_email);
        login_password=(EditText) findViewById(R.id.login_password);


        //添加按钮的点击事件

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_eamil=login_email.getText().toString();
                String user_password=login_password.getText().toString().trim();

                //非空验证
                if(user_eamil.isEmpty()||user_password.isEmpty()){
                    Toast.makeText(accoutSign.this, "密码或账号不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                }

                else if(user_password.length()<6){
                    Toast.makeText(accoutSign.this, "密码长度必须大于6", Toast.LENGTH_SHORT).show();
                    return;
                }

                BmobUser user1 =new BmobUser();
                user1.setUsername(user_eamil);
                user1.setPassword(user_password);

                // 使用BmobSDK提供的登录功能

                user1.login(new SaveListener<Object>() {
                    @Override
                    public void done(Object o, BmobException e) {
                        if(e==null){
                            Toast.makeText(accoutSign.this, "登录成功", Toast.LENGTH_SHORT).show();
                            //创建intent实例
                            Intent intent=new Intent(accoutSign.this,totalfgmt.class);
                            startActivity(intent);
                        }

                        else{
                            Toast.makeText(accoutSign.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(accoutSign.this,MainActivity.class);
                startActivity(intent1);

            }
        });


    }


}
