package com.example.excesizeapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;

public class Player extends AppCompatActivity {
    private VideoView videoview , videoview1;
    private Button video_test1,video_test2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        video_test1=(Button) findViewById(R.id.video_test1);
        video_test2=(Button) findViewById(R.id.video_test2);


        //网络视频

        videoview = (VideoView)this.findViewById(R.id.video_view );
        videoview1 = (VideoView)this.findViewById(R.id.video_view1);
        //设置视频控制器
        videoview.setMediaController(new MediaController(this));
        videoview1.setMediaController(new MediaController(this));
        //播放完成回调
        videoview.setOnCompletionListener( new MyPlayerOnCompletionListener());
        videoview1.setOnCompletionListener( new MyPlayerOnCompletionListener());

        video_test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //设置视频路径
                //videoView.setVideoURI(uri);
                videoview.setVideoPath("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4");

                //开始播放视频
                videoview.start();
            }
        });

        video_test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //设置视频路径
                //videoView.setVideoURI(uri);
                videoview1.setVideoPath("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4");

                //开始播放视频
                videoview1.start();
            }
        });



    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(Player.this, "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }


}



