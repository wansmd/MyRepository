package com.wansmd.king.mutao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity {

    protected Handler handler = new Handler();
    private final static int sleepTime = 3000;
    private int nowTime = 0;
    private Button skipBut;
    private Boolean mStartActivity = false;
    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        skipBut = findViewById(R.id.skip_splash);
        //点击跳过进入主页
        skipBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartActivity = true;
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });

        //倒计时进入主页
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1001:
                        if (nowTime != sleepTime && !mStartActivity) {
                            skipBut.setText((sleepTime - nowTime) / 1000 + " 跳过");
                            handler.sendEmptyMessageDelayed(1001, 1000);
                            nowTime += 1000;
                        } else {
                            skipBut.setText(0 + " 跳过");
                            handler.sendEmptyMessage(1002);
                        }
                        break;
                    case 1002:
                        if (!mStartActivity) {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        }
                        break;
                }
            }
        };
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1001);
            }
        }, 0);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
