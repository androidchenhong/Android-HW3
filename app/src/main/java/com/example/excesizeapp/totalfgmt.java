package com.example.excesizeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

public class totalfgmt extends FragmentActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totalfragment);
        ImageView imageView1=findViewById(R.id.img1);
        ImageView imageView2=findViewById(R.id.im2);
        ImageView imageView3=findViewById(R.id.img3);
        ImageView imageView4=findViewById(R.id.img4);

        imageView1.setOnClickListener(l);
        imageView2.setOnClickListener(l);
        imageView3.setOnClickListener(l);
        imageView4.setOnClickListener(l);

    }
      View.OnClickListener l;
    {
        l=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Fragment f=null;

                switch (v.getId()){
                    case R.id.img1:
                        f=new fragment_test();
                        break;

                    case R.id.im2:
                        f=new fragment1();
                        break;

                    case R.id.img3:
                        f=new fragment2();
                        break;

                    case R.id.img4:
                        f=new fragment3();
                        break;

                    default:
                        f=new fragment1();
                        break;
                }
                ft.replace(R.id.total_fgmt,f);
                ft.commit();
            }
        };
    }

}
