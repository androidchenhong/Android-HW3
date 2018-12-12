package com.example.excesizeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class regsiter extends AppCompatActivity {
    EditText regist_username,regist_email,password,password1;
    Button bt_regist,bt_return;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsiter);
        regist_username=(EditText) findViewById(R.id.register_username);
        regist_email=(EditText) findViewById(R.id.register_email);
        password=(EditText) findViewById(R.id.register_password);
        password1=(EditText) findViewById(R.id.register_password1);
        bt_return=(Button) findViewById(R.id.regsiter_return);
        bt_regist=(Button) findViewById(R.id.regsiter);


        bt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建intent实例
                Intent intent=new Intent(regsiter.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        bt_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_username=regist_username.getText().toString();
                String user_email=regist_email.getText().toString();
                String user_password= password.getText().toString().trim();
                String user_password1= password1.getText().toString().trim();
                //邮箱验证规则
                String regEx="^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
                //编译正则表达式
                Pattern pattern=Pattern.compile(regEx);

                Matcher matcher=pattern.matcher(user_email);

                boolean rs=matcher.matches();

                if(user_email.isEmpty()||user_password.isEmpty()||user_password1.isEmpty()){
                    Toast.makeText(regsiter.this, "邮箱或者密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                else if(rs==false)
                {
                    Toast.makeText(regsiter.this, "请输入正确的邮箱格式", Toast.LENGTH_SHORT).show();
                    return;
                }

                //非空验证


                else if(user_password.length()<6||user_password1.length()<6){
                    Toast.makeText(regsiter.this, "密码长度必须大于6", Toast.LENGTH_SHORT).show();
                    return;
                }

                else if(!(user_password.equals(user_password1))){
                    Toast.makeText(regsiter.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    return;

                }
                // 使用BmobSDK提供的注

                BmobUser user1 =new BmobUser();
                user1.setUsername(user_username);
                user1.setEmail(user_email);
                user1.setPassword(user_password);



                user1.signUp(new SaveListener<user>() {
                    @Override
                    public void done(user user, BmobException e) {
                        if(e==null){
                            Toast.makeText(regsiter.this, "注册成功", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(regsiter.this,LoginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(regsiter.this, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                finish();



            }
        });




    }
}
