package com.example.excesizeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerviewActivity extends AppCompatActivity {

    Button btn_add,btn_delete,btn_list,btn_grid;
    RecyclerView recyclerView;
    ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        btn_add=(Button)findViewById(R.id.btn_add);
        btn_delete=(Button)findViewById(R.id.btn_delete);
        btn_list=(Button)findViewById(R.id.btn_list);
        btn_grid=(Button)findViewById(R.id.btn_grid);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);

        initDA();

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        final MyAdapter myAdapter=new MyAdapter( RecyclerviewActivity.this,datas);


        //设置点击事件
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             myAdapter.addData(0,"New_Content");
             recyclerView.scrollToPosition(0);
            }
        });


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.deleteData(0);

            }
        });


        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerviewActivity.this,LinearLayoutManager.VERTICAL,false));

            }
        });
        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             recyclerView.setLayoutManager(new GridLayoutManager(RecyclerviewActivity.this,2,GridLayoutManager.VERTICAL,false));
            }
        });


        //设置RecyclserView的适配器
        recyclerView.setAdapter(myAdapter);

        //LayoutManager


        //设置点击了某条的监听
        myAdapter.setOnItemClickLister(new MyAdapter.OnItemClickLister() {
            @Override
            public void OnItemClick(View view, String data) {
                Toast.makeText(RecyclerviewActivity.this, "data=="+data, Toast.LENGTH_SHORT).show();
            }
        });


    }
   public void initDA(){
       //准备数据集合
       datas=new ArrayList<>();
       for(int i=0;i<100;i++){
           datas.add("Content_"+i);
       }
   }

}
