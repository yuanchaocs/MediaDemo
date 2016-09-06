package com.feicuiedu.mediademo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private String videoPath;
    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;

    private boolean isPrepared; // 是否准备好


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceview);
        videoPath = getTestVideo1();
    }

    @Override protected void onResume() {
        super.onResume();
        // mediaPlayer初始
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override public void onPrepared(MediaPlayer mp) {
                mediaPlayer.setDisplay(surfaceView.getHolder()); // 设置显示
                isPrepared = true;
                startButton();
            }
        });

        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override public boolean onInfo(MediaPlayer mp, int what, int extra) {
                // 缓冲开始
                if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START) {
                    return true;
                }
                // 缓冲结束
                if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
                    return true;
                }
                return false;
            }
        });
        // mediaPlayer准备
        try {
            mediaPlayer.setDataSource(videoPath);// 设置资源
            mediaPlayer.prepareAsync(); // 异步准备
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override protected void onPause() {
        super.onPause();
        // mediaplayer的release
        pauseButton();
        mediaPlayer.release();
    }

    public void startButton() {
        if (isPrepared) {
            mediaPlayer.start();
        }
    }

    public void pauseButton() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    private String getTestVideo1() {
        return "http://o9ve1mre2.bkt.clouddn.com/raw_%E6%B8%A9%E7%BD%91%E7%94%B7%E5%8D%95%E5%86%B3%E8%B5%9B.mp4";
    }
}
