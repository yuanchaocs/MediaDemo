package com.feicuiedu.mediademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    // Review

    // Demo是为了做技术了解和验证
    // 有一个要求: 不是项目中使用的代码, 不以写出能在项目中直接使用的代码为目的
    // MediaPlayer mediaPlayer;
    // SurfaceView surfaceView;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoview);
        playVideo();
    }

    private void playVideo(){
        videoView.setVideoPath(getTestVideo1());
        videoView.setMediaController(new MediaController(this));
        videoView.start();
    }

    private String getTestVideo1(){
        return "http://o9ve1mre2.bkt.clouddn.com/raw_%E6%B8%A9%E7%BD%91%E7%94%B7%E5%8D%95%E5%86%B3%E8%B5%9B.mp4";
    }

}
