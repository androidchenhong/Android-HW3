package com.example.excesizeapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHodler> {
    Context context;
    ArrayList<String> datas;

    public MyAdapter(Context context, ArrayList<String> datas){

     this.context=context;
     this.datas=datas;

    }


    //相当于getView中创建View和ViewHolder
    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=View.inflate(context,R.layout.item_recyclerview,null);
        return new MyViewHodler(itemView);
    }


    //数据和View绑定
    @Override
    public void onBindViewHolder(@NonNull MyViewHodler myViewHodler, int position) {
      //根据位置得到对应的数据
        String data=datas.get(position);
        myViewHodler.tv_title.setText(data);
    }


    //得到总条数
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //添加数据
    public void addData(int position,String data){

        datas.add(position,data);
        //添加之后一定要刷新适配器
        notifyItemInserted(position);
    }

    //删除数据

    public void deleteData(int position){

        datas.remove(position);
        //添加之后一定要刷新适配器
        notifyItemRemoved(position);
    }




    class MyViewHodler extends RecyclerView.ViewHolder{

        ImageView iv_icon;
        TextView tv_title;


        public MyViewHodler(View itemView){
            super(itemView);
            iv_icon=(ImageView)itemView.findViewById(R.id.iv_icon);
            tv_title=( TextView)itemView.findViewById(R.id. tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   //Toast.makeText(context, "data=="+datas.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();

                    if(onItemClickLister!=null){
                        onItemClickLister.OnItemClick(v,datas.get(getLayoutPosition()));
                    }


                }
            });
        }
    }

    //点击RecyclerView某条的监听

    public interface OnItemClickLister{

        //当RecyclerView的某条被点击时回调 view是点击得到的视图，data是点击得到的数据


        public void OnItemClick(View view,String data);

    }
    OnItemClickLister onItemClickLister;

    //设置RecyclerView某条的监听

    public void setOnItemClickLister(OnItemClickLister onItemClickLister){
        this.onItemClickLister=onItemClickLister;
    }


}
