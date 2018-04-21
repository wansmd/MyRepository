package com.wansmd.king.mutao;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wansmd.king.mutao.client.MyClient;
import com.wansmd.king.mutao.db.DBDao;
import com.wansmd.king.mutao.db.DBEntity;

public class AnotherRegisterActivity extends AppCompatActivity {

    private EditText userName_register,passWord_register;
    private Button submit_b;
    private ImageView register_another_close;
    private DBEntity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_another);
        initView();
        register_another_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        submit_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //本地数据库注册
//                DBDao dao = new DBDao(AnotherRegisterActivity.this);
//                if (dao.quertyByUser(userName_register.getText().toString()).size() == 0){
//                    entity = new DBEntity(userName_register.getText().toString(),passWord_register.getText().toString());
//                    dao.insert(entity);
//                    Toast.makeText(AnotherRegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(AnotherRegisterActivity.this, "用户已存在", Toast.LENGTH_SHORT).show();
//                    userName_register.setText("");
//                    passWord_register.setText("");
//                }
                //服务器注册
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        MyClient client = new MyClient();
                        if (!client.MyServer("queryByUser",userName_register.getText().toString(),passWord_register.getText().toString())){
                            client.MyServer("insert",userName_register.getText().toString(),passWord_register.getText().toString());
                            Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(), "用户已存在", Toast.LENGTH_SHORT).show();
                            AnotherRegisterActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    userName_register.setText("");
                                    passWord_register.setText("");
                                }
                            });
                        }
                        Looper.loop();
                    }
                }).start();

            }
        });

    }

    private void initView() {
        userName_register = findViewById(R.id.userName_register);
        passWord_register = findViewById(R.id.passWord_register);
        submit_b = findViewById(R.id.submit_b);
        register_another_close = findViewById(R.id.register_another_close);
    }

}
