package com.wansmd.king.mutao;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //设置注册页面--直接登录
        Button but = findViewById(R.id.login_register);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //设置协议超链接
        TextView textView = findViewById(R.id.xieyi);
        String str = "我司服务协议";
        SpannableString sp = new SpannableString(str);
        NoLineClickSpan clickSpan = new NoLineClickSpan(str);
        sp.setSpan(clickSpan,0,str.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(sp);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    //设置超链接下划线|字体颜色|点击事件
    private class NoLineClickSpan extends ClickableSpan{
        protected String str;
        public NoLineClickSpan(String str){
            this.str = str;
        }
        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Color.BLUE);
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(RegisterActivity.this, "随便注册！", Toast.LENGTH_SHORT).show();
        }
    }
}
