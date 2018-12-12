package com.example.excesizeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.bmob.v3.b.V;

public class fragment1 extends Fragment {

    Button btn_coachlist,send1,send2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1,null);
        btn_coachlist=(Button)view.findViewById(R.id.btn_coachlist);
        send1=(Button)view.findViewById(R.id.send1);
        send2=(Button)view.findViewById(R.id.send2);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
           super.onActivityCreated(savedInstanceState);

           send2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Uri smsToUri = Uri.parse("smsto:13120023188");
                   Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);
                   intent.putExtra("sms_body", "");

                   startActivity(intent);


               }
           });

           send1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   Uri smsToUri = Uri.parse("smsto:13120023199");
                   Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);
                   intent.putExtra("sms_body", "");

                   startActivity(intent);


               }
           });

        btn_coachlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建intent实例
                Intent intent=new Intent(getActivity(),RecyclerviewActivity.class);
                startActivity(intent);
            }
        });
    }

}
