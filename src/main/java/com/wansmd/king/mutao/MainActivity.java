package com.wansmd.king.mutao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.wansmd.king.mutao.fragment.FindFragment;
import com.wansmd.king.mutao.fragment.MainFragment;
import com.wansmd.king.mutao.fragment.MeFragment;

public class MainActivity extends AppCompatActivity {
    protected MainFragment mainFragment = new MainFragment();
    protected FindFragment findFragment = new FindFragment();
    protected MeFragment meFragment = new MeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreateRb();
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_content, mainFragment)
                .add(R.id.container_content, findFragment)
                .hide(findFragment)
                .add(R.id.container_content, meFragment)
                .hide(meFragment)
                .commit();

    }

    private void onCreateRb() {
        //功能模块RadioGroup 监听器
        RadioGroup rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb1:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .show(mainFragment)
                                .hide(findFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case R.id.rb2:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .show(findFragment)
                                .hide(mainFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case R.id.rb3:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .show(meFragment)
                                .hide(mainFragment)
                                .hide(findFragment)
                                .commit();
                        break;
                }

            }
        });
    }
}
