package com.wansmd.king.mutao;


import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wansmd.king.mutao.client.MyClient;
import com.wansmd.king.mutao.db.DBDao;

public class LoginActivity extends AppCompatActivity {
    private EditText userNameLg,passWordLg;
    private Button loginBut,register,registerAnother;
    private DBDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameLg = findViewById(R.id.userName_login);
        passWordLg = findViewById(R.id.passWord_login);
        loginBut = findViewById(R.id.login_b);
        register = findViewById(R.id.register);
        registerAnother = findViewById(R.id.register_another);


        ImageView img = findViewById(R.id.login_close);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void mOnClick(View view) {
        switch (view.getId()){
            case R.id.login_b:
                //本地数据库登录
//                dao = new DBDao(LoginActivity.this);
//                if (dao.querty(userNameLg.getText().toString(),passWordLg.getText().toString()).size() > 0){
//
//                    MyApplication application = (MyApplication) getApplication();
//                    application.setUserName(userNameLg.getText().toString());
//                    finish();
//                }else {
//                    Toast.makeText(this, "请输入正确的用户名和密码", Toast.LENGTH_SHORT).show();
//                    userNameLg.setText("");
//                    passWordLg.setText("");
//                }
                //服务器登录
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        MyClient client = new MyClient();
                        Toast.makeText(getApplicationContext(), "进来了", Toast.LENGTH_SHORT).show();
                        if (client.MyServer("query",userNameLg.getText().toString(),passWordLg.getText().toString())){
                            MyApplication application = (MyApplication) getApplication();
                            application.setUserName(userNameLg.getText().toString());
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(), "请输入正确的用户名和密码", Toast.LENGTH_SHORT).show();
                            LoginActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    userNameLg.setText("");
                                    passWordLg.setText("");
                                }
                            });
                        }
                        Looper.loop();
                    }
                }).start();
                break;
            case R.id.register:
                //进入注册页面
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.register_another:
                //进入另一个注册页面
                startActivity(new Intent(LoginActivity.this,AnotherRegisterActivity.class));
                break;
        }
    }
}
